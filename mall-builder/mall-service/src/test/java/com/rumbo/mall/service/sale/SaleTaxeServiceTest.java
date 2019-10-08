package com.rumbo.mall.service.sale;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rumbo.mall.dto.sale.ProductDTO;

@ExtendWith( MockitoExtension.class )
public class SaleTaxeServiceTest {

	@InjectMocks
	private SaleTaxeServiceImpl saleTaxeService;
	
	@Test
	public void findTaxeFood_shouldReturn0() {
		final double productPrice = 12.6454;
		final double totalPrice = saleTaxeService.findTotalPriceWithTaxe(mockProduct("chocolate bar",productPrice));
		assertTrue(totalPrice == productPrice);
	}

	private ProductDTO mockProduct(final String productType, final double price) {
		return new ProductDTO(productType, price);
	}
}
