package com.resale.background.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resale.background.pojo.Merchant;
import com.resale.background.service.CategoryService;
import com.resale.background.util.DataMsg;
import com.resale.background.util.PageModel;
import com.resale.util.StringUtil;

/**
 *	品类管理
 * @author tie
 *
 */
@Controller
@RequestMapping("/category")
public class  CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 跳转到品类列表页面
	 * @return
	 */
	@RequiresPermissions("categorytManager:list")//权限管理;
	@RequestMapping("/goCategoryPage")
	public String goCategoryPage(){
		return "category";
	} 
	
	
	/**
	 * 根据商户编页查询所属品类
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCategoryList")
	public DataMsg getMerchantList(HttpServletRequest request,DataMsg dataMsg){
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			//从shiro的session中取merchant
    		Subject subject = SecurityUtils.getSubject();
    		//取身份信息
    		Merchant merchant = (Merchant) subject.getPrincipal();
    		String merchantCode = merchant.getMerchantCode();
    		if (StringUtil.isNotBlank(merchantCode)) {
				paramsCondition.put("merchantCode", merchantCode);
			}
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("pageNumber")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("pageSize")));
			PageModel pageModel =categoryService.getCategorytList(paramsCondition);
			dataMsg.setTotal(pageModel.getTotalRecords());
			dataMsg.setRows(pageModel.getList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataMsg;
	}
	
	
	
}
