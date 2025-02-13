package com.milan.sample_backend_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.milan.sample_backend_api.dto.GraphDataDto;
import com.milan.sample_backend_api.jpa.Transaction;
import com.milan.sample_backend_api.service.TransactionService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
    
    @GetMapping("/graph")
	public GraphDataDto getGraphData(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate) {
    	 List<Transaction> transactions = transactionService.getAllTransactions();
    	 
    	 if (fromDate != null) {
             transactions = transactions.stream()
                 .filter(t -> !t.getTimestamp().isBefore(fromDate))
                 .collect(Collectors.toList());
         }

         if (toDate != null) {
             transactions = transactions.stream()
                 .filter(t -> !t.getTimestamp().isAfter(toDate))
                 .collect(Collectors.toList());
         }

         List<String> nodes = transactions.stream()
             .flatMap(t -> List.of(t.getFrom(), t.getTo()).stream())
             .distinct()
             .collect(Collectors.toList());

         List<GraphDataDto.Edge> edges = transactions.stream()
             .map(t -> {
            	 GraphDataDto.Edge edge = new GraphDataDto.Edge();
                 edge.setFrom(t.getFrom());
                 edge.setTo(t.getTo());
                 edge.setTimestamp(t.getTimestamp());
                 edge.setAmount(t.getAmount());
                 return edge;
             })
             .collect(Collectors.toList());

         GraphDataDto graphData = new GraphDataDto();
         graphData.setNodes(nodes);
         graphData.setEdges(edges);

         return graphData;
	}
}
