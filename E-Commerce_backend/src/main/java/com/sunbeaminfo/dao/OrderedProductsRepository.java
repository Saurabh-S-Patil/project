package com.sunbeaminfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeaminfo.entities.OrderedProducts;

public interface OrderedProductsRepository extends JpaRepository<OrderedProducts, Long> {
    
}
