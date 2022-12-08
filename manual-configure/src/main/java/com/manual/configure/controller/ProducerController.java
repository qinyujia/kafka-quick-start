package com.manual.configure.controller;

import com.manual.configure.service.ProducerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProducerController {
    @Resource
    ProducerService producerService;

    @PostMapping(path = "/send/test/{what}")
    public void testSend(@PathVariable String what) {
        producerService.testSend(what);
    }
}
