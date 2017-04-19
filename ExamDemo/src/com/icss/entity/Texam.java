package com.icss.entity;

import java.util.Date;

public class Texam {
private int examid;
private int pid;
private String ptitle;
private Date stime;
private Date etime;
private String examtitle;
private String examtype;
private String ischeck;
private String examstate;

public String getPtitle() {
	return ptitle;
}
public void setPtitle(String ptitle) {
	this.ptitle = ptitle;
}
public int getExamid() {
	return examid;
}
public void setExamid(int examid) {
	this.examid = examid;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public Date getStime() {
	return stime;
}
public void setStime(Date stime) {
	this.stime = stime;
}
public Date getEtime() {
	return etime;
}
public void setEtime(Date etime) {
	this.etime = etime;
}
public String getExamtitle() {
	return examtitle;
}
public void setExamtitle(String examtitle) {
	this.examtitle = examtitle;
}
public String getExamtype() {
	return examtype;
}
public void setExamtype(String examtype) {
	this.examtype = examtype;
}
public String getIscheck() {
	return ischeck;
}
public void setIscheck(String ischeck) {
	this.ischeck = ischeck;
}
public String getExamstate() {
	return examstate;
}
public void setExamstate(String examstate) {
	this.examstate = examstate;
}


}
