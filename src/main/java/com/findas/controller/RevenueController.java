package com.findas.controller;

import com.findas.entity.Revenue;
import com.findas.service.RevenueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/revenue")
public class RevenueController {
    private final RevenueService revenueService;

    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Double>> getRevenueStats() {
        return ResponseEntity.ok(revenueService.getRevenueStats());
    }

    @PostMapping
    public ResponseEntity<Revenue> addRevenue(@RequestBody Revenue revenue) {
        try {
            Revenue savedRevenue = revenueService.addRevenue(revenue);
            return ResponseEntity.ok(savedRevenue);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/trends")
    public List<Revenue> getMonthlyRevenues() {
        return revenueService.getAllRevenues();
    }
}