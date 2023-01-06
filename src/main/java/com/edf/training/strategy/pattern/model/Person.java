package com.edf.training.strategy.pattern.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private String name;
    private int age;
    private String city;
}
