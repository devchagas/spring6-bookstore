package com.devchagas.spring6bookstore.repositories;

import com.devchagas.spring6bookstore.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
