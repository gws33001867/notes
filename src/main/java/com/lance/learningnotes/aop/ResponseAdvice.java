package com.lance.learningnotes.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lance.learningnotes.annotation.ResponseResultBody;
import com.lance.learningnotes.common.CommonResult;
import com.lance.learningnotes.common.ResultData;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;

@RestControllerAdvice(basePackages = "com.lance.learningnotes")
@Slf4j
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    @Autowired
    private ObjectMapper objectMapper;
    private static final Class<? extends Annotation> ANNOTATION_TYPE = ResponseResultBody.class;


    /**
     * 判断类或者方法是否使用了 @ResponseResultBody
     * 避免swagger返回的数据也被预处理
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
//        return AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), ANNOTATION_TYPE) || returnType.hasMethodAnnotation(ANNOTATION_TYPE);
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if(o instanceof String){
            System.out.println(o);
            return objectMapper.writeValueAsString(CommonResult.success(o));
        }
        if(o instanceof CommonResult){
            return o;
        }
        return CommonResult.success(o);
    }
}