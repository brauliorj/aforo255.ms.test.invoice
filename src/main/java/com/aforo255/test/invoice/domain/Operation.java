package com.aforo255.test.invoice.domain;

import java.io.Serializable;

public class Operation implements Serializable {
	private static final long serialVersionUID = -3554016303700709092L;
	
	private Integer id;
	private Integer invoice;	
	private double amount;	
	private String datetime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInvoice() {
		return invoice;
	}

	public void setInvoice(Integer invoice) {
		this.invoice = invoice;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
}
