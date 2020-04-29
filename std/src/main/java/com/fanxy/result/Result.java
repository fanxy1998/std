package com.fanxy.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author famxy
 * @param <T>泛型类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private String sign;
    private String msg;
    private T resultdata;

    public Result(String sign, String msg) {
        this.sign = sign;
        this.msg = msg;
    }
}
