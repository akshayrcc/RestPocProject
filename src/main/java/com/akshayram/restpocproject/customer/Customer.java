package com.akshayram.restpocproject.customer;

public record Customer(
    String customerId,
    String firstName,
    String lastName,
    String company,
    String city,
    String country,
    String phone1,
    String phone2,
    String email,
    // LocalDate subscriptionDate,
    String subscriptionDate,
    String website) {
}