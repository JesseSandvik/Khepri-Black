package com.khepri.black.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;

import java.io.IOException;
import java.util.Properties;

public class JsonService {

    public static Object deserializeJsonObjectToJavaClass(String jsonObject, Class<?> javaClass) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonObject, javaClass);
    }

    public static Properties getPropertiesFromJsonObject(String jsonObject) throws IOException {
        Object object = deserializeJsonObjectToJavaClass(jsonObject, Object.class);
        JavaPropsMapper javaPropsMapper = new JavaPropsMapper();
        return javaPropsMapper.writeValueAsProperties(object);
    }
}
