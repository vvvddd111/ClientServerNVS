package ru.university.equiprent.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@ConfigurationProperties(prefix = "app.storage")
public class StorageProperties {
    private String rootDir = "./storage";
}

