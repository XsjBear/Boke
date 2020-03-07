package com.boke.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boke.bean.AdminInfo;
import com.boke.mapper.IAdminInfoMapper;
import com.boke.service.IAdminInfoService;

@Service
public class AdminInfoServiceImpl implements IAdminInfoService{
	@Autowired
	private IAdminInfoMapper mapper;
	
	/**
	 * 登录
	 */
	@Override
	public AdminInfo login(AdminInfo af) {
		return mapper.login(af);
	}



	@Override
	public List<AdminInfo> findAll() {
		return mapper.findAll();
	}
	
}
