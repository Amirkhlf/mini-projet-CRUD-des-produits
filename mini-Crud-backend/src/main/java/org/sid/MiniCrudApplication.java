package org.sid;

import java.util.stream.Stream;

import org.sid.dao.ProductRepository;
import org.sid.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MiniCrudApplication  {

	public static void main(String[] args) {
		SpringApplication.run(MiniCrudApplication.class, args);
	}

	@Bean
	CommandLineRunner commandeLineRunner(ProductRepository productRepository) {
		return args -> {
			Stream.of("test","HP Pavion","LG Mobile").forEach(name -> {
				Product product = new Product();
				product.setNom(name);
				product.setPrixUnitaire(Math.random());
				product.setQuantite(Math.random());
				productRepository.save(product);
			});
		};
	}

}
