package com.example.softunispringdatajsonandxml2.models.dtos.XMLWrappers;

import com.example.softunispringdatajsonandxml2.models.dtos.CustomerTotalSalesDto;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerTotalSalesWrapper {
    @XmlElement(name = "customer")
    private List<CustomerTotalSalesDto> customers;
    public CustomerTotalSalesWrapper(List<CustomerTotalSalesDto> customersWithSales) {
        this.customers=customersWithSales;
    }

    public CustomerTotalSalesWrapper() {
    }

    public List<CustomerTotalSalesDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerTotalSalesDto> customers) {
        this.customers = customers;
    }
}
