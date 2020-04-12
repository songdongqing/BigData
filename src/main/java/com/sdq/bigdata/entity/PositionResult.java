
package com.sdq.bigdata.entity;
import lombok.Data;

import java.util.List;

@Data
public class PositionResult {

    private List<Result> result;
//    private CategoryTypeAndName categoryTypeAndName;
//    private LocationInfo locationInfo;
    private int resultSize;
//    private StrategyProperty strategyProperty;
//    private QueryAnalysisInfo queryAnalysisInfo;
    private int totalCount;

}