package com.findas.service;

import com.findas.entity.Revenue;
import com.findas.repository.RevenueRepo;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RevenueService {
    private final RevenueRepo revenueRepository;

    public RevenueService(RevenueRepo revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    public Map<String, Double> getRevenueStats() {
        Map<String, Double> stats = new HashMap<>();

        Double totalRevenue = revenueRepository.calculateTotalRevenue();
        Double highestMonthlyRevenue = revenueRepository.calculateHighestMonthlyRevenue();

        stats.put("totalRevenue", totalRevenue != null ? totalRevenue : 0.0);
        stats.put("monthlyRevenue", highestMonthlyRevenue != null ? highestMonthlyRevenue : 0.0);

        return stats;
    }

    public Revenue addRevenue(Revenue revenue) {
        if (revenue.getAmount() <= 0) {
            throw new IllegalArgumentException("Revenue amount must be positive");
        }

        return revenueRepository.save(revenue);
    }

    public List<Revenue> getAllRevenues() {
        return revenueRepository.findAll();
    }
}