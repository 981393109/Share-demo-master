package com.correction.backend.modules.sys.controller;


import cn.hutool.core.collection.CollUtil;
import com.correction.backend.modules.sys.controller.dto.sys.*;
import com.correction.backend.modules.sys.convert.sys.MOrgConvert;
import com.correction.backend.modules.sys.entity.OrgDO;
import com.correction.backend.modules.sys.service.OrgService;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.common.pojo.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import static com.correction.framework.common.pojo.CommonResult.success;

@Api(tags = "组织架构模块")
@RestController
@RequestMapping("/org")
@Validated
public class OrgController {


    @Resource
    private OrgService orgService;

    @PostMapping("/create")
    @ApiOperation("新增组织")
    public CommonResult<Long> createOrg(@Valid @RequestBody OrgCreateInputDTO reqDTO) {
        Long id = orgService.createOrg(reqDTO);
        return success(id);
    }

    @PostMapping("update")
    @ApiOperation("修改组织")
    public CommonResult<Boolean> updateOrg(@Valid @RequestBody OrgUpdateInputDTO reqDTO) {
        orgService.updateOrg(reqDTO);
        return success(true);
    }

    @PostMapping("delete")
    @ApiOperation("删除组织")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        orgService.removeById(id);
        return success(true);
    }


    @GetMapping("/get")
    @ApiOperation("获取组织详情")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<OrgListOutputDTO> getInfo(@RequestParam("id") Long id) {
        return success(MOrgConvert.INSTANCE.toList(orgService.detail(id)));
    }

    @GetMapping("/page")
    @ApiOperation("获得所有组织分页列表")
    public CommonResult<PageResult<OrgListOutputDTO>> getUserPage(@Valid OrgSearchInputDTO reqVO) {
        // 获得用户分页列表
        PageResult<OrgDO> pageResult = orgService.getPageList(reqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal())); // 返回空
        }
        // 拼接结果返回
        List<OrgListOutputDTO> orgList = new ArrayList<>(pageResult.getList().size());
        pageResult.getList().forEach(org -> {
            OrgListOutputDTO respVO = MOrgConvert.INSTANCE.toList(org);
            orgList.add(respVO);
        });
        return success(new PageResult<>(orgList, pageResult.getTotal()));
    }


    @GetMapping("/getOrgChildsList")
    @ApiOperation("获取组织以及旗下所有子组织列表（未分页）")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<List<OrgListOutputDTO>> getOrgChildsList(@RequestParam("id") Long id) {
        List<OrgListOutputDTO> list = MOrgConvert.INSTANCE.toList(orgService.getOrgChildsList(id));
        return success(list);
    }

    @GetMapping("/getTreeList")
    @ApiOperation("获取组织架构树结构")
    public CommonResult<List<OrgTreeDTO>> getTreeList() {
        List<OrgDO> list = orgService.getList();
        return success(MOrgConvert.INSTANCE.buildMenuTree(list));
    }

}
