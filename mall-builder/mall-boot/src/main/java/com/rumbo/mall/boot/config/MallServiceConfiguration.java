package com.rumbo.mall.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rumbo.mall.service.sale.SaleTaxeService;
import com.rumbo.mall.service.sale.SaleTaxeServiceImpl;

@Configuration
public class MallServiceConfiguration {

	@Bean
	public SaleTaxeService saleTaxeService() {
		return new SaleTaxeServiceImpl();
	}
}
