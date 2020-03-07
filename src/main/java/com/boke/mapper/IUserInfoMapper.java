package com.boke.mapper;

import com.boke.bean.UserInfo;

public interface IUserInfoMapper {
	/**
	 * 注册用户
	 * 
	 * @param uf
	 * @return
	 */
	public int add(UserInfo uf);

	/**
	 * 用户登录
	 * 
	 * @param uf
	 * @return
	 */
	public UserInfo login(UserInfo uf);

	public UserInfo findAll(Integer userid);

	public int update(UserInfo uf);
}
