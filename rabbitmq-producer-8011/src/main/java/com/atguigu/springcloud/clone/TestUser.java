package com.atguigu.springcloud.clone;

import cn.hutool.core.util.ObjectUtil;

/**
 * @author xuzhijian
 * @date 2021/4/21
 **/
public class TestUser {

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("小红");
        User xxx = ObjectUtil.clone(user);;
        user.setId(2);
        user.setName("小明");
        System.out.println(user.toString());
        System.out.println(xxx.toString());
    }

}
