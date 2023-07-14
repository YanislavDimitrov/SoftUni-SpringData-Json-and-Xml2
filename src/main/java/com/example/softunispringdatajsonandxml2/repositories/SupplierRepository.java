package com.example.softunispringdatajsonandxml2.repositories;

import com.example.softunispringdatajsonandxml2.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query("SELECT s FROM Supplier AS s WHERE s.isImporter=false")
    List<Supplier> findAllByImporterFalse();
}
