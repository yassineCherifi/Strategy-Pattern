package com.edf.training.strategy.pattern;

import com.edf.training.strategy.pattern.enums.DataType;
import com.edf.training.strategy.pattern.model.Person;
import com.edf.training.strategy.pattern.service.FileWriter;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StrategyPatternApplication {
    public static void main(String[] args) throws Exception {

        SpringApplication.run(StrategyPatternApplication.class, args);

        Person person = Person.builder().name("Yassine CHERIFI").age(26).city("Voisins-le-Bretonneux").build();

        FileWriter.writeToFile(DataType.JSON, person);

        FileWriter.writeToFile(DataType.TEXT, person);

    }
}
