package com.app.dto;

import java.time.LocalDateTime;

import com.app.pojos.Packages;

public class InvoiceDto 
{

	private double paymentId;
	private double amount;
	private LocalDateTime paymentDate;
	private String packages;
	
	
	
	public InvoiceDto() {
		super();
		
	}


	public InvoiceDto(double paymentId, double amount, LocalDateTime paymentDate, String packages) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.packages = packages;
	}


	public double getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(double paymentId) {
		this.paymentId = paymentId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}


	public String getPackages() {
		return packages;
	}


	public void setPackages(String packages) {
		this.packages = packages;
	}
	
	
	
	
	
}
