package com.boke.bean;

import java.io.Serializable;

public class BokeInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private int bokeid;  //博客Id
	private int userid;    //作者ID
	private String editordate;   //编辑日期
	private String title;        //标题
	private String label;         //标签
	private String content;        //内容
	private String pics;          //图片地址
	private String original;      //是否原创
	private int type;             //类型
	private int shape;             //发布形式
	private int state;             //文章状态
	private int readnum;           //阅读量
	private int evaluate;          //评论量
	
	@Override
	public String toString() {
		return "BokeInfo [bokeid=" + bokeid + ", userid=" + userid + ", editordate=" + editordate + ", title=" + title
				+ ", label=" + label + ", content=" + content + ", pics=" + pics + ", original=" + original + ", type="
				+ type + ", shape=" + shape + ", state=" + state + ", readnum=" + readnum + ", evaluate=" + evaluate
				+ "]";
	}

	public int getBokeid() {
		return bokeid;
	}

	public void setBokeid(int bokeid) {
		this.bokeid = bokeid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getEditordate() {
		return editordate;
	}

	public void setEditordate(String editordate) {
		this.editordate = editordate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPics() {
		return pics;
	}

	public void setPics(String pics) {
		this.pics = pics;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getShape() {
		return shape;
	}

	public void setShape(int shape) {
		this.shape = shape;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getReadnum() {
		return readnum;
	}

	public void setReadnum(int readnum) {
		this.readnum = readnum;
	}

	public int getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(int evaluate) {
		this.evaluate = evaluate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BokeInfo(int bokeid, int userid, String editordate, String title, String label, String content, String pics,
			String original, int type, int shape, int state, int readnum, int evaluate) {
		super();
		this.bokeid = bokeid;
		this.userid = userid;
		this.editordate = editordate;
		this.title = title;
		this.label = label;
		this.content = content;
		this.pics = pics;
		this.original = original;
		this.type = type;
		this.shape = shape;
		this.state = state;
		this.readnum = readnum;
		this.evaluate = evaluate;
	}

	public BokeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bokeid;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((editordate == null) ? 0 : editordate.hashCode());
		result = prime * result + evaluate;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((original == null) ? 0 : original.hashCode());
		result = prime * result + ((pics == null) ? 0 : pics.hashCode());
		result = prime * result + readnum;
		result = prime * result + shape;
		result = prime * result + state;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + type;
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
		BokeInfo other = (BokeInfo) obj;
		if (bokeid != other.bokeid)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (editordate == null) {
			if (other.editordate != null)
				return false;
		} else if (!editordate.equals(other.editordate))
			return false;
		if (evaluate != other.evaluate)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (original == null) {
			if (other.original != null)
				return false;
		} else if (!original.equals(other.original))
			return false;
		if (pics == null) {
			if (other.pics != null)
				return false;
		} else if (!pics.equals(other.pics))
			return false;
		if (readnum != other.readnum)
			return false;
		if (shape != other.shape)
			return false;
		if (state != other.state)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type != other.type)
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	
	
	
}
