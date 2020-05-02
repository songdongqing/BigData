package com.sdq.bigdata.constant;

/**
 * Author:   chenfeiliang
 * Description:
 */
public enum  CompanySizeEnum {


    LEVER1("少于15人","1"),
    LEVER2("15-50人","2"),
    LEVER3("50-150人","3"),
    LEVER4("150-500人","4"),
    LEVER5("500-2000人","5"),
    LEVER6("2000人以上","6")
    ;

    private String companySize;
    private String index;

    public String getCompanySize() {
        return companySize;
    }

    public String getIndex() {
        return index;
    }

    CompanySizeEnum(String companySize, String index) {
        this.companySize = companySize;
        this.index = index;
    }
}