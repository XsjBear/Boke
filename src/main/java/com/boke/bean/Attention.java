package com.boke.bean;

import java.io.Serializable;

public class Attention implements Serializable{
	private int aid;          //关注id
	private String userid;        //关注人
	private String focususerid;      //关注类型
	
	
	
	public Attention() {
		super();
	}
	public Attention(String userid, String focususerid) {
		super();
		this.userid = userid;
		this.focususerid = focususerid;
	}
	@Override
	public String toString() {
		return "Attention [aid=" + aid + ", userid=" + userid + ", focususerid=" + focususerid + "]";
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getFocususerid() {
		return focususerid;
	}
	public void setFocususerid(String focususerid) {
		this.focususerid = focususerid;
	}
	
}
