package com.example.ConfigurationManagementSystem.source;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONConfigSource implements ConfigSource {
    private final String filePath;

    public JSONConfigSource(String filePath) {

        this.filePath = filePath;
    }

    @Override
    public Map<String, String> readConfig() {
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        try {
            return objectMapper.readValue(new File(filePath), new TypeReference<Map<String, String>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Failed to read - " + e.getMessage());
        }

    }
}