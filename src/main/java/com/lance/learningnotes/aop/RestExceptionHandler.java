package com.lance.learningnotes.aop;

import com.lance.learningnotes.common.CommonResult;
import com.lance.learningnotes.common.ResultData;
import com.lance.learningnotes.common.ReturnCode;
import com.lance.learningnotes.enums.ResponseCodeEnum;
import com.lance.learningnotes.exceptions.GlobalException;
import com.lance.learningnotes.exceptions.TokenAuthenticationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    /**
     * 默认全局异常处理。
     * @param e the e
     * @return ResultData
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResult<String> exception(Exception e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return CommonResult.failure(ResponseCodeEnum.RC500);
    }

    @ExceptionHandler(value = GlobalException.class)
    public CommonResult handleGlobalException(GlobalException e) {
        log.error("自定义异常处理 ex={}", e.getMessage());
        return new CommonResult(e.getCode(), e.getMessage());
    }
    @ExceptionHandler(value = TokenAuthenticationException.class)
    public CommonResult handleGlobalException(TokenAuthenticationException e) {
        log.error("自定义异常处理 ex={}", e.getMessage());
        return new CommonResult(e.getCode(), e.getMessage());
    }

}