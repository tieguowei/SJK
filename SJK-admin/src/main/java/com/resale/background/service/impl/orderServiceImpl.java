package com.resale.background.service.impl;

import com.resale.background.mapper.OrderMapper;
import com.resale.background.pojo.Order;
import com.resale.background.service.OrderService;
import com.resale.background.util.DataMsg;
import com.resale.background.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class orderServiceImpl implements OrderService{


    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Order record) {
        return orderMapper.insert(record);
    }

    @Override
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public Order selectByPrimaryKey(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageModel queryAllByPage(Map<String, Object> map) throws Exception {

        PageModel pageModel = new PageModel();
        pageModel.setPageNo((Integer) map.get("pageNo"));
        pageModel.setPageSize((Integer) map.get("pageSize"));
        map.put("startIndex", pageModel.getStartIndex());
        map.put("endIndex", pageModel.getEndIndex());


        long count = orderMapper.queryAllOrderByPageCount(map);
        List<Map<String, Object>> orderList = new ArrayList<>();
        if(count>0){
            orderList = orderMapper.queryAllOrderByPage(map);
        }

        pageModel.setList(orderList);
        pageModel.setTotalRecords(count);

        return pageModel;
    }
}
