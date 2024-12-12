package com.rating.ratingService.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.ratingService.entity.rating;
import com.rating.ratingService.repository.ratingRepository;


@Service
public class ratingServiceImpl implements ratingService {

	@Autowired
	ratingRepository ratingRepository;
	
	@Override
	public rating createating(rating rating) {
		
	    String ratingid=	UUID.randomUUID().toString();
	    
	    rating.setRatingId(ratingid);
	    
		return ratingRepository.save(rating) ;
	}

	@Override
	public List<rating> getAllRatings() {
		
		return ratingRepository.findAll();
	}

	@Override
	public List<rating> getRatingByUserId(String userId) {
		
		return ratingRepository.findByuserId(userId);
	}

	@Override
	public List<rating> getRatingByHotelrId(String hotelId) {
		
		return ratingRepository.findByhotelId(hotelId);
	}

	
	
}
