package com.rumbo.mall.service.sale;


import com.rumbo.mall.dto.enums.sale.ProductType;
import com.rumbo.mall.dto.sale.ProductDTO;

public class SaleTaxeServiceImpl implements SaleTaxeService{

	
	@Override
	public double findTotalPriceWithTaxe(final ProductDTO product) {
		final String productTypeValue = product.getProductType();
		final ProductType productType = ProductType.fromValue(productTypeValue);
		final double importedPrice = productTypeValue.contains("imported") ? 0.05 : 0;
		final double taxe = !isBasicProduct(productType) ? 0.1 : 0;
		return calculateTaxe(product.getPrice(), importedPrice + taxe);
	}

	private boolean isBasicProduct(final ProductType productType) {
		return ProductType.FOOD.equals(productType)|| ProductType.MEDICATION.equals(productType) || ProductType.BOOKS.equals(productType) ? true : false;
	}

	private double calculateTaxe(final double price,final double taxe) {
		return  price + (price*taxe);
	}
	
}
