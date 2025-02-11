package com.milan.sample_backend_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milan.sample_backend_api.jpa.Item;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable String id) {
        Item item = new Item();
        item.setId(id);
        item.setValue("Sample Value");
        return ResponseEntity.ok(item);
    }
}
