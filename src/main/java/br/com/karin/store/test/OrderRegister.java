package br.com.karin.store.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.karin.store.dao.CategoryDAO;
import br.com.karin.store.dao.ClientDAO;
import br.com.karin.store.dao.OrderDAO;
import br.com.karin.store.dao.ProductDAO;
import br.com.karin.store.model.Category;
import br.com.karin.store.model.Client;
import br.com.karin.store.model.Order;
import br.com.karin.store.model.OrderedItem;
import br.com.karin.store.model.Product;
import br.com.karin.store.util.JPAUtil;

public class OrderRegister {

	public static void main(String[] args) {
		populateDatabase();
		
		EntityManager em = JPAUtil.getEntityManager();		
		
		ProductDAO productDao = new ProductDAO(em);		
		Product product = productDao.getById(1l);
		ClientDAO clientDao = new ClientDAO(em);
		
		em.getTransaction().begin();
		
		Client client = clientDao.getById(1l);
		Order order = new Order(client);
		order.addOrderedItem(new OrderedItem(2, product, order));
		order.addOrderedItem(new OrderedItem(2, productDao.getById(2l), order));
		
		OrderDAO orderDao = new OrderDAO(em);
		
		orderDao.register(order);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	private static void populateDatabase() {
		Category category = new Category("Smartphone");
		Client client = new Client("Karinhos", "36698547523");
		Product product = new Product("Iphone 12", "A new smartphone", new BigDecimal("99.9"), category);
		Product otherProduct = new Product("Watermelon", "A new watermelom", new BigDecimal("9999.9"), category);
		
		
		EntityManager em = JPAUtil.getEntityManager();
		
		CategoryDAO categoryDao = new CategoryDAO(em);
		ProductDAO productDao = new ProductDAO(em);
		ClientDAO clientDao = new ClientDAO(em);
		
		em.getTransaction().begin();
		
		categoryDao.register(category);
		productDao.register(product);
		productDao.register(otherProduct);
		clientDao.register(client);
		
		em.getTransaction().commit();
		em.close();
	}

}
