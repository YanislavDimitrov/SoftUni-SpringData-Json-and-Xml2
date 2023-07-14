package com.example.softunispringdatajsonandxml2.services.contracts;

import com.example.softunispringdatajsonandxml2.models.Car;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface CarService {
    void seedCars() throws IOException;

    Car getRandomCar();
}
