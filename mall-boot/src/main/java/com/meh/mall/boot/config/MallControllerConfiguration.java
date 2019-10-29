package com.meh.mall.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.meh.mall.controller.sale.SaleController;
import com.meh.mall.service.sale.SaleService;

@Configuration
@Import( MallServiceConfiguration.class)
public class MallControllerConfiguration {

	@Bean
	public SaleController saleController(final SaleService saleService) {
		return new SaleController(saleService);
	}
}
