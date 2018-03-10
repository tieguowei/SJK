package com.resale.background.mapper;

import com.resale.background.pojo.Commission;
import com.resale.background.pojo.CommissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommissionMapper {
    int countByExample(CommissionExample example);

    int deleteByExample(CommissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Commission record);

    int insertSelective(Commission record);

    List<Commission> selectByExample(CommissionExample example);

    Commission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Commission record, @Param("example") CommissionExample example);

    int updateByExample(@Param("record") Commission record, @Param("example") CommissionExample example);

    int updateByPrimaryKeySelective(Commission record);

    int updateByPrimaryKey(Commission record);
}