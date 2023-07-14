package com.example.softunispringdatajsonandxml2.repositories;

import com.example.softunispringdatajsonandxml2.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
