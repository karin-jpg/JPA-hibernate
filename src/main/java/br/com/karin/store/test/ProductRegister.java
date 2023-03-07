package br.com.karin.store.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.karin.store.dao.ProductDAO;
import br.com.karin.store.model.Product;
import br.com.karin.store.util.JPAUtil;

public class ProductRegister {

	public static void main(String[] args) {
		Product product = new Product();
		
		product.setName("Notebook");
		product.setDescription("A new computer");
		product.setPrice(new BigDecimal("99.9"));
		
		EntityManager em = JPAUtil.getEntityManager();
		ProductDAO productDao = new ProductDAO(em);
		
		em.getTransaction().begin();
		
		productDao.register(product);
		
		em.getTransaction().commit();
		em.close();
	}
}
