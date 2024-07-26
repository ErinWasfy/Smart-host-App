package com.smart_host.hotelallocation.acceptancetest;

import com.smart_host.hotelallocation.entity.model.dto.HotelOccupancyResultDTO;
import com.smart_host.hotelallocation.entity.model.request.CreateHotelAllocationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HotelAllocationAcceptanceTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        restTemplate = new TestRestTemplate();
    }

    @Test
    void returnHotelRoomOccupancy() throws Exception {
        List<Double> lstOfGuests= Arrays.asList(23.0, 45.0,155.0,374.0,22.0,99.99,100.0,101.0,115.0,209.0);
        HotelOccupancyResultDTO expectedOutput=new HotelOccupancyResultDTO(3,738.0,3,167.99);
        HotelOccupancyResultDTO result=this.restTemplate.postForObject("http://localhost:" + port + "/hotel/occupancy",new CreateHotelAllocationDTO(3,3,lstOfGuests),HotelOccupancyResultDTO.class);
      assertThat(result).isEqualTo(expectedOutput);
    }

}
