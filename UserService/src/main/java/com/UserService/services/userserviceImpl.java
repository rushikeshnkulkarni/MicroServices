package com.UserService.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.UserService.entity.User;
import com.UserService.entity.rating;
import com.UserService.exception.resourseNotFoundException;
import com.UserService.repository.userRepository;

@Service
public class userserviceImpl implements userservice {

	@Autowired
	userRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(userserviceImpl.class);
	
	@Override
	public User saveuUser(User user) {
		// TODO Auto-generated method stub
		
	 String uuidString=	UUID.randomUUID().toString();  
	  user.setUserId(uuidString);
	  
		return userRepository.save(user);
	}

	@Override
	public List<User> users() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		//return userRepository.findById(userId).orElseThrow(()-> new resourseNotFoundException("id is not found with id"+userId));
		 User user  =userRepository.findById(userId).orElse(null);
		 
		ArrayList<rating> forobjectArrayList=   restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), ArrayList.class);
		 logger.info("{} ",forobjectArrayList);
		 user.setRating(forobjectArrayList);
		   return user;

	}

}
