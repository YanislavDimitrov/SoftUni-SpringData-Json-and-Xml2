package com.example.softunispringdatajsonandxml2.models.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.List;

public class CustomerFullViewDto {
    @Expose
    @SerializedName("Id")
    private Long id;
    @Expose
    @SerializedName("Name")
    private String name;
    @Expose
    @SerializedName("BirthDate")
    private LocalDate birthDate;
    @Expose
    @SerializedName("IsYoungDriver")
    private boolean isYoungDriver;
    @Expose
    @SerializedName("Sales")
    private List<SaleWithDiscountDto> sales;

    public CustomerFullViewDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public List<SaleWithDiscountDto> getSales() {
        return sales;
    }

    public void setSales(List<SaleWithDiscountDto> sales) {
        this.sales = sales;
    }
}
