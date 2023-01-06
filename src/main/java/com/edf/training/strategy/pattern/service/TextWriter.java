package com.edf.training.strategy.pattern.service;


import org.springframework.stereotype.Service;

@Service
public class TextWriter implements Writer {

    @Override
    public void write(Object object) {
        System.out.println("Object has been converted to Text : \n" + object.toString());
    }
}
