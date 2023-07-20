package org.sid.web;

import java.util.List;

import org.sid.dtos.ProductDto;
import org.sid.exceptions.ProductNotFoundException;
import org.sid.metier.IProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
public class ProductRestController {

	private IProductService productService;
	
	@GetMapping("/products")
	public List<ProductDto> products(){
		return productService.listProducts();
	}
	
	@GetMapping("/products/byName/{name}")
	public List<ProductDto> productsByName(@PathVariable(name="name") String name){
		return productService.listProductsByName(name);
	}
	
	@GetMapping("/products/byPrice/{price}")
	public List<ProductDto> productsByPrice(@PathVariable(name="price") double price){
		return productService.listProductsByPrice(price);
	}
	
	@GetMapping("/products/{id}")
	public ProductDto getProduct(@PathVariable(name ="id") Long idProduct) throws ProductNotFoundException {
		return productService.getProduct(idProduct);
	}
	
	@PostMapping("/products")
	public ProductDto saveProduct(@RequestBody ProductDto productDto) {
		return productService.saveProduct(productDto);
	}
	
	@PutMapping("/products/{id}")
	public ProductDto updateProduct(@PathVariable(name ="id") Long idProduct , @RequestBody ProductDto productDto) {
		productDto.setId(idProduct);
		
		return productService.updateProduct(productDto);
	}
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable(name ="id") Long idProduct) {
		productService.deleteProduct(idProduct);
	}
}
