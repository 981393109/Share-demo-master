package com.correction.backend.modules.sys.controller;


import cn.hutool.core.collection.CollUtil;
import com.correction.backend.modules.sys.controller.dto.user.SysUserCreateReqDTO;
import com.correction.backend.modules.sys.controller.dto.user.SysUserSearchDTO;
import com.correction.backend.modules.sys.controller.dto.user.SysUserUpdateReqDTO;
import com.correction.backend.modules.sys.controller.vo.user.SysUserInfoVO;
import com.correction.backend.modules.sys.controller.vo.user.SysUserPageVO;
import com.correction.backend.modules.sys.convert.user.SysUserConvert;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.service.SysUserService;
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

@Api(tags = "系统模块-用户信息模块")
@RestController
@RequestMapping("/user")
@Validated
public class SysUserController {


    @Resource
    private SysUserService userService;


    @PostMapping("/create")
    @ApiOperation("新增用户")
    public CommonResult<Long> createUser(@Valid @RequestBody SysUserCreateReqDTO reqDTO) {
        Long id = userService.createUser(reqDTO);
        return success(id);
    }

    @PostMapping("update")
    @ApiOperation("修改用户")
    public CommonResult<Boolean> updateUser(@Valid @RequestBody SysUserUpdateReqDTO reqDTO) {
        userService.updateUser(reqDTO);
        return success(true);
    }

    @PostMapping("/delete")
    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<Boolean> deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return success(true);
    }

    @GetMapping("/page")
    @ApiOperation("获得用户分页列表")
    public CommonResult<PageResult<SysUserPageVO>> getUserPage(@Valid SysUserSearchDTO reqVO) {
        // 获得用户分页列表
        PageResult<SysUserDO> pageResult = userService.getUserPage(reqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal())); // 返回空
        }
        // 拼接结果返回
        List<SysUserPageVO> userList = new ArrayList<>(pageResult.getList().size());
        pageResult.getList().forEach(user -> {
            SysUserPageVO respVO = SysUserConvert.INSTANCE.convertPage(user);
            userList.add(respVO);
        });
        return success(new PageResult<>(userList, pageResult.getTotal()));
    }

    @GetMapping("/list")
    @ApiOperation("获得用户列表")
    public CommonResult<List<SysUserPageVO>> list(@Valid SysUserSearchDTO reqVO) {
        // 获得用户列表
        List<SysUserDO> result = userService.getOrgUserList(reqVO);
        List<SysUserPageVO> sysUserPageVOS = SysUserConvert.INSTANCE.convertList(result);
        return success(sysUserPageVOS);
    }


    @GetMapping("/get")
    @ApiOperation("获得用户详情")
    @ApiImplicitParam(name = "id", value = "编号", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<SysUserInfoVO> getInfo(@RequestParam("id") Long id) {
        return success(SysUserConvert.INSTANCE.convertInfo(userService.getUser(id)));
    }




}
