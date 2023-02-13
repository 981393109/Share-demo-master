package com.correction.backend.modules.test.controller;

import cn.hutool.json.JSONObject;
import com.correction.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.correction.framework.common.pojo.CommonResult.success;

@Api(tags = "测试模块")
@RestController
@RequestMapping("/test")
@Validated
public class TestController {


    @PostMapping("/login")
    @ApiOperation("测试登录")
    public CommonResult login(@RequestBody @Valid JSONObject reqVO) {
        return success(reqVO);
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("100010");
        System.out.println(encode);


    }


}
