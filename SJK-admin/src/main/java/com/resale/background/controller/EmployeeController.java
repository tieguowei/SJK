package com.resale.background.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resale.background.pojo.Employee;
import com.resale.background.pojo.Role;
import com.resale.background.service.EmployeeService;
import com.resale.background.util.DataMsg;
import com.resale.background.util.PageModel;
import com.resale.util.StringUtil;
import com.resale.util.UUIDUtil;


/**
 *<dl>
 *<dt>类名：EmployeeController.java</dt>
 *<dd>描述:员工管理逻辑实现</dd> 
 *<dd>创建时间： 2018年8月6日 下午5:33:38</dd>
 *<dd>创建人： TieGuowei </dd>
 *<dt>版本历史: </dt>
 * <pre>
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2018年8月6日 下午5:33:38    TieGuowei       1.0        1.0 Version 
 * </pre>
 *</dl>
 */
@Controller
@RequestMapping("/employee")
public class  EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
    private Logger logger = LoggerFactory.getLogger(this.getClass());

	   /**
		 * 跳转到员工列表页面
		 * @return
		 */
		@RequiresPermissions("employeeManager:list")//权限管理;
		@RequestMapping("/goEmployeePage")
		public String goEmployeePage(){
			logger.info("===测试docker日志 =====");
			return "system/employee/employeeList";
		}
		
		/**
		 * 分页查询所有员工
		 * @param request
		 * @param dataMsg
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/getEmployeeList")
		public DataMsg getEmployeeList(HttpServletRequest request,DataMsg dataMsg){
			try {
				Map<String, Object> paramsCondition = new HashMap<String, Object>();
				Subject subject = SecurityUtils.getSubject();
				Employee employee = (Employee) subject.getPrincipal();
				
				String employeeNo = StringUtil.trim(request.getParameter("employeeNo"));
				if (StringUtil.isNotBlank(employeeNo)) {
					paramsCondition.put("employeeNo", employeeNo);
				}else if(!"admin".equals(employee.getEmployeeNo())){
					paramsCondition.put("employeeNo", employee.getEmployeeNo());
				}
				String employeeName =  StringUtil.trim(request.getParameter("employeeName"));
				if (StringUtil.isNotBlank(employeeName)) {
					paramsCondition.put("employeeName", employeeName);
				}
				paramsCondition.put("pageNo", Integer.valueOf(request.getParameter("pageNumber")));
				paramsCondition.put("pageSize", Integer.valueOf(request.getParameter("pageSize")));
				PageModel pageModel =employeeService.getEmployeeList(paramsCondition);
				dataMsg.setTotal(pageModel.getTotalRecords());
				dataMsg.setRows(pageModel.getList());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dataMsg;
		}
		
		/**
		 * 查询员工拥有的角色
		 * @param id
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/getRole")
		public Map<String,Object> getRole(@RequestParam("employeeId")int employeeId){
			List<Role>rlist=employeeService.getRoleList();
			List<Integer> employeeRoleList=employeeService.getRoleByEmployeeId(employeeId);
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("role", rlist);
			map.put("userRole", employeeRoleList);
			return map;
		}
		
		/**
		 * 校验商户原始密码是否正确
		 * @return
		 */
		@RequestMapping("/checkOldPwd")
		@ResponseBody
		public boolean checkOldPwd(@RequestParam("employeeId")int employeeId,@RequestParam("oldPwd") String oldPwd){
			try {
				Employee employee = employeeService.getEmployeeById(employeeId);
				
				String newPs = new SimpleHash("MD5", oldPwd, employee.getEmployeeNo()+employee.getSalt(), 2).toHex();
				return  employeeService.checkOldPwd(employeeId,oldPwd,newPs);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		
		/**
		 * 修改员工密码
		 * @return
		 */
		@RequestMapping("/updatePwd")
		@ResponseBody
		public boolean updatePwd(@RequestParam("employeeId")int employeeId,@RequestParam("newPwd") String newPwd){
			try {
				Employee employee = employeeService.getEmployeeById(employeeId);
				String newPs = new SimpleHash("MD5", newPwd, employee.getEmployeeNo()+employee.getSalt(), 2).toHex();
				employeeService.updatePwd(employeeId,newPwd,newPs);
				 return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		/**
		 * 修改员工角色
		 * @param merchantId
		 * @param rids
		 * @return
		 */
		@RequiresPermissions("employeeManager:updateRole")//权限管理;
		@ResponseBody
		@RequestMapping("/updateEmployeeRole")
		public boolean updateEmployeeRole(@RequestParam("employeeId")int employeeId,@RequestParam("rid")String rids){
			try {
				employeeService.updateEmployeeRole(employeeId, rids);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		/**
		 * 添加员工
		 * @return
		 */
		@RequiresPermissions("employeeManager:add")//权限管理;
		@RequestMapping("/saveEmployee")
		@ResponseBody
		public boolean saveEmployee(Employee employee ,@RequestParam("entryDate")String entryDate){
			try {
				
				String uuid = UUIDUtil.getUUID();
			    String newPs = new SimpleHash("MD5", employee.getPassword(), employee.getEmployeeNo()+uuid, 2).toHex();
			    Subject subject = SecurityUtils.getSubject();
				Employee employeeShiro = (Employee) subject.getPrincipal();
				DateFormat date = new SimpleDateFormat("yyyy-MM-dd"); 
				employee.setEntryTime(date.parse(entryDate));    
				employee.setOperator(employeeShiro.getEmployeeId());
				
				employeeService.saveEmployee(employee,newPs,uuid);
				 return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		/**
		 * 修改员工 回显
		 * @return
		 */
		@RequestMapping("/getEmployeeById")
		@ResponseBody
		public Map<String,Object> getEmployeeById(@RequestParam("employeeId")int employeeId){
			try {
				Map<String,Object>map=new HashMap<String, Object>();
				 Employee employee = employeeService.getEmployeeById(employeeId);
				 map.put("employee", employee);
				 return map;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		/**
		 * 修改员工信息
		 * @return
		 */
		@RequiresPermissions("employeeManager:update")//权限管理;
		@RequestMapping("/updateEmployee")
		@ResponseBody
		public boolean updateEmployee(Employee employee,@RequestParam("entryDate")String entryDate){
			try {
				Employee result =employeeService.getEmployeeById(employee.getEmployeeId());
				String newPs = new SimpleHash("MD5", "123456", result.getEmployeeNo()+result.getSalt(), 2).toHex();
				DateFormat date = new SimpleDateFormat("yyyy-MM-dd"); 
				employee.setEntryTime(date.parse(entryDate));   
				employeeService.updateEmployee(employee,newPs);
				 return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		
		/**
		 * 更改员工状态（1：启用 2：删除 3：禁用）
		 * @param merchant
		 * @return
		 */
		@RequiresPermissions("employeeManager:delete")//权限管理;
		@ResponseBody
		@RequestMapping("/deleteEmployee")
		public boolean deleteEmployee(Employee employee,@RequestParam("activatedState")String activatedState){ 
			try {
				employeeService.deleteEmployee(employee,activatedState);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			
		}
}
