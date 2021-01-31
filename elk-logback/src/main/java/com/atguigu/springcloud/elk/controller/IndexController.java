package com.atguigu.springcloud.elk.controller;

import com.atguigu.springcloud.elk.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IndexController {
    @GetMapping("/")
    public String index() {
        System.out.println(SpringContextUtil.getActiveProfile());
        log.info("11");
        log.debug("22222");
        log.error("3333");
        return "index";
    }
}
