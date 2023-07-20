package org.sid.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data 
@Builder
@AllArgsConstructor @NoArgsConstructor @ToString
@Entity
public class Product {

	@Id @GeneratedValue
	private Long id;
	
	private String nom;
	
	private double prixUnitaire;
	
	private double quantite;
}
