package br.com.karin.store.dao;

import javax.persistence.EntityManager;

import br.com.karin.store.model.Product;

public class ProductDAO {

	private EntityManager em;
	
	public ProductDAO(EntityManager em) {
		this.em = em;
	}
	
	public void register(Product product) {
		this.em.persist(product);
	}
	
}
