package com.sdq.bigdata.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author:   chenfeiliang
 * Description:
 */
@ApiModel("工作年限请求报文")
@Data
public class GetWorkYearVo {
    @ApiModelProperty("城市，可不传，不传则不区分城市，查全部")
    private String city;
    @ApiModelProperty("职位，可不传，不传则不区分职位，查全部")
    private String position;
}