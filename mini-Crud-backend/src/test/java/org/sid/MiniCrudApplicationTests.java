package org.sid;


import static org.junit.Assert.assertNotNull;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.sid.dtos.ProductDto;
import org.sid.metier.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MiniCrudApplicationTests {
	
	@Autowired
	private IProductService productService;

	@Test
	public void shouldSaveProductWithSucess() {
	    
	    ProductDto expectedProduct = ProductDto.builder()
	            .nom("test")
	            .prixUnitaire(23)
	            .quantite(5)
	            .build();
	    ProductDto savedProduct = productService.saveProduct(expectedProduct);

	    assertNotNull(savedProduct);
	    assertNotNull(savedProduct.getNom());
	    Assertions.assertEquals(expectedProduct.getPrixUnitaire(), savedProduct.getPrixUnitaire());
	    Assertions.assertEquals(expectedProduct.getQuantite(), savedProduct.getQuantite());
	}

}
