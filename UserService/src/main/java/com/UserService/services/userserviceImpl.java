package com.UserService.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.UserService.entity.hotel;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.Builder;
import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.UserService.entity.User;
import com.UserService.entity.rating;
import com.UserService.exception.resourseNotFoundException;
import com.UserService.externalServices.HotelService;
import com.UserService.repository.userRepository;

@Service
@Builder
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
int a=1;
	@Override
	@CircuitBreaker(name = "userServicebreaker",fallbackMethod = "userfallback")
//	@Retry(name = "userServicebreaker",fallbackMethod = "userfallback")
//	@RateLimiter(name = "userServicebreaker",fallbackMethod = "userfallback")
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		//return userRepository.findById(userId).orElseThrow(()-> new resourseNotFoundException("id is not found with id"+userId));
		 User user  =userRepository.findById(userId).orElse(null);
		logger.info("retry count  {} ",a);
		a++;
		rating[] forobjectArrayList=   restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), rating[].class);
		 logger.info("{} ",forobjectArrayList);

		 List<rating> ratings= Arrays.stream((forobjectArrayList)).toList();

		List<rating> ratingList =ratings.stream().map(rating -> {

			 	ResponseEntity<hotel> forentity= restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(),hotel.class);

			hotel body=   forentity.getBody();

			rating.setHotel(body);
			return rating;
		}).collect(Collectors.toList());

		 user.setRating(ratingList);
		   return user;

	}

	public User userfallback(String userId, Exception ex){
		logger.info("service is down", ex.getMessage());
		User user =new User("", "dummy", "dummy@gmail.com", List.of());
		return user;
	}

}
