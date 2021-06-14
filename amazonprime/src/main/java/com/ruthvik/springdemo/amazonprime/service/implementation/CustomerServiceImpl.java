package com.ruthvik.springdemo.amazonprime.service.implementation;

import com.ruthvik.springdemo.amazonprime.dao.interfaces.CustomerRepository;
import com.ruthvik.springdemo.amazonprime.entity.Customer;
import com.ruthvik.springdemo.amazonprime.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    @Transactional
    public Customer getCustomer(String username) {
        Optional<Customer> result = customerRepository.findById(username);
        Customer theCustomer = null;
        if(result.isPresent())
            theCustomer = result.get();
        else
            throw new RuntimeException("Customer not found with username: "+username);
        return theCustomer;
    }
}
