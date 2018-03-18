package com.resale.background.service.impl;

import java.util.Date;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resale.background.mapper.MerchantMapper;
import com.resale.background.pojo.Merchant;
import com.resale.background.service.MerchantService;
@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private MerchantMapper merchantMapper;
	
	@Override
	public boolean checkOldPwd(int id, String oldPwd) {
		//根据id从数据库查出商户信息
		Merchant merchant = merchantMapper.selectByPrimaryKey(id);
		//对获取的密码进行加密处理
	     String newPs = new SimpleHash("MD5", oldPwd, merchant.getMerchantCode()+merchant.getSalt(), 2).toHex();
		 if(merchant.getPassword().equals(newPs)){
			 return true;
		 }
		 return false;
	}

	@Override
	public void updatePwd(int id, String newPwd) {
		Merchant merchant = merchantMapper.selectByPrimaryKey(id);
		merchant.setUpdateTime(new Date());
	    String newPs = new SimpleHash("MD5", newPwd, merchant.getMerchantCode()+merchant.getSalt(), 2).toHex();
		merchant.setPassword(newPs);
		merchantMapper.updateByPrimaryKey(merchant);
	}

}
