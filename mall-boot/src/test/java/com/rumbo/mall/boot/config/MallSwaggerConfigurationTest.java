package com.meh.mall.boot.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.meh.mall.boot.config.MallSwaggerConfiguration;

import springfox.documentation.spring.web.plugins.Docket;


@ExtendWith( MockitoExtension.class )
public class MallSwaggerConfigurationTest {

    @InjectMocks
    private MallSwaggerConfiguration swaggerConfiguration;

    @Test
    public void cmApi() {
        final Docket docket = swaggerConfiguration.mallAPI();
        assertNotNull( docket );
        assertEquals( "MALLAPI", docket.getGroupName() );
    }
	   
}