package com.hugh7568.ddns.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger 配置文件
 *
 * @author Hugh
 * @date 2022/01/18 14:19
 **/

//@Configuration
//@EnableSwagger2
//@EnableSwaggerBootstrapUI
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //这里写的是API接口所在的包位置
                .apis(RequestHandlerSelectors.basePackage("com.hugh7568.ddns.controller"))
                .paths(PathSelectors.any())
                .build();

    }
}
