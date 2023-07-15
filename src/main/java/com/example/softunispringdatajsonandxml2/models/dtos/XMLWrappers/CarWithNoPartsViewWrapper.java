package com.example.softunispringdatajsonandxml2.models.dtos.XMLWrappers;

import com.example.softunispringdatajsonandxml2.models.dtos.CarWithNoPartsViewDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarWithNoPartsViewWrapper {
    @XmlElement(name = "car")
    private List<CarWithNoPartsViewDto> cars;

    public CarWithNoPartsViewWrapper() {
    }

    public CarWithNoPartsViewWrapper(List<CarWithNoPartsViewDto> cars) {
        this.cars = cars;
    }

    public List<CarWithNoPartsViewDto> getCars() {
        return cars;
    }

    public void setCars(List<CarWithNoPartsViewDto> cars) {
        this.cars = cars;
    }
}
