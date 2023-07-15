package com.example.softunispringdatajsonandxml2.models.dtos;

import com.example.softunispringdatajsonandxml2.utils.LocalDateAdapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.List;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerFullViewDto {
    @Expose
    @SerializedName("Id")
    @XmlElement
    private Long id;
    @Expose
    @SerializedName("Name")
    @XmlElement
    private String name;
    @Expose
    @SerializedName("BirthDate")
    @XmlElement(name = "birth-date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate birthDate;
    @Expose
    @SerializedName("IsYoungDriver")
    @XmlElement(name = "is-young-driver")
    private boolean isYoungDriver;
    @Expose
    @SerializedName("Sales")
    @XmlTransient
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
