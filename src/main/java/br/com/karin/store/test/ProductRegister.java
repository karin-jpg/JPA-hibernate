package br.com.karin.store.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.karin.store.dao.CategoryDAO;
import br.com.karin.store.dao.ProductDAO;
import br.com.karin.store.model.Category;
import br.com.karin.store.model.Product;
import br.com.karin.store.util.JPAUtil;

public class ProductRegister {

	public static void main(String[] args) {
		
		createProduct();
	}

	private static void createProduct() {
		Category category = new Category("Smartphone");
		Category testCategory = new Category("IPhone");
		Product product = new Product("Iphone 12", "A new smartphone", new BigDecimal("99.9"), category);
		
		
		EntityManager em = JPAUtil.getEntityManager();
		
		CategoryDAO categoryDao = new CategoryDAO(em);
		ProductDAO productDao = new ProductDAO(em);
		
		em.getTransaction().begin();
		
		categoryDao.register(category);
		categoryDao.register(testCategory);
		
		productDao.register(product);
		
		em.getTransaction().commit();
		em.close();
	}
}
