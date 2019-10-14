package com.rumbo.mall.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.rumbo.mall.controller.sale.SaleController;
import com.rumbo.mall.service.sale.SaleService;

@Configuration
@Import( MallServiceConfiguration.class)
public class MallControllerConfiguration {

	@Bean
	public SaleController saleController(final SaleService saleService) {
		return new SaleController(saleService);
	}
}
