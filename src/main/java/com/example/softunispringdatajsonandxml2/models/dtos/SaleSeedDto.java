package com.example.softunispringdatajsonandxml2.models.dtos;

import com.example.softunispringdatajsonandxml2.models.Car;
import com.example.softunispringdatajsonandxml2.models.Customer;

public class SaleSeedDto {
    private Integer discount;
    private Customer customer;
    private Car car;

    public SaleSeedDto() {
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
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
