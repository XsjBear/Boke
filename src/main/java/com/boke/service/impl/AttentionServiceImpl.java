package com.boke.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boke.bean.Attention;
import com.boke.mapper.AttentionMapper;
import com.boke.service.AttentionService;

@Service
public class AttentionServiceImpl implements AttentionService{
	
	@Autowired
	private AttentionMapper attentions;

	@Override
	public int addAttention(Attention attention) {
		// TODO Auto-generated method stub
		return attentions.addAttention(attention);
	}

	@Override
	public List<Attention> findByUserid(Attention attention) {
		return attentions.findByUserid(attention);
	}

	@Override
	public int delAttention(Attention attention) {
		// TODO Auto-generated method stub
		return attentions.delAttention(attention);
	}
	
	
}
