package com.example.softunispringdatajsonandxml2.models.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleWithDiscountDto {
    @Expose
    @SerializedName("Car")
    private CarMakeModelDistanceDto car;
    @Expose
    @SerializedName("CustomerName")
    @XmlElement(name = "customer-name")
    private String customerName;
    @Expose
    @SerializedName("Discount")
    private BigDecimal discount;
    @Expose
    @SerializedName("Price")
    private BigDecimal price;
    @Expose
    @SerializedName("PriceWithDiscount")
    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;

    public SaleWithDiscountDto() {
    }

    public CarMakeModelDistanceDto getCar() {
        return car;
    }

    public void setCar(CarMakeModelDistanceDto car) {
        this.car = car;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
