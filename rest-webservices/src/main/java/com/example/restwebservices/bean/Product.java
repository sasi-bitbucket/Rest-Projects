package com.example.restwebservices.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue
	private long id;

	@NotBlank(message="Name is required")
	@Column(name = "product_name")
	private String product_name;

	@Column(name = "product_owner")
	private String product_owner;

	@Column(name = "product_quantity")
	private int product_quantity;

	public Product() {

	}

	public Product(String product_name, String product_owner, int product_quantity) {
		this.product_name = product_name;
		this.product_owner = product_owner;
		this.product_quantity = product_quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_owner() {
		return product_owner;
	}

	public void setProduct_owner(String product_owner) {
		this.product_owner = product_owner;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name + ", product_owner=" + product_owner
				+ ", product_quantity=" + product_quantity + "]";
	}

}
