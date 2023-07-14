package com.example.softunispringdatajsonandxml2.services.contracts;

import com.example.softunispringdatajsonandxml2.models.Car;
import com.example.softunispringdatajsonandxml2.models.dtos.CarWithNoPartsViewDto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface CarService {
    void seedCars() throws IOException;

    Car getRandomCar();

    List<CarWithNoPartsViewDto> getAllToyotaCarsOrderedByModelAndDistance();
}
