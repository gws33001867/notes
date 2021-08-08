package com.lance.learningnotes.common;

import com.lance.learningnotes.enums.ResponseCodeEnum;
import lombok.Getter;
import lombok.ToString;

/**
 * 统一返回结果的格式
 */
@Getter
@ToString
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    private CommonResult(ResponseCodeEnum responseCodeEnum, T data){
        this.code = responseCodeEnum.getCode();
        this.message = responseCodeEnum.getMessage();
        this.data = data;
    }
    public CommonResult(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    /** 业务成功返回业务代码和描述信息 */
    public static CommonResult<Void> success() {
        return new CommonResult<Void>(ResponseCodeEnum.SUCCESS, null);
    }

    /** 业务成功返回业务代码,描述和返回的参数 */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResponseCodeEnum.SUCCESS, data);
    }

    /** 业务成功返回业务代码,描述和返回的参数 */
    public static <T> CommonResult<T> success(ResponseCodeEnum responseCodeEnum, T data) {
        if (responseCodeEnum == null) {
            return success(data);
        }
        return new CommonResult<T>(responseCodeEnum, data);
    }

    /** 业务异常返回业务代码和描述信息 */
    public static <T> CommonResult<T> failure() {
        return new CommonResult<T>(ResponseCodeEnum.FAIL, null);
    }

    /** 业务异常返回业务代码,描述和返回的参数 */
    public static <T> CommonResult<T> failure(ResponseCodeEnum responseCodeEnum) {
        return failure(responseCodeEnum, null);
    }

    /** 业务异常返回业务代码,描述和返回的参数 */
    public static <T> CommonResult<T> failure(ResponseCodeEnum responseCodeEnum, T data) {
        if (responseCodeEnum == null) {
            return new CommonResult<T>(ResponseCodeEnum.FAIL, null);
        }
        return new CommonResult<T>(responseCodeEnum, data);
    }

}
