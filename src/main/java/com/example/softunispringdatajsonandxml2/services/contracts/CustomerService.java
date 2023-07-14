package com.example.softunispringdatajsonandxml2.services.contracts;

import com.example.softunispringdatajsonandxml2.models.Customer;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface CustomerService {
    void seedCustomers() throws IOException;

    Customer getRandomCustomer();
}
