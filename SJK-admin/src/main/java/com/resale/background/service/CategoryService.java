package com.resale.background.service;

import java.util.Map;

import com.resale.background.pojo.Category;
import com.resale.background.util.PageModel;

public interface CategoryService {
	
	PageModel getCategorytList(Map<String, Object> paramsCondition);
	/**
	 * 校验品类名称是否存在
	 * @param map
	 * @return
	 */
	Category checkCategoryNameIsRepeat(Map<String, Object> map);
	/**
	 * 添加品类
	 * @param category
	 */
	void saveMenu(Category category);
	/**
	 * 修改回显
	 * @param id
	 * @return
	 */
	Category quertCategoryById(int id);
	/**
	 * 修改
	 * @param category
	 */
	void updateCategory(Category category);
	/**
	 * 删除品类
	 * @param category
	 */
	void deleteCategory(Category category);

}
