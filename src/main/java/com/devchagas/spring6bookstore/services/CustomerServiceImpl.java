package com.devchagas.spring6bookstore.services;

import com.devchagas.spring6bookstore.domain.Customer;
import com.devchagas.spring6bookstore.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }
}
