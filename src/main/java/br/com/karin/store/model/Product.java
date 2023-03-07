package br.com.karin.store.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	private Integer id;
	private String name;
	private String description;
	private BigDecimal price;
	
}
