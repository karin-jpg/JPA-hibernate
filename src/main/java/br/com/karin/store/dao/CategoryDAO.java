package br.com.karin.store.dao;

import javax.persistence.EntityManager;

import br.com.karin.store.model.Category;

public class CategoryDAO {

private EntityManager em;
	
	public CategoryDAO(EntityManager em) {
		this.em = em;
	}
	
	public void register(Category category) {
		this.em.persist(category);
	}
}
