package com.boke.mapper;

import java.util.List;

import com.boke.bean.Evaluation;

/**
 * 评价表表mapper
 * @author Xsj
 */
public interface IEvalationMapper {
	
	public List<Evaluation> selectAll(int bokeid);
	
	
} 
