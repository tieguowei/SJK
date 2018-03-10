package com.resale.background.service;

import java.util.List;
import java.util.Map;

import com.resale.background.pojo.Menu;

public interface MenuService {

	/**
	 * 验证菜单名称是否唯一
	 * @param name
	 * @param id
	 * @return
	 */
	public boolean checkMenu(String name,int id);
	
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */
	public Menu quertMenuById(int id);
	
	/**
	 * 跟据id删除
	 * @param mid
	 * @return
	 */
	public int delMenuById(int mid);
	
	/**
	 * 更新
	 * @param menu
	 * @return
	 */
	public boolean upMenu(Menu menu);
	
	/**
	 * 添加菜单
	 * @param menu
	 * @return
	 */
	public boolean saveMenu(Menu menu);
	
	/**
	 * 分页查询
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Map<String,Object> getMenuList(int pageNumber,int pageSize);
	
	/**
	 * 查询所有父级菜单
	 * @return
	 */
	public List<Menu> getParentMenu();
}
