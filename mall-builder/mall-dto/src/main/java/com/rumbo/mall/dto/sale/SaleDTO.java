package com.rumbo.mall.dto.sale;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SaleDTO implements Serializable {

	private static final long serialVersionUID = -6930317935901308470L;

	private List<ProductDTO> products;
	
}
