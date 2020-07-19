package com.aforo255.test.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.test.invoice.dao.IInvoiceDao;
import com.aforo255.test.invoice.domain.Invoice;

@Service
public class InvoiceServiceImpl implements IInvoiceService {
	
	@Autowired
	private IInvoiceDao invoiceDao;
	
	@Override
	public Invoice save(Invoice invoice) {
		return invoiceDao.save(invoice);
	}
	
	@Override
	public Invoice findId(Integer id) {
		return invoiceDao.findById(id).orElse(null);
	}
	
	@Override
	public List<Invoice> findAll() {
		return (List<Invoice>) invoiceDao.findAll();
	}

}
