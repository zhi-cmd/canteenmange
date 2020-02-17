package com.zhiqiangw.canteen.controller;

import com.zhiqiangw.canteen.bean.*;
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
@Api()
@Controller
@RequestMapping("")
public class StoreHouseController {
    @Autowired
    private StoreHouseService storeHouseService;
    @Autowired
    private AskedFoodService askedFoodService;
    @Autowired
    private BaseService baseService;
    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * @Description: 向菜品仓库中添加一条菜品
     * @Author zhiqiangw
     * @Date 2020/2/17 13:29
     * @param: foodStore
     * @return: java.util.Map<java.lang.String,java.lang.String>
     */
    @PostMapping(value = "/store/addfood")
    @ResponseBody
    @ApiOperation("添加一种菜品")
    public Map<String,String> addFood(@ApiParam("提交的供应商信息") FoodStore foodStore){
        Map<String,String>map=new HashMap<>();
        //添加菜品
        if(storeHouseService.addOneFood(foodStore)){
            //添加成功
            map.put("return","success");
        }else {
            map.put("return","fail");
        }
        return map;
    }
    /**
     * @Description: 查询显示所有仓库里的食物情况
     * @Author zhiqiangw
     * @Date 2020/2/15 14:47
     * @return: com.zhiqiangw.canteen.bean.RestMessage
     */
    @RequestMapping(value = "/store/totals",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("查询所有库存")
    public RestMessage showAll(){
        RestMessage restMessage=new RestMessage();
        List<FoodStore> foodStores =storeHouseService.showAllStoreHouse();
        //System.out.println(jsonArray);
        //清空改变值
        for (FoodStore foodStore :foodStores){
            System.out.println(foodStore.toString());
            foodStore.setChangenum(0);
        }
        restMessage.setMsg("");
        restMessage.setCode(0);
        restMessage.setCount(String.valueOf(foodStores.size()));
        restMessage.setData(foodStores);
        return restMessage;
    }
    /**
     * @Description: 菜品购入请求，修改请求表和历史请求表
     * @Author zhiqiangw
     * @Date 2019/8/15 15:54
     * @param: foodname 菜品名称
     * @param: changenum 购入数量
     * @return: java.util.Map<java.lang.String,java.lang.String>
     */
    @RequestMapping(value = "/store/ask",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("菜品购入请求")
    public Map<String,String> askedStore(@ApiParam(value = "菜品编号")@RequestParam("foodid")Integer foodid, @ApiParam(value = "请求量")@RequestParam("changenum")String changenum) {
       logger.error("获取到菜品名称"+foodid);
        FoodStore foodStore=storeHouseService.findOneById(foodid);
        //更新请求菜品表
        AskedFood askedFood =new AskedFood();
        askedFood.setFoodname(foodStore.getFoodname());
        askedFood.setAskedamount(changenum);
        askedFood.setStatus("0");//设置菜品状态，0代表等待处理
        askedFood.setFinishtime(baseService.getNowTime());
        //插入，实际更新请求表
        askedFoodService.insertOneAsked(askedFood);
        //更新历史请求表

        logger.error("获取到菜品对象"+foodStore);
        HistoryBuy historyBuy =new HistoryBuy();
        historyBuy.setTime(baseService.getNowTime());
        historyBuy.setBuynumber(Math.abs(Integer.parseInt(changenum)));
        historyBuy.setFoodid(foodStore.getFoodid());
        storeHouseService.insertHistoryBuy(historyBuy);
        Map<String,String> map =new HashMap<String, String>();
        map.put("msg","success");
        return map;
    }
    /**
     * @Description: 使用菜品请求，包括修改菜品仓库数据数量以及更新历史使用表
     * @Author zhiqiangw
     * @Date 2019/8/15 15:46
     * @param: foodid 菜品编号
     * @param: changenum 使用数量
     * @return: java.util.Map<java.lang.String,java.lang.String>
     */
    @RequestMapping(value = "/store/use",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("菜品使用")
    public Map<String,String> useFood(@ApiParam(value = "菜品编号") @RequestParam("foodid")int foodid, @ApiParam(value = "使用量") @RequestParam("changenum")int changenum){
        Map<String,String>map =new HashMap<String, String>();
        //更新库存信息
        storeHouseService.updateUseNum(foodid,changenum);
        //更新历史使用表信息
        HistoryUse historyUse =new HistoryUse();
        historyUse.setTime(baseService.getNowTime());
        historyUse.setFoodid(foodid);
        historyUse.setUsenumber(Math.abs(changenum));
        storeHouseService.insertHistoryUse(historyUse);
        //成功提示
        map.put("msg","success");
        return map;
    }

    /**
     * @Description: 视图解析器，拦截/store/chart/{id}跳转store/chart.html界面
     * @Author zhiqiangw
     * @Date 2020/2/15 17:51
     * @param: id 菜品编号
     * @param: model
     * @return: java.lang.String
     */
    @RequestMapping(value = "/store/chart/{id}",method = RequestMethod.GET)
    @ApiOperation("打开图表显示")
    public String storeChart(@ApiParam(value = "菜品编号")@PathVariable("id") Integer id,Model model ){
        //将点击的菜品编号传给前端界面
        model.addAttribute("foodid",id);
        return "store/chart";
    }




    /**
     * @Description: 显示所有的报警信息
     * @Author zhiqiangw
     * @Date 2019/8/15 19:00
     * @return: com.zhiqiangw.canteen.bean.RestMessage
     */
    @RequestMapping(value = "/store/alarms",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("库存报警请求")
    public RestMessage alarmStore(){
        RestMessage restMessage =new RestMessage();
        List<FoodStore> foodStores =storeHouseService.findAllAlarm();
        restMessage.setCode(0);
        restMessage.setMsg("");
        restMessage.setCount(String.valueOf(foodStores.size()));
        restMessage.setData(foodStores);
        return restMessage;
    }

    /**
     * @Description: 获取食品仓库图表显示所需的数据
     * @Author zhiqiangw
     * @Date 2020/2/15 18:20
     * @param: type 图表显示种类
     * @param: foodid 菜品编号
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping(value = "/chart/show/{foodid}",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("使用量图表数据获取")
    public Map<String,Object> storeChartShow(@ApiParam("图表种类")@RequestParam("type") String type,@ApiParam(value = "菜品编号")@PathVariable("foodid") Integer foodid){
        Map<String,Object> map =new HashMap<String, Object>();
        map=storeHouseService.getFoodStoreChartData(foodid, type);
        return map;
    }

    @RequestMapping(value = "/store/receives",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("已发货订单显示")
    public RestMessage storeReceivedOrder(){
        RestMessage restMessage=new RestMessage();
        List<OrderFood> orderFoods = storeHouseService.findReceivedOrder();
        for (OrderFood orderFood:orderFoods){
            //将状态码转化为状态描述显示
            String stu = baseService.statusExchange(orderFood.getStatus());
            orderFood.setStatus(stu);
        }
        restMessage.setData(orderFoods);
        restMessage.setCount(String.valueOf(orderFoods.size()));
        restMessage.setMsg("");
        restMessage.setCode(0);
        return restMessage;
    }

    @RequestMapping(value = "/store/rejects",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("拒绝入库订单显示")
    public RestMessage storeRejectOrder(){
        RestMessage restMessage=new RestMessage();
        List<OrderFood> orderFoods = storeHouseService.findRejectedOrder();
        for (OrderFood orderFood:orderFoods){
            //将状态码转化为状态描述显示
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
