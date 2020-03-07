package com.boke.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boke.bean.Attention;
import com.boke.bean.BokeInfo;
import com.boke.bean.Collect;
import com.boke.bean.TypeInfo;
import com.boke.bean.UserInfo;
import com.boke.service.AttentionService;
import com.boke.service.IBokeInfoService;
import com.boke.service.ICollectService;
import com.boke.service.ITypeInfoService;

/**
 * 首页控制器
 * @author Xsj
 *
 */
@RestController
@ResponseBody
@RequestMapping("/homePage")
public class homePageController {
	
	@Autowired
	private IBokeInfoService bokeInfo;
	
	@Autowired
	private AttentionService attention;
	
	@Autowired
	private ICollectService  collect;
	
	@Autowired
	private ITypeInfoService typeInfo;
	
	/**
	 * 查询最近更新博客请求
	 */
	@RequestMapping(value=("/recentUpdlata"))
	public List<BokeInfo> recentUpdata(HttpServletRequest request) {
		// 从session中取出用户登录信息
		UserInfo user = (UserInfo) request.getSession().getAttribute("loginUser");
		if(user != null) {
			BokeInfo boke = new BokeInfo();
			boke.setUserid(user.getUserid());
			
			//自己写的博客的数量
			int selfBokeNum = bokeInfo.getSelfBokeTotal(boke);
			//设置显示博客数量，如果自己写的博客数量大于六条，则只显示六条博客数量，如果小于六条，则显示全部
			boke.setReadnum((selfBokeNum > 6) ? 6 : selfBokeNum);
			return bokeInfo.recentUpdata(boke);
		}
		return null;
	}
	
	
	/**
	 * 点击排行请求
	 * @return
	 */
	@RequestMapping(value=("/clicRankList"))
	public List<BokeInfo> clicRankList() {
		List<BokeInfo> list = bokeInfo.clicRankList(6);
		return list;
	}
	
	
	/**
	 * 获取所有的类别
	 */
	@RequestMapping(value=("/getAllType"))
	public List<TypeInfo> getAllType() {
		List<TypeInfo> list = typeInfo.findAll();
		return list;
	}
	
	/**
	 * 首页加载请求
	 * @param request
	 * @return
	 */
	@RequestMapping("/loading")
	public Map<String,List>  loading(String type , HttpServletRequest request) {
		//首页加载博客的篇数
		int topNum = 3;
		
		//从session中取出用户登录信息
		UserInfo user = (UserInfo) request.getSession().getAttribute("loginUser");
		
		//获取数据库中现有的博客的数据
		BokeInfo boke = new BokeInfo();
		boke.setUserid(user.getUserid());
		if(type != null) {
			boke.setType(Integer.valueOf(type));
		}
		int allTotal = bokeInfo.getAllTotalExceptSelf(boke);
		
		//将查询记录条数攒存入boke实体类的阅读量中，从数据库中随机获取topNum条数据，如果topNum大于数据库中现有博客数，则将数据库中所有博客返回，否则返回topNum条记录
		boke.setReadnum((topNum > allTotal) ? allTotal : topNum);
		List<BokeInfo> list = bokeInfo.getRand(boke);
		//已关注人的列表
		List<Attention> attentionList = attention.findByUserid(new Attention(String.valueOf(user.getUserid()), null));
		
		//当前推荐的文章中已关注的作者
		List<Attention> curentSuggestListFocus = new ArrayList<>();
		//遍历当前推荐博客
		for (int i = 0; i < list.size(); i++) {
			//遍历当前登陆用户关注的作者
			for (int j = 0; j < attentionList.size(); j++) {
				//判断当前推荐的博客的作者是否是作者关注的作者
				if(String.valueOf(list.get(i).getUserid()).equals(attentionList.get(j).getFocususerid())) {
					//判断curentSuggestListFocus中是否存入数据，如果已存入，直接循环，如果未存入，则直接添加
					if(curentSuggestListFocus.size()!=0) {
						//表示当前推荐的博客的作者是用户已经关注的作者
						for (int k = 0; k < curentSuggestListFocus.size(); k++) {
							//判断文章已关注作者列表中有没有该作者，如果有，则跳过，如果没有，则进行添加
							if(attentionList.get(j).getFocususerid().equals(curentSuggestListFocus.get(k).getFocususerid())) {
								//表示已经添加
								continue;
							}else {
								//表示未添加,进行添加
								curentSuggestListFocus.add(attentionList.get(j));
							}
						}
					}else {
						curentSuggestListFocus.add(attentionList.get(j));
					}
					
				}
			}
		}
		

		//已收藏的列表
		List<Collect> collectList = collect.findByCid(new Collect(String.valueOf(user.getUserid()),null));
		//当前文章已收藏的用户
		List<Collect>  curentSuggestListFocus2 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			//遍历当前登陆用户关注的作者
			for (int j = 0; j < collectList.size(); j++) {
				//判断当前推荐的博客的作者是否是作者关注的作者
				if(String.valueOf(list.get(i).getUserid()).equals(collectList.get(j).getBokeid())) {
					//判断curentSuggestListFocus2中是否存入数据，如果已存入，直接循环，如果未存入，则直接添加
					if(curentSuggestListFocus2.size()!=0) {
						//表示当前推荐的博客的作者是用户已经收藏的作者
						for (int k = 0; k < curentSuggestListFocus2.size(); k++) {
							//判断文章已收藏作者列表中有没有该作者，如果有，则跳过，如果没有，则进行添加
							if(collectList.get(j).equals(curentSuggestListFocus2.get(k).getBokeid())) {
								//表示已经添加
								continue;
							}else {
								//表示未添加,进行添加
								curentSuggestListFocus2.add(collectList.get(j));
							}
						}
					}else {
						curentSuggestListFocus2.add(collectList.get(j));
					}
					
				}
			}
		}
		
		Map<String,List> map = new HashMap<>();
		map.put("bokeList", list);
		map.put("attention", curentSuggestListFocus);
		map.put("collectList", list);
		map.put("collect", collect.findAll(user.getUserid()));
		System.out.println(map);
		return map;
	}
	
	
	/**
	 * 增加一条关注信息
	 */
	@RequestMapping(value=("/addAttention") , method = RequestMethod.POST)
	public int addAttention(String userid , HttpServletRequest request) {
		UserInfo user = (UserInfo) request.getSession().getAttribute("loginUser");
		return attention.addAttention(new Attention(String.valueOf(user.getUserid()) , String.valueOf(userid)));
	}
	
	/**
	 * 删除一条关注信息
	 */
	@RequestMapping(value=("/delAttention") , method = RequestMethod.POST)
	public int delAttention(String userid , HttpServletRequest request) {
		UserInfo user = (UserInfo) request.getSession().getAttribute("loginUser");
		return attention.delAttention(new Attention(String.valueOf(user.getUserid()) , userid));
	}
	
	/**
	 * 增加一条收藏信息
	 * 
	 */
	@RequestMapping("/addCollect")
	public int addCollect(Collect collect1, HttpSession session){
		UserInfo user = (UserInfo) session.getAttribute("loginUser");
		if ( user == null){
			return -2;
		}else{
			collect1.setUserid(user.getUserid());
			int result = collect.addCollect(collect1);
			if (result > 0) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	@RequestMapping("/delCollect")
	public int delCollect(Collect collect1, HttpSession session){
		UserInfo user = (UserInfo) session.getAttribute("loginUser");
		if ( user == null){
			return -2;
		}else{
			collect1.setUserid(user.getUserid());
			int result = collect.delCollect(collect1);
			if (result > 0) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
}
