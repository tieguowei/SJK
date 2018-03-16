package com.resale.background.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resale.background.constants.RedisConstant;
import com.resale.background.mapper.MenuMapper;
import com.resale.background.mapper.MerchantMapper;
import com.resale.background.mapper.RoleMapper;
import com.resale.background.pojo.Menu;
import com.resale.background.pojo.Merchant;
import com.resale.background.pojo.Role;
import com.resale.background.redis.RedisClient;
import com.resale.background.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private MerchantMapper merchantMapper;
	@Autowired
	private RedisClient redisClinet;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private MenuMapper menuMapper;
	
	
	protected final Log logger = LogFactory.getLog(getClass());


	/**
	 * 根据用户登陆账号查询用户信息
	 */
	@Override
	public Merchant getInfoByMerchantCode(String merchantCode) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("merchantCode", merchantCode);
		Merchant merchant = merchantMapper.getInfoByMerchantCode(map);
		/*if(merchant!=null){
			String md5Pwd = MD5Util.md5(password+Constants.MD5KEY);
			if(merchant.getPassword().equals(md5Pwd)){
				if(yzm.equalsIgnoreCase(redisClinet.get(Constants.CHECK_CODE))){
					request.getSession().setAttribute("merchantName", merchant.getMerchantName());
					return new ReturnMsgData("1005",merchant.getId().toString());//登陆成功
				}else{
					return new ReturnMsgData("1006", "验证码有误,请刷新");
				}
			}else{
				return new ReturnMsgData("1004", "账号或密码错误");//密码错误
			}
		}else{
			return new ReturnMsgData("1003", "账号或密码错误");//账号不存在
		}*/
		
		return merchant;
	}
	
	

	
	@Override
	public void deleteImageVerificationCode(String key) {
		redisClinet.delete(key);
	}

	@Override
	public void setImageVerificationCode(String key, String value) {
		redisClinet.set(key, value);
		redisClinet.expire(key, RedisConstant.REDIS_TOKEN_BACKGROUND_LOGIN);
	}




	/**
	 * 根据商户ID查询角色信息
	 */
	@Override
	public List<Role> findRoleByMerchantId(Integer id) {
		return roleMapper.findRoleByMerchantId(id);
	}



	/**
	 * 根据商户角色id 查询权限
	 */
	@Override
	public List<Menu> permissionListRoleId(Integer id) {
		return menuMapper.permissionListRoleId(id);
	}

	
}
