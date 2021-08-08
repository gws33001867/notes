package com.lance.learningnotes.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lance.learningnotes.common.CommonResult;
import com.lance.learningnotes.common.UserInfoContext;
import com.lance.learningnotes.entity.Users;
import com.lance.learningnotes.enums.ResponseCodeEnum;
import com.lance.learningnotes.exceptions.GlobalException;
import com.lance.learningnotes.exceptions.TokenAuthenticationException;
import com.lance.learningnotes.service.UsersService;
import com.lance.learningnotes.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

@Component
@Slf4j
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    private UsersService usersService;

    private static String secretKey = "salt123456";
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("access-token");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        if (token == null || token.equals("")){
//            throw new GlobalException(ResponseCodeEnum.TOKEN_MISSION);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;

            out = response.getWriter();
            out.append(objectMapper.writeValueAsString(CommonResult
                    .failure(ResponseCodeEnum.TOKEN_MISSION)));
            return false;
        }
        JWTUtil.verifyToken(token,secretKey);

        String userId = JWTUtil.getUserInfo(token);

        Users users = usersService.getById(userId);

        UserInfoContext.setUser(users);

        return true;
    }

}
