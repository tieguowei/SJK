package com.resale.background.service;

import java.util.List;
import java.util.Map;

import com.resale.background.pojo.Department;
import com.resale.background.util.TreeView;


public interface DeptService {


	/**
	 * 查询所有部门
	 * @return
	 */

	public List<Map<String, Object>> getDeptList();

	/**
	 * 新增部门
	 * @param department
	 * @return
	 */
	public void saveDepartment(Department department);
	
	public List<TreeView> getDeptTree();
	
	 public Department getDepartmentById(int did);
	 public void updateDepartment(Department department);


}
