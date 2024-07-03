package com.akshayram.intuitproject.customer;

public record Customer(
        String CustomerId,
        String FirstName,
        String LastName,
        String Company,
        String City,
        String Country,
        String Phone_1,
        String Phone_2,
        String Email,
        String SubscriptionDate,
        String Website
) {
}
