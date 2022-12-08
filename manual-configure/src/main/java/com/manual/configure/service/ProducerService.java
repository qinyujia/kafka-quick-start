package com.manual.configure.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ProducerService {
    @Resource
    KafkaTemplate<String, String> kafkaTemplate;

    public void testSend(String what) {
        kafkaTemplate.send("test", "send :" + what);
    }
}
