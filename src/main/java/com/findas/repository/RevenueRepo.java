package com.findas.repository;

import com.findas.entity.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface RevenueRepo extends JpaRepository<Revenue, Long> {
    @Query("SELECT SUM(r.amount) FROM Revenue r")
    Double calculateTotalRevenue();

    @Query("SELECT MAX(r.amount) FROM Revenue r")
    Double calculateHighestMonthlyRevenue();

}