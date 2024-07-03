package com.akshayram.intuitproject.customer;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    final String COMMA_DELIMITER = ",";

    List<Customer> CustomerList = new ArrayList<>();
    List<List<String>> records = new ArrayList<>();

    public CustomerService() {
//        Customer cust1 = new Customer("DD37Cf93aecA6Dc",
//                "Sheryl","Baxter" ,"Rasmussen","","","","","","","");
//        Customer cust2 = new Customer("2",
//                "Tom","Baxter" ,"Rasmussen","","","","","","","");
//
//        CustomerList.add(cust1);

        readCSVDetails();
    }


    public List<Customer> getAllCustomers() {
        return CustomerList;
    }

    public Customer getCustomersByCustomerId(String custId) {
        for (Customer customer : CustomerList) {
            if (customer.CustomerId().equals(custId)) {
                return customer;
            }
        }
        return null;
    }

    public void readCSVDetails() {
        System.out.println("Reading the data from CSV");
        try (BufferedReader br = new BufferedReader(new FileReader("/src/main/resources/customers.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Current Line: "+ line);
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
            //
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
