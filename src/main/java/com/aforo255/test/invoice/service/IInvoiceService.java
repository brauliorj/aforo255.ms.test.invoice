package com.aforo255.test.invoice.service;

import java.util.List;

import com.aforo255.test.invoice.domain.Invoice;

public interface IInvoiceService {

	public Invoice save(Invoice invoice);
	
	public Invoice findId(Integer id);
	
	public List<Invoice> findAll();
	
}
