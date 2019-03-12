package com.resale.background.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.resale.background.pojo.Employee;
import com.resale.background.pojo.Menu;
import com.resale.background.service.MenuService;
import com.resale.background.util.DataMsg;
import com.resale.background.util.TreeView;
import com.resale.util.StringUtil;

	
/**
*<dl>
*<dt>类名：MenuController.java</dt>
*<dd>描述: 菜单管理业务逻辑实现</dd>
*<dd>创建时间： 2018年10月23日 上午10:58:11</dd>
*<dd>创建人：tie</dd>
*<dt>版本历史: </dt>
* <pre>
* Date Author Version Description
* ------------------------------------------------------------------
* 2018年10月23日 上午10:58:11 tie 1.0 1.0 Version
* </pre>
*</dl>
*/
@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	

    private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 跳转到菜单列表页面
	 * 
	 * @return
	 */
	@RequiresPermissions("menuManager:list") // 权限管理;
	@RequestMapping("/goMenuPage")
	public String goMenuPage() {
		return "system/menu/menuList";
	}

	

	/**
	 * 查询所有菜单
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMenuList")
	public List<Map<String, Object>> getMenuList(DataMsg dataMsg) {
		try {
			return  menuService.getMenuList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 查询所有pid为0的菜单
	 * 
	 * @return map
	 */
	@ResponseBody
	@RequestMapping("/getParentMenuList")
	public List<Map<String, Object>> getParentMenuList() {
		try {
			return menuService.getParentMenuList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 添加菜单
	 * 
	 * @param menu
	 * @return
	 */
	@RequiresPermissions("menuManager:add")
	@ResponseBody
	@RequestMapping("/saveMenu")
	public boolean saveMenu(Menu menu) {
		try {
			Subject subject = SecurityUtils.getSubject();
			Employee employee = (Employee) subject.getPrincipal();
			int employeeId = employee.getEmployeeId();
			menuService.saveMenu(menu, employeeId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 校验菜单名称是否存在
	 * 
	 * @param menu
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkMenuName")
	public boolean checkMenuName(HttpServletRequest request) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			String nameZh = StringUtil.trim(request.getParameter("nameZh"));
			if (StringUtil.isNotBlank(nameZh)) {
				map.put("nameZh", nameZh);
			}
			String menuId = StringUtil.trim(request.getParameter("menuId"));
			if (StringUtil.isNotBlank(menuId)) {
				map.put("menuId", menuId);
			}
			Menu result = menuService.checkMenuNameIsRepeat(map);
			if (result == null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 修改回显
	 */
	@ResponseBody
	@RequestMapping("/getMenuById")
	public Map<String, Object> getMenuById(@RequestParam("mid") int mid) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Map<String, Object>> list = menuService.getParentMenuList();
			Menu menu = menuService.quertMenuById(mid);
			map.put("list", list);
			map.put("menu", menu);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 修改菜单
	 * 
	 * @param menu
	 * @return
	 */
	@RequiresPermissions("menuManager:update")
	@ResponseBody
	@RequestMapping("/updateMenu")
	public String updateMenu(Menu menu) {
		try {
			Subject subject = SecurityUtils.getSubject();
			Employee employee = (Employee) subject.getPrincipal();
			int employeeId = employee.getEmployeeId();
			menuService.updateMenu(menu, employeeId);
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "2";
		}

	}

	/**
	 * 删除菜单
	 * 
	 * @param menu
	 * @return
	 */
	@RequiresPermissions("menuManager:delete")
	@ResponseBody
	@RequestMapping("/deleteMenu")
	public boolean deleteMenu(Menu menu) {
		try {
			Subject subject = SecurityUtils.getSubject();
			Employee employee = (Employee) subject.getPrincipal();
			int employeeId = employee.getEmployeeId();
			menuService.deleteMenu(menu, employeeId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	/**
	 * 查询所有的菜单
	 * @return map
	 */
	@ResponseBody
	@RequestMapping("/getMenuDataList")
	public List<Map<String,Object>> getMenuDataList(){
		try {
			return menuService.getMenuDataList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 加载菜单
	 * @param rid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMenuTree")
	public List<TreeView> getMenuTree(){
		try {
			Subject subject = SecurityUtils.getSubject();
			Employee employee = (Employee) subject.getPrincipal();
			int employeeId = employee.getEmployeeId();
			return menuService.getViewTree(employeeId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 菜单管理
	 * @param rid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getManageMenuTree")
	public List<TreeView> getManageMenuTree(){
		try {
			Subject subject = SecurityUtils.getSubject();
			Employee employee = (Employee) subject.getPrincipal();
			int employeeId = employee.getEmployeeId();
			return menuService.getManageMenuTree(employeeId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
