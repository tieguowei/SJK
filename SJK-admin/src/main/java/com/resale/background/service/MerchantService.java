package com.resale.background.service;

public interface MerchantService {
	/**
	 * 校验商户原始密码是否正确
	 * @return
	 */
	boolean checkOldPwd(int id, String oldPwd);
	/**
	 * 修改商户密码
	 * @return
	 */
	void updatePwd(int id, String newPwd);

}
