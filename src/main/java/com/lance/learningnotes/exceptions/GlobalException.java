package com.lance.learningnotes.exceptions;

import com.lance.learningnotes.enums.ResponseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GlobalException extends RuntimeException{
    private int code;
    private String message;

    public GlobalException(ResponseCodeEnum responseCodeEnum){
        this.code = responseCodeEnum.getCode();
        this.message = responseCodeEnum.getMessage();
    }
}
