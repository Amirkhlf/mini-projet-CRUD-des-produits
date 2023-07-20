package org.sid.mappers;


import org.sid.dtos.ProductDto;
import org.sid.entities.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

	public ProductDto fromProduct(Product product) {
		ProductDto productDto=new ProductDto();
		BeanUtils.copyProperties(product, productDto);
		
		return productDto;
	}
	
	public Product fromProductDto(ProductDto productDto) {
		Product product=new Product();
		BeanUtils.copyProperties(productDto, product);
		
		return product;
	}
}
