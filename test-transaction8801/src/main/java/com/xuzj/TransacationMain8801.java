package com.xuzj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//https://www.cnblogs.com/l-y-h/p/12859477.html
@MapperScan("com.xuzj.mapper")
@SpringBootApplication
public class TransacationMain8801 {
    public static void main(String[] args) {

        SpringApplication.run(TransacationMain8801.class,args);
    }

}