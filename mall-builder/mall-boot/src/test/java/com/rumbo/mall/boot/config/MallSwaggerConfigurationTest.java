package com.rumbo.mall.boot.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import springfox.documentation.spring.web.plugins.Docket;


@ExtendWith( MockitoExtension.class )
public class MallSwaggerConfigurationTest {

    @InjectMocks
    private MallSwaggerConfiguration swaggerConfiguration;

    @Test
    public void cmApi() {
        final Docket docket = swaggerConfiguration.cmAPI();
        assertNotNull( docket );
        assertEquals( "MALLAPI", docket.getGroupName() );
    }
	   
}