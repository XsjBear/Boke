package com.boke.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boke.bean.Collect;
import com.boke.bean.UserInfo;
import com.boke.service.ICollectService;

@RestController
@RequestMapping("/collect")
@ResponseBody
public class CollectController {
	
	@Autowired
	private ICollectService service;
	
	@RequestMapping("/finds")
	public List<Map<String, Object>> finds(HttpServletRequest request , Integer page){
		int rows = 1;
		UserInfo user = (UserInfo) request.getSession().getAttribute("loginUser");
		int userid = user.getUserid();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>            " + service.finds(userid,page,rows));
		return service.finds(userid,page,rows);
	}
	
	@RequestMapping("/addBoke")
	public int addBoke(Collect cl) {
		return service.addBoke(cl);
	}
	
	@RequestMapping("/findByType")
	public List<Collect> findByType (Integer bokeid, int page, int rows ){
			return service.findByType(bokeid, page, rows);
		
	}
	
	@RequestMapping("/findByFirst")
	public Map<String, Object> findByFirst(Integer bokeid, int page, int rows){
		System.out.println("bokeid=" + bokeid);
		return service.findByFirst(bokeid, page, rows);
		
	}
	@RequestMapping("/total")
	public Integer getTotalByCid(HttpServletRequest request){
		UserInfo user = (UserInfo) request.getSession().getAttribute("loginUser");
		return service.getTotalByCid(user);
	}
}
