package com.rumbo.mall.service.sale;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rumbo.mall.dto.sale.ProductDTO;

@ExtendWith( MockitoExtension.class )
public class SaleTaxeServiceTest {

	private static final double PRODUCT_PRICE = 12.6454;
	private static final String CHOCOLATE_BAR_FOOD_MOCK = "chocolate bar";
	@InjectMocks
	private SaleTaxeServiceImpl saleTaxeService;
	
	@Test
	public void findTaxeFood_shouldReturnProductPrice() {
		final double taxe = saleTaxeService.findProductTaxe(mockProduct(CHOCOLATE_BAR_FOOD_MOCK,PRODUCT_PRICE));
		assertTrue(0 == taxe);
	}
	
	@Test
	public void findTaxeImportedFood_shouldReturnProductPriceIncreased() {
		final double totalPrice = saleTaxeService.findProductTaxe(mockProduct("imported" + CHOCOLATE_BAR_FOOD_MOCK,PRODUCT_PRICE));
		assertTrue(0.05 == totalPrice);
	}


	private ProductDTO mockProduct(final String productType, final double price) {
		return new ProductDTO(productType, price,1);
	}
}
