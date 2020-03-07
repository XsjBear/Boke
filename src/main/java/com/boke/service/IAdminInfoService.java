package com.boke.service;

import java.util.List;

import com.boke.bean.AdminInfo;

public interface IAdminInfoService {
	public List<AdminInfo> findAll();
	
	public AdminInfo login(AdminInfo af);
}
