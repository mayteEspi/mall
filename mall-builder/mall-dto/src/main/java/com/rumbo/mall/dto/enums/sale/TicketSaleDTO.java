package com.rumbo.mall.dto.enums.sale;

import java.io.Serializable;
import java.util.List;

import com.rumbo.mall.dto.sale.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TicketSaleDTO implements Serializable {

	private static final long serialVersionUID = -1904021983203965960L;

	private List<ProductDTO> products;
	private double saleTaxe;
	private double totalPriceSale;
}
