package com.akshayram.restpocproject.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    @Mock
    private CustomerRepository repository;

    private CustomerService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new CustomerService(repository);
    }

    @Test
    void getAllCustomers() {
        List<Customer> customers = Arrays.asList(
                new Customer("1", "John", "Doe", "ABC Corp", "New York", "USA", "1234567890", "0987654321",
                        "john@example.com", " LocalDate.of(2023, 1, 1)", "www.example.com"),
                new Customer("2", "Jane", "Doe", "XYZ Inc", "London", "UK", "1111111111", "2222222222",
                        "jane@example.com", "LocalDate.of(2023, 2, 1)", "www.example.co.uk"));
        when(repository.findAll()).thenReturn(customers);
        List<Customer> result = service.getAllCustomers();
        assertEquals(customers, result);
        verify(repository, times(1)).findAll();
    }

    @Test
    void getCustomerById() {
        String id = "1";
        Customer customer = new Customer("1", "John", "Doe", "ABC Corp", "New York", "USA", "1234567890", "0987654321",
                "john@example.com", "LocalDate.of(2023, 1, 1)", "www.example.com");
        when(repository.findById(id)).thenReturn(customer);
        Customer result = service.getCustomerById(id);
        assertEquals(customer, result);
        verify(repository, times(1)).findById(id);
    }
}