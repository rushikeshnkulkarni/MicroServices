package com.hotel.hotelService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotelService.entity.hotel;
import com.hotel.hotelService.service.hotelService;

@RestController
@RequestMapping("/hotels")
public class hotelController {

	@Autowired
	private hotelService hotelService;

	@GetMapping
	ResponseEntity<List<hotel>> getallHotels() {

		List<hotel> hotels = hotelService.getallHotel();

		return ResponseEntity.ok(hotels);
		// return new ResponseEntity<List<hotel>>(hotels, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	ResponseEntity<hotel> getsinglehotel(@PathVariable String id) {

		hotel hotel = hotelService.getHotel(id);

		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}

	@PostMapping()
	ResponseEntity<hotel> createhotel(@RequestBody hotel hotel){
		
		hotel hotel2 = hotelService.CreateHotel(hotel);
		
	    return new 	ResponseEntity<hotel>(hotel2,HttpStatus.CREATED);
			
	}
	
	@PutMapping("/{id}")
	ResponseEntity<hotel> updatehotel(@PathVariable String id, @RequestBody hotel hotel){
		
		
		System.out.println(hotel.getName());
		System.out.println(hotel.getLocation());
		
		hotel hotel2 = hotelService.getHotel(id);
		
		System.out.println(hotel2.getId());
		System.out.println(hotel2.getLocation());
		
		hotel2.setName(hotel.getName());
		hotel2.setLocation(hotel.getLocation());
		
		hotel hotel3 = hotelService.updateHotel(hotel2);
		
	    return new 	ResponseEntity<hotel>(hotel3,HttpStatus.OK);
			
	}
//	@PutMapping("/{id}")
//	ResponseEntity<hotel> updateHotel(@PathVariable String id, @RequestBody hotel hotel) {
//	    // Print incoming data for debugging
//	    System.out.println("Incoming hotel name: " + hotel.getName());
//	    System.out.println("Incoming hotel location: " + hotel.getLocation());
//
//	    // Fetch the existing hotel by the id provided in the URL
//	    hotel existingHotel = hotelService.getHotel(id);
//	    
//	    // Ensure the hotel exists before proceeding
//	    if (existingHotel == null) {
//	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//
//	    // Debugging: Print the existing hotel's details
//	    System.out.println("Existing hotel ID: " + existingHotel.getId());
//	    System.out.println("Existing hotel location: " + existingHotel.getLocation());
//
//	    // Update the existing hotel with new details
//	    existingHotel.setName(hotel.getName());
//	    existingHotel.setLocation(hotel.getLocation());
//
//	    // Save the updated hotel
//	    hotel updatedHotel = hotelService.CreateHotel(existingHotel);
//
//	    // Return the updated hotel
//	    return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
//	}

}
