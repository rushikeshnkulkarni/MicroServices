package com.rating.ratingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.rating.ratingService.Service.ratingService;
import com.rating.ratingService.entity.rating;

@RestController
@RequestMapping("/ratings")
public class ratingController {

	@Autowired
	ratingService ratingService;
	
	
	@PostMapping
	ResponseEntity<rating> create(@RequestBody rating rating) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createating(rating));
	}
	
	@GetMapping
	ResponseEntity<List<rating>> getallraing(){
		return ResponseEntity.ok(ratingService.getAllRatings());
	}
	
	@GetMapping("/users/{userId}")
	ResponseEntity<List<rating>> getallratingByuserid(@PathVariable String userId){
		return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
	}
	
	@GetMapping("/hotels/{hotelId}")
	ResponseEntity<List<rating>> getallratingsByhotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(ratingService.getRatingByHotelrId(hotelId));
	}
	
}
