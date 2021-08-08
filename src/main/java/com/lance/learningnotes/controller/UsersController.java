package com.lance.learningnotes.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lance.learningnotes.common.CommonResult;
import com.lance.learningnotes.entity.LoginRequest;
import com.lance.learningnotes.entity.LoginResponse;
import com.lance.learningnotes.entity.Register;
import com.lance.learningnotes.entity.Users;
import com.lance.learningnotes.enums.ResponseCodeEnum;
import com.lance.learningnotes.service.UsersService;
import com.lance.learningnotes.utils.JWTUtil;
import com.lance.learningnotes.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lance shan
 * @since 2021-07-29
 */
@RestController
@Slf4j
@RequestMapping("/users")
@Api("用户模块")
public class UsersController {

    @Autowired
    private UsersService usersService;
    private static String secretKey = "salt123456";

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("register")
    public boolean register(@RequestBody Register register){
        return usersService.register(register);
    }



    @PostMapping("login")
    @ApiOperation("登录")
    public CommonResult login(@RequestBody @Validated LoginRequest request, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return CommonResult.failure(ResponseCodeEnum.PARAMETER_ILLEGAL);
        }

        String userName = request.getUserName();
        String password = request.getPassword();


        Users users = usersService.getOne(new QueryWrapper<Users>()
                .eq("uname",userName)
                .eq("pwd",password));
        //查询用户信息是否正确
        if(users!=null){
            String userId = users.getId().toString();
            String token = JWTUtil.generateToken(userId,secretKey);
            log.info("login---------------"+secretKey);

            String refreshToken = UUID.randomUUID().toString().replace("-","");
            redisUtil.hset(userId,"token",token);
            redisUtil.hset(userId,"refreshToken",refreshToken);
            redisUtil.expire(userId, JWTUtil.TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);

            LoginResponse response = new LoginResponse();
            response.setToken(token);
            response.setRefreshToken(refreshToken);
            response.setUserId(userId);
            response.setUserName(userName);
            return CommonResult.success(response);
        }
        return CommonResult.failure(ResponseCodeEnum.LOGIN_ERROR);
    }

//    /**
//     * 自动登录接口
//     */
//    @PostMapping("/verify")
//    public String verify(){
//        String userId = JWTUtil.getUserInfo(token);
//        String userName = usersService.getById(userId).getUname();
//        return userName;
//    }
}

