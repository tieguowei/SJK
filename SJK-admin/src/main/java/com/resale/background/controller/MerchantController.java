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

import com.resale.background.pojo.Merchant;
import com.resale.background.pojo.Role;
import com.resale.background.service.MerchantService;
import com.resale.background.util.DataMsg;
import com.resale.background.util.PageModel;
import com.resale.util.StringUtil;

/**
 * 商户管理
 * @author tie
 *
 */
@Controller
@RequestMapping("/merchant")
public class  MerchantController {

	@Autowired
	private MerchantService merchantService;
	
	/**
	 * 跳转到商户列表页面
	 * @return
	 */
	@RequiresPermissions("merchantManager:list")//权限管理;
	@RequestMapping("/goMerchantPage")
	public String goMerchantPage(){
		return "merchant";
	}
	
	
	/**
	 * 分页查询所有商户
	 * @param request
	 * @param dataMsg
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMerchantList")
	public DataMsg getMerchantList(HttpServletRequest request,DataMsg dataMsg){
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			Subject subject = SecurityUtils.getSubject();
			Merchant merchant = (Merchant) subject.getPrincipal();
			String merchantCode = request.getParameter("merchantCode");
			if (StringUtil.isNotBlank(merchantCode)) {
				paramsCondition.put("merchantCode", merchantCode);
			}else if(!"admin".equals(merchant.getMerchantCode())){
				paramsCondition.put("merchantCode", merchant.getMerchantCode());
			}
			String merchantName = request.getParameter("merchantName");
			if (StringUtil.isNotBlank(merchantName)) {
				paramsCondition.put("merchantName", merchantName);
			}
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("pageNumber")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("pageSize")));
			PageModel pageModel =merchantService.getMerchantList(paramsCondition);
			dataMsg.setTotal(pageModel.getTotalRecords());
			dataMsg.setRows(pageModel.getList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataMsg;
	}
	
	
	/**
	 * 查询商户拥有的角色
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getRole")
	public Map<String,Object> getRole(@RequestParam("id")int id){
		List<Role>rlist=merchantService.getRoleList();
		List<Integer> merchantRoleList=merchantService.getMerchantRoleById(id);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("role", rlist);
		map.put("userRole", merchantRoleList);
		return map;
	}
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
	

	/**
	 * 修改商户角色
	 * @param merchantId
	 * @param rids
	 * @return
	 */
	@RequiresPermissions("merchantManager:updateRole")//权限管理;
	@ResponseBody
	@RequestMapping("/updateMerchantRole")
	public boolean updateMerchantRole(@RequestParam("merchantId")int merchantId,@RequestParam("rid")String rids){
		try {
			
			merchantService.updateMerchantRole(merchantId, rids);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * 添加管理员
	 * @return
	 */
	@RequiresPermissions("merchantManager:add")//权限管理;
	@RequestMapping("/saveMerchant")
	@ResponseBody
	public boolean saveMerchant(Merchant merchant){
		try {
			 merchantService.saveMerchant(merchant);
			 return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 修改商户 回显
	 * @return
	 */
	@RequestMapping("/getMerchantById")
	@ResponseBody
	public Map<String,Object> getMerchantById(@RequestParam("id")int id){
		try {
			Map<String,Object>map=new HashMap<String, Object>();
			 Merchant merchant = merchantService.getMerchantById(id);
			 map.put("merchant", merchant);
			 return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

	/**
	 * 修改管理员
	 * @return
	 */
	@RequiresPermissions("merchantManager:update")//权限管理;
	@RequestMapping("/updateMerchant")
	@ResponseBody
	public boolean updateMerchant(Merchant merchant){
		try {
			 merchantService.updateMerchant(merchant);
			 return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * 删除商户
	 * @param merchant
	 * @return
	 */
	@RequiresPermissions("merchantManager:delete")//权限管理;
	@ResponseBody
	@RequestMapping("/deleteMerchant")
	public boolean deleteMerchant(Merchant merchant){
		try {
			merchantService.deleteMerchant(merchant);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}


    /**
     *我得地盘>商户信息
     * @return
     */
    @RequestMapping("/goMerchantListPage")
    public String goMerchantListPage(){
        return "merchantList";
    }


}
