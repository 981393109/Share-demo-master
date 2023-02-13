package com.correction.backend.modules.sys.service;

import com.correction.backend.modules.sys.controller.dto.sys.DocumentCenterCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.DocumentCenterListOutputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.DocumentCenterSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.DocumentCenterUpdateInputDTO;
import com.correction.backend.modules.sys.entity.DocumentCenter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.framework.common.pojo.PageResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 文书参考 服务类
 * </p>
 *
 * @author yao
 * @since 2023-02-04
 */
public interface DocumentCenterService extends IService<DocumentCenter> {

    /**
     * 新增：
     */
    DocumentCenter save (DocumentCenterCreateInputDTO createInputDTO, MultipartFile file) throws IOException;


    /**
     * 修改
     */
    DocumentCenter update (DocumentCenterUpdateInputDTO updateInputDTO,MultipartFile file) throws IOException;

    /**
     * 获取详情
     * @param id
     * @return
     */
    DocumentCenter getDetail (Long id);

    /**
     * 获取列表
     */
    List<DocumentCenter> getList (DocumentCenterListOutputDTO searchInputDTO);

    /**
     * 分页获取列表
     */
    PageResult<DocumentCenter> getPageList (DocumentCenterSearchInputDTO searchInputDTO);

    /**
     * 删除
     */
    void delete (String ids);

}
