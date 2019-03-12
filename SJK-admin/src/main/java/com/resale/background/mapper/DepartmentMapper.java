package com.resale.background.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.resale.background.pojo.Department;
import com.resale.background.pojo.DepartmentExample;

public interface DepartmentMapper {
    int countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(Integer deptId);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(Integer deptId);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    /**
     * 查询所有部门
     * @return
     */
	List<Map<String, Object>> findAllRetMapByPage();

	Department findLevelsByDeptId(Integer parentId);
	/**
	 * 查询所有pid为0的部门
	 * @return
	 */
	List<Map<String, Object>> getParentDeptList();
	/**
	 * 根据父id查询子部门
	 * @param object
	 * @return
	 */
	List<Department> queryChildDeptByPidType(String pid);
	
	public Department getDepartmentById(@Param("did")int did);
	public void updateDepartment(Department department);
}