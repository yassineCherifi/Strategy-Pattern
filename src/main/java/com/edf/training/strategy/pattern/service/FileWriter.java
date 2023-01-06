package com.edf.training.strategy.pattern.service;

import com.edf.training.strategy.pattern.enums.DataType;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class FileWriter {

    @Autowired
    ApplicationContext applicationContext;
    private static Map<DataType, Writer> writers;

    @PostConstruct
    void init() {
        writers = Map.of(DataType.TEXT, applicationContext.getBean(TextWriter.class), DataType.JSON, applicationContext.getBean(JSONWriter.class));
    }

    public static void writeToFile(DataType dataType, Object object) throws JsonProcessingException {
        Writer writer = writers.get(dataType);
        if (writer == null) {
            throw new IllegalArgumentException("Unknown data type: " + dataType);
        }
        writer.write(object);
    }
}
