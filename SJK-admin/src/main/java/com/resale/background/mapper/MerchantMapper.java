package com.resale.background.mapper;

import com.resale.background.pojo.Merchant;
import com.resale.background.pojo.MerchantExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MerchantMapper {
    int countByExample(MerchantExample example);

    int deleteByExample(MerchantExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    List<Merchant> selectByExample(MerchantExample example);

    Merchant selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Merchant record, @Param("example") MerchantExample example);

    int updateByExample(@Param("record") Merchant record, @Param("example") MerchantExample example);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);
    /**
	 * 根据用户登陆账号查询用户信息
	 */
	Merchant getInfoByMerchantCode(Map<String, Object> map);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);
}