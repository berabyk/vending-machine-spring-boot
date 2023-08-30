package com.bera.vendingmachine.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bera.vendingmachine.model.BuyRequest;
import com.bera.vendingmachine.model.PaymentResponse;
import com.bera.vendingmachine.model.Product;
import com.bera.vendingmachine.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class PaymentController {
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/buy")
    public PaymentResponse buyProduct(@RequestBody BuyRequest buyRequest) {
        long productId = buyRequest.getProductId();
        double amountPaid = buyRequest.getAmountPaid();

        Optional<Product> productOptional = productRepository.findById(productId);

        if (!productOptional.isPresent()) {
            return new PaymentResponse("Ürün bulunamadı", 0);
        }

        Product product = productOptional.get();
        double productPrice = product.getPrice();
        double change = amountPaid - productPrice;

        if (change >= 0 && product.getQuantity() > 0) {
            product.setQuantity(product.getQuantity() - 1);
            productRepository.save(product);
            return new PaymentResponse("Product has been given. Exchange is: " + change, change);
        }
        else {
        	 return new PaymentResponse("You didn't enter enought money", change);
        }
    }
}
