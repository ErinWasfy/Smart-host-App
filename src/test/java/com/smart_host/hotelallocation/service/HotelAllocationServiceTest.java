package com.smart_host.hotelallocation.service;

import com.smart_host.hotelallocation.entity.model.dto.HotelOccupancyResultDTO;
import com.smart_host.hotelallocation.entity.model.request.CreateHotelAllocationDTO;
import jakarta.annotation.security.RunAs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HotelAllocationServiceTest {

    @Autowired
    HotelAllocationService hotelAllocationService;

    @Test
    void returnErrorIfIncorrectDataEntered() {
        List<Double> lstOfGuests= Arrays.asList(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0);
       IllegalArgumentException exception=Assertions.assertThrows(IllegalArgumentException.class,()->hotelAllocationService.saveHotelOccupancyDetails(new CreateHotelAllocationDTO(0,0,lstOfGuests)));
       assertEquals("Incorrect input",exception.getMessage());
    }
    @Test
    void saveHotelOccupancyForThreePremAndEconomyRooms() {
        List<Double> lstOfGuests= Arrays.asList(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0);
        HotelOccupancyResultDTO hotelOccupancyResultDTO =hotelAllocationService.saveHotelOccupancyDetails(new CreateHotelAllocationDTO(3,3,lstOfGuests));
        assertEquals(new HotelOccupancyResultDTO(3,738.0,3,167.99),hotelOccupancyResultDTO);
    }
    @Test
    void saveHotelOccupancyForSevenPremAndFiveEconomyRooms() {
        List<Double> lstOfGuests= Arrays.asList(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0);
        HotelOccupancyResultDTO hotelOccupancyResultDTO =hotelAllocationService.saveHotelOccupancyDetails(new CreateHotelAllocationDTO(7,5,lstOfGuests));
        assertEquals(new HotelOccupancyResultDTO(6,1054.0,4,189.99),hotelOccupancyResultDTO);
    }

    @Test
    void saveHotelOccupancyForTwoPremAndSevenEconomyRooms() {
        List<Double> lstOfGuests= Arrays.asList(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0);
        HotelOccupancyResultDTO hotelOccupancyResultDTO =hotelAllocationService.saveHotelOccupancyDetails(new CreateHotelAllocationDTO(2,7,lstOfGuests));
        assertEquals(new HotelOccupancyResultDTO(2,583.0,4,189.99),hotelOccupancyResultDTO);
    }
}