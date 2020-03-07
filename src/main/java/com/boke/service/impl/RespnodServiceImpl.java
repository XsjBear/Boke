package com.boke.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boke.bean.Evaluation;
import com.boke.bean.Respond;
import com.boke.mapper.IRespondMapper;
import com.boke.service.IRespondService;

@Service
public class RespnodServiceImpl implements IRespondService{
	
	@Autowired
	private IRespondMapper respond;

	@Override
	public List<Respond> selectAll(int bokeid) {
		// TODO Auto-generated method stub
		return respond.selectAll(bokeid);
	}

	@Override
	public int addOne(Respond rspond) {
		// TODO Auto-generated method stub
		return respond.addOne(rspond);
	}
	
	
	
	
}
