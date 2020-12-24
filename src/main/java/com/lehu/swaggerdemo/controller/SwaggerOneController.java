package com.lehu.swaggerdemo.controller;


import com.alibaba.fastjson.JSON;
import com.lehu.swaggerdemo.entity.one.R;
import com.lehu.swaggerdemo.entity.request.ArtisticProductListRequest;
import com.lehu.swaggerdemo.entity.two.ArtLabelDeleteByNoRequest;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;

//测试地址http://localhost:8066/swagger-ui.html#/swagger-test-controller
@Controller
@RequestMapping("/swaggerTestOne")
@Api(value = "测试接口一")
public class SwaggerOneController {



    /**
     * 公司实例get请求
     * @param request
     * @return
     * @throws ParseException
     */
    @ResponseBody
    @RequestMapping(value ="/getArtisticProductList", method= RequestMethod.GET)
    @ApiOperation(value="接口标识比如新增", notes="接口描述")
    @ApiImplicitParam(paramType="query", name = "ArtisticProductListRequest", value = "第一个参数说明\n 第二个参数说明", required = true,
            dataType = "Json",defaultValue = "{\"pageNum\":\"1\",\"pageSize\":\"999\",\"artisticProductName\":\"可\"}")
    @ApiResponses(value={
            @ApiResponse(code=1,message="model => 'data':{'moduleId':'模型id'}"),
            @ApiResponse(code=2,message="model => 'data':{'modelName':'模型名称'}")}
    )
    public R getArtisticProductList(@RequestParam("ArtisticProductListRequest") String request) throws ParseException {
        ArtisticProductListRequest activityListRequest = JSON.parseObject(request, ArtisticProductListRequest.class);
        System.out.println(request);
        return R.ok().put("test",activityListRequest);
    }



    /**
     * 公司实例Post请求
     */
    @ApiModelProperty(value = "接口说明")
    @ResponseBody
    @RequestMapping(value ="/deleteArtLabel", method= RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "one", value = "入参字段一", required = true, dataType = "Integer",defaultValue = "100"),
            @ApiImplicitParam(paramType="query", name = "two", value = "入参字段二", required = true, dataType = "String",defaultValue = "100"),
            @ApiImplicitParam(paramType="query", name = "three", value = "入参字段三", required = true, dataType = "String",defaultValue = "100"),
            @ApiImplicitParam(paramType="query", name = "ArtLabelDeleteByNoRequest", value = "这个是请求对象",
                    required = true, dataType = "Json",defaultValue = "{\"artlabelNo\":\"100\"}")
    })
    @ApiResponses(value={
            @ApiResponse(code=1,message="model => 'data':{'moduleId':'模型id'}"),
            @ApiResponse(code=2,message="model => 'data':{'modelName':'模型名称'}")}
    )
    public R deletePCArtLabel(ArtLabelDeleteByNoRequest artLabelDeleteByNoRequest) {

        System.out.println(artLabelDeleteByNoRequest);
        return R.ok("删除成功!");
    }

//    @ResponseBody
//    @RequestMapping(value="/test2", method= RequestMethod.POST)
//    @ApiOperation(value="多个入参测试接口", notes="输入用户名密码")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType="query", name = "userId", value = "用户ID", required = true, dataType = "Integer"),
//            @ApiImplicitParam(paramType="query", name = "password", value = "旧密码", required = true, dataType = "String"),
//            @ApiImplicitParam(paramType="query", name = "newPassword", value = "新密码", required = true, dataType = "String")
//    })
//    public String test2(@RequestParam(value="userId") Integer userId, @RequestParam(value="password") String password,
//                        @RequestParam(value="newPassword") String newPassword){
//        if(userId <= 0 || userId > 2){
//            return "未知的用户";
//        }
//        if(StringUtils.isEmpty(password) || StringUtils.isEmpty(newPassword)){
//            return "密码不能为空";
//        }
//        if(password.equals(newPassword)){
//            return "新旧密码不能相同";
//        }
//        return "密码修改成功!";
//    }
}
