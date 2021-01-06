package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


//要不要exclude = DruidDataSourceAutoConfigure.class取决于pom文件 中有没有引入druidstarter
@SpringBootApplication//(exclude = DruidDataSourceAutoConfigure.class)//取消数据源自动创建的配置
public class DynamicDSMainApp2006 {

    public static void main(String[] args)
    {
        SpringApplication.run(DynamicDSMainApp2006.class, args);
    }
}

