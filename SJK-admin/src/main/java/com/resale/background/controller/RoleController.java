package com.resale.background.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resale.background.pojo.Employee;
import com.resale.background.pojo.Role;
import com.resale.background.service.RoleService;
import com.resale.background.util.DataMsg;
import com.resale.background.util.PageModel;
import com.resale.background.util.TreeView;
import com.resale.util.StringUtil;


/**
 *<dl>
 *<dt>类名：RoleController.java</dt>
 *<dd>描述: 角色管理逻辑实现</dd> 
 *<dd>创建时间： 2018年8月14日 上午11:36:02</dd>
 *<dd>创建人： TieGuowei </dd>
 *<dt>版本历史: </dt>
 * <pre>
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2018年8月14日 上午11:36:02    TieGuowei       1.0        1.0 Version 
 * </pre>
 *</dl>
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
	private RoleService roleService;

	/**
	 * 跳转到角色列表页面
	 * @return
	 */
	@RequiresPermissions("roleManager:list")//权限管理;
	@RequestMapping("/goRolePage")
	public String goRolePage(){
		return "system/role/roleList";
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
	public boolean saveRole(Role role){
		try {
			Subject subject = SecurityUtils.getSubject();
			Employee employee = (Employee) subject.getPrincipal();
		    int employeeId= employee.getEmployeeId();
			roleService.saveRole(role,employeeId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * 校验角色编码是否存在
	 * @param menu
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkRoleCode")
	public boolean checkRoleCode(HttpServletRequest request){
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			String roleCode = StringUtil.trim(request.getParameter("roleCode"));
			if (StringUtil.isNotBlank(roleCode)) {
				map.put("roleCode", roleCode);
			}
			String id = StringUtil.trim(request.getParameter("id"));
			if (StringUtil.isNotBlank(id)) {
				map.put("id", id);
			}
			Role result = roleService.checkRoleCodeIsRepeat(map);
			if(result == null){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
	public boolean updateRole(Role role){
		try {
			Subject subject = SecurityUtils.getSubject();
			Employee employee = (Employee) subject.getPrincipal();
		    int employeeId= employee.getEmployeeId();
			roleService.updateRole(role,employeeId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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
			Subject subject = SecurityUtils.getSubject();
			Employee employee = (Employee) subject.getPrincipal();
		    int employeeId= employee.getEmployeeId();
			roleService.deleteRole(role,employeeId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * 加载权限菜单
	 * @param rid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/viewTree")
	public List<TreeView> getRoleTree(@RequestParam("rid")int rid){
		try {
			return roleService.getViewTree(rid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 修改角色权限
	 */
	@ResponseBody
	@RequiresPermissions("roleManager:updateRoleAuth")
	@RequestMapping("/updateRoleAuth")
	public boolean updateRoleAuth(@RequestParam("rid")int rid,@RequestParam("menuIds")String menuIds){
			try {
				Subject subject = SecurityUtils.getSubject();
				Employee employee = (Employee) subject.getPrincipal();
			    int employeeId= employee.getEmployeeId();
				roleService.updateRoleAuth(rid, menuIds,employeeId);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	
}
