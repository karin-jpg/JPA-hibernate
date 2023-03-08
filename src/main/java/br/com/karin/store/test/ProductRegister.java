package br.com.karin.store.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.karin.store.dao.CategoryDAO;
import br.com.karin.store.dao.ProductDAO;
import br.com.karin.store.model.Category;
import br.com.karin.store.model.Product;
import br.com.karin.store.util.JPAUtil;

public class ProductRegister {

	public static void main(String[] args) {
		
		createProduct();
		EntityManager em = JPAUtil.getEntityManager();		
		ProductDAO productDao = new ProductDAO(em);
		
		Product product = productDao.getById(1l);
		
		System.out.println(product.getName());
		System.out.println(product.getDescription());
		System.out.println(product.getPrice());
		System.out.println(product.getCategory().getName());
		
		System.out.println();
		System.out.println("List of all products: ");
		
		List<Product> products = productDao.getAll();
		
		products.stream().forEach(p -> {
			System.out.println(p.getName());
			System.out.println(p.getDescription());
			System.out.println(p.getPrice());
			System.out.println(p.getCategory().getName());
			System.out.println();			
		});
		
		products = productDao.getByName("Watermelon");
		
		products.stream().forEach(p -> {
			System.out.println(p.getName());
			System.out.println(p.getDescription());
			System.out.println(p.getPrice());
			System.out.println(p.getCategory().getName());
			System.out.println();			
		});
		
		products = productDao.getByCategoryName("Smartphone");
		
		products.stream().forEach(p -> {
			System.out.println(p.getName());
			System.out.println(p.getDescription());
			System.out.println(p.getPrice());
			System.out.println(p.getCategory().getName());
			System.out.println();			
		});
		
		
		BigDecimal price = productDao.getPriceByName("Watermelon");
		System.out.println(price);
		
	}

	private static void createProduct() {
		Category category = new Category("Smartphone");
		Category testCategory = new Category("Food");
		Product product = new Product("Iphone 12", "A new smartphone", new BigDecimal("99.9"), category);
		Product product2 = new Product("Watermelon", "Delicious", new BigDecimal("5.00"), testCategory);
		
		
		EntityManager em = JPAUtil.getEntityManager();
		
		CategoryDAO categoryDao = new CategoryDAO(em);
		ProductDAO productDao = new ProductDAO(em);
		
		em.getTransaction().begin();
		
		categoryDao.register(category);
		categoryDao.register(testCategory);		
		productDao.register(product);
		productDao.register(product2);
		
		em.getTransaction().commit();
		em.close();
	}
}
