package org.sid.dtos;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	
	private Long id;

	private String nom;
	
	private double prixUnitaire;
	
	private double quantite;
}
