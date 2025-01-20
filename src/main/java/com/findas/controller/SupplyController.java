package com.findas.controller;

import com.findas.entity.Supply;
import com.findas.service.SupplyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/supplies")
public class SupplyController {
    private final SupplyService supplyService;

    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @GetMapping()
    public List<Supply> getAllSupplies() {
        return supplyService.getAllSupplies();
    }

    @GetMapping("/{id}")
    public Supply getSupplyById(@PathVariable Long id) {
        return supplyService.getSupplyById(id);
    }

    // Update an existing supply
    @PutMapping("/{id}")
    public Supply updateSupply(@PathVariable Long id, @RequestBody Supply updatedSupply) {
        return supplyService.updateSupply(id, updatedSupply);
    }

    // Delete a supply
    @DeleteMapping("/{id}")
    public void deleteSupply(@PathVariable Long id) {
        supplyService.deleteSupply(id);
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Double>> getSupplyStats() {
        return ResponseEntity.ok(supplyService.getSupplyStats());
    }
}
