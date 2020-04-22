package com.sdq.bigdata.constant;

import lombok.Data;

/**
 * Author:   chenfeiliang
 * Description:
 */
public enum PositionEnum {

    DA("数据分析","1"),
    BDO("数据运营","2"),
    DM("数据挖掘","3"),
    AE("算法工程师","4")
    ;

    private String name;
    private String index;

    public String getName() {
        return name;
    }

    public String getIndex() {
        return index;
    }

    // 构造方法
    private PositionEnum(String name, String index) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(int index) {
        for (PositionEnum positionEnum : PositionEnum.values()) {
            if (positionEnum.getIndex().equals(index) ) {
                return positionEnum.name;
            }
        }
        return null;
    }
}
