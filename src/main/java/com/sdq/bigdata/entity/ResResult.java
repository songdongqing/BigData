package com.sdq.bigdata.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Data
@ApiModel(value = "统一返回报文")
public class ResResult {

    @ApiModelProperty("请求返回状态码，200表示成功，其他表示失败")
    private int status;
    @ApiModelProperty("返回的错误信息，若请求成功，则返回null")
    private String message;
    @ApiModelProperty("返回的数据全部封装在list里面")
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