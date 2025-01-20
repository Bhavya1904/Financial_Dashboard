package com.findas.service;

import com.findas.entity.PendingPayment;
import com.findas.repository.PaymentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PendingPaymentService {

    private final PaymentRepo paymentRepo;

    public PendingPaymentService(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    // create
    public PendingPayment savePayment(PendingPayment payment) {
        return paymentRepo.save(payment);
    }

    // read
    public List<PendingPayment> getAllPayments() {
        return paymentRepo.findAll();
    }

    // read only 1
    public Optional<PendingPayment> getPaymentById(Long id) {
        return paymentRepo.findById(id);
    }

    // update
    public PendingPayment updatePayment(Long id,PendingPayment payment) {
        if ( paymentRepo.existsById(id)){
            payment.setPaymentId(id);
            return paymentRepo.save(payment);
        }
        return null;
    }

    // delete
    public void deletePayment(Long id) {
        paymentRepo.deleteById(id);
    }

    // calculating total
    public Double calculateTotalPendingPayments() {
        return paymentRepo.findAll()
                .stream()
                .mapToDouble(PendingPayment::getAmount)
                .sum();
    }
}
