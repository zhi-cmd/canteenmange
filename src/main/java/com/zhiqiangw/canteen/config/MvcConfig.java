package com.zhiqiangw.canteen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName MvcConfig
 * @Description 修改Spring Boot的部分MVC配置
 * @Author zhiqiangw
 * @DATA 2020-2-14 15:27
 * @Version 1.0
 **/
//不要忘记加@Configuration使配置生效
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    /* *
     * @Description: 添加视图解析映射
     * @Author zhiqiangw
     * @Date 2020/2/14 15:29
     * @param: registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        //配置登录的跟页面为登录页面login.html
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        //配置访问主页的视图解析映射
        registry.addViewController("/dashboard.html").setViewName("dashboard");
        //账户相关映射
        //账户查看页面映射account/show.html
        registry.addViewController("/account/show.html").setViewName("account/show");
        //添加账户映射/account/add.html
        registry.addViewController("/account/add.html").setViewName("account/add");
        //食品仓库相关映射
        //添加所有食品映射/store/total.html
        registry.addViewController("/store/total.html").setViewName("store/total");
        //报警食品映射store/alarm.html
        registry.addViewController("/store/alarm.html").setViewName("store/alarm");
        //到货入库映射/store/confirm.html
        registry.addViewController("/store/confirm.html").setViewName("store/confirm");
        //订单相关映射
        //预购订单界面/order/preorder.html
        registry.addViewController("/order/preorder.html").setViewName("order/preorder");
        //订单列表映射/order/show.html
        registry.addViewController("/order/show.html").setViewName("order/show");
        //供应商模块映射
        //供应商审核界面/provider/show.html
        registry.addViewController("/provider/show.html").setViewName("provider/show");
        ///register.html,跳转注册页面
        registry.addViewController("/register.html").setViewName("account/register");
        ///provider/orderShow.html
        registry.addViewController("/provider/orderShow.html").setViewName("provider/order");
        //API文档映射/api-doc.html
        registry.addViewController("/api-doc.html").setViewName("document");
        ///store/add.html
        registry.addViewController("/store/add.html").setViewName("store/add");
    }

    /* *
     * @Description: 配置拦截器
     * @Author zhiqiangw
     * @Date 2020/2/14 15:29
     * @param: registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //super.addInterceptors(registry);
    }
}
