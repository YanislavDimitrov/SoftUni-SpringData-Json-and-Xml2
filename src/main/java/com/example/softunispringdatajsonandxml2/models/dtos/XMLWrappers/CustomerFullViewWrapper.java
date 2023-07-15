package com.example.softunispringdatajsonandxml2.models.dtos.XMLWrappers;

import com.example.softunispringdatajsonandxml2.models.dtos.CustomerFullViewDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerFullViewWrapper {
    @XmlElement(name = "customer")
    List<CustomerFullViewDto> customers;

    public CustomerFullViewWrapper(List<CustomerFullViewDto> customers) {
        this.customers = customers;
    }

    public CustomerFullViewWrapper() {
    }

    public List<CustomerFullViewDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerFullViewDto> customers) {
        this.customers = customers;
    }
}
