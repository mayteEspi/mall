package com.rumbo.mall.boot.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith( MockitoExtension.class )
public class MallServiceConfigurationTest {

	@InjectMocks
	private MallServiceConfiguration serviceConfiguration;
	
	@Test
	public void serviceBeansDefinitions_shouldNotNull() {
		assertNotNull(serviceConfiguration.saleTaxeService());
	}
}
