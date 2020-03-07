package com.boke.bean;

import java.io.Serializable;

public class Respond implements Serializable {
	private static final long serialVersionUID = 1L;
	private String respondid; //回复人
	private String respondman; //回复人
	private String respondedman;   //被回复人
	private String type;        //回复博客id
	private String aboutid;        //回复博客id
	private String bokeid;        //回复博客id
	private String respondtime;    //回复时间
	private String respondcontent;  //回复内容
	private String whichbelong;  //回复内容
	public Respond(String respondid, String respondman, String respondedman, String type, String aboutid, String bokeid,
			String respondtime, String respondcontent, String whichbelong) {
		super();
		this.respondid = respondid;
		this.respondman = respondman;
		this.respondedman = respondedman;
		this.type = type;
		this.aboutid = aboutid;
		this.bokeid = bokeid;
		this.respondtime = respondtime;
		this.respondcontent = respondcontent;
		this.whichbelong = whichbelong;
	}
	public Respond() {
		super();
	}
	@Override
	public String toString() {
		return "Respond [respondid=" + respondid + ", respondman=" + respondman + ", respondedman=" + respondedman
				+ ", type=" + type + ", aboutid=" + aboutid + ", bokeid=" + bokeid + ", respondtime=" + respondtime
				+ ", respondcontent=" + respondcontent + ", whichbelong=" + whichbelong + "]";
	}
	public String getRespondid() {
		return respondid;
	}
	public void setRespondid(String respondid) {
		this.respondid = respondid;
	}
	public String getRespondman() {
		return respondman;
	}
	public void setRespondman(String respondman) {
		this.respondman = respondman;
	}
	public String getRespondedman() {
		return respondedman;
	}
	public void setRespondedman(String respondedman) {
		this.respondedman = respondedman;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAboutid() {
		return aboutid;
	}
	public void setAboutid(String aboutid) {
		this.aboutid = aboutid;
	}
	public String getBokeid() {
		return bokeid;
	}
	public void setBokeid(String bokeid) {
		this.bokeid = bokeid;
	}
	public String getRespondtime() {
		return respondtime;
	}
	public void setRespondtime(String respondtime) {
		this.respondtime = respondtime;
	}
	public String getRespondcontent() {
		return respondcontent;
	}
	public void setRespondcontent(String respondcontent) {
		this.respondcontent = respondcontent;
	}
	public String getWhichbelong() {
		return whichbelong;
	}
	public void setWhichbelong(String whichbelong) {
		this.whichbelong = whichbelong;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aboutid == null) ? 0 : aboutid.hashCode());
		result = prime * result + ((bokeid == null) ? 0 : bokeid.hashCode());
		result = prime * result + ((respondcontent == null) ? 0 : respondcontent.hashCode());
		result = prime * result + ((respondedman == null) ? 0 : respondedman.hashCode());
		result = prime * result + ((respondid == null) ? 0 : respondid.hashCode());
		result = prime * result + ((respondman == null) ? 0 : respondman.hashCode());
		result = prime * result + ((respondtime == null) ? 0 : respondtime.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((whichbelong == null) ? 0 : whichbelong.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Respond other = (Respond) obj;
		if (aboutid == null) {
			if (other.aboutid != null)
				return false;
		} else if (!aboutid.equals(other.aboutid))
			return false;
		if (bokeid == null) {
			if (other.bokeid != null)
				return false;
		} else if (!bokeid.equals(other.bokeid))
			return false;
		if (respondcontent == null) {
			if (other.respondcontent != null)
				return false;
		} else if (!respondcontent.equals(other.respondcontent))
			return false;
		if (respondedman == null) {
			if (other.respondedman != null)
				return false;
		} else if (!respondedman.equals(other.respondedman))
			return false;
		if (respondid == null) {
			if (other.respondid != null)
				return false;
		} else if (!respondid.equals(other.respondid))
			return false;
		if (respondman == null) {
			if (other.respondman != null)
				return false;
		} else if (!respondman.equals(other.respondman))
			return false;
		if (respondtime == null) {
			if (other.respondtime != null)
				return false;
		} else if (!respondtime.equals(other.respondtime))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (whichbelong == null) {
			if (other.whichbelong != null)
				return false;
		} else if (!whichbelong.equals(other.whichbelong))
			return false;
		return true;
	}
	
}
