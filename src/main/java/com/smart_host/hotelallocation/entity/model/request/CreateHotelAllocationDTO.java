package com.smart_host.hotelallocation.entity.model.request;

import java.util.List;

public record CreateHotelAllocationDTO(int noPremiumRooms, int noEconomyRooms, List<Double> lstOfGuests) {
}
