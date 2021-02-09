package com.bjsxt.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("userController")
public class UserController {
    //声明单元方法:用户删除
    @RequiresPermissions("user:del")
    @RequestMapping("userDel")
    @ResponseBody
    public String userDel(){
        System.out.println("用户信息删除单元方法执行");
        return "删除成功";
    }
    //声明单元方法:用户修改
    @RequiresPermissions("user:edit")
    @RequestMapping("userEdit")
    @ResponseBody
    public String userEdit(){
        System.out.println("用户信息修改单元方法执行");
        return "修改成功";
    }
    //声明单元方法:用户新增
    @RequiresPermissions("user:add")
    @RequestMapping("userAdd")
    @ResponseBody
    public String userAdd(){
        System.out.println("用户信息新增单元方法执行");
        return "新增成功";
    }
    //声明单元方法:用户查询
    @RequiresPermissions("user:sel")
    @RequestMapping("userSel")
    @ResponseBody
    public String userSel(){
        System.out.println("用户信息查询单元方法执行");
        return "查询成功";
    }


}
