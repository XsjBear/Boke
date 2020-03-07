package com.boke.service;

import java.util.List;

import com.boke.bean.Evaluation;

/**
 * 评价表的service层
 * @author Xsj
 *
 */
public interface IEvalationService {
	
	public List<Evaluation> selectAll(int bokeid);
	
}
