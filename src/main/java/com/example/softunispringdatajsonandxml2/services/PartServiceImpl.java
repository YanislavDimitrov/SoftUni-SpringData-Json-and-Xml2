package com.example.softunispringdatajsonandxml2.services;

import com.example.softunispringdatajsonandxml2.models.Part;
import com.example.softunispringdatajsonandxml2.models.Supplier;
import com.example.softunispringdatajsonandxml2.models.dtos.PartSeedDto;
import com.example.softunispringdatajsonandxml2.repositories.PartRepository;
import com.example.softunispringdatajsonandxml2.services.contracts.PartService;
import com.example.softunispringdatajsonandxml2.services.contracts.SupplierService;
import com.example.softunispringdatajsonandxml2.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@Service
public class PartServiceImpl implements PartService {
    public static final String PARTS_DATA_FILE = "src/main/resources/files/parts.json";
    private final PartRepository partRepository;
    private final SupplierService supplierService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, SupplierService supplierService, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.partRepository = partRepository;
        this.supplierService = supplierService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public void seedParts() throws IOException {
        if (this.partRepository.count() > 0) {
            return;
        }
        try (FileReader fileReader = new FileReader(PARTS_DATA_FILE)) {
            Arrays.stream(gson.fromJson(fileReader, PartSeedDto[].class))
                    .filter(validationUtil::isValid)
                    .map(dto -> {
                        Part part = modelMapper.map(dto, Part.class);
                        part.setSupplier(getRandomSupplier());
                        return part;
                    })
                    .forEach(partRepository::save);
        }
    }

    private Supplier getRandomSupplier() {
        return this.supplierService.getRandomSupplier();
    }
}
