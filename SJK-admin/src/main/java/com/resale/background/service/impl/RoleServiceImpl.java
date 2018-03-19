package com.resale.background.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resale.background.mapper.RoleMapper;
import com.resale.background.pojo.Merchant;
import com.resale.background.pojo.Role;
import com.resale.background.service.RoleService;
import com.resale.background.util.PageModel;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	protected final Log logger = LogFactory.getLog(getClass());

	
	@Override
	public PageModel getRoleList(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = roleMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = roleMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}


	@Override
	public Role checkRoleCodeIsRepeat(String roleCode) {
		return roleMapper.checkRoleCodeIsRepeat(roleCode);
	}


	@Override
	public void saveRole(Role role) {
		//从shiro中获取商户信息
		Subject subject = SecurityUtils.getSubject();
		Merchant merchant = (Merchant) subject.getPrincipal();
		role.setCreatorId(merchant.getId());
		role.setUpdateTime(new Date());
		role.setCreateTime(new Date());
		role.setRoleStatus("1");
		roleMapper.insert(role);
	}


	@Override
	public Role quertRoleById(int id) {
		return roleMapper.selectByPrimaryKey(id);
	}


	@Override
	public void updateRole(Role updateRole) {
		//查询出要修改的角色
		Role role = roleMapper.selectByPrimaryKey(updateRole.getId());
		
		Subject subject = SecurityUtils.getSubject();
		Merchant merchant = (Merchant) subject.getPrincipal();
		updateRole.setCreatorId(merchant.getId());
		updateRole.setUpdateTime(new Date());
		updateRole.setRoleStatus("1");
		
		//以下是未修改的字段
		updateRole.setCreateTime(role.getCreateTime());
		roleMapper.updateByPrimaryKey(updateRole);
	}


	@Override
	public void deleteRole(Role role) {
		Subject subject = SecurityUtils.getSubject();
		Merchant merchant = (Merchant) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", role.getId());
		map.put("creatorId", merchant.getId());
		map.put("updateTime", new Date());
		map.put("roleStatus", "2");
		roleMapper.deleteRoleById(map);
	}


}
