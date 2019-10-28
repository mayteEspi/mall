package com.rumbo.mall.dto.enums.sale;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProductTypeTest {

	@Test
	public void findFood_shouldReturnFoodType() {
		final String food = "chocolate bar";
		assertEquals(ProductType.FOOD, ProductType.fromValue(food));
	}
	
	@Test
	public void findBook_shouldReturnBookType() {
		final String book = "book";
		assertEquals(ProductType.BOOKS, ProductType.fromValue(book));
	}
	
	@Test
	public void findImportedBook_shouldReturnBookType() {
		final String book = "imported book";
		assertEquals(ProductType.BOOKS, ProductType.fromValue(book));
	}
	
	@Test
	public void findMusicCd_shouldReturnBookType() {
		final String music = "music CD";
		assertEquals(ProductType.ELECTRONIC_DEVICES, ProductType.fromValue(music));
	}
	
	@Test
	public void findFood_shouldNotFindType() {
		final String food = "melon";
		assertEquals(ProductType.GENERIC, ProductType.fromValue(food));
	}
}
