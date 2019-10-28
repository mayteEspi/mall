package com.rumbo.mall.service.sale;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith( MockitoExtension.class )
public class SaleTaxeServiceTest {

	private static final String CHOCOLATE_BAR_FOOD_MOCK = "chocolate bar";
	@InjectMocks
	private SaleTaxeServiceImpl saleTaxeService;
	
	@Test
	public void findTaxeFood_shouldReturnProductPrice() {
		final double taxe = saleTaxeService.findProductTaxe(CHOCOLATE_BAR_FOOD_MOCK);
		assertTrue(0 == taxe);
	}
	
	@Test
	public void findTaxeImportedFood_shouldReturnProductPriceIncreased() {
		final double taxe = saleTaxeService.findProductTaxe("imported" + CHOCOLATE_BAR_FOOD_MOCK);
		assertTrue(0.05 == taxe);
	}
}
