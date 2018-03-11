package com.resale.background.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resale.background.pojo.Menu;
import com.resale.background.service.MenuService;
import com.resale.background.util.DataMsg;
import com.resale.background.util.PageModel;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	
	
	/**
	 * 根据商户id获取菜单
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/getMenuByMerchantId")
	public String getMenuByMerchantId(Model model,@RequestParam(value="uid")Integer id){
		List<Menu>menuList=menuService.getMenuByMerchantId(id);
		model.addAttribute("mlist",menuList);
		return "forward:/index.jsp";
	}
	

	/**
	 * 跳转到菜单列表页面
	 * @return
	 */
	@RequestMapping("/goMenuPage")
	public String goMenuPage(){
		return "menu";
	}
	
	
	/**
	 * 分页查询所有
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMenuList")
	public DataMsg getMenuList(HttpServletRequest request,DataMsg dataMsg){
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("pageNumber")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("pageSize")));
			PageModel pageModel =menuService.getMenuList(paramsCondition);
			dataMsg.setTotal(pageModel.getTotalRecords());
			dataMsg.setRows(pageModel.getList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataMsg;
	}
	
	
	
}
