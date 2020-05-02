package com.sdq.bigdata.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Data
@ApiModel("公司规模请求报文")
public class GetCompanySizeVo {
    @ApiModelProperty("城市，可不传，不传则不区分城市，查全部")
    private String city;
}