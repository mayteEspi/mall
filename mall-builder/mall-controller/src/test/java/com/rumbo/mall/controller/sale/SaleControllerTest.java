package com.rumbo.mall.controller.sale;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

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
import com.rumbo.mall.service.sale.SaleService;
import com.rumbo.mall.util.TestUtil;

@ExtendWith( MockitoExtension.class )
class SaleControllerTest {
	
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
    	final SaleDTO sale = mockSaleDTO();
        final MvcResult response = mockMvc.perform( get( "/ticketSale" ) 
        		.param( "sale",  TestUtil.pojoToJson( sale )  ) )
        		.andExpect( status().isOk() )
                .andReturn();
        assertNotNull( response );
        verify( saleService ).createTicketSale(sale);
    }


	private SaleDTO mockSaleDTO() {
		final ProductDTO product = new ProductDTO("chocolate",0.34,2);
		final SaleDTO sale = new SaleDTO(Collections.singletonList(product));
		return sale;
	}
    
   

}
