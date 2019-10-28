package com.rumbo.mall.dto.sale;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable{

	private static final long serialVersionUID = 8056624630828258759L;

	private String product;
	private double price;
	private int quantity;
}
