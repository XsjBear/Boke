package com.boke.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.boke.bean.BokeInfo;

public interface IBokeInfoMapper {
	/**
	 * 添加博客
	 * @param bf
	 * @return
	 */
	public int add(BokeInfo bf);
	
	/**
	 * 查询所有博客
	 * @return
	 */
	public List<BokeInfo> findAll();
	
	/**
	 * 根据博客类型分页查询
	 * @param map
	 * @return
	 */
	public List<BokeInfo> findByType (Map<String, Integer> map);
	
	/**
	 * 根据博客编号，查询博客信息
	 * @param bokeid
	 * @return
	 */
	public List<BokeInfo> findByBokeid(Integer userid, int page, int rows);
	
	public List<BokeInfo> findByFirst(Integer userid, int page, int rows);
	
	/**
	 * 根据类型获取博客数量
	 * @param type
	 * @return
	 */
	public int getTotalByUserId(Integer userid);
	
	
	/**
	 * 根据用户id查询出最近更新的几条博客
	 * @param bokeid
	 * @return
	 */
	public List<BokeInfo> recentUpdata(BokeInfo boke);
	
	
	/**
	 * 根据查询出点击量最高的几条博客
	 * @param 
	 * @return
	 */
	public List<BokeInfo> clicRankList(int limitNum);
	
	/**
	 * 根据类型获取博客数量
	 * @param type
	 * @return
	 */
	public int getTotal(Integer type);
	
	
	/**
	 * 获取除自己的博客之外之外博客数量
	 * @param type
	 * @return
	 */
	public int getAllTotalExceptSelf(BokeInfo bf);
	
	
	/**
	 * 获取自己的博客数量
	 * @param type
	 * @return
	 */
	public int getSelfBokeTotal(BokeInfo bf);
	
	/**
	 * 随机查询出多条记录
	 * @param topNum	查询出记录的值
	 * @return	查询出的记录
	 */
	public List<BokeInfo> getRand(BokeInfo bf);
	
	
	
	
	/**
	 * 根据博客编号，查询博客信息
	 * @param bokeid
	 * @return
	 */
	public List<BokeInfo> findByBokeid(int bokeid, int page, int rows);
	
	
	/**
	 * 多表查询
	 * @return
	 */
	public  Map<String,Object> finds(Integer bokeid);
	
	public int addread(int bokeid);
}
