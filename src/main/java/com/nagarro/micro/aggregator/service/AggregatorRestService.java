package com.nagarro.micro.aggregator.service;

import java.util.List;

import com.nagarro.micro.aggregator.model.Order;
import com.nagarro.micro.aggregator.model.User;
import com.nagarro.micro.aggregator.model.UserDetails;

public interface AggregatorRestService {
	
	public User getUserById(long userId);
	public List<Order> getOrdersByUserId(long userId);
	public UserDetails getUserDetailsById(long userId);

}
