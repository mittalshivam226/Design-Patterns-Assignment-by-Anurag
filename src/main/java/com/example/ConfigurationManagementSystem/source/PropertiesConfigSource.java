package com.example.ConfigurationManagementSystem.source;

import com.example.ConfigurationManagementSystem.source.ConfigSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesConfigSource implements ConfigSource {
    private String filePath;

    public PropertiesConfigSource(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Map<String, String> readConfig() {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(filePath)) {

            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read - " + e.getMessage());
        }

        Map<String, String> configurationMap = new HashMap<>();
        for (String key : properties.stringPropertyNames()) {
            configurationMap.put(key, properties.getProperty(key));
        }
        return configurationMap;
    }
}