package com.example.softunispringdatajsonandxml2.repositories;

import com.example.softunispringdatajsonandxml2.models.Customer;
import com.example.softunispringdatajsonandxml2.models.dtos.CustomerTotalSalesDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer AS c ORDER BY c.birthDate,c.isYoungDriver")
    List<Customer> getAllCustomersOrderedByBirthDateThenByExperience();

    @Query("SELECT new com.example.softunispringdatajsonandxml2.models.dtos.CustomerTotalSalesDto(c.name,COUNT(DISTINCT ca.id),SUM(p.price))  FROM Customer AS c" +
            " JOIN c.sales as s" +
            " JOIN s.car AS ca" +
            " JOIN ca.parts AS p" +
            " WHERE size(c.sales) > 0" +
            " GROUP BY c.name" +
            " ORDER BY SUM(p.price) DESC, COUNT(DISTINCT ca.id) DESC")
    List<CustomerTotalSalesDto> getAllCustomersWithAtLeastOneCarOrderedByTotalMoneySpend();
}
