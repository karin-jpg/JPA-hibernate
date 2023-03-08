package br.com.karin.store.dao;

import java.util.List;

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
	
	public Product getById(Long id) {
		return em.find(Product.class, id);
	}
	
	public List<Product> getAll() {
		String jpql = "SELECT p FROM Product p";
		return em.createQuery(jpql, Product.class).getResultList();
	}
	
}
