package com.boke.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boke.bean.BokeInfo;
import com.boke.mapper.IBokeInfoMapper;
import com.boke.mapper.ITypeInfoMapper;
import com.boke.service.IBokeInfoService;
import com.boke.util.StringUtil;

@Service
public class BokeInfoServiceImpl implements IBokeInfoService{
	
	@Autowired
	private IBokeInfoMapper mapper;
	
	@Autowired
	private ITypeInfoMapper typemapper;

	
	@Override
	public int add(BokeInfo bf) {
		if (StringUtil.isNull(bf.getUserid(),bf.getPics())){
			return -1;
		}
		return mapper.add(bf);
	}



	@Override
	public List<BokeInfo> findAll() {
		return mapper.findAll();
	}

	

	

	@Override
	public List<BokeInfo> getRand(BokeInfo bf) {
		return mapper.getRand(bf);
	}

	@Override
	public int getAllTotalExceptSelf(BokeInfo bf) {
		// TODO Auto-generated method stub
		return mapper.getAllTotalExceptSelf(bf);
	}

	@Override
	public List<BokeInfo> recentUpdata(BokeInfo boke) {
		// TODO Auto-generated method stub
		return mapper.recentUpdata(boke);
	}

	@Override
	public int getSelfBokeTotal(BokeInfo bf) {
		// TODO Auto-generated method stub
		return mapper.getSelfBokeTotal(bf);
	}

	@Override
	public List<BokeInfo> clicRankList(int limitNum) {
		// TODO Auto-generated method stub
		return mapper.clicRankList(limitNum);
	}

	

	@Override
	public Map<String, Object> finds(Integer bokeid) {
		return mapper.finds(bokeid);
	}

	@Override
	public int addread(int bokeid) {
		return mapper.addread(bokeid);
	}




	@Override
	public List<BokeInfo> findByType(Integer userid, int page, int rows) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page",(page-1)*rows);
		map.put("rows", rows);
		map.put("userid", userid);
		return mapper.findByType(map);
	}



	@Override
	public List<BokeInfo> findByBokeid(Integer userid, int page, int rows) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page",(page-1)*rows);
		map.put("rows", rows);
		map.put("tno", userid);
		
		return mapper.findByType(map);
	}



	@Override
	public Map<String, Object> findByFirst(Integer userid, int page, int rows) {
		List<BokeInfo> boke = this.findByType(userid, page, rows);
		int total = mapper.getTotalByUserId(userid);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("boke", boke);
		resultMap.put("total", total);
		return resultMap;
	}



	@Override
	public int getTotalByUserId(Integer userid) {
		// TODO Auto-generated method stub
		return mapper.getTotalByUserId(userid);
	}

}
