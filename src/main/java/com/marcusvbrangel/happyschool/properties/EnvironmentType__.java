package com.marcusvbrangel.happyschool.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public enum EnvironmentType__ {
    DEVELOPMENT,
    TEST,
    QUALITY,
    STAGING,
    PRODUCTION
}