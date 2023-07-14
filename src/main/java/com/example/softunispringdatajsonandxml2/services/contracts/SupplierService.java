package com.example.softunispringdatajsonandxml2.services.contracts;

import com.example.softunispringdatajsonandxml2.models.Supplier;

import java.io.IOException;

public interface SupplierService {
    void seedSuppliers() throws IOException;

    Supplier getRandomSupplier();
}
