package com.milan.sample_backend_api.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class GraphDataDto {
    private List<String> nodes;
    private List<Edge> edges;

    @Data
    public static class Edge {
        private String from;
        private String to;
        private LocalDateTime timestamp;
        private Float amount;

        // Getters and setters
    }

    // Getters and setters
}
