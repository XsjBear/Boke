package com.boke.bean;

import java.io.Serializable;

public class TypeInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private int type;       //类型id
	private String typename;   //类型名称
	
	@Override
	public String toString() {
		return "TypeInfo [type=" + type + ", typename=" + typename + "]";
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TypeInfo(int type, String typename) {
		super();
		this.type = type;
		this.typename = typename;
	}

	public TypeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + type;
		result = prime * result + ((typename == null) ? 0 : typename.hashCode());
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
		TypeInfo other = (TypeInfo) obj;
		if (type != other.type)
			return false;
		if (typename == null) {
			if (other.typename != null)
				return false;
		} else if (!typename.equals(other.typename))
			return false;
		return true;
	}
	
	
}
