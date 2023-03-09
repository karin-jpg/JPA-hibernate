package br.com.karin.store.dao;

import javax.persistence.EntityManager;

import br.com.karin.store.model.Order;

public class OrderDAO {

private EntityManager em;
	
	public OrderDAO(EntityManager em) {
		this.em = em;
	}
	
	public void register(Order order) {
		this.em.persist(order);
	}
}
