package com.zhiqiangw.canteen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 常用注解介绍
 */
@Controller
@RequestMapping(path = "/anno")
public class AnnoController {
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name")String username){//提交端的name属性给username
        return "success";
    }

    /**
     * 获取请求体的内容
     */
//    @RequestMapping("/testRequestParam")
//    public String testRequestbody(@RequestBody()String body){//这个body与提交属性不不能一样
//        return "success";
//    }
}
