package com.lance.learningnotes.handler;


import com.lance.learningnotes.common.CommonResult;
import com.lance.learningnotes.common.ResultData;
import com.lance.learningnotes.enums.ResponseCodeEnum;
import com.lance.learningnotes.exceptions.GlobalException;
import com.lance.learningnotes.exceptions.TokenAuthenticationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = TokenAuthenticationException.class)
//    public CommonResult handle(TokenAuthenticationException e) {
//        return CommonResult.failure(ResponseCodeEnum.FAIL);
//    }
//
//    @ExceptionHandler(value = GlobalException.class)
//    public CommonResult handleGlobalException(GlobalException e) {
//        return new CommonResult(e.getCode(), e.getMessage());
//    }







//    /**
//     * IllegalArgumentException异常处理返回json
//     * 返回状态码:200
//     */
//    @ExceptionHandler({IllegalArgumentException.class})
//    public CommonResult badRequestExceptionHandler(IllegalArgumentException ex) {
//        log.warn("[badRequestExceptionHandler]", ex);
//        return CommonResult.error(GlobalErrorCodeConstants.BAD_REQUEST.getCode(), GlobalErrorCodeConstants.BAD_REQUEST.getMessage())
//                .setDetailMessage(ExceptionUtil.getRootCauseMessage(ex));
//    }

