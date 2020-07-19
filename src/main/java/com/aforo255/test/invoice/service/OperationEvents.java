package com.aforo255.test.invoice.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.test.invoice.domain.Invoice;
import com.aforo255.test.invoice.domain.Operation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OperationEvents {
	
	private Logger logger = LoggerFactory.getLogger(OperationEvents.class);

	@Autowired
	private IInvoiceService invoiceService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public void processOperationEvents(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		double newamount = 0;
		Invoice invoice = new Invoice();
		
		Operation operationEvent = objectMapper.readValue(consumerRecord.value(), Operation.class);
		logger.info("OperationEvent proccessing: {}", consumerRecord.value());
		
		invoice = invoiceService.findId(operationEvent.getInvoice());
		newamount = invoice.getAmount() - operationEvent.getAmount();
		
		if (newamount == 0) {
			logger.info("The invoice {} has been paid completely.", invoice.getId());
			invoice.setState(0);
		} else if (newamount > 0) {
			logger.info("The invoice {} has been paid partially. Remaining amount: {}", invoice.getId(), newamount);
			invoice.setState(1);
		} else {
			logger.info("The invoice {} has been over paid. Excess amount: {}", invoice.getId(), newamount);
			invoice.setState(-1);
		}
		
		invoice.setAmount(newamount);
		invoiceService.save(invoice);
	}
	
}
