package com.resale.background.service.impl;

import java.util.ArrayList;
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

import com.resale.background.mapper.MenuMapper;
import com.resale.background.mapper.RoleMapper;
import com.resale.background.mapper.RoleMenuRelationMapper;
import com.resale.background.pojo.Menu;
import com.resale.background.pojo.Merchant;
import com.resale.background.pojo.Role;
import com.resale.background.pojo.RoleMenuRelation;
import com.resale.background.service.RoleService;
import com.resale.background.util.PageModel;
import com.resale.background.util.Trees;
import com.resale.background.util.ViewTree;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleMenuRelationMapper  roleMenuRelationMapper;
	@Autowired
	private MenuMapper menuMapper;
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


	@Override
	public List<ViewTree> getViewTree(int rid) {
		List<ViewTree>tree=new ArrayList<ViewTree>();
		//根据角色 查询出所拥有的菜单用于回显
		List<Integer>list=roleMenuRelationMapper.queryMenuIdListByRoleId(rid);
		//查询出所有的父级菜单
		List<Map<String, Object>> plist = menuMapper.getParentMenuList();//父菜单
		for (Map<String, Object> map : plist) {
			ViewTree parent=new ViewTree();
			parent.setId(Integer.valueOf(String.valueOf(map.get("menuId"))));
			parent.setPid(Integer.valueOf(String.valueOf(map.get("parent_id"))));
			parent.setText(String.valueOf(map.get("menuName")));
			parent.setIcon(String.valueOf(map.get("menu_icon")));
			
			//回显 父节点
			for(Integer k:list){
				if(map.get("menuId").equals(k)){
					Trees t=new Trees();
					t.setChecked(true);
					parent.setState(t);
					}
			}
			
			//根据父id查询子菜单
			List<ViewTree>childList=new ArrayList<ViewTree>();
			List<Menu>clist=menuMapper.queryChildMenuByPid(String.valueOf(map.get("menuId")));//子菜单
			for (Menu c : clist) {
				ViewTree child=new ViewTree();
				child.setId(c.getMenuId());
				child.setPid(c.getParentId());
				child.setText(c.getNameZh());
				child.setIcon(c.getMenuIcon());
				
				for(Integer k:list){
					if(c.getMenuId().equals(k)){
						Trees tt=new Trees();
						tt.setChecked(true);
						child.setState(tt);
						}
				}
				
				childList.add(child);
			}
			if(childList.size()>=1){
				parent.setNodes(childList);
			}
			tree.add(parent);
		}
		return tree;
	}

	


}
