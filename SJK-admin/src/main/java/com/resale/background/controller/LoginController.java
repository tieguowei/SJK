package com.resale.background.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resale.background.constants.Constants;
import com.resale.background.pojo.Menu;
import com.resale.background.service.LoginService;
import com.resale.background.util.ReturnMsgData;

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
			String merchantName = request.getParameter("merchant_name");
			String password = request.getParameter("password");
			ReturnMsgData returnMsgData = loginService.getInfoByMerchantName(merchantName,password,yzm);
			return returnMsgData;
		} catch (Exception e) {
			e.printStackTrace();
			return new ReturnMsgData("9999", "登陆异常");
		}
		
	}
	
	/**
	 * 获取菜单
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/login.action")
	public String getMenuByUserId(HttpServletRequest request,@RequestParam(value="uid")Integer id){
		List<Menu>menuList=loginService.getMenuByUserId(id);
		request.getSession().setAttribute("mlist", menuList);
		return "forward:/index.jsp";
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
