package br.com.karin.store.dao;

import javax.persistence.EntityManager;

import br.com.karin.store.model.Client;
import br.com.karin.store.model.Product;

public class ClientDAO {

private EntityManager em;
	
	public ClientDAO(EntityManager em) {
		this.em = em;
	}
	
	public void register(Client client) {
		this.em.persist(client);
	}
	
	public Client getById(Long id) {
		return em.find(Client.class, id);
	}
}
