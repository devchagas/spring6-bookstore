package com.devchagas.spring6bookstore.repositories;

import com.devchagas.spring6bookstore.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
