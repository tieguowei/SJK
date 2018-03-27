package com.resale.background.mapper;

import com.resale.background.pojo.Category;
import com.resale.background.pojo.Merchant;
import com.resale.background.pojo.Product;
import com.resale.background.pojo.ProductExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);

	List<Category> getCategoryList(Merchant merchant);

	/**
	 * 校验商品名称是否重复
	 * @param map
	 * @return
	 */
	Product checkNameIsRepeat(Map<String, Object> map);

	/**
	 * 删除商品
	 * @param map
	 */
	void deleteProductById(Map<String, Object> map);
}