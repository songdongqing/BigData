package com.sdq.bigdata.constant;

/**
 * Author:   chenfeiliang
 * Description:
 */
public enum CityEnum {

    GUANGZHOU("广州","1"),
    SHENZHEN("深圳","2")
    ;

    private String name;
    private String index;

    private CityEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }


    public String getIndex() {
        return index;
    }

}
