package com.boke.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boke.bean.UserInfo;
import com.boke.service.IFocusService;

@RestController
@RequestMapping("/Focus")
@ResponseBody
public class FocusController {
	@Autowired
	private IFocusService service;

	/*@RequestMapping("/findById")
	public Map<String,List> findById(HttpSession session,Integer page,Integer rows){
		//获取session里面用户表的userid
		UserInfo userInfo  = (UserInfo) session.getAttribute("loginUser");
		Focus fs = new Focus();
		fs.setUserid(userInfo.getUserid());
		//查询到被关注人的id
		List<Integer> lists = service.searchaLLFocus(fs, page, rows);
		//System.out.println("LISTS  >>.. " + lists);
		List<UserInfo> list = null;
		if(lists.size() != 0){
			//查询用户信息
			list = service.findById(lists,page,rows);
		}
		//System.out.println(list);
		Focus fss = new Focus();
		fss.setUserid(userInfo.getUserid());
		List<BokeInfo> list1 = null;
		if(lists.size() != 0){
			//查询博客信息
			list1 = service.findBokes(lists,page,rows);
		}
		//将查询的用户信息和博客信息放到map里
		Map<String,List> map = new HashMap<>();
		map.put("UserInfo", list);
		map.put("BokeInfo", list1);
		System.out.println(map);
		return map;
	}*/
	
	/*@RequestMapping("/findBokes")
	public List<BokeInfo> findBokes(HttpSession session){
		UserInfo userInfo  = (UserInfo) session.getAttribute("loginUser");
		Focus fss = new Focus();
		fss.setUserid(userInfo.getUserid());
		List<BokeInfo> list1 = null;
		List<Integer> lists = service.searchaLLFocus(fss);
		if(lists.size() != 0){
			list1 = service.findBokes(lists);
		}
		System.out.println(list1);
		return list1;
	}*/
	@RequestMapping("/findById")
	public List<Map<String,Object>> findById(HttpSession session,Integer page,Integer rows){
		//从session里获取用户信息
		UserInfo userInfo = (UserInfo) session.getAttribute("loginUser");
		Map<String,Integer> map = new HashMap<>();
		//获取关注表里面的userid
		Integer fuserid = userInfo.getUserid();
		map.put("userid", fuserid);
		map.put("page", (page - 1)* rows);
		map.put("rows", rows);
		List<Map<String,Object>> list = service.findById(map);
		return list;
	}
	
	@RequestMapping("/getTotal")
	public int getTotal(HttpSession session){
		UserInfo userInfo = (UserInfo) session.getAttribute("loginUser");
		int userid = userInfo.getUserid();
		int total = service.getTotal(userid);
		return total;
	}
	
	@RequestMapping("/isLogin")
	public int isLogin(HttpSession session){
		UserInfo userInfo = (UserInfo) session.getAttribute("loginUser");
		if(userInfo == null){
			return -1;
		}
		return 1;
	}
}
