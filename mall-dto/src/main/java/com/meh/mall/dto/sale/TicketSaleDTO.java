package com.meh.mall.dto.sale;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TicketSaleDTO implements Serializable {

	private static final long serialVersionUID = -1904021983203965960L;

	private List<TicketProductDTO> products;
	private double saleTaxes;
	private double totalPriceSale;
}
