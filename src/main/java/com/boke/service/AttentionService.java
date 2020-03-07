package com.boke.service;

import java.util.List;

import com.boke.bean.Attention;

public interface AttentionService {
	
	/**
	 * 新增一个关注
	 * @param attention
	 * @return
	 */
	public int addAttention(Attention attention);
	
	/**
	 * 删除一个关注
	 * @param attention
	 * @return
	 */
	public int delAttention(Attention attention);
	
	/**
	 * 查找一个关注
	 * @param attention
	 * @return
	 */
	public List<Attention> findByUserid(Attention attention);
	
}
