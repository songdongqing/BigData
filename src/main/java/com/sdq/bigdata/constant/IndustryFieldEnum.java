package com.sdq.bigdata.constant;

/**
 * Author:   chenfeiliang
 * Description:
 */
public enum IndustryFieldEnum {

    LEVER1("VRAR","1"),
    LEVER2("不限","1"),
    LEVER3("人工智能","1"),
    LEVER4("企业服务","1"),
    LEVER5("信息安全","1"),
    LEVER6("其他","1"),
    LEVER7("区块链","1"),
    LEVER8("医疗健康","1"),
    LEVER9("工具","1"),
    LEVER10("广告营销","1"),
    LEVER11("房产家居","1"),
    LEVER12("招聘","1"),
    LEVER13("教育","1"),
    LEVER14("数据服务","1"),
    LEVER15("文娱内容","1"),
    LEVER16("旅游","1"),
    LEVER17("汽车出行","1"),
    LEVER18("消费生活","1"),
    LEVER19("游戏","1"),
    LEVER20("物流运输","1"),
    LEVER21("物联网","1"),
    LEVER22("电商","1"),
    LEVER23("电子商务","1"),
    LEVER24("硬件","1"),
    LEVER25("社交","1"),
    LEVER26("移动互联网","1"),
    LEVER27("软件开发","1"),
    LEVER28("通讯电子","1"),
    LEVER29("金融","1")

    ;



    private String key;
    private String index;

    IndustryFieldEnum(String key, String index) {
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
