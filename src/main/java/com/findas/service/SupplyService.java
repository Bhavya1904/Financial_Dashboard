package com.findas.service;

import com.findas.entity.Supply;
import com.findas.repository.SupplyRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SupplyService {
    private final SupplyRepo supplyRepo;
    public SupplyService(SupplyRepo supplyRepo) {
        this.supplyRepo = supplyRepo;
    }

    public List<Supply> getAllSupplies() {
        return supplyRepo.findAll();
    }

    public Supply getSupplyById(Long id) {
        return supplyRepo.findById(id).orElse(null);
    }

    public Supply createSupply(Supply supply) {
        return supplyRepo.save(supply);
    }

    public Supply updateSupply(Long id, Supply updatedSupply) {
        return supplyRepo.findById(id).map(supply -> {
            supply.setItem(updatedSupply.getItem());
            supply.setQuantity(updatedSupply.getQuantity());
            supply.setValue(updatedSupply.getValue());
            supply.setStatus(updatedSupply.getStatus());
            return supplyRepo.save(supply);
        }).orElse(null);
    }
    public Map<String, Double> getSupplyStats() {
        Map<String, Double> stats = new HashMap<>();

        Double totalSupply = supplyRepo.calculateTotalSupply();

        stats.put("totalSupply", totalSupply != null ? totalSupply : 0.0);

        return stats;
    }

    public void deleteSupply(Long id) {
        supplyRepo.deleteById(id);
    }
}
