package com.marcusvbrangel.happyschool.properties;

import jakarta.validation.constraints.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component("customPropertiesApplication")
@ConfigurationProperties(prefix = "application")
@Validated
public class CustomPropertiesApplication {

    private EnvironmentType environment;

    private Service service;

    public CustomPropertiesApplication() {
        this.service = new Service();
    }

    public EnvironmentType getEnvironment() {
        return environment;
    }

    public void setEnvironment(EnvironmentType environment) {
        this.environment = environment;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public enum EnvironmentType {
        DEVELOPMENT,
        TEST,
        QUALITY,
        STAGING,
        PRODUCTION
    }

    public class Service {

//        @NotBlank(message = "Name should not be null")
        @Size(min = 3, message = "Name should be at least 3 character")
        private String name;

//        @NotNull(message = "Quantity should be not null")
        @Digits(integer = 10, fraction = 0, message = "Quantity should be a numeric value")
        @Positive(message = "Quantity should be a positive value")
        private Integer quantity;

//        @NotNull(message = "Active should not be null")
        private Boolean active;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

