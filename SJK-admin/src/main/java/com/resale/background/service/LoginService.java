package com.resale.background.service;

import java.util.List;

import com.resale.background.pojo.Menu;
import com.resale.background.pojo.Merchant;
import com.resale.background.pojo.Role;

public interface LoginService {
	
	/**
	 * 根据登陆账号查询用户信息
	 * @param userAccount
	 * @param userPassword
	 * @param yzm
	 * @param request 
	 * @return
	 */
	public Merchant getInfoByMerchantCode(String merchantCode);	
	
	/**
	 * 删除redis中的图片验证码
	 * @param key
	 */
	public void deleteImageVerificationCode(String key);
	/**
	 * 将图片验证码存入redis
	 */
	public void setImageVerificationCode(String key, String value);

	/**
	 * 根据商户id查询角色信息
	 * @param id
	 * @return
	 */
	public List<Role> findRoleByMerchantId(Integer id);

	/**
	 * 根据商户角色id 查询权限
	 * @param id
	 * @return
	 */
	public List<Menu> permissionListRoleId(Integer id);


	
}
