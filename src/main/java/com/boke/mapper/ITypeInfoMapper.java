package com.boke.mapper;

import java.util.List;

import com.boke.bean.TypeInfo;

public interface ITypeInfoMapper {
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<TypeInfo> findAll();
	
	/**
	 * 查询所有
	 * type
	 * @return
	 */
	public List<TypeInfo> finds();
	
}
