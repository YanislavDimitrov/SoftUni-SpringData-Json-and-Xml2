package com.example.softunispringdatajsonandxml2.repositories;

import com.example.softunispringdatajsonandxml2.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
