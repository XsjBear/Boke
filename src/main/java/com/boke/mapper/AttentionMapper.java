package com.boke.mapper;

import java.util.List;

import com.boke.bean.Attention;

public interface AttentionMapper {
	
	/**
	 * 新增一个关注
	 * @param attention
	 * @return
	 */
	public int addAttention(Attention attention);
	
	
	/**
	 * 新增一个关注
	 * @param attention
	 * @return
	 */
	public List<Attention> findByUserid(Attention attention);
	
	
	/**
	 * 新增一个关注
	 * @param attention
	 * @return
	 */
	public int delAttention(Attention attention);
	
	

}
