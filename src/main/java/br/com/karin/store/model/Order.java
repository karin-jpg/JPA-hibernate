package br.com.karin.store.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "total_value")
	private BigDecimal totalValue;
	private LocalDate date = LocalDate.now();
	@ManyToOne
	private Client client;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderedItem> orderedItens = new ArrayList<OrderedItem>();

	public Order() {
	}

	public Order(Client client) {
		this.client = client;
	}
	
	public void addOrderedItem(OrderedItem item) {
		item.setOrder(this);
		this.orderedItens.add(item);
	}

	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
