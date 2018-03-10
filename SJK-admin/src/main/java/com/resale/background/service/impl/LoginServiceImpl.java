package com.resale.background.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resale.background.config.RedisClient;
import com.resale.background.constants.Constants;
import com.resale.background.mapper.MenuMapper;
import com.resale.background.mapper.UserMapper;
import com.resale.background.pojo.Menu;
import com.resale.background.pojo.User;
import com.resale.background.service.LoginService;
import com.resale.background.util.ReturnMsgData;
import com.resale.util.StringUtil;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	MenuMapper menuMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	private RedisClient redisClinet;
	protected final Log logger = LogFactory.getLog(getClass());

	public User getUserInfoByAccount(String name,String pass) {
		User user=userMapper.getInfoByAccount(name);
		return user;
	}

	/**
	 * 根据用户登陆账号查询用户信息
	 */
	@Override
	public ReturnMsgData getInfoByMerchantName(String merchantName, String password, String yzm) {
		
		if(StringUtil.isBlank(password)){
			return new ReturnMsgData("1000", "小子，请输入用户名");
		}
		if(StringUtil.isBlank(password)){
			return new ReturnMsgData("1001", "小子，请输入密码");
		}
		
		if(StringUtil.isBlank(yzm)){	
			return new ReturnMsgData("1002", "小子，请输入验证码");
		}
		User user=userMapper.getInfoByAccount(merchantName);
		if(user!=null){
			if(user.getUserPassword().equals(password)){
				if(yzm.equalsIgnoreCase(redisClinet.get(Constants.CHECK_CODE))){
					return new ReturnMsgData("1005",user.getUserId().toString());//登陆成功
				}else{
					return new ReturnMsgData("1006", "验证码有误");
				}
				/*request.getSession().setAttribute("USER", userBean);
				request.getSession().setAttribute("NAME", userBean.getUserName());
				request.getSession().setAttribute("ACCOUNT", userBean.getUserAccount());
				request.getSession().setAttribute("PASS", userBean.getUserPassword());
				request.getSession().setAttribute("ID", userBean.getUserId());*/
			}else{
				return new ReturnMsgData("1004", "账号或密码错误");//密码错误
			}
		}else{
			return new ReturnMsgData("1003", "账号或密码错误");//账号不存在
		}
	}
	
	
	/**
	 * 根据用户id查找此用户所用户的菜单
	 */
	public List<Menu> getMenuByUserId(int id) {
		List<Menu>plist=menuMapper.getParenMenuByUserId(id);
		for(Menu m:plist){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("uid", id);
			map.put("pid", m.getMenuId());
			List<Menu>clist=menuMapper.getChildMenuByPid(map);
			if(clist!=null){
				m.setChildren(clist);
			}
		}
		return plist;
	}

	
	@Override
	public void deleteImageVerificationCode(String key) {
		redisClinet.delete(key);
	}

	@Override
	public void setImageVerificationCode(String key, String value) {
		redisClinet.set(key, value);
	}

	
}
