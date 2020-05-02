package com.sdq.bigdata.constant;

/**
 * Author:   chenfeiliang
 * Description:
 */
public enum  CompanySalaryEnum {

    LEVER1("A轮","1"),
    LEVER2("B轮","1"),
    LEVER3("C轮","1"),
    LEVER4("D轮及以上","1"),
    LEVER5("上市公司","1"),
    LEVER6("不需要融资","1"),
    LEVER7("天使轮","1"),
    LEVER8("未融资","1")
    ;



    private String key;
    private String index;

    CompanySalaryEnum(String key, String index) {
        this.key = key;
        this.index = index;
    }

    public String getKey() {
        return key;
    }

    public String getIndex() {
        return index;
    }
}