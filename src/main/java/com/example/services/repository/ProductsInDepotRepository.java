package com.example.services.repository;


import com.example.services.entity.ProductsInDepot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsInDepotRepository extends  JpaRepository<ProductsInDepot, Long> {
}
