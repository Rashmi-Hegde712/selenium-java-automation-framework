package com.testproject.uiandapiautomation.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonUtils {
	
		    public static JsonNode readJsonFile(String filePath) {
		        try {
		            ObjectMapper objectMapper = new ObjectMapper();
		            return objectMapper.readTree(new File(filePath));
		        } catch (Exception e) {
		            throw new RuntimeException("Error reading JSON file: " + filePath, e);
		        }
		    }

	}