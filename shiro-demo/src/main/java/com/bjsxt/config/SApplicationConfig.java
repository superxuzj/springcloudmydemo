package com.bjsxt.config;

import com.bjsxt.realm.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuzhijian
 * @date 2021/2/9
 **/
@Configuration
public class SApplicationConfig {
    @Autowired
    private MyRealm myRealm;
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(){
        DefaultWebSecurityManager  defaultWebSecurityManager=new DefaultWebSecurityManager();
        /*HashedCredentialsMatcher matcher=new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(3);
        myRealm.setCredentialsMatcher(matcher);*/
        defaultWebSecurityManager.setRealm(myRealm);
        return defaultWebSecurityManager;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        definition.addPathDefinition("/userLogin", "anon");
        definition.addPathDefinition("/login", "anon");
        //definition.addPathDefinition("/**", "authc");

        definition.addPathDefinition("/logout", "logout");
        definition.addPathDefinition("/**", "authc");
        return definition;
    }

}
