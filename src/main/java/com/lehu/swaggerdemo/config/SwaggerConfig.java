package com.lehu.swaggerdemo.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableSwaggerBootstrapUi;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUi
public class SwaggerConfig {

    private static final String splitor = ";";
    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    //单路径的
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))           //加了ApiOperation注解的方法，生成接口文档
                .apis(RequestHandlerSelectors.basePackage("com.lehu.swaggerdemo.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    //多个路径的
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))           //加了ApiOperation注解的方法，生成接口文档
//                .apis(basePackage("com.gl.ms.basemodule.controller"+splitor
//                        + "com.gl.ms.modules.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://localhost:端口号/swagger-ui.html#/swagger-test-controller
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("")
                .description("project文档")
                .termsOfServiceUrl("https://blog.csdn.net/ityqing")
                .contact("lcl")
                .version("1.0")
                .build();
    }

    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage)     {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(splitor)) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }


//    @Api：用在类上，说明该类的作用。
//
//    @ApiOperation：注解来给API增加方法说明。
//
//    @ApiImplicitParams : 用在方法上包含一组参数说明。
//
//    @ApiImplicitParam：用来注解来给方法入参增加说明。
//
//    @ApiResponses：用于表示一组响应
//
//    @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
//
//    l   code：数字，例如400
//
//    l   message：信息，例如"请求参数没填好"
//
//    l   response：抛出异常的类
//
//    @ApiModel：描述一个Model的信息（一般用在请求参数无法使用@ApiImplicitParam注解进行描述的时候）
//
//    l   @ApiModelProperty：描述一个model的属性
//
//
//
//    注意：@ApiImplicitParam的参数说明：

}