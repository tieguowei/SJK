package com.resale.background.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resale.background.pojo.Role;
import com.resale.background.service.RoleService;
import com.resale.background.util.DataMsg;
import com.resale.background.util.PageModel;
import com.resale.util.StringUtil;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	

	/**
	 * 跳转到角色列表页面
	 * @return
	 */
	@RequiresPermissions("roleManager:list")//权限管理;
	@RequestMapping("/goRolePage")
	public String goRolePage(){
		return "role";
	}
	
	/**
	 * 分页查询所有角色
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getRoleList")
	public DataMsg getRoleList(HttpServletRequest request,DataMsg dataMsg){
		try {
			Map<String, Object> paramsCondition = new HashMap<String, Object>();
			paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("pageNumber")));
			paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("pageSize")));
			PageModel pageModel =roleService.getRoleList(paramsCondition);
			dataMsg.setTotal(pageModel.getTotalRecords());
			dataMsg.setRows(pageModel.getList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataMsg;
	}
	
	
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	@RequiresPermissions("roleManager:add")
	@ResponseBody
	@RequestMapping("/saveRole")
	public String saveRole(Role role){
		try {
			//根据角色编码校验是否有重复
			Role result = roleService.checkRoleCodeIsRepeat(StringUtil.trim(role.getRoleCode()));
			if(result != null){
				return "0";
			}else{
				roleService.saveRole(role);
				return "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "2";
		}
		
	}
	
	
	
	/**
	 * 修改回显
	 */
	
	@ResponseBody
	@RequestMapping("/getRoleById")
	public Map<String,Object> getRoleById(@RequestParam("rid")int id,Model model){
		try {
			Map<String,Object>map=new HashMap<String, Object>();
			Role role=roleService.quertRoleById(id);
			map.put("role", role);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	@RequiresPermissions("roleManager:update")
	@ResponseBody
	@RequestMapping("/updateRole")
	public String updateRole(Role role){
		try {
			//根据角色编码校验是否有重复
			Role result = roleService.checkRoleCodeIsRepeat(StringUtil.trim(role.getRoleCode()));
			if(result != null){
				return "0";
			}else{
				roleService.updateRole(role);
				return "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "2";
		}
		
	}
	
	
	/**
	 * 删除菜单
	 * @param role
	 * @return
	 */
	@RequiresPermissions("roleManager:delete")
	@ResponseBody
	@RequestMapping("/deleteRole")
	public boolean deleteRole(Role role){
		try {
			roleService.deleteRole(role);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
}
