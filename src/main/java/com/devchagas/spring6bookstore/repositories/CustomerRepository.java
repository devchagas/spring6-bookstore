package com.devchagas.spring6bookstore.repositories;

import com.devchagas.spring6bookstore.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
