package com.aisino.springboot_ssmp.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Result<T> {

    private int code;

    private String msg;

    private T data;

    /**
     * 成功时候的调用（有数据）
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    /**
     * 成功时候的调用（无数据）
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(){
        return new Result<T>();
    }

    /**
     * 异常时候的调用（有msg参数）
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(String msg){
        return new Result<T>(msg);
    }

    /**
     * 异常时候的调用（无msg参数）
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(){
        return new Result<T>("error");
    }

    private Result(T data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }

    private Result() {
        this.code = 200;
        this.msg = "success";
    }

    private Result(String msg) {
        this.code = 400;
        this.msg = msg;
    }




}
