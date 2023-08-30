package com.bera.vendingmachine.model;

public class PaymentResponse {
	private String message;
    private double change;

    public PaymentResponse(String message, double change) {
        this.message = message;
        this.change = change;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}
}
