package com.rumbo.mall.controller.sale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rumbo.mall.dto.sale.SaleDTO;
import com.rumbo.mall.dto.sale.TicketSaleDTO;
import com.rumbo.mall.service.sale.SaleService;

@RestController
@RequestMapping("/ticketSale")
public class SaleController {
	
	 private final SaleService saleService;
	 
	 
	 public SaleController(SaleService saleService) {
		this.saleService = saleService;
	}


	@GetMapping
	public TicketSaleDTO generateTicketSale(final SaleDTO sale){
		return saleService.createTicketSale(sale);
		 
	}

}
