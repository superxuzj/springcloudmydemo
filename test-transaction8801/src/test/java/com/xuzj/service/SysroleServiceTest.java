package com.xuzj.service;

import cn.hutool.core.util.RandomUtil;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.xuzj.BaseTest;
import com.xuzj.entity.Sysrole;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class SysroleServiceTest extends BaseTest {

    @Autowired
    private SysroleService sysroleService;
    @Test
    public void selectList() {
        List<Sysrole> sysroleList = sysroleService.selectList();
        for(Sysrole sysrole:sysroleList) {
            System.out.println(sysrole);
        }
    }

    @Test
    public void insert() {
        Sysrole sysrole = new Sysrole();
        sysrole.setId(RandomUtil.randomInt(100));
        sysrole.setName("name"+RandomUtil.randomInt(100));
        sysrole.setRemark("remark"+RandomUtil.randomInt(100));
        sysroleService.insert(sysrole);
    }
}