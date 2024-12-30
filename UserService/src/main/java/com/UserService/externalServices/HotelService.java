package com.UserService.externalServices;

import com.UserService.entity.hotel;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@EnableFeignClients("HOTELSERVICE")
public interface HotelService {


@GetMapping("/hotels/{hotelId}")
hotel gethotel(@PathVariable String hotelId) ;


}
