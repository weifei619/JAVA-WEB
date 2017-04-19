package com.icss.entity;
/**
 * 题型表
 * @author Administrator
 *
 */
public class Tqt {
	
	

	private int qtid;//题目id;
	private String qtname;//题目类型；
	private int issubject;//是否主观题；
	public int getQtid() {
		return qtid;
	}
	public void setQtid(int qtid) {
		this.qtid = qtid;
	}
	public String getQtname() {
		return qtname;
	}
	public void setQtname(String qtname) {
		this.qtname = qtname;
	}
	public int getIssubject() {
		return issubject;
	}
	public void setIssubject(int issubject) {
		this.issubject = issubject;
	}


}
