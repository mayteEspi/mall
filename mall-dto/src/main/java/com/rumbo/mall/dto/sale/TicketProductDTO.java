package com.rumbo.mall.dto.sale;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketProductDTO implements Serializable {

	private static final long serialVersionUID = 7829375393522571747L;
	
	private String product;
	private double price;
	private int quantity;
	private double taxePrice;
	private double pricePerQuantity;

}
