package com.xuzj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestTransactionService {
    @Autowired
    private SysroleService sysroleService;

    public void testTransactions(){

    }
}
