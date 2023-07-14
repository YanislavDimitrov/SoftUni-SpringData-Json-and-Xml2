package com.example.softunispringdatajsonandxml2.services.contracts;

import com.example.softunispringdatajsonandxml2.models.Part;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface PartService {
    void seedParts() throws IOException;

    List<Part> getRandomParts();
}
