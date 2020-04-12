package com.sdq.bigdata.entity;

import lombok.Data;

/**
 * Author:   chenfeiliang
 * Description:存放拉钩数据的属性
 */
@Data
public class Datas {

    private boolean success;
    private String msg;
    private int code;
    private Content content;
    private String resubmitToken;
    private String requestId;

}