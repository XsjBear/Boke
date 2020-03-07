package com.boke.websocket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.aop.config.AdvisorComponentDefinition;
import org.springframework.stereotype.Component;

import com.boke.util.LogUtil;


@ServerEndpoint("/websocket/{sid}")
@Component
public class WebSocketServer {
	private static int onlineCount = 0;   //记录在线用户人数
	
	//用来保存每一个客户端对应的websocket对象
	private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();
	
	private Session session;   //于某个客户端连接的回话
	
	private String sid = "";   //用来接收用户编号
	
	/**
	 * 说明连接的时候需要调用的方法
	 * @param session
	 * @param sid
	 */
	@OnOpen
	public void onOpen(Session session, @PathParam("sid") String sid){
		this.sid = sid;
		this.session = session;
		webSocketSet.add(this);
		addOnlineCount();   //当前在线用户人数+1
		
		LogUtil.log.info("有新用户连接上来了，sid为:"+sid+",当前在线用户人数" + getOnlineCount());
		
		try {
			this.sendMessage("连接服务器成功...");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 当连接断开时，调用次方法
	 */
	@javax.websocket.OnClose
	public void OnClose() {
		webSocketSet.remove(this);
		subOnlineCount();   //在线人数 -1
		LogUtil.log.info("用户" + sid + " 下线了，当前在线用户人数" + getOnlineCount());
	}
	
	/**
	 * 监听处理客户端发过来的消息和方法
	 */
	@OnMessage
	public void onMessage(String msg, Session session){
		LogUtil.log.info("收到来自" +sid+" 的信息：" + msg);
		
		//群发
		for (WebSocketServer iss : webSocketSet){
			try {
				iss.sendMessage(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 发送错误时
	 */
	@OnError
	public void onError(Session session, Throwable error){
		error.printStackTrace();
	}

	/**
	 * 发送消息的方法
	 * @param string
	 * @throws IOException 
	 */
	public void sendMessage(String msg) throws IOException {
		this.session.getBasicRemote().sendText(msg);
	}
	
	public static synchronized void addOnlineCount() {
		WebSocketServer.onlineCount ++;
	}
	
	public static synchronized int getOnlineCount() {
		return onlineCount;
	}
	
	public static synchronized void subOnlineCount() {
		WebSocketServer.onlineCount --;
	}
	
	public static WebSocketServer getWebSocket(String sid){
		if (webSocketSet == null || webSocketSet.isEmpty()){
			return null;
		}
		for (WebSocketServer wss : webSocketSet){
			System.out.println(sid + "\t" + wss.sid);
			if (sid.equals(wss.sid)){
				return wss;
			}
		}
		return null;
		
	}
}
