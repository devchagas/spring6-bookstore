package com.devchagas.spring6bookstore.services;

import com.devchagas.spring6bookstore.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
