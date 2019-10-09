package com.rumbo.mall.dto.enums.sale;

import java.io.Serializable;
import java.util.List;

import com.rumbo.mall.dto.sale.ProductDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleDTO implements Serializable {

	private static final long serialVersionUID = -6930317935901308470L;

	private List<ProductDTO> products;
	
	
}
