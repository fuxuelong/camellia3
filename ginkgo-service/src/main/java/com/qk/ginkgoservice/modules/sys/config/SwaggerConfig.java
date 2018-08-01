package com.qk.ginkgoservice.modules.sys.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by chen on 2017/4/19.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 全局参数
     *
     * @return
     */
    private List<Parameter> parameter() {
        List<Parameter> params = new ArrayList<>();
        params.add(new ParameterBuilder().name("Authorization")
                .description("Authorization Bearer token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build());
        return params;
    }


    @Bean
    public Docket sysApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.qk.ginkgoservice.modules"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(parameter());
                //.securitySchemes(newArrayList(oauth()))
               // .securityContexts(newArrayList(securityContext()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(" ginkgo-service api ")
                .description("ginkgo-service 微服务")
                .termsOfServiceUrl("")
                .contact("fuxuelong")
                .version("v1.0.0")
                .build();
    }

}
