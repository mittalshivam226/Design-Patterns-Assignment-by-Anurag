package com.example.ConfigurationManagementSystem.config;

import com.example.ConfigurationManagementSystem.source.ConfigSource;
import com.example.ConfigurationManagementSystem.sourceFactory.ConfigSourceFactory;

import java.lang.module.Configuration;
import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {
    public static volatile ConfigurationManager instance;

    public ConfigSource configSource;

    private final HashMap<String, String> configurations;

    private ConfigurationManager(){
        configurations = new HashMap<>();
    }

    public static ConfigurationManager getInstance(String type, String filePath){
        if(instance == null){
            synchronized (ConfigurationManager.class){
                if(instance == null){
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    public String getConfig(String key){
        return configurations.get(key);
    }

    public void setConfig(String key, String value){
        configurations.put(key, value);
    }

    public void loadFromSource(ConfigSource source) {
        Map<String, String> loadedConfigurations = source.readConfig();
        configurations.putAll(loadedConfigurations);
    }

    public void refreshConfig() {
        Map<String, String> loadedConfigurations = configSource.readConfig();
        configurations.clear();
        configurations.putAll(loadedConfigurations);
    }


}


