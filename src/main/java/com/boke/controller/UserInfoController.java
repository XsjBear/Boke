package com.boke.controller;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boke.bean.UserInfo;
import com.boke.service.IUserInfoService;
import com.boke.util.SendMailUtil;

@RestController
@RequestMapping("/userInfo")
@ResponseBody
public class UserInfoController {
	
	@Autowired
	private IUserInfoService service;
	
	private SendMailUtil sendMailutil = new SendMailUtil("1293580602@qq.com", "dihpepdwtahlgefh");
	
	@RequestMapping("/code")
	public int code(String name,String email,HttpSession session){
		int result = -1;
		try {
			String code = "";
			Random rd = new Random();
			while(code.length() < 6 ){
				code += rd.nextInt(10);
			}
			if(sendMailutil.sendHtmlMail(email, name, code)){
				session.setAttribute("code", code);
				//启用一个定时任务，当3分钟后清空这个session中的值
				TimerTask task = new TimerTask(){
					@Override
					public void run() {
						session.removeAttribute("code");
					}
				};
				Timer timer = new Timer();
				timer.schedule(task, 180000);
				result = 1;
			}else{
				result = 0;
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 用户注册
	 * @param session
	 * @param uf
	 * @return
	 */
	@RequestMapping("/add")
	public int reg(HttpSession session,UserInfo uf){
		String code = (String) session.getAttribute("code");
		if(!uf.getCode().equals(code)){
			return -2;
		}
		return service.add(uf);
	}
	/**
	 * 用户登录
	 * @param session
	 * @param uf
	 * @return
	 */
	@RequestMapping("/login")
	public int login(HttpSession session, UserInfo uf){
		UserInfo userInfo = service.login(uf);
		System.out.println("UserInfo       " + userInfo);
		if (userInfo != null){
			session.setAttribute("loginUser", userInfo);
			return 1;
		}
		return 0;
	}
	
	@RequestMapping("/check")
	public UserInfo checkLogin(HttpSession session){
		Object obj = session.getAttribute("loginUser");
		
		if (obj == null){
			return new UserInfo();
		}
		return (UserInfo) obj;
	}
	
	@RequestMapping("/exit")
	public int exit(HttpSession session) {
		UserInfo user = (UserInfo) session.getAttribute("loginUser");
		if (user == null) {
			return -1;
		}
		
		session.removeAttribute("loginUser");
		return 1;
	} 
	
	

	/**
	 * 关于我页面查询
	 * @param session
	 * @param userid
	 * @return
	 */
	@RequestMapping("/findAll")
	public UserInfo findAll(HttpSession session,Integer userid){
		UserInfo userInfo = (UserInfo) session.getAttribute("loginUser");
//		userid = userInfo.getUserid();
//		UserInfo uf = service.findAll(userid);
//		if(uf != null){
//			session.setAttribute("findAlluf", uf);
//		}
		if(userInfo != null) {
			return userInfo;
		}
		return null;
	}
	/**
	 * 修改用户信息
	 * @param session
	 * @param userid
	 * @return
	 */
	@RequestMapping("/update")
	public int update(HttpSession session,UserInfo uf){
		UserInfo userInfo = (UserInfo) session.getAttribute("loginUser");
		uf.setUserid(userInfo.getUserid());
		return service.update(uf);
	}
	

}
