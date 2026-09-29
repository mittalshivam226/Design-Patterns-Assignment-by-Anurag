package com.example.ConfigurationManagementSystem.demo;

import com.example.ConfigurationManagementSystem.config.ConfigurationManager;
import com.example.ConfigurationManagementSystem.source.ConfigSource;
import com.example.ConfigurationManagementSystem.sourceFactory.ConfigSourceFactory;

public class mainDemo {

    public static void main(String[] args) {

        ConfigurationManager manager = ConfigurationManager.getInstance("properties", "src/main/java/com/example/ConfigurationManagementSystem/demo/PropertiesConfig.properties");

        ConfigSource propertiesSource = ConfigSourceFactory.createSource("properties","src/main/java/com/example/ConfigurationManagementSystem/demo/PropertiesConfig.properties");
        manager.loadFromSource(propertiesSource);

        System.out.println("Properties Configurations - ");
        System.out.println("spring.config.import = " + manager.getConfig("spring.config.import"));
        System.out.println("spring.datasource.url = " + manager.getConfig("spring.datasource.url"));
        System.out.println("spring.datasource.driver-class-name = " + manager.getConfig("spring.datasource.driver-class-name"));


        ConfigSource jsonSource = ConfigSourceFactory.createSource("json","src/main/java/com/example/ConfigurationManagementSystem/demo/JSONConfig.json");
        manager.loadFromSource(jsonSource);

        System.out.println("JSON Configurations - ");
        System.out.println("server.port = " + manager.getConfig("server.port"));
        System.out.println("database.url = " + manager.getConfig("database.url"));
        System.out.println("database.name = " + manager.getConfig("database.name"));


        ConfigSource yamlSource = ConfigSourceFactory.createSource("yaml", "src/main/java/com/example/ConfigurationManagementSystem/demo/YamlConfig.yaml");
        manager.loadFromSource(yamlSource);

        System.out.println("Yaml Configurations - ");
        System.out.println("server.port = " + manager.getConfig("server.port"));
        System.out.println("datasource.url = " + manager.getConfig("datasource.url"));


        manager.setConfig("environment", "development");
        System.out.println("environment = " + manager.getConfig("environment"));

        ConfigurationManager manager2 = ConfigurationManager.getInstance("json","dummy");
        System.out.println("Same ConfigurationManager: " + (manager == manager2));

        ConfigSource source1 = ConfigSourceFactory.createSource("json", "src/main/java/com/example/ConfigurationManagementSystem/demo/JSONConfig.json");
        ConfigSource source2 = ConfigSourceFactory.createSource("json", "src/main/java/com/example/ConfigurationManagementSystem/demo/JSONConfig.json");
        System.out.println("\n\nSame ConfigSource: " + (source1 == source2));
    }
}
