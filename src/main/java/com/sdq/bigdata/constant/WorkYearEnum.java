package com.sdq.bigdata.constant;

/**
 * Author:   chenfeiliang
 * Description:
 */
public enum  WorkYearEnum {

    LEVER1("应届毕业生","1"),
    LEVER2("1年以下","1"),
    LEVER3("1-3年","1"),
    LEVER4("3-5年","1"),
    LEVER5("5-10年","1"),
    LEVER6("10年以上","1"),
    LEVER7("不限","1")
    ;



    private String key;
    private String index;

    WorkYearEnum(String key, String index) {
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