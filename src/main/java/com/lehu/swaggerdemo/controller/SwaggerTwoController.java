package com.lehu.swaggerdemo.controller;


import com.alibaba.fastjson.JSON;
import com.lehu.swaggerdemo.entity.request.ArtisticProductListRequest;
import com.lehu.swaggerdemo.entity.two.ApiResult;
import com.lehu.swaggerdemo.entity.two.ArtLabelDeleteByNoRequest;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

//测试地址http://localhost:8066/swagger-ui.html#/swagger-test-controller
@Controller
@RequestMapping("/swaggerTestTwo")
@Api(value = "测试接口二")
public class SwaggerTwoController extends BaseController{



    /**
     * 公司实例get请求
     * @param request
     * @return
     * @throws ParseException
     */
    @ResponseBody
    @RequestMapping(value ="/getArtisticProductList", method= RequestMethod.GET)
    @ApiOperation(value="接口标识比如新增", notes="接口描述")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name = "id", value = "参数的汉字说明、解释",required=true,defaultValue="1", dataType = "string"),
            @ApiImplicitParam(paramType="query",name = "userId", value = "参数的汉字说明、解释用户id",required=true,defaultValue="1", dataType = "string"),
            @ApiImplicitParam(paramType="query", name = "ArtisticProductListRequest", value = "第一个参数说明\n 第二个参数说明", required = true,
                    dataType = "Json",defaultValue = "{\"pageNum\":\"1\",\"pageSize\":\"999\",\"artisticProductName\":\"可\"}")
    })
    public ApiResult getArtisticProductList(@RequestParam("ArtisticProductListRequest") String request) throws ParseException {
        ArtisticProductListRequest activityListRequest = JSON.parseObject(request, ArtisticProductListRequest.class);
        System.out.println(request);
        return success("test",activityListRequest);
    }



    /**
     * 公司实例Post请求
     */
    @ApiModelProperty(value = "接口说明")
    @ResponseBody
    @RequestMapping(value ="/deleteArtLabel", method= RequestMethod.POST)
    public ApiResult deletePCArtLabel(@RequestBody ArtLabelDeleteByNoRequest artLabelDeleteByNoRequest) {
        System.out.println(artLabelDeleteByNoRequest);
        return success(artLabelDeleteByNoRequest);
    }

}
