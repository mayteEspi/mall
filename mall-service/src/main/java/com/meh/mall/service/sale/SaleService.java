package com.meh.mall.service.sale;

import com.meh.mall.dto.sale.SaleDTO;
import com.meh.mall.dto.sale.TicketSaleDTO;

public interface SaleService {

	TicketSaleDTO createTicketSale(final SaleDTO sale);

}
