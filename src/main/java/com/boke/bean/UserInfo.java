package com.boke.bean;

import java.io.Serializable;

public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private int userid;   //用户id
	private String username; //用户昵称
	private String userpass;  //密码
	private String realname;   //真实姓名
	private	String contackway;  //联系方式
	private String birthday;   //生日
	private String sex;        //性别
	private String address;    //家庭住址
	private String work;       //行业
	private String code;
	private String email;     //邮箱
	
	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", username=" + username + ", userpass=" + userpass + ", realname="
				+ realname + ", contackway=" + contackway + ", birthday=" + birthday + ", sex=" + sex + ", address="
				+ address + ", work=" + work + ", code=" + code + ", email=" + email + "]";
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getContackway() {
		return contackway;
	}

	public void setContackway(String contackway) {
		this.contackway = contackway;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserInfo(int userid, String username, String userpass, String realname, String contackway, String birthday,
			String sex, String address, String work, String code, String email) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpass = userpass;
		this.realname = realname;
		this.contackway = contackway;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
		this.work = work;
		this.code = code;
		this.email = email;
	}

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((contackway == null) ? 0 : contackway.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((realname == null) ? 0 : realname.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + userid;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((userpass == null) ? 0 : userpass.hashCode());
		result = prime * result + ((work == null) ? 0 : work.hashCode());
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
		UserInfo other = (UserInfo) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (contackway == null) {
			if (other.contackway != null)
				return false;
		} else if (!contackway.equals(other.contackway))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (realname == null) {
			if (other.realname != null)
				return false;
		} else if (!realname.equals(other.realname))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (userid != other.userid)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (userpass == null) {
			if (other.userpass != null)
				return false;
		} else if (!userpass.equals(other.userpass))
			return false;
		if (work == null) {
			if (other.work != null)
				return false;
		} else if (!work.equals(other.work))
			return false;
		return true;
	}
	
	
	
	
	
}
