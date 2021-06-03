package com.xuzj.test;

import com.xuzj.BaseTest;
import com.xuzj.entity.Sysrole;
import com.xuzj.mapper.SysroleMapper;
import com.xuzj.service.TestTransactionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author xuzhijian
 * @date 2021/6/2
 **/
public class TestMybatisPlusApplicationTests extends BaseTest {

    @Autowired
    private TestTransactionService testTransactionService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        testTransactionService.testTransactions();
    }
}
