package com.akshayram.restpocproject.util;

import com.akshayram.restpocproject.customer.Customer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {
  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public List<Customer> readCSVFile(String fileName) {
    List<Customer> customers = new ArrayList<>();
    try (InputStream inputStream = getClass().getResourceAsStream(fileName)) {
      if (inputStream == null) {
        throw new RuntimeException("Could not find customers.csv");
      }
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

        // Skip the header row
        reader.readLine();

        String line;
        while ((line = reader.readLine()) != null) {
          Customer customer = null;
          try {
            customer = getCustomer(line);
            if (customer == null) {
              System.out.println("customer skipped");
              continue;
            }
            customers.add(customer);
          } catch (Exception e) {
            System.err.println("Error parsing line: " + line);
            e.printStackTrace();
          }
        }
      }
      return customers;
    } catch (IOException e) {
      throw new RuntimeException("Error initializing customer data", e);
    }
  }

  private static Customer getCustomer(String line) {
    String[] data = line.split(",");
    if (data.length < 11 || data[11] == null) {
      System.out.println("data length is less than 11");
      return null;
    }
    System.out.println("date is" + data[10]);
    try {
      Customer cu = new Customer(
          data[1], // Customer Id
          data[2], // First Name
          data[3], // Last Name
          data[4], // Company
          data[5], // City
          data[6], // Country
          data[7], // Phone 1
          data[8], // Phone 2
          data[9], // Email
          data[10], // Subscription Date
          // LocalDate.parse(data[10], DATE_FORMATTER), // Subscription Date
          data[11] // Website
      );
      return cu;
    } catch (Exception e) {
      System.out.println("Customer row could not be parsed: " + line);
      System.out.println(e.getMessage());
      return null;
    }
  }
}
