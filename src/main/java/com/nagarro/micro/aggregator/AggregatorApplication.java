package com.nagarro.micro.aggregator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AggregatorApplication {
	
	


	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(AggregatorApplication.class);
		logger.info("AggregatorApplication start");
		SpringApplication.run(AggregatorApplication.class, args);
	}

	@Bean
	public RestTemplate getRestClient(RestTemplateBuilder builder) {
	    return builder.build();
	}
}
