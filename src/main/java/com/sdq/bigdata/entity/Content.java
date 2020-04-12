
package com.sdq.bigdata.entity;

import lombok.Data;

@Data
public class Content {

    private String showId;
//    private HrInfoMap hrInfoMap;
    private int pageNo;
    private PositionResult positionResult;
    private int pageSize;
    public void setShowId(String showId) {
        this.showId = showId;
    }

}