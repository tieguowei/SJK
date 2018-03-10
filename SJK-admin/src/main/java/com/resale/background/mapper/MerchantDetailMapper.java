package com.resale.background.mapper;

import com.resale.background.pojo.MerchantDetail;
import com.resale.background.pojo.MerchantDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchantDetailMapper {
    int countByExample(MerchantDetailExample example);

    int deleteByExample(MerchantDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MerchantDetail record);

    int insertSelective(MerchantDetail record);

    List<MerchantDetail> selectByExample(MerchantDetailExample example);

    MerchantDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MerchantDetail record, @Param("example") MerchantDetailExample example);

    int updateByExample(@Param("record") MerchantDetail record, @Param("example") MerchantDetailExample example);

    int updateByPrimaryKeySelective(MerchantDetail record);

    int updateByPrimaryKey(MerchantDetail record);
}