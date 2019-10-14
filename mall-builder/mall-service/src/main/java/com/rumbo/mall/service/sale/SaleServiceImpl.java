package com.rumbo.mall.service.sale;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import com.rumbo.mall.dto.sale.SaleDTO;
import com.rumbo.mall.dto.sale.TicketProductDTO;
import com.rumbo.mall.dto.sale.TicketSaleDTO;
import com.rumbo.mall.service.mapper.OrikaMapper;

public class SaleServiceImpl implements SaleService {

	private final SaleTaxeService saleTaxeService;
	private OrikaMapper mapper;
	 
	public SaleServiceImpl(SaleTaxeService saleTaxeService) {
		this.saleTaxeService = saleTaxeService;
		mapper = new OrikaMapper();
	}

	@Override
	public TicketSaleDTO createTicketSale(final SaleDTO sale){
		List<TicketProductDTO> products =  sale.getProducts().stream()
				.map(product ->  mapper.map(product, TicketProductDTO.class))
				.map(product -> generateDataTicketProduct(product))
				.collect(Collectors.toList());
		return new TicketSaleDTO(products,calculateTaxeSale(products), calculateTotalSale(products));
	}
	
	private TicketProductDTO generateDataTicketProduct(final TicketProductDTO product) {
		final double price = product.getPrice() ;
		final double taxe = saleTaxeService.findProductTaxe(product.getProduct());
		final double totalPriceProduct =  formatNumber(price + (price*taxe));
		product.setPrice(formatNumber(totalPriceProduct));
		product.setTaxePrice(formatNumber(totalPriceProduct - price));
		product.setPricePerQuantity( totalPriceProduct * product.getQuantity());
		return product;
	}
	
	private double calculateTaxeSale(final List<TicketProductDTO> products) {
		return products.stream()
		  .mapToDouble(product -> formatNumber(product.getTaxePrice()))
		  .sum();
	}
	
	private double calculateTotalSale(final List<TicketProductDTO> products) {
		return products.stream()
		  .mapToDouble(product -> formatNumber( product.getPricePerQuantity()))
		  .sum();
	}
	
	private double formatNumber(final double value) {
		final BigDecimal bigDecimal = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
		return bigDecimal.doubleValue();
	}
	
	
}
