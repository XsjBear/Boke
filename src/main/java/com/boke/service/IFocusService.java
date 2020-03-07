package com.boke.service;

import java.util.List;
import java.util.Map;




public interface IFocusService {
	/*public List<UserInfo> findById(List<Integer> list,Integer page,Integer rows);
	
	public List<Integer> searchaLLFocus(Focus fs,Integer page,Integer rows);
	
	public List<BokeInfo> findBokes(List<Integer> list1,Integer page,Integer rows);*/
	
	public List<Map<String,Object>> findById(Map<String,Integer> map); 
	
	public int getTotal(int userid);
}
