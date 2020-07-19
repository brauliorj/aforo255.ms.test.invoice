package com.aforo255.test.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aforo255.test.invoice.domain.Invoice;
import com.aforo255.test.invoice.service.IInvoiceService;

@RestController
public class InvoiceController {

	@Autowired
	private IInvoiceService invoiceService;
	
	@GetMapping("/invoices")
	public List<Invoice> invoices() {
		return invoiceService.findAll();
	}
	
	@GetMapping("/invoice/{id}")
	public Invoice getInvoice(@PathVariable Integer id) {
		return invoiceService.findId(id);
	}
	
}
