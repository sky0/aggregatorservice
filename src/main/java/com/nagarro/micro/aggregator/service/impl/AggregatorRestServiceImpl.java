package com.nagarro.micro.aggregator.service.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.nagarro.micro.aggregator.exception.UserNotFoundException;
import com.nagarro.micro.aggregator.model.Order;
import com.nagarro.micro.aggregator.model.User;
import com.nagarro.micro.aggregator.model.UserDetails;
import com.nagarro.micro.aggregator.service.AggregatorRestService;

@Service("AggregatorService")
public class AggregatorRestServiceImpl implements AggregatorRestService {

	Logger logger = LoggerFactory.getLogger(AggregatorRestServiceImpl.class);

	@Value("${user.base.url}")
	private String userUrl;
	
	@Value("${order.base.url}")
	private String orderUrl;
	
	@Autowired
	private RestTemplate restClient;

	@Override
	public User getUserById(long userId) {
		User user=null;
		try {
			logger.info("Get user from url :"+userUrl);
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			ResponseEntity<User> respone= restClient.exchange(userUrl+"/"+userId, HttpMethod.GET, entity, User.class);
			
			logger.info("Status code is:"+respone);
			if(respone.getStatusCode().equals(HttpStatus.NOT_FOUND)){
				throw new UserNotFoundException(userId, "User not found");
			}
			user=respone.getBody();
			logger.info("User::"+user);
		} catch (HttpClientErrorException e) {
			logger.error("Error while calling user service:"+e.getMessage());
			throw new UserNotFoundException(userId, e.getMessage());
		}
	
		return user;
	}

	@Override
	public List<Order> getOrdersByUserId(long userId) {
		logger.info("Get orders from url :"+orderUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		List<Order> orders= restClient.exchange(orderUrl+"/"+userId, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Order>>() {}).getBody();
		logger.info("Orders ::"+orders);
		return orders;
	}

	@Override
	public UserDetails getUserDetailsById(long userId) {
		UserDetails userDetails=new UserDetails();
		userDetails.setUserDetails(getUserById(userId));
		userDetails.setOrders(getOrdersByUserId(userId));
		
		return userDetails;
	}

}
