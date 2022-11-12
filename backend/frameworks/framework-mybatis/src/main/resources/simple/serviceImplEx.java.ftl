package ${package.ServiceImpl};

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.suyuan.common.model.PageModel;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${superServiceImplClassPackage};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.suyuan.upload.mapper.UploadHistoryMapper;
import com.suyuan.upload.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suyuan.upload.mapper.UploadTemporaryDataMapper;
import com.suyuan.upload.service.UploadTemporaryDataService;
import com.suyuan.upload.model.UploadTemporaryData;
import com.suyuan.upload.service.UploadTemporaryDataService;
import javax.annotation.Resource;
import com.suyuan.system.service.CompanyService;
import org.springframework.web.multipart.MultipartFile;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.suyuan.system.model.UserInfo;
import java.util.Map;
import com.suyuan.upload.model.UploadHistory;
import com.suyuan.upload.mapper.UploadHistoryMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;
import com.suyuan.iinv.service.extend.OutPutService;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@Service
public class ${entity}ExServiceImpl implements ${entity}ExService {

    /**
     * 结果导出名称
     */
    private static final String  UPLOAD_TEMPLATE_NAME = "纳税申报各类表.xls";

    /**
     * 发票明细导出
     */
    private static final String  UPLOAD_TEMPLATE_DETAIL_NAME = "纳税申报记录表.xls";

    /**
     * 未删除标记
     */
    private static final String  DEL_FLAG_0 = "0";

    /**
     * 删除标记
     */
    private static final String  DEL_FLAG_1 = "1";


    @Resource
    private ImportService importService;

    @Resource
    private UploadHistoryMapper uploadHistoryMapper;

    @Autowired
    private ${table.mapperName}Ex ${table.mapperName};



    @Resource
    private UploadTemporaryDataMapper uploadTemporaryDataMapper;

    @Resource
    private UploadTemporaryDataService uploadTemporaryDataService;

    @Resource
    private OutPutService outPutService;
    @Resource
    private CompanyService companyService;


    /**
     * 导入票据信息
     * @param user
     * @param companyCode
     * @param importType
     * @param file
     * @return
     */
    @Override
    public JSONObject ${entity}FileUpload(UserInfo user, String companyCode, String importType, MultipartFile file)  {
        JSONObject result = new JSONObject();
        try {
            if (ObjectUtil.isNotEmpty(file) && file.getSize() > 0){
                String batchNum = importService.importFile(user, companyCode, importType, "IINV", file, NsIiFp.class);
                log.info("保存导入的增值税");
                // 转化内存数据
                List<NsliFpAndMxInputDto> nsliFpAndMxInputDtoList = tranInputVat(batchNum);
                // 保存进项增值税发票数据
                this.saveNsliFpAndMx(nsliFpAndMxInputDtoList);
                log.info("本次导入批次号："+batchNum);
                UploadHistory uploadHistory = uploadHistoryMapper.selectOne(Wrappers.<UploadHistory>lambdaQuery().eq(UploadHistory::getBatchNo, batchNum));
                result.put("successCount",uploadHistory.getRightCount());
                result.put("errorCount",uploadHistory.getErrorCount());
                result.put("batchNo",batchNum);
            }
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            result.put("error","导入错误");
        }
        return result;
    }

    /**
     * 转化内存数据
     * @param batchNum
     * @return
     */
    public List<NsliFpAndMxInputDto> tranInputVat(String batchNum) {
        List<NsliFpAndMxInputDto> nsliFpAndMxInputDtoList = new ArrayList<>();
        LambdaQueryWrapper<UploadTemporaryData> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(StringUtils.isNotBlank(batchNum), UploadTemporaryData::getBatchNo, batchNum);
        List<UploadTemporaryData> list = uploadTemporaryDataService.list(queryWrapper);
        if (!CollectionUtils.isEmpty(list)) {
            for (UploadTemporaryData UploadTemporaryData : list) {
                NsliFpAndMxInputDto nsliFpAndMxInputDto = JSON.parseObject(UploadTemporaryData.getRowJson(), NsliFpAndMxInputDto.class);
                nsliFpAndMxInputDtoList.add(nsliFpAndMxInputDto);
            }
        }
        return nsliFpAndMxInputDtoList;
    }

    /**
     * 保存进项增值税发票数据
     * @param nsliFpAndMxInputDtoList
     */
    public void saveNsliFpAndMx(List<NsliFpAndMxInputDto> nsliFpAndMxInputDtoList) throws Exception {
        Map<String, List<NsliFpAndMxInputDto>> liMap = nsliFpAndMxInputDtoList.stream().collect(Collectors.groupingBy(e -> e.getFaphm() + e.getFapdm()));
        for (Map.Entry<String,List<NsliFpAndMxInputDto>> entry: liMap.entrySet()){
             List<NsliFpAndMxInputDto> nsList = entry.getValue();
            // 保存发票主记录
            NsliFpAndMxInputDto nsliFpAndMxInputDto = nsList.get(0);
            NsIiFp nsIiFp = new NsIiFp();
            BeanUtils.copyProperties(nsliFpAndMxInputDto,nsIiFp);
            // 根据公司代码获取公司名称
            if(StringUtils.isNotBlank(nsIiFp.getCompanyCode())){
                nsIiFp.setCompanyName(this.getCompanyName(nsIiFp.getCompanyCode()));
                nsIiFp.setDelFlag(DEL_FLAG_0);
            }
            nsIiFpMapper.insert(nsIiFp);
            // 保存发票明细
            for(NsliFpAndMxInputDto nsliFpMxInputDto: nsList){
                NsIiFpMx nsIiFpMx = new NsIiFpMx();
                BeanUtils.copyProperties(nsliFpMxInputDto,nsIiFpMx);
                nsIiFpMx.setIinvFpId(nsIiFp.getId());
                nsIiFpMxMapper.insert(nsIiFpMx);
            }
        }
    }

