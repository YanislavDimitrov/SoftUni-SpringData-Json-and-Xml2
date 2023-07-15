package com.example.softunispringdatajsonandxml2.models.dtos.XMLWrappers;

import com.example.softunispringdatajsonandxml2.models.dtos.CarWithPartsDto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWithPartsWrapper {

    @XmlElement(name = "car")
    private List<CarWithPartsDto> cars;

    public CarWithPartsWrapper(List<CarWithPartsDto> cars) {
        this.cars = cars;
    }

    public CarWithPartsWrapper() {
    }

    public List<CarWithPartsDto> getCars() {
        return cars;
    }

    public void setCars(List<CarWithPartsDto> cars) {
        this.cars = cars;
    }
}
