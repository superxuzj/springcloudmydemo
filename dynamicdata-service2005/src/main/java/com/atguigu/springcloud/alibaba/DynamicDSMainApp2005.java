package com.atguigu.springcloud.alibaba;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
        //(exclude = DataSourceAutoConfiguration.class)//取消数据源自动创建的配置
public class DynamicDSMainApp2005 {

    public static void main(String[] args)
    {
        SpringApplication.run(DynamicDSMainApp2005.class, args);
    }
}

