package externalServices;

import com.UserService.entity.hotel;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("HOTELSERVICE")
public interface HotelService {


    };

}
