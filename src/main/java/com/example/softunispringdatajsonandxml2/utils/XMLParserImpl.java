package com.example.softunispringdatajsonandxml2.utils;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@Component
public class XMLParserImpl implements XMLParser {

    @Override
    public <T> String serialize(T entity) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(entity.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter string = new StringWriter();
        marshaller.marshal(entity, string);
        return string.toString();
    }
}
