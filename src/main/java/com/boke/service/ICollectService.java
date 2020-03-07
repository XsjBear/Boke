package com.boke.service;

import java.util.List;
import java.util.Map;

import com.boke.bean.Attention;
import com.boke.bean.Collect;
import com.boke.bean.UserInfo;

public interface ICollectService {
	/**
	 * 点击收藏博客
	 * @param cl
	 * @return
	 */
	public int addBoke(Collect cl);
	
	
	/**
	 * 查询所有收藏博客
	 * @return
	 */
	public List<Map<String,Object>> finds(Integer userid ,Integer page,Integer rows);
	
	/**
	 * 根据收藏ID分页查询
	 * @param map
	 * @return
	 */
	public List<Collect> findByType (Integer bokeid, int page, int rows);
	
	/**
	 * 根据收藏博客编号，查询搜藏博客信息
	 * @param bokeid
	 * @return
	 */
	public List<Collect> findByCid(Collect collect);
	
	public Map<String, Object> findByFirst(Integer bokeid, int page, int rows);
	
	/**
	 * 根据类型获取博客数量
	 * @param type
	 * @return
	 */
	public Integer getTotalByCid(UserInfo user);
	
	public int addCollect(Collect collect);
	
	public int delCollect(Collect collect);
	
	public List<Collect> findAll(int userid);

}
