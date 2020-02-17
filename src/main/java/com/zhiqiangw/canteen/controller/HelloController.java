package com.zhiqiangw.canteen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//控制类
@Controller
@RequestMapping(path="/user")
public class HelloController {
//    method,决定响应的请求方式
//    params ={"username"},要求必须穿一个username的属性
    @RequestMapping(path = "/hello",method = {RequestMethod.POST})
    public String sayHello(){
        System.out.println("hello stringmvc");
        return  "success";
    }
//    请求参数绑定，请求键名与方法定义的参数名一致，自动绑定相应的参数
    @RequestMapping(path = "/param")
    public String sayHello(String username){
        System.out.println(username);
        return "success";
    }

    /**
     * 获取原生的API
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(path = "/ServletAPI")
    public String servletAPI(HttpServletRequest request , HttpServletResponse response){
        return "success";
    }


}