    /**
     * 下载模板
     * @param response
     * @return
     */
    @Override
    public JSONObject ${entity}TemplateDownload(HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        try {
            String path = this.getClass().getResource("/").getPath();
            String filePath = path + File.separator + "template" + File.separator + UPLOAD_TEMPLATE_NAME;
            // 获取输出流
            OutputStream os = response.getOutputStream();
            // 获取输入流
            InputStream is = new FileInputStream(filePath);
            IOUtils.copy(is,os);
            is.close();
            os.close();
            jsonObject.put("resMsg","下载成功");
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            jsonObject.put("resMsg","下载失败");
        }
        return jsonObject;
    }

    @Override
    public IPage<ResultShowDto> ${entity}ListQuery(Map<String, Object> searchInfo, Page page) {
        Page<ResultShowDto> jsonObject = new Page<>();
        try{
            jsonObject = nsIiFpMapper.fetchResultShow(searchInfo,page);
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 导出结果展示的接口
     * @return
     * @param shengbq
     */
    @Override
    public void outPut${entity}Result(String shengbq) {
        JSONObject jsonObject = new JSONObject();
        try{
            List<ResultShowDto> resultShowDtos = nsIiFpMapper.fetchAllResultShow(shengbq);
            // 获取路径
            String filePath = this.getClass().getResource("/").getPath() + File.separator +
                    "export" + File.separator + UPLOAD_TEMPLATE_NAME;
            //初始化导出
            ResultShowDto resultShowDto = new ResultShowDto();
            // 调用文件导出接口
            outPutService.outPutService(resultShowDto,resultShowDtos,"",filePath);
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 票据明细(分页查询)
     * @param searchInfo
     * @param page
     * @return
     */
    @Override
    public IPage<ResultDetailShowDto> ${entity}DetailsQuery(Map<String, Object> searchInfo, Page page) {
        Page<ResultDetailShowDto> jsonObject = new Page<>();
        try{
            jsonObject = nsIiFpMapper.fetchResultShowOfDetail(searchInfo,page);
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 发票明细导出
     * @param exprotObj
     */
    @Override
    public void fetchDetailExport(Map<String, Object> exprotObj) {
        try{
            // 导出路径
            String filePath = this.getClass().getResource("/").getPath() + File.separator +
                    "export" + File.separator + UPLOAD_TEMPLATE_DETAIL_NAME;
            List<ResultDetailShowDto> records = nsIiFpMapper.fetchAllResultShowOfDetail(exprotObj);
//            List<ResultDetailShowDto> records = jsonObject.getRecords();
            //初始化导出
            ResultDetailShowDto resultDetailShowDto = new ResultDetailShowDto();
            // 调用文件导出接口
            outPutService.outPutServiceDetail(resultDetailShowDto,records,"",filePath);
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }


     /**
     * 删除明细接口
     * @param exprotObj
     * @throws Exception
     */
    @Override
    public void ${entity}ResultDelete(Map<String, Object> exprotObj) throws Exception {
        try {
            String pich = String.valueOf(exprotObj.get("pich"));
            Map<String,Object> deleteMap = new HashMap<>();
            deleteMap.put("pich",pich);

            // 删除明细
            Boolean flag = deleteDetial(pich);
            if(flag){
                throw new Exception("删除明细失败");
            }
            LambdaUpdateWrapper<NsIiFp> wrapper = Wrappers.lambdaUpdate();
            wrapper.eq(NsIiFp::getPich,pich).eq(NsIiFp::getDelFlag, DEL_FLAG_0).set(NsIiFp::getDelFlag,DEL_FLAG_1);
            nsIiFpService.update(wrapper);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 删除明细信息
     */

    public Boolean deleteDetial(String pich) {
        Boolean flag = false;
        try {
            if(pich != null && pich !=""){
                Map<String,Object> queryMap = new HashMap<>();
                queryMap.put("pich",pich);
                queryMap.put("del_flag",DEL_FLAG_0);
                nsIiFpMxMapper.updateDetailInfoByPich(queryMap);
                flag = true;
            }
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
        return flag;
    }

    /**
     * 获取分页排序page对象
     * @param dto
     * @return
     */
    @Override
    public Page<T> getPage(PageShowListPojo dto) {
        Map<String, String> orderBys = dto.getOrderByColumn();
        List<OrderItem> list = new ArrayList<>();
        if (orderBys != null) {
            Iterator<Map.Entry<String, String>> orderIter = orderBys.entrySet().iterator();
            while (orderIter.hasNext()) {
                OrderItem orderItem = new OrderItem();
                Map.Entry<String, String> orderby = orderIter.next();
                orderItem.setColumn(orderby.getKey());
                orderItem.setAsc(orderby.getValue() != null ? orderby.getValue().toLowerCase().equals("asc") : true);
                list.add(orderItem);
            }
        } else {
            OrderItem orderItem = new OrderItem();
            orderItem.setColumn("id");
            orderItem.setAsc(false);
        }
        Page page = new Page();
        page.setSize(dto.getSize());
        page.setCurrent(dto.getPage());
        page.setOrders(list);
        return page;
    }

    /**
     * 获取公司名称
     * @param companyCode
     * @return
     */
    public String getCompanyName(String companyCode) {
        LambdaQueryWrapper<Company> queryWrapper = Wrappers.<Company>lambdaQuery();
        queryWrapper.eq(Company::getCompanyNo,companyCode);
        Company company = companyService.getOne(queryWrapper);
        return company.getNsrmc();
    }

}