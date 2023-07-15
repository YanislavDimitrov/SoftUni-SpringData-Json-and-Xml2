package com.example.softunispringdatajsonandxml2;

import com.example.softunispringdatajsonandxml2.models.dtos.*;
import com.example.softunispringdatajsonandxml2.models.dtos.XMLWrappers.CarWithNoPartsViewWrapper;
import com.example.softunispringdatajsonandxml2.models.dtos.XMLWrappers.CustomerFullViewWrapper;
import com.example.softunispringdatajsonandxml2.models.dtos.XMLWrappers.SupplierPartsCountWrapper;
import com.example.softunispringdatajsonandxml2.services.contracts.*;
import com.example.softunispringdatajsonandxml2.utils.XMLParser;
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
    private final XMLParser xmlParser;

    @Autowired
    public CommandLineRunnerImpl(SupplierService supplierService,
                                 PartService partService,
                                 CarService carService,
                                 CustomerService customerService,
                                 SaleService saleService,
                                 Gson gson,
                                 XMLParser xmlParser) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.gson = gson;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter format (XML/JSON): ");
        String formatInput = sc.nextLine();

        System.out.println("Please select operation: " +
                "\n1 -> Ordered Customers by Birthdate." +
                "\n2 -> Cars from Make Toyota ordered by Model and Distance." +
                "\n3 -> Get all suppliers that do not import parts from abroad." +
                "\n4 -> Get all cars along with their list of parts." +
                "\n5 -> Total Sales by Customer." +
                "\n6 -> Get all Sales with Applied Discount.");

        int operation = Integer.parseInt(sc.nextLine());

        switch (operation) {
            case 1:
                List<CustomerFullViewDto> customers =
                        this.customerService.getAllCustomersOrderedByBirthdateThenByExperience();

                if (formatInput.equalsIgnoreCase("json")) {
                    System.out.println(gson.toJson(customers));
                } else if (formatInput.equalsIgnoreCase("xml")) {
                    System.out.println(xmlParser.serialize(new CustomerFullViewWrapper(customers)));
                } else {
                    System.out.println("Invalid format!");
                }
                break;
            case 2:
                List<CarWithNoPartsViewDto> cars =
                        this.carService.getAllToyotaCarsOrderedByModelAndDistance();

                if (formatInput.equalsIgnoreCase("json")) {
                    System.out.println(gson.toJson(cars));
                } else if (formatInput.equalsIgnoreCase("xml")) {
                    System.out.println(xmlParser.serialize(new CarWithNoPartsViewWrapper(cars)));
                } else {
                    System.out.println("Invalid format!");
                }
                break;
            case 3:
                List<SupplierPartsCountDto> suppliers =
                        this.supplierService.getNotImportingSuppliers();

                if (formatInput.equalsIgnoreCase("json")) {
                    System.out.println(gson.toJson(suppliers));
                } else if (formatInput.equalsIgnoreCase("xml")) {
                    System.out.println(xmlParser.serialize(new SupplierPartsCountWrapper(suppliers)));
                } else {
                    System.out.println("Invalid format!");
                }
                break;
            case 4:
                List<CarWithPartsDto> carsWithParts =
                        this.carService.getCarsWithParts();

                System.out.println(gson.toJson(carsWithParts));
                break;
            case 5:
                List<CustomerTotalSalesDto> customersWithSales =
                        this.customerService.getAllCustomersWithAtLeastOneCarOrderedByMoneySpend();

                System.out.println(gson.toJson(customersWithSales));
                break;
            case 6:
                List<SaleWithDiscountDto> sales = this.saleService.getAllSales();

                System.out.println(gson.toJson(sales));
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
