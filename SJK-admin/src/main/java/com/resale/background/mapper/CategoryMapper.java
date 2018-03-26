package com.resale.background.mapper;

import com.resale.background.pojo.Category;
import com.resale.background.pojo.CategoryExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
    int countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

	List<Map<String, Object>> findAllRetMapByPage(Map<String, Object> paramsCondition);

	Long findAllByPageCount(Map<String, Object> paramsCondition);
	/**
	 * 校验品类名称是否存在
	 * @param map
	 * @return
	 */
	Category checkCategoryNameIsRepeat(Map<String, Object> map);
	/**
	 * 修改
	 * @param category
	 */
	void updateCategory(Category category);
	/**
	 * 删除
	 * @param category
	 */
	void deleteCategory(Category category);
	
	/**
	 * 根据code 查询所有分类
	 * @param merchantCode
	 * @return
	 */
	List<Category> getCategoryList(String merchantCode);
}