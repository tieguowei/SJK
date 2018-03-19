package com.resale.background.service;

import java.util.Map;

import com.resale.background.pojo.Menu;
import com.resale.background.pojo.Role;
import com.resale.background.util.PageModel;

public interface RoleService {
	/**
	 * 分页查询所有角色
	 * @param paramsCondition
	 * @return
	 */
	PageModel getRoleList(Map<String, Object> paramsCondition);
	/**
	 * 根据角色编码校验是否有重复
	 * @param trim
	 * @return
	 */
	Role checkRoleCodeIsRepeat(String roleCode);
	/**
	 * 添加角色
	 */
	void saveRole(Role role);
	/**
	 * 修改回显
	 * @param id
	 * @return
	 */
	Role quertRoleById(int id);
	/**
	 * 修改角色
	 * @param role
	 */
	void updateRole(Role role);
	/**
	 * 删除菜单
	 * @param role
	 */
	void deleteRole(Role role);

}
