package com.rumbo.mall.service.sale;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rumbo.mall.dto.sale.ProductDTO;
import com.rumbo.mall.dto.sale.SaleDTO;
import com.rumbo.mall.dto.sale.TicketSaleDTO;

@ExtendWith( MockitoExtension.class )
public class SaleServiceTest {


	private SaleService saleService;
	
	@InjectMocks
	private SaleTaxeServiceImpl saleTaxeService;
	
	@BeforeEach
	public void init() {
		saleService = new SaleServiceImpl(saleTaxeService);
	}
	
	@Test
	public void searchInput1_shouldReturnTicket() {
		final List<ProductDTO> products= new ArrayList<>();
		products.add(new ProductDTO("Chocolate Bar", 0.85 ,1 ));
		products.add(new ProductDTO("book", 12.49 ,1 ));
		products.add(new ProductDTO("music CD", 14.99 ,1) );
		SaleDTO sale = new SaleDTO(products);
		final TicketSaleDTO ticket = saleService.createTicketSale(sale);
		assertTrue(1.50 == ticket.getSaleTaxes());
	}
	
	@Test
	public void searchInput2_shouldReturnTicket() {
		final List<ProductDTO> products= new ArrayList<>();
		products.add(new ProductDTO("imported box of chocolate", 10.00 ,1 ));
		products.add(new ProductDTO("imported bottle of perfume", 47.50 ,1 ));
		SaleDTO sale = new SaleDTO(products);
		final TicketSaleDTO ticket = saleService.createTicketSale(sale);
		assertTrue(7.63 == ticket.getSaleTaxes());
		assertTrue(65.13 == ticket.getTotalPriceSale());
	}
	
	@Test
	public void searchInput3_shouldReturnTicket() {
		final List<ProductDTO> products= new ArrayList<>();
		products.add(new ProductDTO("bottle of perfume", 20.89 ,1 ));
		products.add(new ProductDTO("imported bottle of perfume", 32.19 ,1 ));
		products.add(new ProductDTO("packet of headache pills", 9.75 ,1 ));
		products.add(new ProductDTO("imported box of chocolates", 11.85 ,1 ));
		SaleDTO sale = new SaleDTO(products);
		final TicketSaleDTO ticket = saleService.createTicketSale(sale);
		assertTrue(7.51 == ticket.getSaleTaxes());
	}
	
	
}
