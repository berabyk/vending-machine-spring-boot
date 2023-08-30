package com.bera.vendingmachine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bera.vendingmachine.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
