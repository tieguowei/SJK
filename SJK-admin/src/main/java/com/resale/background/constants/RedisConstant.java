package com.resale.background.constants;

public class RedisConstant {

	public static final int REDIS_TOKEN_BACKGROUND_YZM=120;//redis中存储后台用户登录生成的验证码时间（30秒）
	public static final String  USER_TOKEN = "USERTOKEN";//redis中存储用户token的前缀
	public static final int REDIS_TOKEN_DELAY = 60*60*24*30;//redis中存储token的时间(30天)


}
