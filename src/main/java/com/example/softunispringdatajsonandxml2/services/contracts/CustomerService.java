package com.example.softunispringdatajsonandxml2.services.contracts;

import com.example.softunispringdatajsonandxml2.models.Customer;
import com.example.softunispringdatajsonandxml2.models.dtos.CustomerFullViewDto;
import com.example.softunispringdatajsonandxml2.models.dtos.CustomerTotalSalesDto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface CustomerService {
    void seedCustomers() throws IOException;

    Customer getRandomCustomer();

    List<CustomerFullViewDto> getAllCustomersOrderedByBirthdateThenByExperience();

    List<CustomerTotalSalesDto> getAllCustomersWithAtLeastOneCarOrderedByMoneySpend();
}
