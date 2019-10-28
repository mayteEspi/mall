package com.rumbo.mall.service.sale;

import com.rumbo.mall.dto.sale.SaleDTO;
import com.rumbo.mall.dto.sale.TicketSaleDTO;

public interface SaleService {

	TicketSaleDTO createTicketSale(final SaleDTO sale);

}
