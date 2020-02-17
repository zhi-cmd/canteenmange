package com.zhiqiangw.canteen.controller;

import com.zhiqiangw.canteen.bean.AskedFood;
import com.zhiqiangw.canteen.bean.OrderFood;
import com.zhiqiangw.canteen.bean.RestMessage;
import com.zhiqiangw.canteen.bean.UserLogin;
import com.zhiqiangw.canteen.service.impl.AskedFoodService;
import com.zhiqiangw.canteen.service.impl.BaseService;
import com.zhiqiangw.canteen.service.impl.StoreHouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName OrderController
 * @Description 预订单有关的请求处理
 * @Author zhiqiangw
 * @DATA 2020-2-15 21:56
 * @Version 1.0
 **/
@Controller
@RequestMapping("")
@Api()
public class OrderController {
    @Autowired
    private AskedFoodService askedFoodService;

    @Autowired
    private StoreHouseService storeHouseService;

    @Autowired
    private BaseService baseService;

    private Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping(value = "/order/detail/{ordernumber}",method = RequestMethod.GET)
    @ApiOperation("跳转订单详情界面")
    public String showOrderDeatil(Model model, @ApiParam(value = "订单编号") @PathVariable("ordernumber")Integer ordernumber){
        model.addAttribute("ordernumber",ordernumber);
        return "order/detail";
    }

/**
 * @Description: 获取订单详情所用的图表的数据
 * @Author zhiqiangw
 * @Date 2020/2/16 10:57
 * @param: ordernumber 订单号
 * @return: java.util.Map<java.lang.String,java.lang.Object>
 */
    @RequestMapping(value = "/order/chart/{ordernumber}",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("获取订单图表数据")
    public Map<String,Object> orderChart(@ApiParam(value = "订单编号") @PathVariable("ordernumber")Integer ordernumber){
        return askedFoodService.getOrderChartData(ordernumber);
    }

    /**
     * @Description: 获取订单的详细数据
     * @Author zhiqiangw
     * @Date 2020/2/16 11:06
     * @param: ordernumber 订单号
     * @return: com.zhiqiangw.canteen.bean.RestMessage
     */
    @RequestMapping(value = "/order/list/{ordernumber}",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("获取订单详细数据")
    public RestMessage orderList(@ApiParam(value = "订单编号") @PathVariable("ordernumber")Integer ordernumber){
        RestMessage restMessage =new RestMessage();
        //查询该订单对应的所有信息
        List<AskedFood>askedFoods=askedFoodService.findOrderDetail(ordernumber);
        //session.removeAttribute("ordernumber");
        restMessage.setCode(0);
        restMessage.setMsg("");
        restMessage.setCount(String.valueOf(askedFoods.size()));
        restMessage.setData(askedFoods);
        return restMessage;
    }

    /**
     * @Description: 确认收货，包括修改食品仓库食品数，更新订单状态等操作
     * @Author zhiqiangw
     * @Date 2020/2/16 11:49
     * @param: ordernumber
     * @return: java.util.Map<java.lang.String,java.lang.String>
     */
    @RequestMapping(value = "/order/confirm/{ordernumber}",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("确认收货")
    public Map<String,String> confirmRecOrder(@ApiParam(value = "订单编号") @PathVariable("ordernumber")Integer ordernumber){
        Map<String,String>map =new HashMap<>();
        Map<String,Integer>map1 =new HashMap<>();
        //获取订单的详细信息
        List<AskedFood>askedFoods=askedFoodService.findOrderDetail(ordernumber);
        //订单中相同食品数量求和
        map1 = askedFoodService.getNumberByFoodName(askedFoods);
        logger.error(map1.toString());
        //更新菜品仓库的菜品数量
        storeHouseService.putInStore(map1);
        //更新订单状态,确认收货
        storeHouseService.changeOrderStatus(ordernumber,"3");
        map.put("return","true");
        return map;
    }

    /**
     * @Description: 拒绝收货，不需要修改菜品仓库的数量
     * @Author zhiqiangw
     * @Date 2020/2/16 11:56
     * @param: ordernumber
     * @return: java.util.Map<java.lang.String,java.lang.String>
     */
    @RequestMapping(value = "/order/reject/{ordernumber}",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("拒绝收货")
    public Map<String,String> rejectRecOrder(@ApiParam(value = "订单编号") @PathVariable("ordernumber")Integer ordernumber){
        Map<String,String>map =new HashMap<>();
        storeHouseService.changeOrderStatus(ordernumber,"4");
        map.put("return","true");
        return map;
    }

    /**
     * @Description: 批量确认收货操作
     * @Author zhiqiangw
     * @Date 2020/2/16 12:06
     * @param: orderFoods 订单对象列表
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping(value = "/orders/confirm",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("批量确认收货")
    public Map<String,Object> checkOrder(@ApiParam(value = "选取的订单对象列表")@RequestBody List<OrderFood> orderFoods){
        Map<String,Object> map =new HashMap<>();
        for (OrderFood orderFood : orderFoods) {
//            Integer ordernumber =orderFood.getOrdernumber();
            logger.error(String.valueOf(orderFood.getOrdernumber()));
            List<AskedFood>askedFoods=askedFoodService.findOrderDetail(orderFood.getOrdernumber());
            //订单中相同食品数量求和
            if(askedFoods!=null) {//可能又空的订单
                Map<String, Integer> map1 = askedFoodService.getNumberByFoodName(askedFoods);
                //更新菜品仓库的菜品数量
                storeHouseService.putInStore(map1);
            }
            //更新订单状态,确认收货
            storeHouseService.changeOrderStatus(orderFood.getOrdernumber(),"3");
        }
        map.put("status","ok");
        return map;
    }

    /**
     * @Description: 查看所有的预购菜品
     * @Author zhiqiangw
     * @Date 2020/2/15 15:54
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping(value = "/preorders/all",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("查看所有的预购请求")
    public Map<String,Object> preorderAll(){
        Map<String,Object> map =new HashMap<String, Object>();
        List<AskedFood> askedFoods = askedFoodService.findAllAsked();
        for (AskedFood askedFood :askedFoods){
            System.out.println(askedFood.toString());
            if(askedFood.getStatus().equals("0")){//根据状态代号修改状态
                askedFood.setStatus("未处理");
            }
            else {
                askedFood.setStatus("已处理");
            }
        }
        map.put("code","0");
        map.put("msg","");
        map.put("count",String.valueOf(askedFoods.size()));
        map.put("data",askedFoods);
        return map;
    }
    @RequestMapping(value = "/preorders/notdeal",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("获取所有未处理的订单")
    public RestMessage preorderNotDeal(){
        RestMessage restMessage = new RestMessage();
        List<AskedFood> askedFoods = askedFoodService.findNotDeal();
        for (AskedFood askedFood :askedFoods){
            System.out.println(askedFood.toString());
            if(askedFood.getStatus().equals("0")){
                askedFood.setStatus("未处理");
            }
            else {
                askedFood.setStatus("已处理");
            }
        }
        restMessage.setData(askedFoods);
        restMessage.setCount(String.valueOf(askedFoods.size()));
        restMessage.setMsg("");
        restMessage.setCode(0);
        return restMessage;
    }

    /**
     * @Description: 根据预购请求生成订单
     * @Author zhiqiangw
     * @Date 2020/2/16 16:38
     * @param: askedFoods
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping(value = "/preorder/make",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("预购请求生成订单")
    public Map<String,Object> makeOrder(@ApiParam("预购请求列表")@RequestBody List<AskedFood> askedFoods){
        Map<String,Object> map =new HashMap<String, Object>();
        int totalmoney=0;//计算订单总钱数
        int nextnum= askedFoodService.getNextOrderNum();
        for (AskedFood askedFood :askedFoods){
            System.out.println(askedFood.toString());
            askedFoodService.makeupAskedFood(askedFood.getFooduid(),nextnum);
            totalmoney =totalmoney+Integer.parseInt(askedFoodService.getMoneyByname(askedFood.getFoodname()))*Integer.parseInt(askedFood.getAskedamount());
            if(askedFood.getStatus().equals("未处理")){
            }
            else {
                askedFood.setStatus("1");
            }
        }
        //更新订单信息
        OrderFood orderFood =new OrderFood();
        orderFood.setOrdernumber(nextnum);
        orderFood.setStatus("0");
        orderFood.setOrdertime(baseService.getNowTime());
        orderFood.setTotalmoney(String.valueOf(totalmoney));
        //插入新的订单
        askedFoodService.addOrder(orderFood);
        map.put("msg","success");
        return map;
    }

    /**
     * @Description: 获取所有的订单信息
     * @Author zhiqiangw
     * @Date 2020/2/16 16:19
     * @return: com.zhiqiangw.canteen.bean.RestMessage
     */
    @RequestMapping(value = "/orders",method =RequestMethod.GET )
    @ResponseBody
    @ApiOperation("获取订单列表")
    public RestMessage ordersShow(){
        RestMessage restMessage = new RestMessage();
        List<OrderFood> orderFoods = askedFoodService.findAllOrder();
        //将订单状态码转化为状态
        for (OrderFood askedFood :orderFoods){
            System.out.println(askedFood.toString());
            String stu = baseService.statusExchange(askedFood.getStatus());
            askedFood.setStatus(stu);
        }
        //构造回复信息的格式
        restMessage.setCode(0);
        restMessage.setMsg("");
        restMessage.setCount(String.valueOf(orderFoods.size()));
        restMessage.setData(orderFoods);
        return restMessage;
    }

    /**
     * @Description: 批量审核订单
     * @Author zhiqiangw
     * @Date 2020/2/16 16:26
     * @param: orderFoods 选中的订单对象列表
     * @param: request
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping(value = "/orders/check",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("批量审核订单")
    public Map<String,Object> checkOrders(@ApiParam("待确认的订单对象列表")@RequestBody List<OrderFood> orderFoods, HttpServletRequest request){
        Map<String,Object> map =new HashMap<>();
        //只有系统管理员才又权限进行订单审核，身份码0
        HttpSession session = request.getSession();
        UserLogin userLogin = (UserLogin)session.getAttribute("UserInfo") ;
        if(userLogin.getIdentity().equals("0")) {//管理员身份
            map.put("status","ok");
            for (OrderFood orderFood : orderFoods) {//所有选中订单循环
                if (orderFood.getStatus().equals("未处理")) {//修改订单状态
                    askedFoodService.setOrderStatusTo1(orderFood.getOrdernumber());
                }
            }
        }
        else {
            map.put("status","no");
        }
        return map;
    }

    @RequestMapping(value = "/order/check/{ordernumber}",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("审核单个订单")
    public Map<String,Object> checkOrder(@ApiParam("订单编号")@PathVariable("ordernumber")Integer ordermunber, HttpServletRequest request){
        Map<String,Object> map =new HashMap<>();
        //只有系统管理员才又权限进行订单审核，身份码0
        HttpSession session = request.getSession();
        UserLogin userLogin = (UserLogin)session.getAttribute("UserInfo") ;
        if(userLogin.getIdentity().equals("0")) {//管理员身份
            map.put("status","ok");
            OrderFood orderFood = askedFoodService.findOrderByNum(ordermunber);
            if (orderFood.getStatus().equals("0")) {//未处理的进行求改，其他不需要
                askedFoodService.setOrderStatusTo1(ordermunber);
            }
        }
        else {
            map.put("status","no");
        }
        return map;
    }

    /**
     * @Description: 删除指定的订单，删除后要修改购货需求的状态
     * @Author zhiqiangw
     * @Date 2020/2/16 16:36
     * @param: ordernumber 订单编号
     * @return: java.util.Map<java.lang.String,java.lang.String>
     */
    @RequestMapping(value = "/order/delete/{ordernumber}",method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation("删除对应的订单")
    public Map<String,String> deleteOrder(@ApiParam("订单编号")@PathVariable("ordernumber")Integer ordernumber){
        Map<String,String> map =new HashMap<>();
        //获取订单包含的所有购物请求
        List<AskedFood>askedFoods=askedFoodService.findOrderDetail(ordernumber);
        //修改订单中预购请求的状态
        for(AskedFood askedFood:askedFoods){
            askedFoodService.setAskedStatusTo0(askedFood.getFooduid());
        }
        //删除orderfood数据库中的订单
        askedFoodService.deleteOrderByNum(ordernumber);
        map.put("status","success");
        return map;
    }

    /**
     * @Description: 获取未处理的订单
     * @Author zhiqiangw
     * @Date 2020/2/16 19:07
     * @return: com.zhiqiangw.canteen.bean.RestMessage
     */
    @RequestMapping(value = "/orders/notdeal",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("获取未处理的订单")
    public RestMessage notCheckOrder(){
        RestMessage restMessage =new RestMessage();
        List<OrderFood> orderFoods = askedFoodService.findNotDealOrder();
        for (OrderFood orderFood:orderFoods){
            String stu = baseService.statusExchange(orderFood.getStatus());
            orderFood.setStatus(stu);
        }
        restMessage.setData(orderFoods);
        restMessage.setCount(String.valueOf(orderFoods.size()));
        restMessage.setMsg("");
        restMessage.setCode(0);
        return restMessage;
    }

}
