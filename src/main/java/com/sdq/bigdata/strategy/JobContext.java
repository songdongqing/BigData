package com.sdq.bigdata.strategy;

import com.sdq.bigdata.dto.JobResult;
import lombok.Data;

/**
 * Author:   chenfeiliang
 * Description:
 */

public class JobContext<T> {

    private IJobStrategy iJobStrategy;

    public JobResult<T> getDatas(int pages) {
        return iJobStrategy.getDatas(pages);
    }

    public JobContext(IJobStrategy iJobStrategy) {
        this.iJobStrategy = iJobStrategy;
    }
}