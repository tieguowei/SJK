package com.resale.background.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.resale.background.config.RedisClient;
import com.resale.background.config.RedisConfiguration;
import com.resale.background.constants.Constants;
import com.resale.background.constants.RedisConstant;
import com.resale.background.mapper.MerchantMapper;
import com.resale.background.pojo.Menu;
import com.resale.background.pojo.Merchant;
import com.resale.background.service.LoginService;
import com.resale.background.util.ReturnMsgData;
import com.resale.util.MD5Util;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private MerchantMapper merchantMapper;
	@Autowired
	private RedisClient redisClinet;
	
	
	protected final Log logger = LogFactory.getLog(getClass());


	/**
	 * 根据用户登陆账号查询用户信息
	 */
	@Override
	public ReturnMsgData getInfoByMerchantCode(String merchantCode, String password, String yzm) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("merchantCode", merchantCode);
		Merchant merchant = merchantMapper.getInfoByMerchantCode(map);
		if(merchant!=null){
			String md5Pwd = MD5Util.md5(merchant.getPassword()+Constants.MD5KEY);
			if(md5Pwd.equals(password)){
				if(yzm.equalsIgnoreCase(redisClinet.get(Constants.CHECK_CODE))){
					return new ReturnMsgData("1005",merchant.getId().toString());//登陆成功
				}else{
					return new ReturnMsgData("1006", "验证码有误");
				}
				/*request.getSession().setAttribute("USER", userBean);
				request.getSession().setAttribute("NAME", userBean.getUserName());
				request.getSession().setAttribute("ACCOUNT", userBean.getUserAccount());
				request.getSession().setAttribute("PASS", userBean.getUserPassword());
				request.getSession().setAttribute("ID", userBean.getUserId());*/
			}else{
				return new ReturnMsgData("1004", "账号或密码错误");//密码错误
			}
		}else{
			return new ReturnMsgData("1003", "账号或密码错误");//账号不存在
		}
	}
	
	

	
	@Override
	public void deleteImageVerificationCode(String key) {
		redisClinet.delete(key);
	}

	@Override
	public void setImageVerificationCode(String key, String value) {
		redisClinet.set(key, value);
		redisClinet.expire(key, RedisConstant.REDIS_TOKEN_BACKGROUND_YZM);
	}

	
}
