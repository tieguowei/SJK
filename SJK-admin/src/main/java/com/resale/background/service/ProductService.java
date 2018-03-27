package com.resale.background.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

	/**
	 * 回显
	 * @param id
	 * @return
	 */
	Product getProductById(int id);
	/**
	 * 修改
	 * @param product
	 * @param fileField
	 */
	void updateProduct(Product product, MultipartFile fileField) throws IOException;
	/**
	 * 校验商品名称是否重复
	 * @param map
	 * @return
	 */
	Product checkNameIsRepeat(Map<String, Object> map);

	/**
	 * 删除商品
	 * @param product
	 */
	void deleteProduct(Product product);

}
