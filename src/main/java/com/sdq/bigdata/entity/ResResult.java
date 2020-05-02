package com.sdq.bigdata.entity;

import lombok.Data;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Data
public class ResResult {

    private int status;
    private String message;
    private List<Object> list;

    public ResResult(int status, String message, List<Object> list) {
        this.status = status;
        this.message = message;
        this.list = list;
    }



    public static ResResult success(List<Object> list){
        return new ResResult(200,"success",list);
    }

    public static ResResult fail(String message){
        return new ResResult(400,message,null);
    }
}