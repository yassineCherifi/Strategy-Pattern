package com.edf.training.strategy.pattern.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Service;

@Service
public class JSONWriter implements Writer {

    @Override
    public void write(Object object) {

        try {
            ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String jsonObject = objectWriter.writeValueAsString(object);
            System.out.println("Object has been converted to JSON : \n" + jsonObject);

        } catch (Exception e) {
            System.out.println("A problem occured during writing json object");
        }
    }
}
