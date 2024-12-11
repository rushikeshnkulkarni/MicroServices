package com.hotel.hotelService.service;

import java.util.List;

import org.springframework.data.annotation.CreatedBy;

import com.hotel.hotelService.entity.hotel;

public interface hotelService {

	List<hotel> getallHotel();
	
	hotel getHotel(String id);
	
   hotel CreateHotel(hotel hotel);
   
   hotel updateHotel(hotel hotel);
	
	
}
