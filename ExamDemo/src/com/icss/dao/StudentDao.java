package com.icss.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.icss.entity.Taccount;
import com.icss.entity.Tpaperinfo;
import com.icss.entity.Tscorew;
import com.icss.entity.Tstuansinfo;

import com.icss.entity.Tstudent;

public class StudentDao extends BaseDao {
	
	public int querypids( String sno) throws SQLException{
		int examid=0;
		String sql="select examid from tstuansinfo where sno=? ";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,sno);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			
			examid=rs.getInt("answerid");
			
		}
	
	
	return examid;
	}
	
	
	
	
	public int querypid(String sno,int examid) throws SQLException{
		int pid=0;
		String sql="select answerid from tstuansinfo where sno=? and examid=?";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,sno);
		ps.setInt(2, examid);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			
			pid=rs.getInt("answerid");
			
		}
		return pid;
	}

	
	public List<Tstuansinfo> querypapers(String sno) throws SQLException{
		List<Tstuansinfo> t=new ArrayList<Tstuansinfo>();
		String sql="select * from tstuansinfo where sno=? ";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,sno);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		     Tstuansinfo	ts=new Tstuansinfo();
			ts.setAnswerid(rs.getInt("answerid"));
			ts.setExamid(rs.getInt("examid"));
			ts.setScore(rs.getInt("score"));
			ts.setSno(sno);
			t.add(ts);
		}
		
		return t;
	}	
		
	
	
	public List<Tstuansinfo> querypaper(String sno) throws SQLException{
		List<Tstuansinfo> t=new ArrayList<Tstuansinfo>();
		String sql="select * from tstuansinfo ts,texam te  where ts.sno=? and ts.state=3 and ts.examid=te.examid";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,sno);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		     Tstuansinfo	ts=new Tstuansinfo();
		     ts.setExamtitle(rs.getString("examtitle"));
			ts.setAnswerid(rs.getInt("answerid"));
			ts.setExamid(rs.getInt("examid"));
			ts.setScore(rs.getInt("score"));
			ts.setSno(sno);
			t.add(ts);
		}
		
		return t;
	}	
		
	
	
	
	public void addtstuansinfo(int examid,String sno) throws SQLException{
		String sql="insert into tstuansinfo values(seq_id.nextval,?,?,1,0)";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);	
		ps.setInt(1,examid);
		ps.setString(2,sno);
	    ps.executeQuery();
		
		
	}
	
	
	
	
public void addts(int pid,int qid,String an) throws SQLException{
		String sql="insert into tstuanscom values(seq_id.nextval,?,?,?,0)";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, pid);
		ps.setInt(2,qid);
		ps.setString(3,an);
	ps.executeQuery();	
	}
	
	

	public Taccount checkaccount(String account) throws SQLException {
		Taccount a = null;
		String sql = "select *from taccount where uno=?";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, account);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			a = new Taccount();
			a.setUno(account);
			a.setPassword(rs.getString("password"));
			a.setRole(rs.getInt("role"));
		}
		return a;
	}

	public Tstudent checkstudent(String sno) throws SQLException {
		Tstudent student = null;
		String sql = "select * from tstudent where sno=?";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, sno);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			student = new Tstudent();
			student.setSno(rs.getString("sno"));
			student.setClassno(rs.getString("classno"));
			student.setSaddress(rs.getString("saddress"));
			student.setSage(rs.getInt("sage"));
			student.setScontact(rs.getString("scontact"));
			student.setSemail(rs.getString("semail"));
			student.setSname(rs.getString("sname"));
			student.setSschool(rs.getString("sschool"));
			student.setSgrade(rs.getString("sgrade"));
			if (rs.getInt("sgender") == 1) {
				student.setSgender("男");
			} else {
				student.setSgender("女");
			}
		}
		return student;
	}

	public void editstudent(Tstudent student) throws SQLException {
		String sql = "update tstudent set  classno=? , sname=? ,sgender=?, sage=? ,scontact=? ,semail=? ,saddress=? ,sschool=?, sgrade=?  where  sno=?";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, student.getClassno());
		ps.setString(2, student.getSname());
		ps.setString(3, student.getSgender());
		ps.setInt(4, student.getSage());
		ps.setString(5, student.getScontact());
		ps.setString(6, student.getSemail());
		ps.setString(7, student.getSaddress());
		ps.setString(8, student.getSschool());
		ps.setString(9, student.getSgrade());
		ps.setString(10, student.getSno());
		ps.executeUpdate();

	}

	public boolean checkAccount(String sno) throws Exception {
		boolean bRet = false;
		String sql = "select password from taccount where uno='" + sno + "'";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			bRet = true;
			break;
		}
		return bRet;
	}

	public boolean checkAccount1(String sno, String pw) throws Exception {
		boolean bRet = false;
		String sql = "select password from taccount where uno='" + sno + "'";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next() && rs.getString("password").equals(pw)
				&& !rs.equals("")) {
			bRet = true;
			break;
		}
		return bRet;
	}

	public void eidtpwd(String sno, String password) throws Exception {
		String sql = "update taccount set password=? where uno='" + sno + "'";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, password);
		ps.executeUpdate();
	}

	public List<Tpaperinfo> queryallpaper() throws SQLException {
		String sql = "select * from tpaperinfo,tcourse,texam where tpaperinfo.cno=tcourse.cno and texam.pid=tpaperinfo.pid";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Tpaperinfo> paperinfo = new ArrayList<Tpaperinfo>();
		while (rs.next()) {
			Tpaperinfo p = new Tpaperinfo();
			p.setEid(rs.getInt("examid"));
			p.setPid(rs.getInt("pid"));
			p.setCno(rs.getString("cno"));
			p.setCname(rs.getString("cname"));
			p.setTno(rs.getString("tno"));
			p.setPtitle(rs.getString("ptitle"));
			p.setStime(rs.getDate("stime"));
			p.setEtime(rs.getDate("etime"));
			p.setScore(rs.getInt("score"));
			if (rs.getString("pstate").equals("1")) {
				p.setPstate("已出完");
			} else {
				p.setPstate("未出完");
			}
			paperinfo.add(p);
		}
		return paperinfo;
	}


	
public int queryscore(String sno , int sansid) throws Exception {
	int score = 0;
	String sql ="select score from tstuansinfo where sno=? and examid=?";
	openConnection();
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1,sno);
	ps.setInt(2,sansid);
	ResultSet rs = ps.executeQuery();

	while(rs.next()){
		score = rs.getInt("score");
		

		
	}
	return score;
}

	
	

public List<Tscorew> queryscorew(String sno,int pid){

	
	
	
	
	return null;

}
}
	
	
	
