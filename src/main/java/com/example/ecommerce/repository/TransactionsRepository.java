package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {

    Optional<Transactions> findById(int id);
}
