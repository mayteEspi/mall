package com.rumbo.mall.service.sale;

import com.rumbo.mall.dto.sale.ProductDTO;

public interface SaleTaxeService {

	double findProductTaxe(ProductDTO product);

}
