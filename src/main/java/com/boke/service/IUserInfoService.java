package com.boke.service;

import com.boke.bean.UserInfo;

public interface IUserInfoService {
	/**
	 * 用户登录
	 * 
	 * @param uf
	 * @return
	 */
	public UserInfo login(UserInfo uf);

	/**
	 * 用户注册
	 * 
	 * @param uf
	 * @return
	 */
	public int add(UserInfo uf);

	public UserInfo findAll(Integer userid);

	public int update(UserInfo uf);
}
