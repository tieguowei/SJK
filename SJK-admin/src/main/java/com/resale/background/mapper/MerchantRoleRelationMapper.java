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

    /**
     * 根据商户id 查询所属角色
     * @param id
     * @return
     */
	List<Integer> getMerchantRoleById(int id);

	/**
	 * 根据商户id删除原有的角色id
	 * @param merchantId
	 */
	void deleteRoleIdByMerchantId(int merchantId);

	/**
	 * 为商户添加角色
	 * @param list
	 */

	void insertRoleIds(List<MerchantRoleRelation> list);
}