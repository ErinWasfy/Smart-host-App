package com.smart_host.hotelallocation.entity;

import com.smart_host.hotelallocation.utils.RoomCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelRoom {
    private int roomId;
    private RoomCategory roomCategory;
}
