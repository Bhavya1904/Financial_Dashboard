package com.findas.controller;

import com.findas.entity.PendingPayment;
import com.findas.service.PendingPaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pending-payments")
public class PendingPaymentController {

    private final PendingPaymentService pendingPaymentService;
    public PendingPaymentController(PendingPaymentService pendingPaymentService) {
        this.pendingPaymentService = pendingPaymentService;
    }

    // read all
    @GetMapping
    public ResponseEntity<List<PendingPayment>> getAllPayments(){
        return ResponseEntity.ok(pendingPaymentService.getAllPayments());
    }

    // read 1
    @GetMapping("/{id}")
    public ResponseEntity<PendingPayment> getPaymentById(@PathVariable Long id){
        return ResponseEntity.ok(pendingPaymentService.getPaymentById(id).orElse(null));
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<PendingPayment> updatePayment(@PathVariable Long id, @RequestBody PendingPayment payment){
        return ResponseEntity.ok(pendingPaymentService.updatePayment(id,payment));
    }

    // delete
    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id){
        pendingPaymentService.deletePayment(id);
    }

    // Get the total
    @GetMapping("/total")
    public Double getTotalPendingPayments() {
        return pendingPaymentService.calculateTotalPendingPayments();
    }
}
