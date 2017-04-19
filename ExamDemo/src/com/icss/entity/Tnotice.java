package com.icss.entity;

import java.util.Date;

public class Tnotice {
private int nid; //公告ID
private String acc_id;//外键 用户ID
private String ncont;//通知内容
private Date time;//创建时间
public int getNid() {
	return nid;
}
public void setNid(int nid) {
	this.nid = nid;
}
public String getAcc_id() {
	return acc_id;
}
public void setAcc_id(String acc_id) {
	this.acc_id = acc_id;
}
public String getNcont() {
	return ncont;
}
public void setNcont(String ncont) {
	this.ncont = ncont;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}

}
