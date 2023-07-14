package com.example.softunispringdatajsonandxml2.services;

import com.example.softunispringdatajsonandxml2.models.Customer;
import com.example.softunispringdatajsonandxml2.models.dtos.CustomerFullViewDto;
import com.example.softunispringdatajsonandxml2.models.dtos.SaleWithDiscountDto;
import com.example.softunispringdatajsonandxml2.models.dtos.seedDtos.CustomerSeedDto;
import com.example.softunispringdatajsonandxml2.repositories.CustomerRepository;
import com.example.softunispringdatajsonandxml2.services.contracts.CustomerService;
import com.example.softunispringdatajsonandxml2.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

    @Override
    public Customer getRandomCustomer() {
        long totalCustomers = this.customerRepository.count();
        return this.customerRepository
                .findById(new Random().nextLong(1, totalCustomers + 1))
                .orElse(null);
    }

    @Override
    public List<CustomerFullViewDto> getAllCustomersOrderedByBirthdateThenByExperience() {
        return customerRepository.getAllCustomersOrderedByBirthDateThenByExperience()
                .stream()
                .map(c -> {
                    CustomerFullViewDto dto = modelMapper.map(c, CustomerFullViewDto.class);
                    for (SaleWithDiscountDto sale : dto.getSales()) {
                        sale.setPriceWithDiscount(sale.getPrice().multiply(BigDecimal.ONE.subtract(sale.getDiscount())));
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
