package com.resale.background.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resale.background.mapper.EmployeeMapper;
import com.resale.background.mapper.EmployeeRoleRelationMapper;
import com.resale.background.mapper.RoleMapper;
import com.resale.background.pojo.Employee;
import com.resale.background.pojo.EmployeeRoleRelation;
import com.resale.background.pojo.Role;
import com.resale.background.service.EmployeeService;
import com.resale.background.util.PageModel;
@Service
public class EmployeeServiceImpl implements EmployeeService {


	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private  EmployeeRoleRelationMapper employeeRoleRelationMapper;
	
	@Override
	public PageModel getEmployeeList(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer)paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer)paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = employeeMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = employeeMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}
	
	@Override
	public boolean checkOldPwd(int employeeId, String oldPwd,String newPs) {
		//根据id查出员工信息
		Employee employee = employeeMapper.selectByPrimaryKey(employeeId);
		 if(employee.getPassword().equals(newPs)){
			 return true;
		 }
		 return false;
	}

	@Override
	public void updatePwd(int employeeId, String newPwd,String newPs) {
		Employee employee = employeeMapper.selectByPrimaryKey(employeeId);
		employee.setUpdateTime(new Date());
	    employee.setPassword(newPs);
	    employeeMapper.updateByPrimaryKeySelective(employee);
	}

	@Override
	public List<Role> getRoleList() {
		return roleMapper.getRoleList();
	}

	@Override
	public List<Integer> getRoleByEmployeeId(int employeeId) {
		return employeeRoleRelationMapper.getRoleByEmployeeId(employeeId);
	}
	
	
	@Transactional
	@Override
	public void updateEmployeeRole(int employeeId, String rids) {
		//根据商户id删除原有的角色id
		employeeRoleRelationMapper.deleteRoleIdByEmployeeId(employeeId);
		List<EmployeeRoleRelation>  list = new ArrayList<EmployeeRoleRelation> ();
		String[] split = rids.split(",");
		for (int i = 0; i < split.length; i++) {
			EmployeeRoleRelation relation = new EmployeeRoleRelation();
			relation.setUpdateTime(new Date());
			relation.setEmployeeId(employeeId);
			relation.setCreateTime(new Date());
			relation.setRoleId(Integer.valueOf(split[i]));
			list.add(relation);
		}
		employeeRoleRelationMapper.insertRoleIds(list);
	}

	@Override
	public void saveEmployee(Employee employee,String newPs,String uuid ) {
		employee.setCreateTime(new Date());
		employee.setUpdateTime(new Date());
		employee.setSalt(uuid);
	    employee.setPassword(newPs);
	    employee.setActivatedState("1");
	    employeeMapper.insert(employee);
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		return employeeMapper.selectByPrimaryKey(employeeId);
	}

	@Override
	public void updateEmployee(Employee employee,String newPs) {
		Employee result =employeeMapper.selectByPrimaryKey(employee.getEmployeeId());

		//密码还原
		if("1".equals(employee.getIsResetPwd())){
		    employee.setPassword(newPs);
		}else{
			employee.setPassword(result.getPassword());
		}
		employee.setUpdateTime(new Date());
		employeeMapper.updateByPrimaryKeySelective(employee);
	}

	@Override
	public void deleteEmployee(Employee employee,String activatedState) {
		Map<String,Object> map = new HashMap<String,Object>();
			map.put("employeeId", employee.getEmployeeId());
			map.put("activatedState", activatedState);
		employeeMapper.deleteEmployee(map);
	}


}
