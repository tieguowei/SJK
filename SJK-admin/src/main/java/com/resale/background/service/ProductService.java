package com.resale.background.service;

import java.util.List;
import java.util.Map;

import com.resale.background.pojo.Category;
import com.resale.background.util.PageModel;

public interface ProductService {
	/**
	 * 分页查询所有商品
	 * @param paramsCondition
	 * @return
	 */
	PageModel getProductList(Map<String, Object> paramsCondition);

	/**
	 * 添加查询商户所有的类别
	 * @param merchantCode
	 * @return
	 */
	List<Category> getCategoryList(String merchantCode);

}
