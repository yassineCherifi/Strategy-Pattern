package com.edf.training.strategy.pattern.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface Writer {
    public void write(Object object) throws JsonProcessingException;
}
