package com.devchagas.spring6bookstore.services;

import com.devchagas.spring6bookstore.domain.Customer;

public interface CustomerService {
    Iterable<Customer> findAll();
}
