package com.findas.repository;

import com.findas.entity.PendingPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<PendingPayment, Long> {
}
