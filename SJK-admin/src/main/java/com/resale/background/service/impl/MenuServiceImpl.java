package com.resale.background.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resale.background.mapper.MenuMapper;
import com.resale.background.pojo.Menu;
import com.resale.background.pojo.Merchant;
import com.resale.background.redis.RedisClient;
import com.resale.background.service.MenuService;
import com.resale.background.util.PageModel;
import com.resale.util.SerializeUtil;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuMapper menuMapper;
	@Autowired
	private RedisClient redisClinet;
	
	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public List<Menu> getMenuByMerchantId(Integer id) {
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("id", id);
		requestMap.put("pid", 0);
		List<Menu>plist=menuMapper.getMenuByMerchantId(requestMap);
		for(Menu m:plist){
			Map<String,Object>map = new HashMap<String,Object>();
			map.put("id", id);
			map.put("pid", m.getMenuId());
			List<Menu>clist=menuMapper.getMenuByMerchantId(map);
			if(clist!=null){
				m.setChildren(clist);
			}
		}
		return plist;
	}
	
	/**
	 *  分页查询所有
	 */
	@Override
	public PageModel getMenuList(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = menuMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = menuMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}

	@Override
	public List<Map<String, Object>> getParentMenuList() {
		return menuMapper.getParentMenuList();
	}

	@Override
	public Menu checkMenuNameIsRepeat(String nameZh) {
		return menuMapper.checkMenuNameIsRepeat(nameZh);
	}

	@Override
	public void saveMenu(Menu menu) {
		//从redis取出登陆用户的信息
		byte[] bs = redisClinet.get("merchant".getBytes());
		Merchant merchant = (Merchant) SerializeUtil.unserialize(bs );
		menu.setCreatorId(merchant.getId());
		menu.setUpdateTime(new Date());
		menu.setCreateTime(new Date());
		menuMapper.insert(menu);
	}

	
	


}
