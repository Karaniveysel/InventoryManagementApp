package com.example.services.repository;

import com.example.services.entity.Depot;
import com.example.services.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends  JpaRepository<Product, Long> {
}
