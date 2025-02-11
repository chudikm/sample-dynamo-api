package com.milan.sample_backend_api.jpa;

import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository {
    Optional<Item> getById(String id);
}
