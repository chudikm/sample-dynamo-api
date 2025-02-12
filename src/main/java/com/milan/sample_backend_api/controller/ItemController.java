package com.milan.sample_backend_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milan.sample_backend_api.service.ItemService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/items")
@AllArgsConstructor
public class ItemController {
	
	private ItemService itemService;
	
    @GetMapping("/{id}")
    public ResponseEntity<String> getItem(@PathVariable String id) {
        String item = itemService.getItemById(id);
        return ResponseEntity.ok("Item from controller: " + item);
    }
}
