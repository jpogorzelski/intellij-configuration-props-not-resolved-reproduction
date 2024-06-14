package com.example.ijconfigurationpropsbug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(PropertiesConfiguration.class)
public class IjConfigurationPropsBugApplication {
    public static void main(String[] args) {
        SpringApplication.run(IjConfigurationPropsBugApplication.class, args);
    }
}

@ConfigurationProperties(prefix = "buggy")
record PropertiesConfiguration(
        String name,
        SubProperties sub) {

    PropertiesConfiguration {
        System.out.printf("\n\n\n######### %s ################\n\n\n", sub.value());
    }

}

record SubProperties(String value) {
}

