package com.devchagas.spring6bookstore.services;

import com.devchagas.spring6bookstore.domain.Publisher;
import com.devchagas.spring6bookstore.repositories.PubliserRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PubliserRepository publiserRepository;

    public PublisherServiceImpl(PubliserRepository publiserRepository) {
        this.publiserRepository = publiserRepository;
    }

    @Override
    public Iterable<Publisher> findAll() {
        return publiserRepository.findAll();
    }
}
