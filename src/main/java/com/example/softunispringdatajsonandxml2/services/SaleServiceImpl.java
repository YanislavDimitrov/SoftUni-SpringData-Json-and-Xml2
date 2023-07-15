package com.example.softunispringdatajsonandxml2.services;

import com.example.softunispringdatajsonandxml2.models.Sale;
import com.example.softunispringdatajsonandxml2.models.dtos.SaleWithDiscountDto;
import com.example.softunispringdatajsonandxml2.models.dtos.seedDtos.SaleSeedDto;
import com.example.softunispringdatajsonandxml2.repositories.SaleRepository;
import com.example.softunispringdatajsonandxml2.services.contracts.CarService;
import com.example.softunispringdatajsonandxml2.services.contracts.CustomerService;
import com.example.softunispringdatajsonandxml2.services.contracts.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {
    private static final int SALES_COUNT = 50;
    private static final Double[] DISCOUNTS = new Double[]{0.0, 0.05, 0.10, 0.15, 0.20, 0.30, 0.40, 0.50};
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

    @Override
    public List<SaleWithDiscountDto> getAllSales() {
        return saleRepository.findAll()
                .stream().map(sale -> {
                    SaleWithDiscountDto dto = modelMapper.map(sale, SaleWithDiscountDto.class);
                    dto.setPriceWithDiscount(dto.getPrice().multiply(BigDecimal.ONE.subtract(sale.getDiscount())));
                    return dto;
                })
                .collect(Collectors.toList());
    }

    private BigDecimal getRandomDiscount() {
        int discountsCount = DISCOUNTS.length;

        return BigDecimal.valueOf(DISCOUNTS[new Random().nextInt(discountsCount)]);
    }
}
