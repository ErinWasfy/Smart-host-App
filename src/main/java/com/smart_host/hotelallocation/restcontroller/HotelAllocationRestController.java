package com.smart_host.hotelallocation.restcontroller;

import com.smart_host.hotelallocation.entity.model.request.CreateHotelAllocationDTO;
import com.smart_host.hotelallocation.entity.model.dto.HotelOccupancyResultDTO;
import com.smart_host.hotelallocation.service.HotelAllocationService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelAllocationRestController {

    HotelAllocationService hotelAllocationService;

    @Autowired
    public HotelAllocationRestController(HotelAllocationService hotelAllocationService) {
        this.hotelAllocationService=hotelAllocationService;
    }

    @PostMapping("/occupancy")
    public ResponseEntity<HotelOccupancyResultDTO> saveHotelRoomOccupancyDetails(@RequestBody @Valid CreateHotelAllocationDTO createHotelAllocationDTO) {

        HotelOccupancyResultDTO newHotelOccupanceDTO  =hotelAllocationService.saveHotelOccupancyDetails(createHotelAllocationDTO);
      return new ResponseEntity<HotelOccupancyResultDTO>(newHotelOccupanceDTO,HttpStatus.CREATED);
    }
}
