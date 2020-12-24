package com.lehu.swaggerdemo.entity.two;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
@ApiModel("通用接口返回对象")
@Data
public class ArtLabelDeleteByNoRequest {

    //编号
    @ApiParam(value="试试画框编号",required = true,defaultValue="110")
    private String  artlabelNo;

    @ApiParam(value="试试画框名称",required = true,defaultValue = "200")
    private String  artlabelName;

}
