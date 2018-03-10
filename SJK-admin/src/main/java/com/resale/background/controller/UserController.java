package com.resale.background.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@RequestMapping("/goMenu.action")
	public String goMenuPage(){
		return "menu";
	}
	@RequestMapping("/goRole.action")
	public String goRolePage(){
		return "role";
	}
	@RequestMapping("/goAuth.action")
	public String goAuthPage(){
		return "auth";
	}
	@RequestMapping("/goUser.action")
	public String goUserPage(){
		return "user";
	}
	@RequestMapping("/goChar.action")
	public String goHightPage(){
		return "hight";
	}
	
}
