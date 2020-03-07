package com.boke.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boke.bean.TypeInfo;
import com.boke.mapper.ITypeInfoMapper;
import com.boke.service.ITypeInfoService;

@Service
public class TypeInfoServiceImpl implements ITypeInfoService{
	
	@Autowired
	private ITypeInfoMapper mapper;
	
	@Override
	public List<TypeInfo> findAll() {
		return mapper.findAll();
	}

	@Override
	public List<TypeInfo> finds() {
		return mapper.finds();
	}
	
}
