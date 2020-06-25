package com.nagarro.micro.aggregator.model;

import java.util.List;

public class UserDetails {
	
	private User userDetails;
	private List<Order> orders;
	public User getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	

}
