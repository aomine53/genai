package com.genai.ecommerce.repository;

import com.genai.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom queries, if needed
    Product getById(Long id);
}

