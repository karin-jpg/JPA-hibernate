package br.com.karin.store.dao;

import java.math.BigDecimal;
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
	
	public List<Product> getByName(String name) {
		String jpql = "SELECT p FROM Product p WHERE p.name = :name";
		return em.createQuery(jpql, Product.class)
				.setParameter("name", name)
				.getResultList();
	}
	
	public List<Product> getByCategoryName(String name) {
		String jpql = "SELECT p FROM Product p WHERE p.category.name = :name";
		return em.createQuery(jpql, Product.class)
				.setParameter("name", name)
				.getResultList();
	}
	
	public BigDecimal getPriceByName(String name) {
		String jpql = "SELECT p.price FROM Product p WHERE p.name = :name";
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter("name", name)
				.getSingleResult();
				
	}
	
}
