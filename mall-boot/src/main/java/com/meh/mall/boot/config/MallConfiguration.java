package com.meh.mall.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MallControllerConfiguration.class,MallSwaggerConfiguration.class })
public class MallConfiguration {

}
