package com.UserService.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.UserService.entity.hotel;
import com.UserService.externalServices.HotelService;

@Configuration
public class beanConfig {
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}

}
