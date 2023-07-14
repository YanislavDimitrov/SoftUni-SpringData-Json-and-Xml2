package com.example.softunispringdatajsonandxml2.services.contracts;

import com.example.softunispringdatajsonandxml2.models.Supplier;
import com.example.softunispringdatajsonandxml2.models.dtos.SupplierPartsCountDto;

import java.io.IOException;
import java.util.List;

public interface SupplierService {
    void seedSuppliers() throws IOException;

    Supplier getRandomSupplier();

    List<SupplierPartsCountDto> getNotImportingSuppliers();
}
