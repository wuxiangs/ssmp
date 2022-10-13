package com.aisino.springboot_ssmp.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 作为springmvc的异常处理器
 *
 * @author wuxiang
 * @date 2022/10/13
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {

    /**
     * 拦截所有的异常信息
     */
    @ExceptionHandler
    public Result doException(Exception ex){
        ex.printStackTrace();
        return Result.error("服务器故障,请稍后再试");
    }
}
