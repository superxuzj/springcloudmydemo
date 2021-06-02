package com.xuzj.service;

import cn.hutool.core.util.RandomUtil;
import com.xuzj.entity.Sysrole;
import com.xuzj.mapper.SysroleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xuzhijian
 * @date 2021/6/2
 **/
@Service
public class SysroleService {

    @Autowired
    private SysroleMapper sysroleMapper;

    public List<Sysrole> selectList(){
        return sysroleMapper.selectList(null);
    }

    @Transactional(rollbackFor = Exception.class)
    public int insert(Sysrole sysrole){
        int b = sysroleMapper.insert(sysrole);
        //callException();
        return b;
    }

    private void callException() {
        int  i = 1/0;
    }

    public void saveParent(){
        Sysrole sysrole = new Sysrole();
        sysrole.setName("parent"+RandomUtil.randomInt(100));
        sysrole.setRemark("parent"+RandomUtil.randomInt(100));
        sysroleMapper.insert(sysrole);
    }

    public void saveChild(){
        saveChild1();
        int a = 1/0;
        saveChild2();
    }

    public void saveChild1(){
        Sysrole sysrole = new Sysrole();
        sysrole.setName("Child1"+RandomUtil.randomInt(100));
        sysrole.setRemark("Child1"+RandomUtil.randomInt(100));
        sysroleMapper.insert(sysrole);
    }

    public void saveChild2(){
        Sysrole sysrole = new Sysrole();
        sysrole.setName("Child2"+RandomUtil.randomInt(100));
        sysrole.setRemark("Child2"+RandomUtil.randomInt(100));
        sysroleMapper.insert(sysrole);
    }

}
