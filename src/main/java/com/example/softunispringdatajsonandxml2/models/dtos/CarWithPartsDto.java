package com.example.softunispringdatajsonandxml2.models.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CarWithPartsDto {
    @Expose
    @SerializedName("Car")
    private CarMakeModelDistanceDto car;
    @Expose
    @SerializedName("Parts")
    private List<PartNameAndPriceDto> parts;

    public CarWithPartsDto() {
    }

    public CarMakeModelDistanceDto getCar() {
        return car;
    }

    public void setCar(CarMakeModelDistanceDto car) {
        this.car = car;
    }

    public List<PartNameAndPriceDto> getParts() {
        return parts;
    }

    public void setParts(List<PartNameAndPriceDto> parts) {
        this.parts = parts;
    }
}