//    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
//    public CommonResult httpMediaTypeNotSupportedExceptionHandler(HttpMediaTypeNotSupportedException ex) {
//        log.warn("[httpMediaTypeNotSupportedExceptionHandler]", ex);
//        return CommonResult.error(GlobalErrorCodeConstants.UNSUPPORTED_MEDIA_TYPE.getCode(), GlobalErrorCodeConstants.UNSUPPORTED_MEDIA_TYPE.getMessage())
//                .setDetailMessage(ExceptionUtil.getRootCauseMessage(ex));
//    }
//
//    /**
//     * 处理 SpringMVC 请求参数缺失
//     *
//     * 例如说，接口上设置了 @RequestParam("xx") 参数，结果并未传递 xx 参数
//     */
//    @ExceptionHandler(value = MissingServletRequestParameterException.class)
//    public CommonResult missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException ex) {
//        log.warn("[missingServletRequestParameterExceptionHandler]", ex);
//        return CommonResult.error(GlobalErrorCodeConstants.BAD_REQUEST.getCode(), StrUtil.format("请求参数缺失:{}", ex.getParameterName()))
//                .setDetailMessage(ExceptionUtil.getRootCauseMessage(ex));
//    }
//
//    /**
//     * 处理 SpringMVC 请求参数类型错误
//     *
//     * 例如说，接口上设置了 @RequestParam("xx") 参数为 Integer，结果传递 xx 参数类型为 String
//     */
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    public CommonResult methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException ex) {
//        log.warn("[missingServletRequestParameterExceptionHandler]", ex);
//        return CommonResult.error(GlobalErrorCodeConstants.BAD_REQUEST.getCode(), StrUtil.format("请求参数类型错误:{}", ex.getMessage()))
//                .setDetailMessage(ExceptionUtil.getRootCauseMessage(ex));
//    }
//
//    /**
//     * 处理 SpringMVC 参数校验不正确
//     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public CommonResult methodArgumentNotValidExceptionExceptionHandler(MethodArgumentNotValidException ex) {
//        log.warn("[methodArgumentNotValidExceptionExceptionHandler]", ex);
//        FieldError fieldError = ex.getBindingResult().getFieldError();
//        String errorMsg = fieldError == null ? "请求参数不正确" : StrUtil.format("{}", fieldError.getDefaultMessage());
//        return CommonResult.error(GlobalErrorCodeConstants.BAD_REQUEST.getCode(), errorMsg)
//                .setDetailMessage(ExceptionUtil.getRootCauseMessage(ex));
//    }
//
//    /**
//     * 处理 SpringMVC 参数校验不正确
//     */
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public CommonResult httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException ex) {
//        log.warn("[httpMessageNotReadableExceptionHandler]", ex);
//        return CommonResult.error(GlobalErrorCodeConstants.BAD_REQUEST.getCode(), "请求参数格式错误")
//                .setDetailMessage(ExceptionUtil.getRootCauseMessage(ex));
//    }
//
//    /**
//     * 处理 SpringMVC 参数绑定不正确，本质上也是通过 Validator 校验
//     */
//    @ExceptionHandler(BindException.class)
//    public CommonResult bindExceptionHandler(BindException ex) {
//        log.warn("[handleBindException]", ex);
//        FieldError fieldError = ex.getFieldError();
//        String errorMsg = fieldError == null ? "请求参数不正确" : StrUtil.format("{}", fieldError.getDefaultMessage());
//        return CommonResult.error(GlobalErrorCodeConstants.BAD_REQUEST.getCode(), errorMsg)
//                .setDetailMessage(ExceptionUtil.getRootCauseMessage(ex));
//    }
//
//    /**
//     * 处理 Validator 校验不通过产生的异常
//     */
//    @ExceptionHandler(value = ConstraintViolationException.class)
//    public CommonResult constraintViolationExceptionHandler(ConstraintViolationException ex) {
//        log.warn("[constraintViolationExceptionHandler]", ex);
//        ConstraintViolation<?> constraintViolation = ex.getConstraintViolations().iterator().next();
//        return CommonResult.error(GlobalErrorCodeConstants.BAD_REQUEST.getCode(), StrUtil.format("{}", constraintViolation.getMessage()))
//                .setDetailMessage(ExceptionUtil.getRootCauseMessage(ex));
//    }
//
//    /**
//     * 处理 SpringMVC 请求地址不存在
//     *
//     * 注意，它需要设置如下两个配置项：
//     * 1. spring.mvc.throw-exception-if-no-handler-found 为 true
//     * 2. spring.mvc.static-path-pattern 为 /statics/**
//     */
//    @ExceptionHandler(NoHandlerFoundException.class)
//    public CommonResult noHandlerFoundExceptionHandler(NoHandlerFoundException ex) {
//        log.warn("[noHandlerFoundExceptionHandler]", ex);
//        return CommonResult.error(GlobalErrorCodeConstants.NOT_FOUND.getCode(), StrUtil.format("请求地址不存在:{}", ex.getRequestURL()))
//                .setDetailMessage(ExceptionUtil.getRootCauseMessage(ex));
//    }
//
//    /**
//     * 处理 SpringMVC 请求方法不正确
//     *
//     * 例如说，A 接口的方法为 GET 方式，结果请求方法为 POST 方式，导致不匹配
//     */
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public CommonResult httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException ex) {
//        log.warn("[httpRequestMethodNotSupportedExceptionHandler]", ex);
//        return CommonResult.error(GlobalErrorCodeConstants.METHOD_NOT_ALLOWED.getCode(), StrUtil.format("请求方法不正确:{}", ex.getMessage()))
//                .setDetailMessage(ExceptionUtil.getRootCauseMessage(ex));
//    }
//
//    /**
//     * 处理业务异常 ServiceException
//     *
//     * 例如说，商品库存不足，用户手机号已存在。
//     */
//    @ExceptionHandler(value = ServiceException.class)
//    public CommonResult serviceExceptionHandler(ServiceException ex) {
//        log.info("[serviceExceptionHandler]", ex);
//        return CommonResult.error(ex.getCode(), ex.getMessage());
//    }
//
//    /**
//     * 处理全局异常 ServiceException
//     *
//     * 例如说，Dubbo 请求超时，调用的 Dubbo 服务系统异常
//     */
//    @ExceptionHandler(value = GlobalException.class)
//    public CommonResult globalExceptionHandler(HttpServletRequest req, GlobalException ex) {
//        // 系统异常时，才打印异常日志
//        if (GlobalErrorCodeConstants.INTERNAL_SERVER_ERROR.getCode().equals(ex.getCode())) {
//            log.error("[globalExceptionHandler]", ex);
//        } else {
//            log.info("[globalExceptionHandler]", ex);
//        }
//        // 返回 ERROR CommonResult
//        return CommonResult.error(ex);
//    }
//
//    /**
//     * 处理系统异常，兜底处理所有的一切
//     */
//    @ExceptionHandler(value = Exception.class)
//    public CommonResult defaultExceptionHandler(HttpServletRequest req, Throwable ex) {
//        log.error("[defaultExceptionHandler]", ex);
//        // 返回 ERROR CommonResult
//        return CommonResult.error(GlobalErrorCodeConstants.INTERNAL_SERVER_ERROR.getCode(), GlobalErrorCodeConstants.INTERNAL_SERVER_ERROR.getMessage())
//                .setDetailMessage(ExceptionUtil.getRootCauseMessage(ex));
//    }
}
