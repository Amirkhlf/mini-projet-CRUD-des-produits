package org.sid.metier;

import java.util.List;


import org.sid.dtos.ProductDto;
import org.sid.exceptions.ProductNotFoundException;


public interface IProductService {
	
	public ProductDto getProduct(Long idProduct) throws ProductNotFoundException ;
	
	public List<ProductDto> listProducts();
	
	public ProductDto saveProduct(ProductDto productDto);
	
	public ProductDto updateProduct(ProductDto productDto);
	
	public void deleteProduct(Long idProduct);

	public List<ProductDto> listProductsByName(String productName);

	public List<ProductDto> listProductsByPrice(double productPrice);

}
