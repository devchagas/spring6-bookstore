package com.devchagas.spring6bookstore.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerName;
    private int age;
    private String areaOfInterest;
    @OneToMany(mappedBy = "soldTo")
    private Set<Book> booksPurchased;
}
