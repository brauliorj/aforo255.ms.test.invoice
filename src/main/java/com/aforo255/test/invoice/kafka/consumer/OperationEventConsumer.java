package com.aforo255.test.invoice.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.aforo255.test.invoice.service.OperationEvents;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
public class OperationEventConsumer {
	
	private Logger logger = LoggerFactory.getLogger(OperationEventConsumer.class);
	
	@Autowired
	private OperationEvents operationEvents;

	@KafkaListener(topics = {"operation-events"})
	public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		logger.info("Receiving operation record: {}", consumerRecord);
		operationEvents.processOperationEvents(consumerRecord);
		logger.info("Finishing operation process...");
	}
	
}
