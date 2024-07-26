package com.smart_host.hotelallocation.entity;

import com.smart_host.hotelallocation.utils.CustomerCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private int custId;
    private String custName;
    private double age;
    private CustomerCategory customerCategory;

    public Customer(String custName, double age, CustomerCategory customerCategory) {
        this.custName = custName;
        this.age = age;
        this.customerCategory = customerCategory;
    }

}
