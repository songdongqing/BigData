package com.sdq.bigdata.dto;

import com.sdq.bigdata.entity.Result;
import lombok.Data;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:统一返回的结果实体类
 */
@Data
public class JobResult<T> {
    private T jobs;
}