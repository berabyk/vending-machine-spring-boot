package com.bera.vendingmachine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bera.vendingmachine.model.Product;
import com.bera.vendingmachine.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	private final ProductRepository productRepository;

	@Autowired
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
}
