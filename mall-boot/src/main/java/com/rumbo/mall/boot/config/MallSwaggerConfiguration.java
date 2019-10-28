package com.rumbo.mall.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class MallSwaggerConfiguration {
	

	private static final String UNEXPECTED_ERROR_MESSAGE = "Unexpected Error";
	private static final String BAD_REQUEST_MESSAGE = HttpStatus.BAD_REQUEST.getReasonPhrase();
	
	@Bean
    public Docket mallAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("MALLAPI")
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,
                        Lists.newArrayList(new ResponseMessageBuilder()
                                        .code(500)
                                        .message(UNEXPECTED_ERROR_MESSAGE)
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(400)
                                        .message(BAD_REQUEST_MESSAGE)
                                        .build()))
                .globalResponseMessage(RequestMethod.POST,
                        Lists.newArrayList(new ResponseMessageBuilder()
                                        .code(500)
                                        .message(UNEXPECTED_ERROR_MESSAGE)
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(400)
                                        .message(BAD_REQUEST_MESSAGE)
                                        .build()))
                .globalResponseMessage(RequestMethod.PUT,
                        Lists.newArrayList(new ResponseMessageBuilder()
                                        .code(500)
                                        .message(UNEXPECTED_ERROR_MESSAGE)
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(400)
                                        .message(BAD_REQUEST_MESSAGE)
                                        .build()))
                .globalResponseMessage(RequestMethod.DELETE,
                        Lists.newArrayList(new ResponseMessageBuilder()
                                        .code(500)
                                        .message(UNEXPECTED_ERROR_MESSAGE)
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(400)
                                        .message(BAD_REQUEST_MESSAGE)
                                        .build()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rumbo.mall.controller"))
                .paths(PathSelectors.any())
                .build();
	}

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("MALL - API")
                .description("Rumbo @ MALL API")
                .version("1.0")
                .build();
    }
    
}