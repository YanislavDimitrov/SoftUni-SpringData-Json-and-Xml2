package com.example.softunispringdatajsonandxml2.services;

import com.example.softunispringdatajsonandxml2.models.Supplier;
import com.example.softunispringdatajsonandxml2.models.dtos.SupplierSeedDto;
import com.example.softunispringdatajsonandxml2.repositories.SupplierRepository;
import com.example.softunispringdatajsonandxml2.services.contracts.SupplierService;
import com.example.softunispringdatajsonandxml2.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

@Service
public class SupplierServiceImpl implements SupplierService {
    public static final String SUPPLIERS_DATA_FILE = "src/main/resources/files/suppliers.json";
    private final SupplierRepository supplierRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.supplierRepository = supplierRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedSuppliers() throws IOException {
        if (this.supplierRepository.count() > 0) {
            return;
        }

        try (FileReader reader = new FileReader(SUPPLIERS_DATA_FILE)) {
            SupplierSeedDto[] dtos = gson.fromJson(reader, SupplierSeedDto[].class);
            Arrays.stream(dtos)
                    .map(dto -> modelMapper.map(dto, Supplier.class))
                    .filter(validationUtil::isValid)
                    .forEach(this.supplierRepository::save);
        }
    }

    @Override
    public Supplier getRandomSupplier() {
        long suppliersCount = this.supplierRepository.count();

        long randomId = new Random().nextLong(1, suppliersCount + 1);
        return this.supplierRepository.findById(randomId)
                .orElse(null);
    }
}
