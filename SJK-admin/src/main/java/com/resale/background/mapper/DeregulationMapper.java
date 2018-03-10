package com.resale.background.mapper;

import com.resale.background.pojo.Deregulation;
import com.resale.background.pojo.DeregulationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeregulationMapper {
    int countByExample(DeregulationExample example);

    int deleteByExample(DeregulationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Deregulation record);

    int insertSelective(Deregulation record);

    List<Deregulation> selectByExample(DeregulationExample example);

    Deregulation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Deregulation record, @Param("example") DeregulationExample example);

    int updateByExample(@Param("record") Deregulation record, @Param("example") DeregulationExample example);

    int updateByPrimaryKeySelective(Deregulation record);

    int updateByPrimaryKey(Deregulation record);
}