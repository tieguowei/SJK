package com.resale.background.service;

import java.util.List;
import java.util.Map;

import com.resale.background.pojo.Menu;
import com.resale.background.util.PageModel;

public interface MenuService {

	/**
	 * 根据商户id获取菜单
	 * @param id
	 * @return
	 */
	public List<Menu> getMenuByMerchantId(Integer id);
	/**
	 *  分页查询所有
	 * @param paramsCondition
	 * @return
	 */
	public PageModel getMenuList(Map<String, Object> paramsCondition);
}
