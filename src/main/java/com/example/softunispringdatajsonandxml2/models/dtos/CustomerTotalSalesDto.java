package com.example.softunispringdatajsonandxml2.models.dtos;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerTotalSalesDto {
    @XmlAttribute(name = "full-name")
    @Expose
    private String name;
    @XmlAttribute(name = "bought-cars")
    @Expose
    private Long boughtCars;
    @Expose
    @XmlAttribute(name = "spend-money")
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
