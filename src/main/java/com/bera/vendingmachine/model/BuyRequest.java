package com.bera.vendingmachine.model;

public class BuyRequest {
	private long productId;
    private double amountPaid;
    
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
    
    
}
