package com.ruthvik.springdemo.amazonprime.dao.interfaces;

import com.ruthvik.springdemo.amazonprime.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
