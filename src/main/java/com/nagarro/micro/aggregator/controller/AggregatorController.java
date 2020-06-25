package com.nagarro.micro.aggregator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.micro.aggregator.model.UserDetails;
import com.nagarro.micro.aggregator.service.AggregatorRestService;
import com.nagarro.micro.aggregator.service.impl.AggregatorRestServiceImpl;

@RestController
@RequestMapping("api/v1")
public class AggregatorController {
	Logger logger = LoggerFactory.getLogger(AggregatorRestServiceImpl.class);

	@Autowired
	private AggregatorRestService aggeratorService;
	
	@GetMapping("orderdetails/{id}")
	public ResponseEntity<UserDetails> getUserDetailsById(@PathVariable(value="id") long userId){
		
		return new ResponseEntity<>(aggeratorService.getUserDetailsById(userId),HttpStatus.OK);
	}

}
