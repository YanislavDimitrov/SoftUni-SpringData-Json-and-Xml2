package com.example.softunispringdatajsonandxml2.models.dtos.seedDtos;

import com.google.gson.annotations.Expose;

import java.time.LocalDate;

public class CustomerSeedDto {
    @Expose
    private String name;
    @Expose
    private LocalDate birthDate;
    @Expose
    private boolean isYoungDriver;

    public CustomerSeedDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
