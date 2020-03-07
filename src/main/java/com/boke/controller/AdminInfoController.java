package com.boke.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.boke.bean.AdminInfo;
import com.boke.service.IAdminInfoService;
import com.boke.websocket.WebSocketServer;

@RestController
@ResponseBody
@RequestMapping("Admin")
public class AdminInfoController {
	@Autowired
	private IAdminInfoService service;
	
	@RequestMapping("/findAll")
	public List<AdminInfo> findAll(){
		return service.findAll();
	}
	
	
	
	@RequestMapping("/login")
	public int login(HttpSession session, AdminInfo af){
		AdminInfo login = service.login(af);
		System.out.println(login);
		if (login != null){
			//有没有在其他地方登录
			WebSocketServer wss = WebSocketServer.getWebSocket(String.valueOf(login.getAdminid()));
			if (wss != null){  //说明在其他地方已经登录，则击退
				try {
					wss.sendMessage("110");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			session.setAttribute("loginUser", login);
			return 1;
		}
		return 0;
	}
	
	@RequestMapping("/back/index")
	public String gotoBackIndex(){
		return "foeward:/WEB-INF/back/index.jsp";
	}
}
