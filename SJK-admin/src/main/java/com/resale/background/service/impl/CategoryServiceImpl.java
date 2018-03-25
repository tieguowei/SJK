package com.resale.background.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resale.background.mapper.CategoryMapper;
import com.resale.background.pojo.Category;
import com.resale.background.pojo.Merchant;
import com.resale.background.service.CategoryService;
import com.resale.background.util.PageModel;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	



	@Override
	public PageModel getCategorytList(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = categoryMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = categoryMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}




	@Override
	public Category checkCategoryNameIsRepeat(Map<String, Object> map) {
		return categoryMapper.checkCategoryNameIsRepeat(map);
	}




	@Override
	public void saveMenu(Category category) {
		//从shiro的session中取merchant
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		Merchant merchant = (Merchant) subject.getPrincipal();
		category.setCreateTime(new Date());
		category.setUpdateTime(new Date());
		category.setMerchantCode(merchant.getMerchantCode());
		category.setStatus("1");
		categoryMapper.insert(category);
	}




	@Override
	public Category quertCategoryById(int id) {
		return categoryMapper.selectByPrimaryKey(id);
	}




	@Override
	public void updateCategory(Category category) {
		categoryMapper.updateCategory(category);
	}




	@Override
	public void deleteCategory(Category category) {
		category.setStatus("2");
		categoryMapper.deleteCategory(category);
	}


}
