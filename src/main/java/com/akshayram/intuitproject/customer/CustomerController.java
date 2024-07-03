package com.akshayram.intuitproject.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("")
public class CustomerController {

//    LoggerFactory loggerFactory = new SLF4JLogger();

//    GET /api/customers - returns the list of all customers in the CSV file.
//    GET /api/customers/{customerId} - returns a single customer by ID.
    CustomerService customerService;

//     CustomerController customerController(CustomerService customerService){
//        this.customerService = customerService;
//    }

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    void getHello(){
        System.out.println("Hello World");
        return;
    }

    @GetMapping("/customers")
    List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{customerId}")
    Customer getCustomersByCustomerId(@PathVariable String customerId){
        System.out.println("customerId" + customerId);
        return customerService.getCustomersByCustomerId(customerId);
    }
}
