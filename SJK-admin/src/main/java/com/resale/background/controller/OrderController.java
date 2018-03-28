package com.resale.background.controller;


import com.resale.background.pojo.Merchant;
import com.resale.background.service.OrderService;
import com.resale.background.util.DataMsg;
import com.resale.background.util.PageModel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/***
 * 订单管理
 */
@Controller
@RequestMapping("/order")
public class OrderController {


    private final static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping("/goOrderPage")
    public String orderListPage(){
        return "/orderPage/orderList";
    }


    @RequestMapping("orderListByPage")
    @ResponseBody
    public DataMsg orderListByPage(HttpServletRequest request, DataMsg dataMsg){
        try{
            Map<String,Object> map = new HashMap<String,Object>();
            Subject subject = SecurityUtils.getSubject();
            Merchant merchant = (Merchant) subject.getPrincipal();

            map.put("merchant_code",merchant.getMerchantCode());
            map.put("pageNo", Integer.valueOf(request.getParameter("pageNumber")));
            map.put("pageSize", Integer.valueOf(request.getParameter("pageSize")));
            PageModel pageModel = orderService.queryAllByPage(map);

            dataMsg.setRows(pageModel.getList());
            dataMsg.setTotal(pageModel.getTotalRecords());

        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return dataMsg;
        }


    }
