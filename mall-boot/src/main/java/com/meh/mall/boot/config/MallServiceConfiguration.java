package com.meh.mall.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.meh.mall.service.sale.SaleService;
import com.meh.mall.service.sale.SaleServiceImpl;
import com.meh.mall.service.sale.SaleTaxeService;
import com.meh.mall.service.sale.SaleTaxeServiceImpl;

@Configuration
public class MallServiceConfiguration {

	@Bean
	public SaleTaxeService saleTaxeService() {
		return new SaleTaxeServiceImpl();
	}
	
	@Bean
	public SaleService saleService(final SaleTaxeService saleTaxeService) {
		return new SaleServiceImpl(saleTaxeService);
	}
}
