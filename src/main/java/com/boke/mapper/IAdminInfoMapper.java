package com.boke.mapper;

import java.util.List;

import com.boke.bean.AdminInfo;


public interface IAdminInfoMapper {
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<AdminInfo> findAll();
	
	/**
	 * 管理员登录
	 * @param af
	 * @return
	 */
	public AdminInfo login(AdminInfo af);
	
	/**
	 * 添加后台管理信息
	 * @param af
	 * @return
	 */
	public int add(AdminInfo af);
	
	/**
	 * 重置密码
	 * @param adminid
	 * @return
	 */
	public int updatPwd(AdminInfo adminid);

	
} 
