package br.com.karin.store.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordered_itens")
public class OrderedItens {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal unitPrice;
	private int quantity;
	@ManyToOne
	private Product product;
	@ManyToOne
	private Order order;

	public OrderedItens() {
	}

	public OrderedItens(int quantity, Product product, Order order) {
		this.quantity = quantity;
		this.product = product;
		this.order = order;
	}

}