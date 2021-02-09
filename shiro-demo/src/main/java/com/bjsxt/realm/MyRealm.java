package com.bjsxt.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuzhijian
 * @date 2021/2/9
 **/
@Component
public class MyRealm extends AuthorizingRealm{
    /**
     * 自定义登录认证的逻辑，配置生效后，login方法被执行，底层自动调用改方法完成登录认证
     * 而不再使用shiro自己内置的登录认证逻辑
     * @param token
     * @return {@link AuthenticationInfo}
     * @Author: zhijian.xu
     * @date 2021/2/9
    **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("自定义登录认证");
        String uname = token.getPrincipal().toString();
        System.out.println(uname);
        AuthenticationInfo info = new SimpleAuthenticationInfo(token.getPrincipal()
        ,"111",token.getPrincipal().toString());

        return info;
    }

    /**
     * 自定义授权方法
     * @param principalCollection
     * @return {@link AuthorizationInfo}
     * @Author: zhijian.xu
     * @date 2021/2/9
    **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("开始授权");
        //0.获取当前认证的用户的身份信息(登录名)
        String uname = (String) principalCollection.getPrimaryPrincipal();
        System.out.println(" doGetAuthorizationInfo : "+uname);
        //1.查询当前用户具备的权限信息--从数据库
        List<String> list=new ArrayList<>();
        list.add("user:del");
        list.add("user:add");
        //2.将当前用户具备的权限信息给Shiro
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(list);
        //3.返回
        return info;
    }
}
