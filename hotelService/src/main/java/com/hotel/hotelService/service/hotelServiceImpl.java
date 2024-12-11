package com.hotel.hotelService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotelService.entity.hotel;
import com.hotel.hotelService.epository.hotelrepository;


@Service
public class hotelServiceImpl implements hotelService {

	
	@Autowired
	hotelrepository hotelrepository;
	
	@Override
	public List<hotel> getallHotel() {
		
		return hotelrepository.findAll();
	}

	@Override
	public hotel getHotel(String id) {
		
		return hotelrepository.findById(id).orElse(null);
	}

	@Override
	public hotel CreateHotel(hotel hotel) {
		
	   String uuidString=	UUID.randomUUID().toString();
		
	   hotel.setId(uuidString);
	   
		return hotelrepository.save(hotel);
	}

	@Override
	public hotel updateHotel(hotel hotel) {
		
		return hotelrepository.save(hotel);
	}

}
