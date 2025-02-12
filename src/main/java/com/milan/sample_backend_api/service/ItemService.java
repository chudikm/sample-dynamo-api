package com.milan.sample_backend_api.service;

import org.springframework.stereotype.Service;

@Service
public class ItemService {
    public String getItemById(String id) {
        return "Item: " + id;
    }
}