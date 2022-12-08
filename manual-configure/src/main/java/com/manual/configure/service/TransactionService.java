package com.manual.configure.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TransactionService {
    private final Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    @Qualifier("tranKafkaTemplate")
    KafkaTemplate<String, String> kafkaTemplate;

    @Transactional
    public void testTransactionalAnnotation() {
        kafkaTemplate.send("test", "test transactional annotation");
//        throw new RuntimeException("fail test transactional annotation");
    }

    public void testExecuteInTransaction() throws InterruptedException {
        kafkaTemplate.executeInTransaction(new KafkaOperations.OperationsCallback() {
            @Override
            public Object doInOperations(KafkaOperations kafkaOperations) {
                kafkaOperations.send("test", "test executeInTransaction");
//                throw new RuntimeException("fail test executeInTransaction");
                return true;
            }
        });
    }
}
