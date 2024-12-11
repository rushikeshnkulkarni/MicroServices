package com.hotel.hotelService.epository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotelService.entity.hotel;

public interface hotelrepository extends JpaRepository<hotel, String> {

	
	
	
}
