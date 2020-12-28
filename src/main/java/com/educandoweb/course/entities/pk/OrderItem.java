package com.educandoweb.course.entities.pk;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
	}
	
	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
		public Double getPrice() {
		return price;
	}
	 
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getSubTotal() {
		return price * quantity;
	}

}
