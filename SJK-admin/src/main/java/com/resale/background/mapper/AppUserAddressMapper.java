package com.resale.background.mapper;

import com.resale.background.pojo.AppUserAddress;
import com.resale.background.pojo.AppUserAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppUserAddressMapper {
    int countByExample(AppUserAddressExample example);

    int deleteByExample(AppUserAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppUserAddress record);

    int insertSelective(AppUserAddress record);

    List<AppUserAddress> selectByExample(AppUserAddressExample example);

    AppUserAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppUserAddress record, @Param("example") AppUserAddressExample example);

    int updateByExample(@Param("record") AppUserAddress record, @Param("example") AppUserAddressExample example);

    int updateByPrimaryKeySelective(AppUserAddress record);

    int updateByPrimaryKey(AppUserAddress record);
}