package com.boke.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boke.mapper.IFocusMapper;
import com.boke.service.IFocusService;
import com.boke.util.StringUtil;

@Service
public class FocusServiceImpl implements IFocusService{
	@Autowired
	private IFocusMapper mapper;

	@Override
	public List<Map<String,Object>> findById(Map<String,Integer> map){
		return mapper.findById(map);
	}

	@Override
	public int getTotal(int userid) {
		if(StringUtil.isNull(userid)){
			return -1;
		}
		return mapper.getTotal(userid);
	}

	/*@Override
	public List<UserInfo> findById(List<Integer> list,Integer page,Integer rows){
		return mapper.findById(list, page, rows);
	}

	@Override
	public List<Integer> searchaLLFocus(Focus fs,Integer page,Integer rows) {
		return mapper.searchaLLFocus(fs, page, rows);
	}

	@Override
	public List<BokeInfo> findBokes(List<Integer> list1,Integer page,Integer rows) {
		return mapper.findBokes(list1, page, rows);
	}*/
	

}
