package com.resale.background.service;

import java.util.List;

import com.resale.background.pojo.Menu;
import com.resale.background.util.ReturnMsgData;

public interface LoginService {
	//查询用户拥有的菜单
	public List<Menu>getMenuByUserId(int id);
	
	/**
	 * 根据登陆账号查询用户信息
	 * @param userAccount
	 * @param userPassword
	 * @param yzm
	 * @return
	 */
	public ReturnMsgData getInfoByMerchantName(String merchantName, String userPassword, String yzm);	/**
	
	 * 删除redis中的图片验证码
	 * @param key
	 */
	public void deleteImageVerificationCode(String key);
	/**
	 * 将图片验证码存入redis
	 */
	public void setImageVerificationCode(String key, String value);

	
}
