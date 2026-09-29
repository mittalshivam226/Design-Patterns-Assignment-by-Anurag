package com.example.ConfigurationManagementSystem.source;

import com.example.ConfigurationManagementSystem.source.ConfigSource;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class YamlConfigSource implements ConfigSource {
    private String filePath;

    public YamlConfigSource(String filePath) {

        this.filePath = filePath;
    }

    @Override
    public Map<String, String> readConfig() {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            return objectMapper.readValue(
                    new File(filePath),
                    new TypeReference<Map<String, String>>() {
                    }
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to read - " + e.getMessage());
        }
    }
}