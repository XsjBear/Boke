package com.boke.bean;

import java.io.Serializable;

public class IabelInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private int labelid;   //标签id
	private String labelname;   //标签名
	
	@Override
	public String toString() {
		return "IabelInfo [labelid=" + labelid + ", labelname=" + labelname + "]";
	}

	public int getLabelid() {
		return labelid;
	}

	public void setLabelid(int labelid) {
		this.labelid = labelid;
	}

	public String getLabelname() {
		return labelname;
	}

	public void setLabelname(String labelname) {
		this.labelname = labelname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public IabelInfo(int labelid, String labelname) {
		super();
		this.labelid = labelid;
		this.labelname = labelname;
	}

	public IabelInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + labelid;
		result = prime * result + ((labelname == null) ? 0 : labelname.hashCode());
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
		IabelInfo other = (IabelInfo) obj;
		if (labelid != other.labelid)
			return false;
		if (labelname == null) {
			if (other.labelname != null)
				return false;
		} else if (!labelname.equals(other.labelname))
			return false;
		return true;
	}
	
	
}
