package com.example.softunispringdatajsonandxml2.utils;


import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
    }

    public String marshal(LocalDate v) throws Exception {
        return v.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
