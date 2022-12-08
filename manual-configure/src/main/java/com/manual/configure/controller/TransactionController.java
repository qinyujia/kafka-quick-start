package com.manual.configure.controller;

import com.manual.configure.service.TransactionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TransactionController {

    @Resource
    TransactionService transactionService;

    @PostMapping(path = "/send/test/annotation/{what}")
    public void testTransactionalAnnotation(@PathVariable String what) {
        transactionService.testTransactionalAnnotation();
    }

    @PostMapping(path = "/send/test/execute/{what}")
    public void testExecuteInTransaction(@PathVariable String what) throws InterruptedException {
        transactionService.testExecuteInTransaction();
    }

}
