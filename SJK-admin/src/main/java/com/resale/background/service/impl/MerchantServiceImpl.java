package com.resale.background.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resale.background.mapper.MerchantMapper;
import com.resale.background.mapper.MerchantRoleRelationMapper;
import com.resale.background.mapper.RoleMapper;
import com.resale.background.pojo.Merchant;
import com.resale.background.pojo.MerchantRoleRelation;
import com.resale.background.pojo.Role;
import com.resale.background.pojo.RoleMenuRelation;
import com.resale.background.service.MerchantService;
import com.resale.background.util.PageModel;
import com.resale.util.UUIDUtil;
@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private MerchantMapper merchantMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private MerchantRoleRelationMapper merchantRoleRelationMapper;
	
	@Override
	public boolean checkOldPwd(int id, String oldPwd) {
		//根据id从数据库查出商户信息
		Merchant merchant = merchantMapper.selectByPrimaryKey(id);
		//对获取的密码进行加密处理
	     String newPs = new SimpleHash("MD5", oldPwd, merchant.getMerchantCode()+merchant.getSalt(), 2).toHex();
		 if(merchant.getPassword().equals(newPs)){
			 return true;
		 }
		 return false;
	}

	@Override
	public void updatePwd(int id, String newPwd) {
		Merchant merchant = merchantMapper.selectByPrimaryKey(id);
		merchant.setUpdateTime(new Date());
	    String newPs = new SimpleHash("MD5", newPwd, merchant.getMerchantCode()+merchant.getSalt(), 2).toHex();
		merchant.setPassword(newPs);
		merchantMapper.updateByPrimaryKey(merchant);
	}

	@Override
	public PageModel getMerchantList(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = merchantMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = merchantMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

	@Override
	public List<Role> getRoleList() {
		return roleMapper.getRoleList();
	}

	@Override
	public List<Integer> getMerchantRoleById(int id) {
		return merchantRoleRelationMapper.getMerchantRoleById(id);
	}
	@Transactional
	@Override
	public void updateMerchantRole(int merchantId, String rids) {
		//根据商户id删除原有的角色id
		merchantRoleRelationMapper.deleteRoleIdByMerchantId(merchantId);
		List<MerchantRoleRelation>  list = new ArrayList<MerchantRoleRelation> ();
		String[] split = rids.split(",");
		for (int i = 0; i < split.length; i++) {
			MerchantRoleRelation relation = new MerchantRoleRelation();
			relation.setUpdateTime(new Date());
			relation.setMerchantId(merchantId);
			relation.setCreateTime(new Date());
			relation.setRoleId(Integer.valueOf(split[i]));
			list.add(relation);
		}
		merchantRoleRelationMapper.insertRoleIds(list);
	}

	@Override
	public void saveMerchant(Merchant merchant) {
		String uuid = UUIDUtil.getUUID();
		//从shiro中获取商户信息
		merchant.setCreateTime(new Date());
		merchant.setUpdateTime(new Date());
		merchant.setSalt(uuid);
		//密码加密
	    String newPs = new SimpleHash("MD5", merchant.getPassword(), merchant.getMerchantCode()+uuid, 2).toHex();
	    merchant.setPassword(newPs);
	    merchant.setMerchantStatus("1");
	    merchantMapper.insert(merchant);
	}

}
