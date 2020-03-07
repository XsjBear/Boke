package com.boke.bean;

import java.io.Serializable;

public class Evaluation implements Serializable{

	private static final long serialVersionUID = 1L;
	private String evaluationman;   //评价人
	private String evaluationedman;   //被评价人
	private int bokeid;               //评价博客id
	private String evaluationtime;    //评价时间
	private String evaluationcontent;   //评价内容
	
	@Override
	public String toString() {
		return "Evaluation [evaluationman=" + evaluationman + ", evaluationedman=" + evaluationedman + ", bokeid="
				+ bokeid + ", evaluationtime=" + evaluationtime + ", evaluationcontent=" + evaluationcontent + "]";
	}

	public String getEvaluationman() {
		return evaluationman;
	}

	public void setEvaluationman(String evaluationman) {
		this.evaluationman = evaluationman;
	}

	public String getEvaluationedman() {
		return evaluationedman;
	}

	public void setEvaluationedman(String evaluationedman) {
		this.evaluationedman = evaluationedman;
	}

	public int getBokeid() {
		return bokeid;
	}

	public void setBokeid(int bokeid) {
		this.bokeid = bokeid;
	}

	public String getEvaluationtime() {
		return evaluationtime;
	}

	public void setEvaluationtime(String evaluationtime) {
		this.evaluationtime = evaluationtime;
	}

	public String getEvaluationcontent() {
		return evaluationcontent;
	}

	public void setEvaluationcontent(String evaluationcontent) {
		this.evaluationcontent = evaluationcontent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Evaluation(String evaluationman, String evaluationedman, int bokeid, String evaluationtime,
			String evaluationcontent) {
		super();
		this.evaluationman = evaluationman;
		this.evaluationedman = evaluationedman;
		this.bokeid = bokeid;
		this.evaluationtime = evaluationtime;
		this.evaluationcontent = evaluationcontent;
	}

	public Evaluation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bokeid;
		result = prime * result + ((evaluationcontent == null) ? 0 : evaluationcontent.hashCode());
		result = prime * result + ((evaluationedman == null) ? 0 : evaluationedman.hashCode());
		result = prime * result + ((evaluationman == null) ? 0 : evaluationman.hashCode());
		result = prime * result + ((evaluationtime == null) ? 0 : evaluationtime.hashCode());
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
		Evaluation other = (Evaluation) obj;
		if (bokeid != other.bokeid)
			return false;
		if (evaluationcontent == null) {
			if (other.evaluationcontent != null)
				return false;
		} else if (!evaluationcontent.equals(other.evaluationcontent))
			return false;
		if (evaluationedman == null) {
			if (other.evaluationedman != null)
				return false;
		} else if (!evaluationedman.equals(other.evaluationedman))
			return false;
		if (evaluationman == null) {
			if (other.evaluationman != null)
				return false;
		} else if (!evaluationman.equals(other.evaluationman))
			return false;
		if (evaluationtime == null) {
			if (other.evaluationtime != null)
				return false;
		} else if (!evaluationtime.equals(other.evaluationtime))
			return false;
		return true;
	}
	
	
}
