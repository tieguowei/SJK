package com.resale.background.mapper;

import com.resale.background.pojo.Headline;
import com.resale.background.pojo.HeadlineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HeadlineMapper {
    int countByExample(HeadlineExample example);

    int deleteByExample(HeadlineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Headline record);

    int insertSelective(Headline record);

    List<Headline> selectByExampleWithBLOBs(HeadlineExample example);

    List<Headline> selectByExample(HeadlineExample example);

    Headline selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Headline record, @Param("example") HeadlineExample example);

    int updateByExampleWithBLOBs(@Param("record") Headline record, @Param("example") HeadlineExample example);

    int updateByExample(@Param("record") Headline record, @Param("example") HeadlineExample example);

    int updateByPrimaryKeySelective(Headline record);

    int updateByPrimaryKeyWithBLOBs(Headline record);

    int updateByPrimaryKey(Headline record);
}