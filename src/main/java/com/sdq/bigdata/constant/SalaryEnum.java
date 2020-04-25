package com.sdq.bigdata.constant;

/**
 * Author:   chenfeiliang
 * Description:
 */
public enum  SalaryEnum {

    NUM_0_5 ("0-5",0,5),
    NUM_6_10 ("6-10",6,10),
    NUM_11_15 ("11-15",11,15),
    NUM_16_20 ("16-20",16,20),
    NUM_21_25 ("21-25",21,25),
    NUM_26_30 ("26-30",26,30),
    NUM_31_35 ("31-35",31,35),
    NUM_36_40 ("36-40",35,40),
    NUM_41("41以上",41,10000)

    ;


    private String key;
    private int minVal;
    private int maxVal;

    SalaryEnum(String key, int minVal, int maxVal) {
        this.key = key;
        this.minVal = minVal;
        this.maxVal = maxVal;
    }

    public String getKey() {
        return key;
    }

    public int getMinVal() {
        return minVal;
    }

    public int getMaxVal() {
        return maxVal;
    }
}