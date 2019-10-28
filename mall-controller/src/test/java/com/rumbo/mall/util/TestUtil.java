package com.rumbo.mall.util;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {
	
	 public static <T> String pojoToJson( final T pojoObject ) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion( JsonInclude.Include.NON_NULL );
        try {
            return mapper.writeValueAsString( pojoObject );
        } catch( final JsonProcessingException error ) {
            return null;
        }
	 }
}
