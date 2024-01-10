package com.devchagas.spring6bookstore.repositories;

import com.devchagas.spring6bookstore.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PubliserRepository extends CrudRepository<Publisher, Long> {
}
