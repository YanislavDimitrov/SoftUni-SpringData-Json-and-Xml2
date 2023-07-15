package com.example.softunispringdatajsonandxml2.services.contracts;

import com.example.softunispringdatajsonandxml2.models.dtos.SaleWithDiscountDto;

import java.util.List;

public interface SaleService {
    void seedSales();

    List<SaleWithDiscountDto> getAllSales();
}
