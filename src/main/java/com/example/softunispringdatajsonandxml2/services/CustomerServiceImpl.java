package com.example.softunispringdatajsonandxml2.services;

import com.example.softunispringdatajsonandxml2.models.Customer;
import com.example.softunispringdatajsonandxml2.models.dtos.CustomerSeedDto;
import com.example.softunispringdatajsonandxml2.repositories.CustomerRepository;
import com.example.softunispringdatajsonandxml2.services.contracts.CustomerService;
import com.example.softunispringdatajsonandxml2.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@Service
public class CustomerServiceImpl implements CustomerService {
    public static final String CUSTOMERS_DATA_FILE = "src/main/resources/files/customers.json";
    private final CustomerRepository customerRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCustomers() throws IOException {
        if (customerRepository.count() > 0) {
            return;
        }
        try (FileReader fileReader = new FileReader(CUSTOMERS_DATA_FILE)) {
            Arrays.stream(gson.fromJson(fileReader, CustomerSeedDto[].class))
                    .filter(validationUtil::isValid)
                    .map(dto -> modelMapper.map(dto, Customer.class))
                    .forEach(customerRepository::save);
        }
    }
}
