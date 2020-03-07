package com.boke.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;



public interface IFocusMapper {
	
	/*public List<UserInfo> findById(List<Integer> list,Integer page,Integer rows);
	
	public List<Integer> searchaLLFocus(Focus fs, Integer page,Integer rows);
	
	public List<BokeInfo> findBokes(List<Integer> list1,Integer page,Integer rows);*/
	
	//根据userid查询出关注的人的所有博客信息和用户信息
	public List<Map<String,Object>> findById(Map<String,Integer> map); 
	
	//查出数量
	public int getTotal(int userid);
}
