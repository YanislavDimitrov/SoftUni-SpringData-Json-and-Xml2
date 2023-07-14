package com.example.softunispringdatajsonandxml2;

import com.example.softunispringdatajsonandxml2.services.contracts.CarService;
import com.example.softunispringdatajsonandxml2.services.contracts.PartService;
import com.example.softunispringdatajsonandxml2.services.contracts.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;

    @Autowired
    public CommandLineRunnerImpl(SupplierService supplierService, PartService partService, CarService carService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() throws IOException {
        this.supplierService.seedSuppliers();
        this.partService.seedParts();
        this.carService.seedCars();
    }
}
