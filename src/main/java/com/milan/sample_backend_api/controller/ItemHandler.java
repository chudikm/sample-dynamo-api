package com.milan.sample_backend_api.controller;

import java.util.Map;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.milan.sample_backend_api.service.ItemService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ItemHandler {
	
	private ItemService itemService;
	
    @Bean
    public Function<Map<String, String>, String> getItem() {
        return input -> itemService.getItemById(input.get("id"));
    }
}
