package com.example.softunispringdatajsonandxml2.models.dtos.seedDtos;

import com.example.softunispringdatajsonandxml2.models.Car;
import com.example.softunispringdatajsonandxml2.models.Customer;

import java.math.BigDecimal;

public class SaleSeedDto {
    private BigDecimal discount;
    private Customer customer;
    private Car car;

    public SaleSeedDto() {
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
