package com.rating.ratingService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rating.ratingService.entity.rating;

public interface ratingRepository extends JpaRepository<rating, String> {

	
	 List<rating> findByuserId(String userId);
	
	 List<rating> findByhotelId(String hotelId);
}
