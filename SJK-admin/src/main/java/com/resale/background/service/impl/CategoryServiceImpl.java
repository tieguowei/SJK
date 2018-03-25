package com.resale.background.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resale.background.mapper.CategoryMapper;
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


}
