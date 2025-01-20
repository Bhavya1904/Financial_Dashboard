package com.findas.repository;

import com.findas.entity.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SupplyRepo extends JpaRepository<Supply, Long> {
    @Query("SELECT SUM(s.value) FROM Supply s")
    Double calculateTotalSupply();
}
