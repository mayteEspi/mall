package com.meh.mall.service.sale;


import com.meh.mall.dto.enums.sale.ProductType;

public class SaleTaxeServiceImpl implements SaleTaxeService{

	
	@Override
	public double findProductTaxe(final String descProduct) {
		final ProductType productType = ProductType.fromValue(descProduct);
		final double importedPrice = descProduct.contains("imported") ? 0.05 : 0;
		final double taxe = !isBasicProduct(productType) ? 0.10 : 0;
		return importedPrice + taxe;
	}

	private boolean isBasicProduct(final ProductType productType) {
		return ProductType.FOOD.equals(productType)|| ProductType.MEDICATION.equals(productType) || ProductType.BOOKS.equals(productType) ? true : false;
	}

}
