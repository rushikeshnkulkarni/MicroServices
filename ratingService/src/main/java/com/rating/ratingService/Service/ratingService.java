package com.rating.ratingService.Service;

import java.util.List;

import com.rating.ratingService.entity.rating;

public interface ratingService {

	// create Rating

	rating createating(rating rating);

	// get rating by user id
	List<rating> getRatingByUserId(String userId);

	// get all rating

	List<rating> getAllRatings();

	// get rating by user id
	List<rating> getRatingByHotelrId(String hotelId);

}
