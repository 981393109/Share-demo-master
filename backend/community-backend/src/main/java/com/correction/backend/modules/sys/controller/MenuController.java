package com.correction.backend.modules.sys.controller;

import com.correction.backend.modules.sys.controller.dto.sys.MenuSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.MenuTreeDTO;
import com.correction.backend.modules.sys.convert.sys.MMenuConvert;
import com.correction.backend.modules.sys.entity.Menu;
import com.correction.backend.modules.sys.service.MenuService;
import com.correction.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static com.correction.framework.common.pojo.CommonResult.success;

@Api(tags = "系统模块-菜单相关接口")
@RestController
@RequestMapping("/menu")
@Validated
public class MenuController {

    @Resource
    private MenuService menuService;

    @GetMapping("/getTreeList")
    @ApiOperation("获取菜单树结构")
    public CommonResult<List<MenuTreeDTO>> getTreeList() {
        List<Menu> list = menuService.getList();
        return success(MMenuConvert.INSTANCE.buildMenuTree(list));
    }

}
