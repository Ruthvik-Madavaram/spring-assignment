package com.ruthvik.springdemo.amazonprime.service.interfaces;

import com.ruthvik.springdemo.amazonprime.entity.Customer;

public interface CustomerService {
    public Customer getCustomer(String username);
}
