package com.resale.background.service;

import javax.servlet.http.HttpServletRequest;

import com.resale.background.util.ReturnMsgData;

public interface LoginService {
	
	/**
	 * 根据登陆账号查询用户信息
	 * @param userAccount
	 * @param userPassword
	 * @param yzm
	 * @param request 
	 * @return
	 */
	public ReturnMsgData getInfoByMerchantCode(String merchantCode, String userPassword, String yzm, HttpServletRequest request);	/**
	
	 * 删除redis中的图片验证码
	 * @param key
	 */
	public void deleteImageVerificationCode(String key);
	/**
	 * 将图片验证码存入redis
	 */
	public void setImageVerificationCode(String key, String value);


	
}
