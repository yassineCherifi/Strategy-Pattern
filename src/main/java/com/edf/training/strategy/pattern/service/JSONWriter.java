package com.edf.training.strategy.pattern.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Service;

@Service
public class JSONWriter implements Writer {

    @Override
    public void write(Object object) throws JsonProcessingException {

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonObject = objectWriter.writeValueAsString(object);
        System.out.println("Object has been converted to JSON : \n" + jsonObject);
    }
}
