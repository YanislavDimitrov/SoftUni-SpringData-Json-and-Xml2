package com.example.softunispringdatajsonandxml2.models.dtos;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class CustomerTotalSalesDto {
    @Expose
    private String name;
    @Expose
    private Long boughtCars;
    @Expose
    private BigDecimal spendMoney;

    public CustomerTotalSalesDto() {
    }

    public CustomerTotalSalesDto(String name, Long boughtCars, BigDecimal spendMoney) {
        this.name = name;
        this.boughtCars = boughtCars;
        this.spendMoney = spendMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBoughtCars() {
        return boughtCars;
    }

    public void setBoughtCars(Long boughtCars) {
        this.boughtCars = boughtCars;
    }

    public BigDecimal getSpendMoney() {
        return spendMoney;
    }

    public void setSpendMoney(BigDecimal spendMoney) {
        this.spendMoney = spendMoney;
    }
}
