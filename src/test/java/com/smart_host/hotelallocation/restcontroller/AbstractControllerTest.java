package com.smart_host.hotelallocation.restcontroller;


import com.smart_host.hotelallocation.service.HotelAllocationService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class AbstractControllerTest {
    @Autowired
    protected MockMvc mockMvc;
    @MockBean
    HotelAllocationService hotelAllocationService;

    @BeforeEach
    public void setUp() {
        Mockito.reset(hotelAllocationService);

    }
}
