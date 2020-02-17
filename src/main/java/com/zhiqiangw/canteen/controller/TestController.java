package com.zhiqiangw.canteen.controller;

import com.zhiqiangw.canteen.bean.AskedFood;
import com.zhiqiangw.canteen.bean.UserLogin;
import com.zhiqiangw.canteen.mapper.IAskedFoodDao;
import com.zhiqiangw.canteen.service.impl.UserLoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestController
 * @Description controller层测试所用类
 * @Author zhiqiangw
 * @DATA 2020-2-14 11:57
 * @Version 1.0
 **/
@Controller
public class TestController {
    @Autowired
    IAskedFoodDao askedFoodDao;
    //自动注入
    @Autowired
    private UserLoginService userLoginService;
    /* *
     * @Description: 测试mybatis的查询功能
     * @Author zhiqiangw
     * @Date 2020/2/14 12:32
     * @param: id 带查询订单号
     * @return: java.util.List<com.zhiqiangw.canteen.bean.AskedFood>
     */
    @ResponseBody
    @GetMapping("/aksedfood/{id}")
    public List<AskedFood> testMybatis(@PathVariable("id") Integer id){
        return askedFoodDao.findByOrdernumber(id);
    }

    /**
     * @Description: 获取所有的用户信息，以列表的形式返回
     * @Author zhiqiangw
     * @Date 2020/2/14 18:40
     * @param: request
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @ApiOperation("显示所有用户")
    @RequestMapping(value = "//users",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> accountMsg(HttpServletRequest request) throws IOException {
        Map<String,Object> map =new HashMap<String, Object>();
        //获取用户登录信息
        HttpSession session = request.getSession();
        UserLogin userLogin = (UserLogin)session.getAttribute("UserInfo") ;
        //判读用户权限，只有管理员权限才可以进行该操作
        if (userLogin.getIdentity().equals("0")) {
            List<UserLogin> users = userLoginService.findAll();
            //System.out.println(jsonArray);
            map.put("code", "0");
            map.put("msg", "success");
            map.put("count", String.valueOf(users.size()));
            map.put("data", users);
        }
        else{
            map.put("code", "0");
            map.put("msg", "对不起，您的权限不足");
            map.put("count", 0);
            map.put("data", "");
        }
        return map;
    }
}
