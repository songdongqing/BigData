package com.sdq.bigdata.constant;

/**
 * Author:   chenfeiliang
 * Description:
 */
public enum  SkillEnum {

    LEVER1("AE","1"),
    LEVER2("APP推广","1"),
    LEVER3("APP运营","1"),
    LEVER4("ASO","1"),
    LEVER5("ASP","1"),
    LEVER6("Android","1"),
    LEVER7("B2B","1"),
    LEVER8("BI","1"),
    LEVER9("B端产品","1"),
    LEVER10("C","1"),
    LEVER11("C#/.NET","1"),
    LEVER12("C++","1"),
    LEVER13("C/C++","1"),
    LEVER14("CAD制图","1"),
    LEVER15("CD","1"),
    LEVER16("CI","1"),
    LEVER17("CSS","1"),
    LEVER18("C端产品","1"),
    LEVER19("DB2","1"),
    LEVER20("DBA","1"),
    LEVER21("DevOps","1"),
    LEVER22("ETL","1"),
    LEVER23("Flink","1"),
    LEVER24("GO","1"),
    LEVER25("GSM","1"),
    LEVER26("HTML5","1"),
    LEVER27("Hadoop","1"),
    LEVER28("Hive","1"),
    LEVER29("IOS","1"),

    LEVER30("IT支持","1"),
    LEVER31("Java","1"),
    LEVER32("KA","1"),
    LEVER33("KPI考核","1"),
    LEVER34("LTE","1"),
    LEVER35("Linux","1"),
    LEVER36("Linux/Unix","1"),
    LEVER37("MongoDB","1"),
    LEVER38("MySQL","1"),
    LEVER39("NLP","1"),
    LEVER40("O2O","1"),
    LEVER41("O2O运营","1"),
    LEVER42("OKR管理","1"),
    LEVER43("Oracle","1"),
    LEVER44("PKI","1"),
    LEVER45("Perl","1"),
    LEVER46("Python","1"),
    LEVER47("Redis","1"),
    LEVER48("SAAS","1"),
    LEVER49("SDK","1"),
    LEVER50("SEM","1"),
    LEVER51("SEO","1"),
    LEVER52("SPSS","1"),
    LEVER53("SQL","1"),
    LEVER54("SQLServer","1"),
    LEVER55("SaaS","1"),
    LEVER56("Scala","1"),
    LEVER57("Server端测试","1"),
    LEVER58("Shell","1"),

//    LEVER1("Spark","1"),
//    LEVER2("Storm","1"),
//    LEVER3("TD-SCDMA","1"),
//    LEVER4("UGC","1"),
//    LEVER5("Unity3D","1"),
//    LEVER6("WCDMA","1"),
//    LEVER7("Windows","1"),
//    LEVER8("app","1"),
//    LEVER9("专利","1"),
//    LEVER10("业务流程管理","1"),
//    LEVER11("中间件","1"),
//    LEVER12("主编","1"),
//    LEVER13("买手","1"),
//    LEVER14("事业部经营","1"),
//    LEVER15("交互设计","1"),
//    LEVER16("交易咨询","1"),
//    LEVER17("产品","1"),
//    LEVER18("产品测试","1"),
//    LEVER19("产品策划","1"),
//    LEVER20("产品设计","1"),
//    LEVER21("产品运营","1"),
//    LEVER22("人工智能","1"),
//    LEVER23("人脸识别","1"),
//    LEVER24("付费内容","1"),
//    LEVER25("企业软件","1"),
//    LEVER26("会员体系","1"),
//    LEVER27("传感器","1"),
//    LEVER28("供应链","1"),
//    LEVER29("保险","1"),
//
//    LEVER30("信息安全","1"),
//    LEVER31("信用管理","1"),
//    LEVER32("信贷风险管理","1"),
//    LEVER33("光传输","1"),
//    LEVER34("光通信","1"),
//    LEVER35("全栈","1"),
//    LEVER36("内容","1"),
//    LEVER37("内容审核","1"),
//    LEVER38("内容运营","1"),
//    LEVER39("决策能力","1"),
//    LEVER40("出纳","1"),
//    LEVER41("分布式","1"),
//    LEVER42("分析","1"),
//    LEVER43("创业","1"),
//    LEVER44("PKI","1"),
//    LEVER45("Perl","1"),
//    LEVER46("Python","1"),
//    LEVER47("Redis","1"),
//    LEVER48("SAAS","1"),
//    LEVER49("SDK","1"),
//    LEVER50("SEM","1"),
//    LEVER51("SEO","1"),
//    LEVER52("SPSS","1"),
//    LEVER53("SQL","1"),
//    LEVER54("SQLServer","1"),
//    LEVER55("SaaS","1"),
//    LEVER56("Scala","1"),
//    LEVER57("Server端测试","1"),
//    LEVER58("Shell","1"),

            ;



    private String key;
    private String index;

    SkillEnum(String key, String index) {
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