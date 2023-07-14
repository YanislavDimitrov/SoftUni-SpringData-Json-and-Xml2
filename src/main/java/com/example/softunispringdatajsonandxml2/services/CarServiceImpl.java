package com.example.softunispringdatajsonandxml2.services;

import com.example.softunispringdatajsonandxml2.models.Car;
import com.example.softunispringdatajsonandxml2.models.Part;
import com.example.softunispringdatajsonandxml2.models.dtos.CarWithNoPartsViewDto;
import com.example.softunispringdatajsonandxml2.models.dtos.seedDtos.CarSeedDto;
import com.example.softunispringdatajsonandxml2.repositories.CarRepository;
import com.example.softunispringdatajsonandxml2.services.contracts.CarService;
import com.example.softunispringdatajsonandxml2.services.contracts.PartService;
import com.example.softunispringdatajsonandxml2.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    public static final String CARS_DATA_FILE = "src/main/resources/files/cars.json";
    public static final String CAR_MAKE = "Toyota";
    private final CarRepository carRepository;
    private final PartService partService;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartService partService, ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.partService = partService;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCars() throws IOException {
        if (carRepository.count() > 0) {
            return;
        }
        try (FileReader fileReader = new FileReader(CARS_DATA_FILE)) {
            Arrays.stream(gson.fromJson(fileReader, CarSeedDto[].class))
                    .filter(validationUtil::isValid)
                    .map(dto -> {
                        Car car = modelMapper.map(dto, Car.class);
                        car.setParts(getRandomParts());
                        return car;
                    })
                    .forEach(carRepository::save);
        }
    }

    @Override
    public Car getRandomCar() {
        long totalCars = this.carRepository.count();
        return this.carRepository
                .findById(new Random().nextLong(1, totalCars + 1))
                .orElse(null);
    }

    @Override
    public List<CarWithNoPartsViewDto> getAllToyotaCarsOrderedByModelAndDistance() {
        return this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc(CAR_MAKE)
                .stream().map(car -> modelMapper.map(car, CarWithNoPartsViewDto.class))
                .collect(Collectors.toList());
    }

    private List<Part> getRandomParts() {
        return this.partService.getRandomParts();
    }
}
