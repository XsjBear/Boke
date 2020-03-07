package com.boke.bean;

public class Collect {
	private int collectionid;         //收藏ID
	private int userid;             //用户收藏id
	private int bokeid;                //收藏博客ID
	private String Stringcollectiondate;    //收藏日期
	
	@Override
	public String toString() {
		return "Collect [collectionid=" + collectionid + ", userid=" + userid + ", bokeid=" + bokeid
				+ ", Stringcollectiondate=" + Stringcollectiondate + "]";
	}

	public int getCollectionid() {
		return collectionid;
	}

	public void setCollectionid(int collectionid) {
		this.collectionid = collectionid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getBokeid() {
		return bokeid;
	}

	public void setBokeid(int bokeid) {
		this.bokeid = bokeid;
	}

	public String getStringcollectiondate() {
		return Stringcollectiondate;
	}

	public void setStringcollectiondate(String stringcollectiondate) {
		Stringcollectiondate = stringcollectiondate;
	}

	public Collect(int collectionid, int userid, int bokeid, String stringcollectiondate) {
		super();
		this.collectionid = collectionid;
		this.userid = userid;
		this.bokeid = bokeid;
		Stringcollectiondate = stringcollectiondate;
	}

	public Collect() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collect(String valueOf, Object object) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Stringcollectiondate == null) ? 0 : Stringcollectiondate.hashCode());
		result = prime * result + bokeid;
		result = prime * result + collectionid;
		result = prime * result + userid;
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
		Collect other = (Collect) obj;
		if (Stringcollectiondate == null) {
			if (other.Stringcollectiondate != null)
				return false;
		} else if (!Stringcollectiondate.equals(other.Stringcollectiondate))
			return false;
		if (bokeid != other.bokeid)
			return false;
		if (collectionid != other.collectionid)
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	
}
