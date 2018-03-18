package com.resale.background.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resale.background.service.MerchantService;

@Controller
@RequestMapping("/merchant")
public class  MerchantController {

	@Autowired
	private MerchantService merchantService;
	
	/**
	 * 校验商户原始密码是否正确
	 * @return
	 */
	@RequestMapping("/checkOldPwd")
	@ResponseBody
	public boolean checkOldPwd(@RequestParam("id")int id,@RequestParam("oldPwd") String oldPwd){
		try {
			return  merchantService.checkOldPwd(id,oldPwd);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 修改商户密码
	 * @return
	 */
	@RequestMapping("/updatePwd")
	@ResponseBody
	public boolean updatePwd(@RequestParam("id")int id,@RequestParam("newPwd") String newPwd){
		try {
			 merchantService.updatePwd(id,newPwd);
			 return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
