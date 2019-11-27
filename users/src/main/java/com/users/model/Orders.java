package com.users.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "orders")
public class Orders {
	@Id
	private String id;

	@DBRef
	private User user;
	
	@DBRef
	private Counter counter;

	@CreatedDate
	private Date date;
	@DBRef
	private List<Item> items;
	private String status = "Pending";
	private float total;
	public Orders() {

	}

	public Orders(User user, Counter counter, Date date, List<Item> items, float total) {
		super();
		this.user = user;
		this.counter = counter;
		this.date = date;
		this.items = items;
		this.total = total;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Counter getCounter() {
		return counter;
	}

	public void setCounter(Counter counter) {
		this.counter = counter;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}
