package com.rumbo.mall.service.sale;


import com.rumbo.mall.dto.enums.sale.ProductType;
import com.rumbo.mall.dto.sale.ProductDTO;

public class SaleTaxeServiceImpl implements SaleTaxeService{

	
	@Override
	public double findProductTaxe(final ProductDTO product) {
		final String productDesc = product.getProduct();
		final ProductType productType = ProductType.fromValue(productDesc);
		final double importedPrice = productDesc.contains("imported") ? 0.05 : 0;
		final double taxe = !isBasicProduct(productType) ? 0.1 : 0;
		return importedPrice + taxe;
	}

	private boolean isBasicProduct(final ProductType productType) {
		return ProductType.FOOD.equals(productType)|| ProductType.MEDICATION.equals(productType) || ProductType.BOOKS.equals(productType) ? true : false;
	}

}
