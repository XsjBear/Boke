package com.boke.mapper;

import java.util.List;
import java.util.Map;

import com.boke.bean.Collect;
import com.boke.bean.UserInfo;


public interface ICollectMapper {
	
	/**
	 * 点击收藏博客
	 * @param cl
	 * @return
	 */
	public int addBoke(Collect cl);
	
	
	/**
	 * 查询收藏博客
	 * @return
	 */
	public List<Map<String,Object>> finds(Map<String,Integer> map);
	
	/**
	 * 根据博客类型分页查询
	 * @param map
	 * @return
	 */
	public List<Collect> findByType (Map<String, Integer> map);
	
	/**
	 * 根据博客编号，查询博客信息
	 * @param bokeid
	 * @return
	 */
	public List<Collect> findByCid(Collect collect);
	
	/**
	 * 新增一个收藏
	 * @param collect
	 * @return
	 */
	public int addCollect(Collect collect);
	
	public int delCollect(Collect collect);
	
	public List<Collect> findAll(int userid);
	
	
	public List<Collect> findByFirst(Integer collectionid, int page, int rows);
	
	/**
	 * 根据类型获取博客数量
	 * @param type
	 * @return
	 */
	public Integer getTotalByCid(UserInfo user);

	
	


	
}
