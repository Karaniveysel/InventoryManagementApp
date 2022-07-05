package com.example.services.repository;

import com.example.services.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends  JpaRepository<Category, Long> {
}
