package com.zhiqiangw.canteen.controller;

import com.zhiqiangw.canteen.bean.RestMessage;
import com.zhiqiangw.canteen.bean.UserLogin;
import com.zhiqiangw.canteen.service.impl.UserLoginService;
import com.zhiqiangw.canteen.utils.MyUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
@Api()
@RequestMapping("")
@Controller
public class UserLoginController {
    //自动注入
    @Autowired
    private UserLoginService userLoginService;

    @ApiOperation("判断用户登录")
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @ResponseBody
    public RestMessage testAjax(@ApiParam(value = "用户账号") @RequestParam("account")String account,@ApiParam(value = "用户密码")  @RequestParam("password")String password, HttpServletRequest request) throws IOException {
        RestMessage restMessage =new RestMessage();
        if(account!=null){
            UserLogin userLogin= userLoginService.findByAccount(account);
            if(userLogin==null){
                restMessage.setCode(1);
                restMessage.setMsg("false1");
                //这个账号未注册，提示账号需要注册
            }
            else {
                if(userLogin.getPassword().equals(MyUtils.getMD5String(password))){
                    //账号验证通过
                    restMessage.setMsg("true");
                    restMessage.setCode(0);
                    //将登录信息放入session中
                    HttpSession session = request.getSession(true);
                    session.setAttribute("UserInfo", userLogin);
                }
                else {
                    restMessage.setMsg("false2");
                    restMessage.setCode(3);
                }
            }

        }
        return restMessage;
    }

    /**
     * @Description: 退出登录或切换账号
     * @Author zhiqiangw
     * @Date 2020/2/17 12:51
     * @param: request
     * @return: java.lang.String
     */
    @GetMapping("/user/logout")
    @ApiOperation("退出登录")
    public String logout(HttpServletRequest request){
        //清空所有session
        Enumeration em = request.getSession().getAttributeNames();
        while(em.hasMoreElements()){
            request.getSession().removeAttribute(em.nextElement().toString());
        }
        return "redirect:/";
    }

/**
 * @Description: 获取所有的用户信息，以列表的形式返回
 * @Author zhiqiangw
 * @Date 2020/2/14 18:40
 * @param: request
 * @return: java.util.Map<java.lang.String,java.lang.Object>
 */
    @ApiOperation("显示所有用户")
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    @ResponseBody
    public RestMessage accountMsg(HttpServletRequest request) throws IOException {
        RestMessage restMessage =new RestMessage();
        //获取用户登录信息
        HttpSession session = request.getSession();
        UserLogin userLogin = (UserLogin)session.getAttribute("UserInfo") ;
        //判读用户权限，只有管理员权限才可以进行该操作
        if (userLogin.getIdentity().equals("0")) {
            List<UserLogin> users = userLoginService.findAll();
            restMessage.setCode(0);
            restMessage.setCount(String.valueOf(users.size()));
            restMessage.setMsg("success");
            restMessage.setData(users);
            //System.out.println(jsonArray);
        }
        else{
            restMessage.setCode(1);
            restMessage.setMsg("对不起，您的权限不足");
            restMessage.setData("");
            restMessage.setCount("0");
        }
       return restMessage;
    }

    /**
     * 根据id号删除指定的账户
     * @param id
     * @return
     * @throws IOException
     */
    @ApiOperation("删除账户")
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public RestMessage  deleteAccout(@ApiParam(value = "删除账号的编号") @PathVariable("id") Integer id) throws IOException {
        RestMessage restMessage =new RestMessage();
        userLoginService.deletById(id);
        restMessage.setMsg("success");
//        map.put("msg","success");
        return restMessage;
    }

    /**
     * @Description: t添加账号
     * @Author zhiqiangw
     * @Date 2020/2/14 22:22
     * @param: userLogin 带添加用户的信息
     * @return: java.util.Map<java.lang.String,java.lang.String>
     */
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("添加账户")
    public RestMessage addAccout(@ApiParam(value = "用户详细信息")UserLogin userLogin) throws IOException {
        RestMessage restMessage =new RestMessage();
        userLoginService.insertOne(userLogin);
        restMessage.setMsg("success");
        return restMessage;
    }

    /**
     * provider注册
     * @param account 账户
     * @param password 密码
     * @param username 用户名
     * @return 成功与否
     */
    @RequestMapping(value = "/user/register",method =RequestMethod.POST)
    @ResponseBody
    @ApiOperation("新增供应商")
    public RestMessage providerSignUp(@ApiParam(value = "供应商账号")@RequestParam("account")String account, @ApiParam(value = "供应商密码")@RequestParam("password")String password, @ApiParam(value = "供应商用户名")@RequestParam("username")String username) throws IOException {
        RestMessage restMessage =new RestMessage();
        UserLogin u=userLoginService.findByAccount(account);
        if(u==null) {
            UserLogin userLogin = new UserLogin();
            userLogin.setIdentity("3");
            userLogin.setUsername(username);
            userLogin.setPassword(MyUtils.getMD5String(password));
            userLogin.setAccount(account);
            userLoginService.providerLogin(userLogin);
            restMessage.setCode(0);
            restMessage.setMsg("true");
            //map.put("return","true");
        }
        else {
            restMessage.setCode(1);
            restMessage.setMsg("该账号已经存在");
        }
        return restMessage;
    }
}

