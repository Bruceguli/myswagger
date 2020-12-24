package com.lehu.swaggerdemo.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@ApiModel("通用接口返回对象")
@Data
public class ArtisticProductListRequest {
    @ApiParam(value="用户id",required = true)
    private String userId;
    @ApiParam(value="画框产品尺寸",required = true)
    private String artisticProductSize;
    @ApiParam(value="画框名称",required = true)
    private String artisticProductName;
    @ApiParam(value="画框英文名称",required = true)
    private String artisticProductEnglishName;
    @ApiParam(value="画框英文材质",required = true)
    private String artisticProductEnglishMaterial;
    @ApiParam(value="画框此安置",required = true)
    private String artisticProductMaterial;
    @ApiParam(value="画框创建时间",required = true)
    private String artisticProductCreateTime;
    @ApiParam(value="画框产品版本",required = true)
    private String artisticProductVersion;
    @ApiParam(value="画框产品编号",required = true)
    private String artisticProductNo;

}
