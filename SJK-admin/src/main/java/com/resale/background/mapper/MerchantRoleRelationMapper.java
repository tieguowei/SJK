package com.resale.background.mapper;

import com.resale.background.pojo.MerchantRoleRelation;
import com.resale.background.pojo.MerchantRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantRoleRelationMapper {
    int countByExample(MerchantRoleRelationExample example);

    int deleteByExample(MerchantRoleRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MerchantRoleRelation record);

    int insertSelective(MerchantRoleRelation record);

    List<MerchantRoleRelation> selectByExample(MerchantRoleRelationExample example);

    MerchantRoleRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MerchantRoleRelation record, @Param("example") MerchantRoleRelationExample example);

    int updateByExample(@Param("record") MerchantRoleRelation record, @Param("example") MerchantRoleRelationExample example);

    int updateByPrimaryKeySelective(MerchantRoleRelation record);

    int updateByPrimaryKey(MerchantRoleRelation record);
}