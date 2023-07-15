package com.example.softunispringdatajsonandxml2.utils;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface XMLParser {
    <T> String serialize(T Entity) throws JAXBException;
}
