package com.testproject.uiandapiautomation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {
    private static final Properties prop = new Properties();

    static {
        try (InputStream is = ConfigFileReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (is == null) {
                throw new RuntimeException("config.properties not found on classpath");
            }
            prop.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}