package com.resale.background.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.resale.background.pojo.Category;
import com.resale.background.pojo.Product;
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
	/**
	 * 添加商品
	 * @param product
	 * @param request
	 * @param response 
	 */

	void saveProduct(Product product, MultipartFile fileField)  throws IOException;

}
