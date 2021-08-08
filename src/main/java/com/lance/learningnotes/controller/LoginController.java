package com.lance.learningnotes.controller;

import com.lance.learningnotes.common.CommonResult;
import com.lance.learningnotes.entity.LoginRequest;
import com.lance.learningnotes.entity.LoginResponse;
import com.lance.learningnotes.enums.ResponseCodeEnum;
import com.lance.learningnotes.utils.JWTUtil;
import com.lance.learningnotes.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@Api("用户模块")
public class LoginController {



}
