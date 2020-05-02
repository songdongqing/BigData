package com.sdq.bigdata.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author:   chenfeiliang
 * Description:
 */
@ApiModel("样本请求报文")
@Data
public class GetSampleVo {
    @ApiModelProperty("城市，可不传，不传则不区分城市，查全部")
    String city;
}