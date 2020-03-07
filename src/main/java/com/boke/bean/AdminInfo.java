package com.boke.bean;

import java.io.Serializable;

public class AdminInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private int adminid ;  //管理员id
	private  String adminname ; //管理员昵称
	private String adminpass ;  //管理员密码
	
	@Override
	public String toString() {
		return "AdminInfo [adminid=" + adminid + ", adminname=" + adminname + ", adminpass=" + adminpass + "]";
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpass() {
		return adminpass;
	}

	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AdminInfo(int adminid, String adminname, String adminpass) {
		super();
		this.adminid = adminid;
		this.adminname = adminname;
		this.adminpass = adminpass;
	}

	public AdminInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adminid;
		result = prime * result + ((adminname == null) ? 0 : adminname.hashCode());
		result = prime * result + ((adminpass == null) ? 0 : adminpass.hashCode());
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
		AdminInfo other = (AdminInfo) obj;
		if (adminid != other.adminid)
			return false;
		if (adminname == null) {
			if (other.adminname != null)
				return false;
		} else if (!adminname.equals(other.adminname))
			return false;
		if (adminpass == null) {
			if (other.adminpass != null)
				return false;
		} else if (!adminpass.equals(other.adminpass))
			return false;
		return true;
	}
	
	
	
	
	
	

}
