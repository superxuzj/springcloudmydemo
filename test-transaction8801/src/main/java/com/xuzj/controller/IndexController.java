package com.xuzj.controller;

import com.atguigu.springcloud.entities.OrderMaster;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@Slf4j
public class IndexController {

    @GetMapping("/")
    public String index() {

        System.out.println(new Date());
        return "index";
    }
}
