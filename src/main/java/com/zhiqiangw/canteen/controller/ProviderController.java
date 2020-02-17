package com.zhiqiangw.canteen.controller;

import com.zhiqiangw.canteen.bean.*;
import com.zhiqiangw.canteen.service.impl.AskedFoodService;
import com.zhiqiangw.canteen.service.impl.BaseService;
import com.zhiqiangw.canteen.service.impl.ProviderService;
import com.zhiqiangw.canteen.service.impl.StoreHouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("")
@Api()
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @Autowired
    private AskedFoodService askedFoodService;

    @Autowired
    private BaseService baseService;

    @Autowired
    private StoreHouseService storeHouseService;

    @RequestMapping(value = "/provider/message" ,method = RequestMethod.GET)
    @ApiOperation("供应商信息跳转")
    public String providerMsgDetail(@ApiParam Model model,HttpServletRequest request){
        HttpSession session =request.getSession();
        UserLogin userLogin =(UserLogin) session.getAttribute("UserInfo");
        //登录的用户名就是providernumber
        //获取供应商详细信息
        ProviderMsg providerMsg = providerService.findProviderMsgByNum(userLogin.getAccount());
        model.addAttribute("providerMsg",providerMsg);
        return "provider/detail";
    }
    @RequestMapping(value = "/provider/message/{providernum}",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("更新供应商信息")
    public Map<String,Object> providerMsg(@ApiParam("提交的供应商信息") ProviderMsg providerMsg, @ApiParam("供应商账号")@PathVariable("providernum")String providernum, HttpServletRequest request){
        Map<String,Object> map =new HashMap<String, Object>();
        if(providerMsg!=null) {
            providerMsg.setProvidernum(providernum);
            //供应商重新提交之后，可以再次发起认证请求
            providerMsg.setStatus("0");
            providerService.updateProviderMsg(providerMsg);
            map.put("return", "true");
        }
        else map.put("return","false");
        return map;
    }

    /**
     * @Description: 显示所有审核完成等待发货的订单
     * @Author zhiqiangw
     * @Date 2020/2/16 21:38
     * @return: com.zhiqiangw.canteen.bean.RestMessage
     */
    @RequestMapping(value = "/provider/orders",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("待发货订单显示")
    public RestMessage providerOrders(){
        RestMessage restMessage=new RestMessage();
        List<OrderFood> orderFoods = askedFoodService.findProviderShow();
        for (OrderFood orderFood:orderFoods){
            String stu = baseService.statusExchange(orderFood.getStatus());
            orderFood.setStatus(stu);
        }
        //构造返回信息
        restMessage.setData(orderFoods);
        restMessage.setCount(String.valueOf(orderFoods.size()));
        restMessage.setCode(0);
        restMessage.setMsg("");
        return restMessage;
    }


    /**
     * @Description: 确认发货操作
     * @Author zhiqiangw
     * @Date 2020/2/16 22:05
     * @param: ordernumber
     * @param: request
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping(value = "/provider/send/{ordernumber}",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("确认发货")
    public Map<String,Object> providerSend(@ApiParam("确认发货")@PathVariable("ordernumber") Integer ordernumber, HttpServletRequest request){
        Map<String,Object> map =new HashMap<String, Object>();
        //获取当前登录的用户
        HttpSession session = request.getSession();
        UserLogin userLogin =(UserLogin)session.getAttribute("UserInfo");//供应商被认证，可以供货
        if (providerService.confirmProvider(ordernumber, userLogin.getAccount())) {//内部包含身认证
            map.put("return", "true");
        }
        else map.put("return","false");//没有供货权限
        return map;
    }

    /**
     * @Description: 显示认证的供应商信息
     * @Author zhiqiangw
     * @Date 2020/2/16 19:57
     * @return: com.zhiqiangw.canteen.bean.RestMessage
     */
    @RequestMapping(value = "/providers/notdeal",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("获取待认证供应商列表")
    public RestMessage providerIdentifyShow(){
        RestMessage restMessage =new RestMessage();
        List<ProviderMsg>providerMsgs=providerService.findNotIdentifyProvider();
        restMessage.setCode(0);
        restMessage.setMsg("");
        restMessage.setCount(String.valueOf(providerMsgs.size()));
        restMessage.setData(providerMsgs);
        return restMessage;
    }


    /**
     * @Description: 认证某个供应商
     * @Author zhiqiangw
     * @Date 2020/2/16 20:01
     * @param: providernum
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping(value = "/provider/approve/{providernum}",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("认证供应商")
    public Map<String,Object> providerApprove(@ApiParam("供应商账号") @PathVariable("providernum")String providernum){
        Map<String,Object> map =new HashMap<String, Object>();
        providerService.identifyProvider(providernum);
        map.put("return","true");
        return map;
    }

    /**
     * @Description: 忽略供应商的认证请求
     * @Author zhiqiangw
     * @Date 2020/2/16 22:05
     * @param: providernum
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping(value = "/provider/approve/{providernum}",method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation("忽略供应商认证请求")
    public Map<String,Object> providerIgnore(@ApiParam("供应商账号") @PathVariable("providernum")String providernum){
        Map<String,Object> map =new HashMap<String, Object>();
        providerService.ignoreProvider(providernum);
        map.put("return","true");
        return map;
    }

    /**
     * @Description: 返回当前登录供应商的错误订单
     * @Author zhiqiangw
     * @Date 2020/2/16 22:16
     * @param: request
     * @return: com.zhiqiangw.canteen.bean.RestMessage
     */
    @RequestMapping(value = "/provider/reject",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("当前供应商的问题订单")
    public RestMessage providerReject(HttpServletRequest request){
        RestMessage restMessage =new RestMessage();
        //获取当前登录用户的信息
        HttpSession session = request.getSession();
        UserLogin userLogin =(UserLogin)session.getAttribute("UserInfo");
        List<OrderFood> orderFoods = storeHouseService.findRejectedOrder();
        Iterator<OrderFood> iterator = orderFoods.iterator();
        while(iterator.hasNext()){
            OrderFood orderFood =iterator.next();
            if(orderFood.getProvideraccount().equals(userLogin.getAccount())) {//是该供应商的错误订单
                //将状态码转化为状态描述显示
                String stu = baseService.statusExchange(orderFood.getStatus());
                orderFood.setStatus(stu);
            }
            else {//该问题订单与当前登录供应商无关
                iterator.remove();
            }
        }
        restMessage.setMsg("");
        restMessage.setCode(0);
        restMessage.setData(orderFoods);
        restMessage.setCount(String.valueOf(orderFoods.size()));
        return restMessage;
    }
    /**
     * 展示订单的详细信息。
     * @return
     */
    @RequestMapping("/orderDetail")
    @ResponseBody
    public Map<String,Object> orderDetail(HttpServletRequest request){
        Map<String,Object> map =new HashMap<String, Object>();
        HttpSession session=request.getSession();
        int ordernum=Integer.parseInt( (String) session.getAttribute("ordernumber"));
        List<AskedFood>providerMsgs=askedFoodService.findOrderDetail(ordernum);
        //session.removeAttribute("ordernumber");
        map.put("code","0");
        map.put("msg","");
        map.put("count",String.valueOf(providerMsgs.size()));
        map.put("data",providerMsgs);
        return map;
    }


}
