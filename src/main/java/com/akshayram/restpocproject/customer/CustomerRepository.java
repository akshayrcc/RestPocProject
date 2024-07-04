package com.akshayram.restpocproject.customer;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import com.akshayram.restpocproject.util.CSVHelper;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    private final String CSV_FILE_NAME = "/customers.csv";

    @PostConstruct
    public void init() {
        CSVHelper ch = new CSVHelper();
        customers = ch.readCSVFile(CSV_FILE_NAME);
    }

    public List<Customer> findAll() {
        return customers;
    }

    public Customer findById(String id) {
        return customers.stream()
                .filter(c -> c.customerId().equals(id))
                .findFirst()
                .orElse(null);
    }
}