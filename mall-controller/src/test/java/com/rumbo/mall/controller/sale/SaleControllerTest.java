package com.rumbo.mall.controller.sale;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.rumbo.mall.dto.sale.ProductDTO;
import com.rumbo.mall.dto.sale.SaleDTO;
import com.rumbo.mall.dto.sale.TicketProductDTO;
import com.rumbo.mall.dto.sale.TicketSaleDTO;
import com.rumbo.mall.service.sale.SaleService;
import com.rumbo.mall.util.TestUtil;

@ExtendWith( MockitoExtension.class )
class SaleControllerTest {
	
	private static final double PRICE_SALE_MOCK = 0.34;

	@InjectMocks
	private SaleController controller;
	
	@Mock
	private SaleService saleService;
	

	private MockMvc mockMvc;
	
	@BeforeEach
    public void setUp() {
		controller = new SaleController(saleService);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup( controller )
                .setMessageConverters( new GsonHttpMessageConverter() )
                .build();
    }
	

    @Test
    public void findLocationShouldOk() throws Exception {
    	final TicketSaleDTO ticketResp = mockTicketSale();
    	when(saleService.createTicketSale(any(SaleDTO.class))).thenReturn(ticketResp);
        final MvcResult response = mockMvc.perform( post( "/ticketSale"  ) 
        		.contentType( APPLICATION_JSON_UTF8 )
        		.content(TestUtil.pojoToJson(mockSaleDTO())))
        		.andExpect( status().isOk() )
                .andReturn();
        assertTrue(response.getResponse().getContentAsString().contains(TestUtil.pojoToJson(ticketResp)));
    }


	private TicketSaleDTO mockTicketSale() {
		double totalPrice = PRICE_SALE_MOCK*2;
		final TicketProductDTO product = TicketProductDTO.builder()
				.price(totalPrice)
				.pricePerQuantity(PRICE_SALE_MOCK)
				.taxePrice(0)
				.build();
		final List<TicketProductDTO> ticketProducts = Collections.singletonList(product);
		return new TicketSaleDTO(ticketProducts, 0, totalPrice);
	}


	private SaleDTO mockSaleDTO() {
		return new SaleDTO(Collections.singletonList(new ProductDTO("chocolate",PRICE_SALE_MOCK,2)));
	}
    
   

}
