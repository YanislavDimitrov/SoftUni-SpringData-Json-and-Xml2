package com.example.softunispringdatajsonandxml2.models.dtos.XMLWrappers;

import com.example.softunispringdatajsonandxml2.models.dtos.SaleWithDiscountDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaleWithDiscountWrapper {
    @XmlElement(name = "sale")
    private List<SaleWithDiscountDto> sales;

    public SaleWithDiscountWrapper(List<SaleWithDiscountDto> sales) {
        this.sales = sales;
    }

    public SaleWithDiscountWrapper() {
    }

    public List<SaleWithDiscountDto> getSales() {
        return sales;
    }

    public void setSales(List<SaleWithDiscountDto> sales) {
        this.sales = sales;
    }
}
