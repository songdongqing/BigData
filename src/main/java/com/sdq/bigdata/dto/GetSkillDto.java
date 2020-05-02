package com.sdq.bigdata.dto;

import lombok.Data;

import java.util.Map;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Data
public class GetSkillDto {
    String position;
    Map<String,Integer> skillMap;
}