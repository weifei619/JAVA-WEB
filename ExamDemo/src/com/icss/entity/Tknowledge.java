package com.icss.entity;
/**
 * 知识点
 * @author Liuda_000
 *
 */
public class Tknowledge {
	private int kid;//知识点Id
	private String cno;//课程Id
	private String kname;//知识点名称
	private String cname;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}

}
