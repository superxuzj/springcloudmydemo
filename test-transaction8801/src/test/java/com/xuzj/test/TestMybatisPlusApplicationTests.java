package com.xuzj.test;

import com.xuzj.entity.Sysrole;
import com.xuzj.mapper.SysroleMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author xuzhijian
 * @date 2021/6/2
 **/
@SpringBootTest
public class TestMybatisPlusApplicationTests {

    @Autowired
    private SysroleMapper sysroleMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Sysrole> sysroleList = sysroleMapper.selectList(null);
        for(Sysrole sysrole:sysroleList) {
            System.out.println(sysrole);
        }
    }
}
