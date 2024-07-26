package com.smart_host.hotelallocation.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelRoomAllocation {
    private String hotelName;
    private int numOfPremiumRooms;
    private int numOfEconomyRooms;

    public HotelRoomAllocation(String hotelName, int numOfPremiumRooms, int numOfEconomyRooms) {
        this.hotelName = hotelName;
        this.numOfPremiumRooms = numOfPremiumRooms;
        this.numOfEconomyRooms = numOfEconomyRooms;
    }
}
