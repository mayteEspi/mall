package com.rumbo.mall.dto.enums.sale;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public enum ProductType {
	
	FOOD(Arrays.asList(new String[]{"chocolate", "caramel"})),
	COSMETICS(Arrays.asList(new String[]{"eye shadow","bottle of perfume"})),
	BOOKS(Arrays.asList(new String[]{"book","novel"})),
	ELECTRONIC_DEVICES(Arrays.asList(new String[]{"music","CD","ebook"})),
	MEDICATION(Arrays.asList(new String[]{"headache pills","anti-inflammatory"})),
	GENERIC(Arrays.asList(new String[]{"other"}));
	
	
	private final List<String> valuesProducType;

	private ProductType(List<String> valuesProducType) {
		this.valuesProducType = valuesProducType;
	}

    public static ProductType fromValue( final String valueToFind ) {
    	 return Arrays.asList(ProductType.values()).stream()
    	 	.filter(productType -> findProduct(productType, valueToFind) != null)
    	 	.findFirst().orElse(GENERIC);
    }
    
    private static ProductType findProduct(final ProductType typeProduct, final String value) {
    	final String type =  typeProduct.valuesProducType.stream()
    		    .filter(product -> value.toLowerCase().contains(product.toLowerCase()))
    		    .findFirst()
    		    .orElse(null);
    	return type != null ? typeProduct : null;
    }
	
}
