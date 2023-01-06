package com.edf.training.strategy.pattern.service;

import com.edf.training.strategy.pattern.enums.DataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.EnumMap;

@Component
public class FileWriter {

    @Autowired
    ApplicationContext applicationContext;

    private static final EnumMap<DataType, Writer> writers = new EnumMap<>(DataType.class);

    @PostConstruct
    void init() {
        writers.put(DataType.TEXT, applicationContext.getBean(TextWriter.class));
        writers.put(DataType.JSON, applicationContext.getBean(JSONWriter.class));
    }

    public static void writeToFile(DataType dataType, Object object) {
        Writer writer = writers.get(dataType);
        if (writer == null) {
            throw new IllegalArgumentException("Unknown data type: " + dataType);
        }
        writer.write(object);
    }
}
