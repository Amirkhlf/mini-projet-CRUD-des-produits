package org.sid.metier;

import java.util.List;
import java.util.stream.Collectors;

import org.sid.dao.ProductRepository;
import org.sid.dtos.ProductDto;
import org.sid.entities.Product;
import org.sid.exceptions.ProductNotFoundException;
import org.sid.mappers.ProductMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService  {

	private ProductRepository productRepository;
	
	private ProductMapper dtoMapper ;
	
	
	@Override
	public ProductDto getProduct(Long idProduct) throws ProductNotFoundException {
		
		Product product =  productRepository.findById(idProduct).orElse(null);
		
		if(product==null) throw new ProductNotFoundException("Produit non trouvé pour le id : " + idProduct);

		return dtoMapper.fromProduct(product);
	}

	
	@Override
	public List<ProductDto> listProducts() {

		List<Product> products = productRepository.findAll();
		
		List<ProductDto> productDTOS = products.stream()
				.map(product -> dtoMapper.fromProduct(product))
				.collect(Collectors.toList());
		
		return productDTOS;
	}

	
	@Override
	public ProductDto saveProduct(ProductDto productDto) {

		Product product=dtoMapper.fromProductDto(productDto);
		
		Product savedProduct = productRepository.save(product);

		return dtoMapper.fromProduct(savedProduct);
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto) {
		
		Product product = dtoMapper.fromProductDto(productDto);
		 
		 Product savedProduct = productRepository.save(product);  

		return dtoMapper.fromProduct(savedProduct);
	
	}

	@Override
	public void deleteProduct(Long idProduct) {
		productRepository.deleteById(idProduct);		
	}


	@Override
	public List<ProductDto> listProductsByName(String productName) {
		List<Product> products = productRepository.findByName(productName);
		
		List<ProductDto> productDTOS = products.stream()
				.map(product -> dtoMapper.fromProduct(product))
				.collect(Collectors.toList());
		
		return productDTOS;
	}


	@Override
	public List<ProductDto> listProductsByPrice(double productPrice) {
		List<Product> products = productRepository.findByPrice(productPrice );
		
		List<ProductDto> productDTOS = products.stream()
				.map(product -> dtoMapper.fromProduct(product))
				.collect(Collectors.toList());
		
		return productDTOS;
	}

}
