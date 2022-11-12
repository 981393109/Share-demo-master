package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.suyuan.iinv.dto.searchDto.PageShowListPojo;
import com.suyuan.system.model.UserInfo;
import org.springframework.data.domain.Page;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;


/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${entity}ExService {

  /**
     *  导入文件
     * @param user
     * @param companyCode
     * @param importType
     * @param file
     * @return
     * @throws Exception
     */
    JSONObject ${entity}FileUpload(UserInfo user, String companyCode, String importType, MultipartFile file) throws Exception;


    /**
     *  下载标准模板
     * @return
     * @param response
     */
    JSONObject ${entity}TemplateDownload(HttpServletResponse response);

    /**
     * 查询结果展示
     * @param searchInfo
     * @param Page
     * @return
     */
    IPage<ResultShowDto> ${entity}ListQuery(Map<String, Object> searchInfo, Page page);

    /**
     * 导出结果
     * @return
     * @param shenbq
     */
    void outPut${entity}Result(String shenbq);

    /**
     * 查看票据明细(分页)
     * @param searchInfo
     * @param Page
     * @return
     */
    IPage<ResultDetailShowDto> ${entity}DetailsQuery(Map<String, Object> searchInfo, Page page);

    /**
     * 从dto中获取分页信息
     * @param dto
     * @return
     */
    Page getPage(PageShowListPojo dto);

    /**
     * 导出明细结果
     * @param exprotObj
     */
    void fetchDetailExport(Map<String, Object> exprotObj);



    /**
     * 删除进项和明细记录
     * @param exprotObj
     * @throws Exception
     */
    void ${entity}ResultDelete(Map<String, Object> exprotObj) throws Exception;

}
</#if>
