package com.rumbo.mall.controller.sale;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rumbo.mall.dto.sale.SaleDTO;
import com.rumbo.mall.dto.sale.TicketSaleDTO;
import com.rumbo.mall.service.sale.SaleService;

@RestController
@RequestMapping( value =  "/ticketSale", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE } )
public class SaleController {
	
	 private final SaleService saleService;
	 
	 
	 public SaleController(SaleService saleService) {
		this.saleService = saleService;
	}


	@PostMapping
	public TicketSaleDTO generateTicketSale(@RequestBody final SaleDTO sale){
		return saleService.createTicketSale(sale);
		 
	}

}
