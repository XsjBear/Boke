package com.boke.mapper;

import java.util.List;

import com.boke.bean.Respond;

/**
 * 回复表mapper
 * @author Xsj
 */
public interface IRespondMapper {
	
	public List<Respond> selectAll(int bokeid);
	
	
	public int addOne(Respond rspond);
	
	
} 
