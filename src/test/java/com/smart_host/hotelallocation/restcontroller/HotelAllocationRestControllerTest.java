package com.smart_host.hotelallocation.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart_host.hotelallocation.entity.model.dto.HotelOccupancyResultDTO;
import com.smart_host.hotelallocation.entity.model.request.CreateHotelAllocationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.RequestBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class HotelAllocationRestControllerTest extends AbstractControllerTest{

    @Test
	void returnSuccessForSaveHotelRoomOccupancyDetails() throws Exception {
        List<Double> lstOfGuests=Arrays.asList(23.0, 45.0,155.0,374.0,22.0,99.99,100.0,101.0,115.0,209.0);
       HotelOccupancyResultDTO hotelOccupancyResultDTO=new HotelOccupancyResultDTO(3,738,3,167.99);
        String hotelOccupancyResult="{\"noPremiumRooms\":\"3\",\"noEconomyRooms\":\"3\",\"usageEconomy\":\"3\",\"lstOfGuests\":\"[{23, 45, 155, 374, 22, 99.99, 100, 101, 115, 209}]\"}";
        when(hotelAllocationService.saveHotelOccupancyDetails(any(CreateHotelAllocationDTO.class))).thenReturn(hotelOccupancyResultDTO);
	mockMvc.perform(post("/hotel/occupancy").contentType(APPLICATION_JSON).content(asJsonString(new CreateHotelAllocationDTO(3,3, lstOfGuests))).accept(MediaType.APPLICATION_JSON))
 	.andExpect(status().isCreated())
            .andExpect(jsonPath("$.usagePremium",is(3)))
            .andExpect(jsonPath("$.revenuePremium",is(738.0)))
            .andExpect(jsonPath("$.usageEconomy",is(3)))
            .andExpect(jsonPath("$.revenueEconomy",is(167.99)));
    }
    @Test
    void returnIncorrectOutcomeForSaveHotelRoomOccupancyDetails() throws Exception {
        List<Double> lstOfGuests=Arrays.asList(3.0, 45.0,155.0,374.0,22.0,99.99,100.0,101.0,115.0,209.0);
        HotelOccupancyResultDTO hotelOccupancyResultDTO=new HotelOccupancyResultDTO(3,738,3,167.99);
        String hotelOccupancyResult="{\"noPremiumRooms\":\"3\",\"noEconomyRooms\":\"3\",\"usageEconomy\":\"3\",\"lstOfGuests\":\"[{23, 45, 155, 374, 22, 99.99, 100, 101, 115, 209}]\"}";
        when(hotelAllocationService.saveHotelOccupancyDetails(any(CreateHotelAllocationDTO.class))).thenReturn(hotelOccupancyResultDTO);
        mockMvc.perform(post("/hotel/occupancy").contentType(APPLICATION_JSON).content(asJsonString(new CreateHotelAllocationDTO(3,3, lstOfGuests))).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.usagePremium",is(3)))
                .andExpect(jsonPath("$.revenuePremium",is(78.0)))
                .andExpect(jsonPath("$.usageEconomy",is(3)))
                .andExpect(jsonPath("$.revenueEconomy",is(167.99)));
    }
    public static String asJsonString(final Object obj)
    {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        }
        catch (Exception e)
        {
            throw  new RuntimeException();
        }
    }
}