package com.example.softunispringdatajsonandxml2.models.dtos.XMLWrappers;

import com.example.softunispringdatajsonandxml2.models.dtos.SupplierPartsCountDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierPartsCountWrapper {
    @XmlElement(name = "supplier")
    private List<SupplierPartsCountDto> suppliers;

    public SupplierPartsCountWrapper() {
    }

    public SupplierPartsCountWrapper(List<SupplierPartsCountDto> suppliers) {
        this.suppliers = suppliers;
    }

    public List<SupplierPartsCountDto> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierPartsCountDto> suppliers) {
        this.suppliers = suppliers;
    }
}
