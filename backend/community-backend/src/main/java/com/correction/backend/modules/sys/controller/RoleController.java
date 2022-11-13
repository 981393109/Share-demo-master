package com.correction.backend.modules.sys.controller;

import cn.hutool.core.collection.CollUtil;
import com.correction.backend.modules.sys.controller.dto.sys.*;
import com.correction.backend.modules.sys.controller.vo.user.SysUserPageVO;
import com.correction.backend.modules.sys.convert.sys.MMenuConvert;
import com.correction.backend.modules.sys.convert.sys.MRoleConvert;
import com.correction.backend.modules.sys.convert.user.SysUserConvert;
import com.correction.backend.modules.sys.entity.Menu;
import com.correction.backend.modules.sys.entity.Role;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.service.RoleService;
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

@Api(tags = "角色模块相关接口")
@RestController
@RequestMapping("/role")
@Validated
public class RoleController {


    @Resource
    private RoleService roleService;

    @PostMapping("/create")
    @ApiOperation("新增角色")
    public CommonResult<Long> createRole(@Valid @RequestBody RoleCreateInputDTO reqDTO) {
        Long id = roleService.createRole(reqDTO);
        return success(id);
    }

    @PostMapping("update")
    @ApiOperation("修改角色")
    public CommonResult<Boolean> updateRole(@Valid @RequestBody RoleUpdateInputDTO reqDTO) {
        roleService.updateRole(reqDTO);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获取角色详情")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<RoleListOutputDTO> getInfo(@RequestParam("id") Long id) {
        return success(MRoleConvert.INSTANCE.toList(roleService.get(id)));
    }

    @PostMapping("delete")
    @ApiOperation("删除角色")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        roleService.delete(id);
        return success(true);
    }


    @GetMapping("/page")
    @ApiOperation("获得所有角色分页列表")
    public CommonResult<PageResult<RoleListOutputDTO>> getPageList(@Valid RoleSearchInputDTO reqVO) {
        // 获得用户分页列表
        PageResult<Role> pageResult = roleService.getPageList(reqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal())); // 返回空
        }
        // 拼接结果返回
        List<RoleListOutputDTO> roleList = new ArrayList<>(pageResult.getList().size());
        pageResult.getList().forEach(role -> {
            RoleListOutputDTO respVO = MRoleConvert.INSTANCE.toList(role);
            roleList.add(respVO);
        });
        return success(new PageResult<>(roleList, pageResult.getTotal()));
    }


    @GetMapping("/getList")
    @ApiOperation("获取角色列表（未分页）")
    public CommonResult<List<RoleListOutputDTO>> getList(@Valid RoleSearchInputDTO reqVO) {
        List<RoleListOutputDTO> list = MRoleConvert.INSTANCE.toList(roleService.getList(reqVO));
        return success(list);
    }

    @GetMapping("/getUserListByRoleId")
    @ApiOperation("得到角色下所有用户列表")
    public CommonResult<List<SysUserPageVO>> getUserListByRoleId(@RequestParam("id") Long id) {
        List<SysUserDO> userInfoByRoleId = roleService.getUserInfoByRoleId(id);
        List<SysUserPageVO> sysUserPageVOS = SysUserConvert.INSTANCE.convertList(userInfoByRoleId);
        return success(sysUserPageVOS);
    }

    @GetMapping("/getMeanTree")
    @ApiOperation("得到角色下所有菜单树")
    public CommonResult<List<MenuTreeDTO>> getMeanTree(@RequestParam("id") Long id) {
        List<Menu> menus = roleService.getMenuByRoleId(id);
        List<MenuTreeDTO> menuTreeDTO = MMenuConvert.INSTANCE.buildMenuTree(menus);
        return success(menuTreeDTO);
    }


}
