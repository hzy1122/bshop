package org.hzy.bshop.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    private Integer status; // 404 200 501
    private String message; // OK NotFound
    private List<T> data;

    public CommonResult(Integer status, String message){
        this(status,message,null);
    }

}
