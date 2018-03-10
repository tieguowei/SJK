package com.resale.background.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resale.background.mapper.MenuMapper;
import com.resale.background.pojo.Menu;
import com.resale.background.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuMapper menuMapper;
	
	protected final Log logger = LogFactory.getLog(getClass());

	
	public boolean checkMenu(String name, int id) {
		boolean flag=false;
		if(id!=0){//修改
			Menu menu=menuMapper.getMenuByName(name);
			if(menu==null||(menu!=null&&menu.getMenuId()==id)){
				flag=true;
			}
		}else{//添加
			Menu menu=menuMapper.getMenuByName(name);
			if(menu==null){
				flag=true;
			}
		}
		
		return flag;
	}

	public Menu quertMenuById(int id) {
		return menuMapper.quertMenuById(id);
	}

	public int delMenuById(int mid) {
		// TODO Auto-generated method stub
		return menuMapper.delMenuById(mid);
	}

	public boolean upMenu(Menu menu) {
		boolean flag=false;
		int i=menuMapper.upMenu(menu);
		if(i>0){
			flag=true;
		}
		return flag;
	}

	public boolean saveMenu(Menu menu) {
		boolean flag=true;
		int i=menuMapper.saveMenu(menu);
		if(i>0){
			flag=true;
		}
		return flag;
	}

	public Map<String,Object> getMenuList(int pageNumber, int pageSize) {
		Map<String,Object>map=new HashMap<String, Object>();
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("startIndex", (pageNumber-1)*pageSize);
		requestMap.put("pageSize", pageNumber*pageSize);
		List<Menu>list=menuMapper.getMenuList(requestMap);
		int count =menuMapper.getCount();
		map.put("rows", list);
		map.put("total", count);
		return map;
	}

	public List<Menu> getParentMenu() {
		System.out.println(menuMapper.getParentMenu());
		return menuMapper.getParentMenu();
	}

}
