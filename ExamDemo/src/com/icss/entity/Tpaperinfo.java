package com.icss.entity;

import java.util.Date;

public class Tpaperinfo {
	private int eid;
private int pid;
private String tno;
private String cno;
private String cname;
private Date stime;
private Date etime;

public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
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
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
private Date ctime;
private String ptitle;
private String pstate;
private int score;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getTno() {
	return tno;
}
public void setTno(String tno) {
	this.tno = tno;
}
public String getCno() {
	return cno;
}
public void setCno(String cno) {
	this.cno = cno;
}
public Date getCtime() {
	return ctime;
}
public void setCtime(Date ctime) {
	this.ctime = ctime;
}
public String getPtitle() {
	return ptitle;
}
public void setPtitle(String ptitle) {
	this.ptitle = ptitle;
}
public String getPstate() {
	return pstate;
}
public void setPstate(String pstate) {
	this.pstate = pstate;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
	
	
	
	
}
