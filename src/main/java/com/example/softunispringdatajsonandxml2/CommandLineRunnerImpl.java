package com.example.softunispringdatajsonandxml2;

import com.example.softunispringdatajsonandxml2.models.dtos.*;
import com.example.softunispringdatajsonandxml2.services.contracts.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;
    private final Gson gson;

    @Autowired
    public CommandLineRunnerImpl(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService, Gson gson) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please select operation: " +
                "\n1 -> Ordered Customers by Birthdate." +
                "\n2 -> Cars from Make Toyota ordered by Model and Distance." +
                "\n3 -> Get all suppliers that do not import parts from abroad." +
                "\n4 -> Get all cars along with their list of parts." +
                "\n5 -> Total Sales by Customer.");
        int operation = Integer.parseInt(sc.nextLine());

        switch (operation) {
            case 1:
                List<CustomerFullViewDto> customers = this.customerService.getAllCustomersOrderedByBirthdateThenByExperience();
                System.out.println(gson.toJson(customers));
                break;
            case 2:
                List<CarWithNoPartsViewDto> cars = this.carService.getAllToyotaCarsOrderedByModelAndDistance();
                System.out.println(gson.toJson(cars));
                break;
            case 3:
                List<SupplierPartsCountDto> suppliers = this.supplierService.getNotImportingSuppliers();
                System.out.println(gson.toJson(suppliers));
                break;
            case 4:
                List<CarWithPartsDto> carsWithParts = this.carService.getCarsWithParts();
                System.out.println(gson.toJson(carsWithParts));
                break;
            case 5:
                List<CustomerTotalSalesDto> customersWithSales = this.customerService.getAllCustomersWithAtLeastOneCarOrderedByMoneySpend();
                System.out.println(gson.toJson(customersWithSales));
                break;
        }
    }

    private void seedData() throws IOException {
        this.supplierService.seedSuppliers();
        this.partService.seedParts();
        this.carService.seedCars();
        this.customerService.seedCustomers();
        this.saleService.seedSales();
    }
}
