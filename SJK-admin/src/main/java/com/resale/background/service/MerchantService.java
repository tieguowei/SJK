package com.resale.background.service;

import java.util.List;
import java.util.Map;

import com.resale.background.pojo.Merchant;
import com.resale.background.pojo.MerchantRoleRelation;
import com.resale.background.pojo.Role;
import com.resale.background.util.PageModel;

public interface MerchantService {
	/**
	 * 校验商户原始密码是否正确
	 * @return
	 */
	boolean checkOldPwd(int id, String oldPwd);
	/**
	 * 修改商户密码
	 * @return
	 */
	void updatePwd(int id, String newPwd);
	/**
	 * 查询所有商户
	 * @param paramsCondition
	 * @return
	 */
	PageModel getMerchantList(Map<String, Object> paramsCondition);
	/**
	 * 查询所有角色
	 * @return
	 */
	List<Role> getRoleList();
	
	/**查询商户所属角色
	 */
	List<Integer> getMerchantRoleById(int id);
	/**
	 * 修改商户角色
	 * @param merchantId
	 * @param rids
	 */
	void updateMerchantRole(int merchantId, String rids);
	/**
	 * 添加商户管理员
	 * @param merchant
	 */
	void saveMerchant(Merchant merchant);

}
