package com.aforo255.test.invoice.dao;

import org.springframework.data.repository.CrudRepository;

import com.aforo255.test.invoice.domain.Invoice;

public interface IInvoiceDao extends CrudRepository<Invoice, Integer>{

}
