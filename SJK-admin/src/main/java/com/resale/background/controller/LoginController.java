package com.resale.background.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resale.background.constants.Constants;
import com.resale.background.service.LoginService;
import com.resale.background.util.ReturnMsgData;
import com.resale.util.StringUtil;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	
	/**
	 * 用户登陆
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/doLogin")
	public ReturnMsgData doLoginByAccount(HttpServletRequest request){
		try {
			String yzm = request.getParameter(Constants.CHECK_CODE);
			String merchantCode = request.getParameter("merchant_code");
			String password = request.getParameter("password");
			if(StringUtil.isBlank(password)){
				return new ReturnMsgData("1000", "小子，请输入用户名");
			}
			if(StringUtil.isBlank(password)){
				return new ReturnMsgData("1001", "小子，请输入密码");
			}
			
			if(StringUtil.isBlank(yzm)){	
				return new ReturnMsgData("1002", "小子，请输入验证码");
			}
			ReturnMsgData returnMsgData = loginService.getInfoByMerchantCode(merchantCode,password,yzm,request);
			return returnMsgData;
		} catch (Exception e) {
			e.printStackTrace();
			return new ReturnMsgData("9999", "登陆异常");
		}
		
	}
	
	
	
	
	/**
	 * 退出登陆
	 * @param request
	 * @return
	 */
	@RequestMapping("/quit.action")
	public String quitLogin(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:/login.jsp";
	}
	
	/**
	 * 删除redis中的图片验证码
	 */
	@RequestMapping("/deleteImageVerificationCode")
	public void deleteImageVerificationCode(String key,String value){
		loginService.deleteImageVerificationCode(key);
	}
	/**
	 * 将图片验证码存入redis 
	 */
	@RequestMapping("/getImageVerificationCode")
	public void getImagevVerificationCode(String key,String value){
		loginService.setImageVerificationCode( key,value);
	}
}
