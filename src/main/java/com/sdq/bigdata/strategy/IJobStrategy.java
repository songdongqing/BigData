package com.sdq.bigdata.strategy;

import com.sdq.bigdata.dto.JobResult;

/**
 * Author:   chenfeiliang
 * Description:策略模式
 */
public interface IJobStrategy <T> {

    public JobResult<T> getDatas(int pages);
}
