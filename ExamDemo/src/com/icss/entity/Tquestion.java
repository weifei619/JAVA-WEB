package com.icss.entity;

public class Tquestion {
private int qid;
private int qtid;
private String qtname;

private String qcont;
private String qans;
private String qexp;
private String qurl;
private int ispastdue;

public String getQtname() {
	return qtname;
}
public void setQtname(String qtname) {
	this.qtname = qtname;
}
public int getQid() {
	return qid;
}
public void setQid(int qid) {
	this.qid = qid;
}
public int getQtid() {
	return qtid;
}
public void setQtid(int qtid) {
	this.qtid = qtid;
}
public String getQcont() {
	return qcont;
}
public void setQcont(String qcont) {
	this.qcont = qcont;
}
public String getQans() {
	return qans;
}
public void setQans(String qans) {
	this.qans = qans;
}
public String getQexp() {
	return qexp;
}
public void setQexp(String qexp) {
	this.qexp = qexp;
}
public String getQurl() {
	return qurl;
}
public void setQurl(String qurl) {
	this.qurl = qurl;
}
public int getIspastdue() {
	return ispastdue;
}
public void setIspastdue(int ispastdue) {
	this.ispastdue = ispastdue;
}

}
