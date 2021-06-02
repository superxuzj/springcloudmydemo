package com.xuzj.service;

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
        callException();
        return b;
    }

    private void callException() {
        int  i = 1/0;
    }
}
