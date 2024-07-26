package com.smart_host.hotelallocation.service;

import com.smart_host.hotelallocation.entity.Customer;
import com.smart_host.hotelallocation.entity.HotelRoomAllocation;
import com.smart_host.hotelallocation.entity.model.request.CreateHotelAllocationDTO;
import com.smart_host.hotelallocation.entity.model.dto.HotelOccupancyResultDTO;
import com.smart_host.hotelallocation.utils.constants.HotelAllocationConstants;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HotelAllocationService {

    public HotelOccupancyResultDTO saveHotelOccupancyDetails(CreateHotelAllocationDTO createHotelAllocationDTO)
    {
        int nopremiumCount=0;
        int noEconomyCount=0;
        double revenuePremium=0.0,revenueEconomy=0.0;
       if(createHotelAllocationDTO.lstOfGuests()==null || createHotelAllocationDTO.noEconomyRooms()<1 || createHotelAllocationDTO.noPremiumRooms()<1)
         throw new IllegalArgumentException("Incorrect input");

        Set<Double> lstOfGuests=new HashSet<>(createHotelAllocationDTO.lstOfGuests());
        List<Double> lstOfSortedGuests=new ArrayList<>(lstOfGuests);
       Collections.sort(lstOfSortedGuests);
        ///premium & economy class
        List<Double> lstOfPremEconGuests=new ArrayList<>(lstOfSortedGuests);
        Collections.reverse(lstOfPremEconGuests);
        for(double guest:lstOfPremEconGuests)
        {
            if(createHotelAllocationDTO.noEconomyRooms()>noEconomyCount && guest< HotelAllocationConstants.HIGH_CUSTOMER_PAYMENT)
            {
                revenueEconomy+=guest;
                noEconomyCount++;
            }
            else
            if(createHotelAllocationDTO.noPremiumRooms()>nopremiumCount && guest>= HotelAllocationConstants.HIGH_CUSTOMER_PAYMENT)
            {
                revenuePremium+=guest;
                nopremiumCount++;
            }
        }
        return new HotelOccupancyResultDTO(nopremiumCount,revenuePremium,noEconomyCount,revenueEconomy);
    }
}
