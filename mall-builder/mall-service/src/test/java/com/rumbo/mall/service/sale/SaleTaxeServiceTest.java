package com.rumbo.mall.service.sale;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rumbo.mall.dto.sale.ProductDTO;

@ExtendWith( MockitoExtension.class )
public class SaleTaxeServiceTest {

	private static final String CHOCOLATE_BAR_FOOD_MOCK = "chocolate bar";
	@InjectMocks
	private SaleTaxeServiceImpl saleTaxeService;
	
	@Test
	public void findTaxeFood_shouldReturnProductPrice() {
		final double productPrice = 12.6454;
		final double totalPrice = saleTaxeService.findTotalPriceWithTaxe(mockProduct(CHOCOLATE_BAR_FOOD_MOCK,productPrice));
		assertTrue(totalPrice == productPrice);
	}
	
	@Test
	public void findTaxeImportedFood_shouldReturnProductPriceIncreased() {
		final double productPrice = 12.6454;
		final double totalPrice = saleTaxeService.findTotalPriceWithTaxe(mockProduct("imported" + CHOCOLATE_BAR_FOOD_MOCK,productPrice));
		assertFalse(totalPrice == productPrice);
	}


	private ProductDTO mockProduct(final String productType, final double price) {
		return new ProductDTO(productType, price);
	}
}
