package com.devchagas.spring6bookstore.services;

import com.devchagas.spring6bookstore.domain.Publisher;

public interface PublisherService {
    Iterable<Publisher> findAll();
}
