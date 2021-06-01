package com.atguigu.springcloud.clone;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author xuzhijian
 * @date 2021/4/21
 **/
@Data
public class User implements Serializable {
    private Integer id ;
    private String name;
}
