package com.example.ConfigurationManagementSystem.sourceFactory;

import com.example.ConfigurationManagementSystem.source.ConfigSource;
import com.example.ConfigurationManagementSystem.source.JSONConfigSource;
import com.example.ConfigurationManagementSystem.source.PropertiesConfigSource;
import com.example.ConfigurationManagementSystem.source.YamlConfigSource;

import java.util.HashMap;
import java.util.Map;

public class ConfigSourceFactory {

    private static final Map<String, ConfigSource> cache = new HashMap<>();

    public static synchronized ConfigSource createSource(String type, String filePath) {

        String key = type.toLowerCase() + ":" + filePath;

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        ConfigSource source = switch (type.toLowerCase()) {

            case "json" -> new JSONConfigSource(filePath);
            case "yaml" -> new YamlConfigSource(filePath);
            case "properties" -> new PropertiesConfigSource(filePath);
            default -> throw new RuntimeException("Unsupported configuration type:" + type);
        };
        cache.put(key, source);
        return source;
    }
}