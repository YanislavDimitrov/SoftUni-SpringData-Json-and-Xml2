package com.example.softunispringdatajsonandxml2.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "travelled_distance")
    private Long travelledDistance;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Part> parts;

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public BigDecimal getPrice() {
        BigDecimal total = BigDecimal.ZERO;
        for (Part part : this.parts) {
            total = total.add(part.getPrice());
        }
        return total;
    }
}
