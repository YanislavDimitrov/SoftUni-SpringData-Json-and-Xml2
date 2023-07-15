package com.example.softunispringdatajsonandxml2.models.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWithPartsDto {
    @Expose
    @SerializedName("Car")
    private CarMakeModelDistanceDto car;
    @Expose
    @SerializedName("Parts")
    @XmlElementWrapper(name = "parts")
    @XmlElement(name = "part")
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
