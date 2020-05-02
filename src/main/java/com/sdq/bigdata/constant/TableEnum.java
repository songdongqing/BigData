package com.sdq.bigdata.constant;

/**
 * Author:   chenfeiliang
 * Description:
 */
public enum  TableEnum {

    POSITION("position","1"),
    COMPANY_SALARY("companySalary","2"),

    ;

    private String tableName;
    private String index;

    private TableEnum(String tableName, String index) {
        this.tableName = tableName;
        this.index = index;
    }

    public String getTableName() {
        return tableName;
    }

    public String getIndex() {
        return index;
    }
}