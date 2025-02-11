package com.milan.sample_backend_api.controller;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ItemHandler {
    @Bean
    public Function<String, String> getItem() {
        return input -> "Item: " + input.get("id");
    }
}
