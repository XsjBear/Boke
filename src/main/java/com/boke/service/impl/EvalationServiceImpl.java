package com.boke.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boke.bean.Evaluation;
import com.boke.mapper.IEvalationMapper;
import com.boke.service.IEvalationService;

@Service
public class EvalationServiceImpl implements IEvalationService{
	
	@Autowired
	private IEvalationMapper evaluation;

	@Override
	public List<Evaluation> selectAll(int bokeid) {
		// TODO Auto-generated method stub
		return evaluation.selectAll(bokeid);
	}
	
	
	
	
}
