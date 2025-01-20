package com.findas.controller;

import com.findas.entity.PendingPayment;
import com.findas.entity.Supply;
import com.findas.service.PendingPaymentService;
import com.findas.service.SupplyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    private final PendingPaymentService pendingPaymentService;
    private final SupplyService supplyService;

    public FormController(PendingPaymentService pendingPaymentService, SupplyService supplyService) {
        this.pendingPaymentService = pendingPaymentService;
        this.supplyService = supplyService;
    }

    @PostMapping("/api/pending-payments/payment")
    public String createPayment(@ModelAttribute PendingPayment payment) {
        pendingPaymentService.savePayment(payment);
        return "redirect:/user/profile";
    }

    @PostMapping("/api/supplies/supply")
    public String createSupply(@ModelAttribute Supply supply) {
        supplyService.createSupply(supply);
        return "redirect:/user/profile";
    }
}
