package com.example.softunispringdatajsonandxml2.services;

import com.example.softunispringdatajsonandxml2.models.Sale;
import com.example.softunispringdatajsonandxml2.models.dtos.SaleSeedDto;
import com.example.softunispringdatajsonandxml2.repositories.SaleRepository;
import com.example.softunispringdatajsonandxml2.services.contracts.CarService;
import com.example.softunispringdatajsonandxml2.services.contracts.CustomerService;
import com.example.softunispringdatajsonandxml2.services.contracts.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class SaleServiceImpl implements SaleService {
    private static final int SALES_COUNT = 50;
    private static final Integer[] DISCOUNTS = new Integer[]{0, 5, 10, 15, 20, 30, 40, 50};
    private final SaleRepository saleRepository;
    private final CarService carService;
    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, CarService carService, CustomerService customerService, ModelMapper modelMapper) {
        this.saleRepository = saleRepository;
        this.carService = carService;
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSales() {
        if (this.saleRepository.count() > 0) {
            return;
        }
        SaleSeedDto[] dtos = new SaleSeedDto[SALES_COUNT];

        for (int i = 0; i < SALES_COUNT; i++) {
            SaleSeedDto dto = new SaleSeedDto();
            dto.setCar(this.carService.getRandomCar());
            dto.setCustomer(this.customerService.getRandomCustomer());
            dto.setDiscount(getRandomDiscount());
            dtos[i] = dto;
        }
        Arrays.stream(dtos)
                .map(dto -> modelMapper.map(dto, Sale.class))
                .forEach(saleRepository::save);
    }

    private Integer getRandomDiscount() {
        int discountsCount = DISCOUNTS.length;

        return DISCOUNTS[new Random().nextInt(discountsCount)];
    }
}
