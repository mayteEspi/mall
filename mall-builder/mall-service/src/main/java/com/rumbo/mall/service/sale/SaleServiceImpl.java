package com.rumbo.mall.service.sale;

import java.util.List;
import java.util.stream.Collectors;

import com.rumbo.mall.dto.enums.sale.SaleDTO;
import com.rumbo.mall.dto.enums.sale.TicketSaleDTO;
import com.rumbo.mall.dto.sale.ProductDTO;

public class SaleServiceImpl implements SaleService {

	private final SaleTaxeService saleTaxeService;
	
	public SaleServiceImpl(SaleTaxeService saleTaxeService) {
		this.saleTaxeService = saleTaxeService;
	}

	public TicketSaleDTO createTicketSale(final SaleDTO sale){
		double saleTaxes = 0;
		double totalPriceSale = 0;
		List<ProductDTO> products = generateDataTicketProducts(sale.getProducts(), saleTaxes, totalPriceSale);	
		return new TicketSaleDTO(products,saleTaxes, totalPriceSale);
	}
	
	
	private List<ProductDTO> generateDataTicketProducts(final List<ProductDTO> products, double saleTaxes, double totalPriceSale) {
		return products.stream()
				.map(product -> calculatePriceWithTaxe(product, saleTaxes, totalPriceSale))
				.collect(Collectors.toList());
	}
	
	private ProductDTO calculatePriceWithTaxe(final ProductDTO product, double saleTaxes, double totalPriceSale) {
		final double price = product.getPrice();
		final double taxe = saleTaxeService.findProductTaxe(product);
		final double totalPriceProduct =  price + (price*taxe);
		saleTaxes = saleTaxes + taxe;
		totalPriceSale = totalPriceSale * product.getQuantity() + totalPriceProduct;
		product.setPrice(totalPriceProduct);
		return product;
	}
	
	
}
