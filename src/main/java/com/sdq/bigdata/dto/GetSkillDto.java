package com.sdq.bigdata.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * Author:   chenfeiliang
 * Description:
 */
@ApiModel("职位要求分析结果")
@Data
public class GetSkillDto {
    @ApiModelProperty("职位名称")
    String position;
    @ApiModelProperty("职位要求集合，key为职业要求技能，value为要求该技能的公司职位数量")
    Map<String,Integer> skillMap;
}