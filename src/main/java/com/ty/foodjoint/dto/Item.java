package com.ty.foodjoint.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel(value = "Item Entity", description = "Item  entity to hold item details")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	private String name;
	private double cost;
	private int quantity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Orders order;

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Item(int itemId, String name, double cost, int quantity, com.ty.foodjoint.dto.Orders order) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
		this.order = order;
	}

	public Item() {
		super();
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", cost=" + cost + ", quantity=" + quantity + ", order="
				+ order + "]";
	}

}
