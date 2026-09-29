package com.example.ConfigurationManagementSystem.source;

import java.util.Map;

public interface ConfigSource {
    Map<String, String> readConfig();
}