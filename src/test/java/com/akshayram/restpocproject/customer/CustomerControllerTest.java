package com.akshayram.restpocproject.customer;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class CustomerControllerTest {

  @Mock
  private CustomerService customerService;

  @InjectMocks
  private CustomerController customerController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void getAllCustomers_ShouldReturnListOfCustomers() {
    // Arrange
    List<Customer> expectedCustomers = Arrays.asList(
        new Customer("1", "John", "Doe", "Company A", "City A", "Country A", "123456", "654321", "john@example.com",
            "LocalDate.now()", "www.johndoe.com"),
        new Customer("2", "Jane", "Doe", "Company B", "City B", "Country B", "789012", "210987", "jane@example.com",
            "LocalDate.now()", "www.janedoe.com"));
    when(customerService.getAllCustomers()).thenReturn(expectedCustomers);

    // Act
    ResponseEntity<List<Customer>> response = customerController.getAllCustomers();

    // Assert
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(expectedCustomers, response.getBody());
    verify(customerService, times(1)).getAllCustomers();
  }

  @Test
  void getCustomerById_WithValidId_ShouldReturnCustomer() {
    // Arrange
    String customerId = "1";
    Customer expectedCustomer = new Customer("1", "John", "Doe", "Company A", "City A", "Country A", "123456", "654321",
        "john@example.com", "LocalDate.now()", "www.johndoe.com");
    when(customerService.getCustomerById(customerId)).thenReturn(expectedCustomer);

    // Act
    ResponseEntity<Customer> response = customerController.getCustomerById(customerId);

    // Assert
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(expectedCustomer, response.getBody());
    verify(customerService, times(1)).getCustomerById(customerId);
  }

  @Test
  void getCustomerById_WithInvalidId_ShouldReturnNotFound() {
    // Arrange
    String customerId = "999";
    when(customerService.getCustomerById(customerId)).thenReturn(null);

    // Act
    ResponseEntity<Customer> response = customerController.getCustomerById(customerId);

    // Assert
    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    assertNull(response.getBody());
    verify(customerService, times(1)).getCustomerById(customerId);
  }
}
