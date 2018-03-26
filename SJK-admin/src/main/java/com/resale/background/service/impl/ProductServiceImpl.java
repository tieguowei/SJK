package com.resale.background.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.resale.background.mapper.CategoryMapper;
import com.resale.background.mapper.ProductMapper;
import com.resale.background.pojo.Category;
import com.resale.background.pojo.Product;
import com.resale.background.service.ProductService;
import com.resale.background.util.PageModel;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public PageModel getProductList(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = productMapper.findAllRetMapByPage(paramsCondition);
		Long totalRecords = productMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}


	@Override
	public List<Category> getCategoryList(String merchantCode) {
		return categoryMapper.getCategoryList(merchantCode);
	}


	@Override
	public void saveProduct(Product product, HttpServletRequest request,HttpServletResponse response) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	}


}
