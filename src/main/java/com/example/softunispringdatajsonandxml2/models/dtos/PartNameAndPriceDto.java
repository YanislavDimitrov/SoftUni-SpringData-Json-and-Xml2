package com.example.softunispringdatajsonandxml2.models.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import jakarta.persistence.Column;

import java.math.BigDecimal;

public class PartNameAndPriceDto {
    @Expose
    @SerializedName("Name")
    private String name;
    @Expose
    @SerializedName("Price")
    private BigDecimal price;

    public PartNameAndPriceDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
