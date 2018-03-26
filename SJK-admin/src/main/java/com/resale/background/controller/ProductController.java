package com.resale.background.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.resale.background.pojo.Category;
import com.resale.background.pojo.Merchant;
import com.resale.background.pojo.Product;
import com.resale.background.service.ProductService;
import com.resale.background.util.DataMsg;
import com.resale.background.util.PageModel;
import com.resale.util.StringUtil;

/**
 * 商品管理
 * @author tie
 *
 */
@Controller
@RequestMapping("/product")
public class  ProductController {

	@Autowired
	private ProductService productService;
	
	/**
	 * 跳转到商户列表页面
	 * @return
	 */
	@RequiresPermissions("productManager:list")//权限管理;
	@RequestMapping("/goProductPage")
	public String goProductPage(){
		return "product";
	}
	
	
	/**
	 * 分页查询所有商品
	 * @param request
	 * @param dataMsg
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getProductList")
	public DataMsg getProductList(HttpServletRequest request,DataMsg dataMsg){
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			Subject subject = SecurityUtils.getSubject();
			Merchant merchant = (Merchant) subject.getPrincipal();
			String name = StringUtil.trim(request.getParameter("name"));
			if (StringUtil.isNotBlank(name)) {
				paramsCondition.put("name", name);
			}
			paramsCondition.put("merchantCode", merchant.getMerchantCode());
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("pageNumber")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("pageSize")));
			PageModel pageModel =productService.getProductList(paramsCondition);
			dataMsg.setTotal(pageModel.getTotalRecords());
			dataMsg.setRows(pageModel.getList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataMsg;
	}
	
	/**
	 * 查询商户所有的类别
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCategory")
	public Map<String,Object> getCategory(){
		Subject subject = SecurityUtils.getSubject();
		Merchant merchant = (Merchant) subject.getPrincipal();
		List<Category> clist=productService.getCategoryList(merchant.getMerchantCode());
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("category", clist);
		return map;
	}
	
	/**
	 * 添加商品
	 * @param menu
	 * @return
	 */
	@RequiresPermissions("productManager:add")
	@ResponseBody
	@RequestMapping("/saveProduct")
	public boolean saveMenu(Product product,@RequestParam(value = "uploadfile",required = false)MultipartFile fileField){
		try {
			productService.saveProduct(product,fileField);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
