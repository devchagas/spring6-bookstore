package com.devchagas.spring6bookstore.services;

import com.devchagas.spring6bookstore.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
