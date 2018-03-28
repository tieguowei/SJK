package com.resale.background.service;

import com.resale.background.pojo.Order;
import com.resale.background.pojo.OrderExample;
import com.resale.background.util.DataMsg;
import com.resale.background.util.PageModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderService {



    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加不判空
     * @param record
     * @return
     */
    int insert(Order record);

    /**
     * 添加，判空
     * @param record
     * @return
     */
    int insertSelective(Order record);


    /**
     * 根据id查询
     * @param id
     * @return
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * 修改 判空
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * 修改，不判空
     * @param record
     * @return
     */
    int updateByPrimaryKey(Order record);

    /**
     * 分页查询
     * @param map
     * @return
     */
    PageModel queryAllByPage(Map<String,Object> map) throws Exception;
}
