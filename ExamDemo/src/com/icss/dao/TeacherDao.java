package com.icss.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.entity.Tcourse;
import com.icss.entity.Texam;
import com.icss.entity.Tknowledge;
import com.icss.entity.Tpaperinfo;
import com.icss.entity.Tpaperties;
import com.icss.entity.Tqk;
import com.icss.entity.Tqt;
import com.icss.entity.Tquestion;
import com.icss.entity.Tstuanscom;


public class TeacherDao extends BaseDao{
	public boolean check(String tno,int examid) throws SQLException{
		 boolean bRet=false;
			String sql="select * from tmarkperm where tno=? and examid=?";
			openConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tno);
			ps.setInt(2, examid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				bRet=true;
				break;
			}
			
			return bRet;
		}	
			
	public List<Texam> queryexam() throws SQLException{
		List<Texam> exam=null;
		String sql="select * from texam t,tpaperinfo tp  where t.ischeck=2 ";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		exam=new ArrayList<Texam>();
		while(rs.next()){
			Texam ex=new Texam();
			ex.setPid(rs.getInt("pid"));
			ex.setPtitle(rs.getString("ptitle"));
			ex.setExamid(rs.getInt("examid"));
			ex.setStime(rs.getDate("stime"));
			ex.setEtime(rs.getDate("etime"));
			ex.setExamstate(rs.getString("examstate"));
			ex.setExamtitle(rs.getString("examtitle"));
			ex.setExamtype(rs.getString("examtype"));
			ex.setIscheck(rs.getString("ischeck"));
			exam.add(ex);
		
		
		}
		return exam;
	}
		
	
	
	
	
	
	public void removekq(int kid,int qid) throws SQLException{
		String sql="delete tqk where kid=? and qid=?";
		openConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setInt(1, kid);
	    ps.setInt(2,qid);
	    
		ps.executeUpdate();
		
		
		
	}
	
	
public void addscore(String sno,int pid,int score) throws SQLException{
String sql="update tstuansinfo set score=? where sno=? and examid=?";		
	openConnection();
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, score);
    ps.setString(2, sno);
    ps.setInt(3, pid);
	ps.executeUpdate();
}
	
public void editscore(String a,int b, int c) throws SQLException{
		String sql="update tstuanscom  set ansscore=? where exists(select 1 from tstuansinfo where tstuansinfo.sno=? and tstuanscom.sansid=tstuansinfo.answerid and tstuanscom.qid=?)";
   	openConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setInt(1, c);
	    ps.setString(2, a);
	    ps.setInt(3, b);
		ps.executeUpdate();
	}
	
	
	
	public List<Tstuanscom> querytst(int examid) throws SQLException{
		List<Tstuanscom> tst=null;
		String sql="select  tpa.score,tst.sno,ts.qid,tq.qcont,tq.qans,ts.anscont from tstuanscom ts,tquestion tq,tstuansinfo tst,tpaperties tpa   where tst.examid=?  and ts.qid=tq.qid and ts.sansid=tst.answerid  and tpa.qid=ts.qid";
		openConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setInt(1, examid);
	    ResultSet rs=ps.executeQuery();
	    tst=new ArrayList<Tstuanscom>();
	    while(rs.next()){
	    	Tstuanscom t=new Tstuanscom();
	    	t.setSc(rs.getInt("score"));
	    	t.setSno(rs.getString("sno"));
	    	t.setQid(rs.getInt("qid"));
	    	t.setQcont(rs.getString("qcont"));
	    	t.setQans(rs.getString("qans"));
	    	t.setAnscont(rs.getString("anscont"));
	    	tst.add(t);
	    	
	    }
		
		return tst;
	}

	
	
	
	public List<Tpaperinfo> querypaper() throws SQLException{
		List<Tpaperinfo> paperinfo=new ArrayList<Tpaperinfo>();
		String sql="select * from tpaperinfo tp,texam t  where t.pid=tp.pid and t.ischeck=2";
		openConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Tpaperinfo p=new Tpaperinfo();
			p.setPid(rs.getInt("pid"));
			p.setPtitle(rs.getString("ptitle"));
			paperinfo.add(p);	
		}
		return paperinfo;
		}
		
		
	
	
	
	public int queryallscore( int pid) throws SQLException{
	int score=0;
	String sql="select sum(score) from tpaperties where pid=?";
	openConnection();
    PreparedStatement ps = conn.prepareStatement(sql);
	ps.setInt(1,pid);	
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		score=rs.getInt("sum(score)");
	}
	return score;
	}
	
	public void removepaper(int qid) throws SQLException{
		String sql="delete   from tpaperties where qid=?";
		openConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,qid);		
		ps.executeQuery();
	}
	
	
	
	
	public List<Tpaperties> queryQ(int pid) throws SQLException{
		List<Tpaperties>  paper=null;
	String sql="select * from tquestion tq,tpaperties tp,tqt  where tp.pid=? and tq.qid=tp.qid and tq.qtid=tqt.qtid";	
	openConnection();
    PreparedStatement ps = conn.prepareStatement(sql);
	ps.setInt(1, pid);
	ResultSet rs=ps.executeQuery();
	paper=new ArrayList<Tpaperties>();
	while (rs.next()){
		Tpaperties t=new Tpaperties();
		t.setQid(rs.getInt("qid"));
		t.setQtid(rs.getInt("qtid"));
		t.setQtname(rs.getString("qtname"));
		t.setQcont(rs.getString("qcont"));
		t.setScore(rs.getInt("score"));
		t.setSeq(rs.getInt("seq"));
		paper.add(t);
		
		
	}
		return paper;
	}
	
	
	
	
	
	public void addpaper(Tpaperties tp) throws SQLException,Exception{
	String sql="insert into tpaperties values(seq_id.nextval,?,?,?,?)";	
	openConnection();
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, tp.getPid());
    ps.setInt(2, tp.getQid());
    ps.setInt(3, tp.getScore());
    ps.setInt(4, tp.getSeq());
    ps.executeQuery();
		
		
		
		
	}
	
	
	
public void updatetest(Tpaperinfo p) throws SQLException{
		String sql="update tpaperinfo set cno=?,ptitle=?,pstate=?,score=? where pid=?";
		openConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);
	    
	    ps.setString(1,p.getCno());
	    ps.setString(2,p.getPtitle());
	    ps.setString(3, p.getPstate());
	    ps.setInt(4, p.getScore());
	    ps.setInt(5, p.getPid());
		ps.executeUpdate();
	}
	
	
	
	
	
	
	public Tpaperinfo querypaperinfos(int pid) throws SQLException{
		Tpaperinfo p=null;
		String sql="select * from tpaperinfo where pid=?";
		openConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, pid);
		ResultSet rs=ps.executeQuery();
		while (rs.next()){
			p =new Tpaperinfo();
			p.setPid(rs.getInt("pid"));
			p.setCno(rs.getString("cno"));
			p.setTno(rs.getString("tno"));
			p.setPtitle(rs.getString("ptitle"));
			p.setCtime(rs.getDate("ctime"));
			p.setScore(rs.getInt("score"));
			if(rs.getString("pstate").equals("1")){
			p.setPstate("已出完");}else{
				p.setPstate("未出完");
			}
			
		}
		return p;
	} 
	
	
	
	
	public List<Tqk> querytqk(int kid) throws SQLException{
		List<Tqk> tqk=null;
		String sql="select *  from tqk where kid=?";
		openConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, kid);
		ResultSet rs=ps.executeQuery();
		tqk=new ArrayList<Tqk>();
		while(rs.next()){
			Tqk t=new 	Tqk();
			t.setKid(kid);
			t.setQid(rs.getInt("qid"));
			tqk.add(t);
		}
	
	return tqk;
	}
	
	public void removetqk(int qid) throws SQLException{
		String sql="delete  from tqk where qid=?";
		openConnection();
	    PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, qid);
		ps.executeQuery();
		
		
	}
	
	
	
	
	public List<Tquestion> queryq(String kid,String qtid) throws SQLException{	
	String sql="select tq.qid,tq.qcont,tq.qans,tq.qexp,tq.qurl,tq.ispastdue  from  tqk  t,tquestion tq  where  t.kid=?  and  tq.qtid=? and  t.qid=tq.qid";	
	openConnection();
    PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, kid);
	ps.setString(2, qtid);
	ResultSet rs=ps.executeQuery();
	List<Tquestion> question=new ArrayList<Tquestion>();
	while(rs.next()){
		Tquestion qu=new Tquestion();
		qu.setQid(rs.getInt("qid"));
		qu.setQcont(rs.getString("qcont"));
		qu.setQans(rs.getString("qans"));
		qu.setQexp(rs.getString("qexp"));
		qu.setQurl(rs.getString("qurl"));
		qu.setIspastdue(rs.getInt("ispastdue"));
		question.add(qu);	
	}
		return question;
	}
	
	
	public  void removepaperinfo(int pid) throws SQLException{
		String sql="delete from tpaperinfo where pid=?";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, pid);
		ps.executeQuery();
		
		
	}
	
	
	
	
	
	public List<Tpaperinfo> queryallpaper() throws SQLException{
		String sql="select * from tpaperinfo,tcourse where tpaperinfo.cno=tcourse.cno";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		List<Tpaperinfo> paperinfo=new ArrayList<Tpaperinfo>();
		while(rs.next()){
			Tpaperinfo p=new Tpaperinfo();
			p.setPid(rs.getInt("pid"));
			p.setCno(rs.getString("cno"));
			p.setCname(rs.getString("cname"));
			p.setTno(rs.getString("tno"));
			p.setPtitle(rs.getString("ptitle"));
			p.setCtime(rs.getDate("ctime"));
			p.setScore(rs.getInt("score"));
			if(rs.getString("pstate").equals("1")){
			p.setPstate("已出完");}else{
				p.setPstate("未出完");
			}
		    paperinfo.add(p);
		}
		return paperinfo;
	}
	
	
	public List<Tpaperinfo> querypaperinfo(String ptitle) throws SQLException{
		String sql="select * from tpaperinfo,tcourse where ptitle like '%" + ptitle+"%'  and  tpaperinfo.cno=tcourse.cno";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		List<Tpaperinfo> paperinfo=new ArrayList<Tpaperinfo>();
		while(rs.next()){
			Tpaperinfo p=new Tpaperinfo();
			p.setPid(rs.getInt("pid"));
			p.setCno(rs.getString("cno"));
			p.setCname(rs.getString("cname"));
			p.setTno(rs.getString("tno"));
			p.setPtitle(rs.getString("ptitle"));
			p.setCtime(rs.getDate("ctime"));
			p.setScore(rs.getInt("score"));
			if(rs.getString("pstate").equals("1")){
			p.setPstate("已出完");}else{
				p.setPstate("未出完");
			}
		    paperinfo.add(p);
		}
		return paperinfo;
	}
	
	
	
	
	
	
	
	
public void addtest(Tpaperinfo tp) throws SQLException{
		String sql="insert into tpaperinfo values(?,?,?,?,?,?,?)";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, tp.getPid());
		ps.setString(2,tp.getTno());
		ps.setString(3, tp.getCno());
		ps.setDate(4, new java.sql.Date(tp.getCtime().getTime()));
		ps.setString(5, tp.getPtitle());
		ps.setString(6, tp.getPstate());
		ps.setInt(7, tp.getScore());
		ps.executeUpdate();
		
		
		
	}
	
	
	
	
public void addqu(int kid,int qid) throws SQLException{
		String sql="insert into tqk values (seq_id.nextval,?,?)";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,kid);
		ps.setInt(2, qid);
		ps.executeUpdate();
	}
	

	public List<Tqt> queryqtid()throws Exception {
		List<Tqt>tqt=null;
		String sql="select * from tqt";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			 tqt= new ArrayList<Tqt>(20);
			while (rs.next()) {
			Tqt tq=new Tqt();
				tq.setQtid(rs.getInt("qtid"));
				tq.setQtname(rs.getString("qtname"));
		        tq.setIssubject(rs.getInt("issubject"));
		        tqt.add(tq);
	}
		}
		return tqt;
	}
	public List<Tknowledge>  queryallknowledge()throws Exception{
		List<Tknowledge> knowledge = null;
		String sql = "select *  from tknowledge k, tcourse where k.cno=tcourse.cno ";
		openConnection();
		PreparedStatement ps =conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			knowledge = new ArrayList<Tknowledge>(50);
			while(rs.next()){
				Tknowledge know = new Tknowledge();
				know.setKid(rs.getInt("kid"));
				know.setCno(rs.getString("cno"));
				know.setKname(rs.getString("kname"));
				know.setCname(rs.getString("cname"));
				knowledge.add(know);
			}
		}
		return knowledge;
	}
	
	public List<Tquestion> queryallquestion()throws Exception{
		List<Tquestion> ques =null;
		String sql="select *  from tquestion t , tqt where t.qtid=tqt.qtid ";
		openConnection();	
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs!=null){
		ques=new ArrayList<Tquestion>(50);  
		while(rs.next()){
			Tquestion qu=new Tquestion();
			qu.setQid(rs.getInt("qid"));
			qu.setQtid(rs.getInt("qtid"));
			qu.setQtname(rs.getString("qtname"));
			qu.setQcont(rs.getString("qcont"));
			qu.setQans(rs.getString("qans"));
			qu.setQexp(rs.getString("qexp"));
			qu.setQurl(rs.getString("qurl"));
			qu.setIspastdue(rs.getInt("ispastdue"));
			ques.add(qu);	
		
		}
		}
		return ques;
		}
	
	
	/**
	 * 添加试题
	 */
	public void addquestion(Tquestion question)throws Exception {
		String sql="insert into tquestion values(?,?,?,?,?,?,?)";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,question.getQid());
		ps.setInt(2,question.getQtid());
		ps.setString(3, question.getQcont());
		ps.setString(4, question.getQans());
		ps.setString(5, question.getQexp());
		ps.setString(6, question.getQurl());
		ps.setInt(7,question.getIspastdue());
		ps.executeUpdate();
	}
	/**
	 *根据qtid查询和关键字查询试题
	 */
	public List<Tquestion> queryquestion(int qtid, String qcont)throws Exception{
		List<Tquestion>ques=null;
		String sql="select *  from tquestion t , tqt where t.qtid='"+qtid+"'and t.qtid=tqt.qtid ";
		if(qcont != null && !qcont.equals("")){
			sql += " and qcont like '%" + qcont +"%'";
		}
		openConnection();	
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs!=null){
		ques=new ArrayList<Tquestion>(20);  
		while(rs.next()){
			Tquestion qu=new Tquestion();
			qu.setQid(rs.getInt("qid"));
			qu.setQtid(rs.getInt("qtid"));
			qu.setQtname(rs.getString("qtname"));
			qu.setQcont(rs.getString("qcont"));
			qu.setQans(rs.getString("qans"));
			qu.setQexp(rs.getString("qexp"));
			qu.setQurl(rs.getString("qurl"));
			qu.setIspastdue(rs.getInt("ispastdue"));
		ques.add(qu);	
		
		}
		}
		return ques;
		}
	/**
	 * 添加知识点
	 * @param kno
	 * @throws Exception
	 */
	public void addknowledge(Tknowledge kno)throws Exception{
		String sql="insert into tknowledge values(?,?,?)";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,kno.getKid());
		ps.setString(2,kno.getCno());
		ps.setString(3, kno.getKname());
		ps.executeUpdate();
		
	}
	/**
	 * 查询课程
	 */
	public List<Tcourse> querycno()throws Exception {
		List<Tcourse> course = null;
		String sql="select * from tcourse ";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			 course= new ArrayList<Tcourse>(20);
			while (rs.next()) {
				Tcourse cour=new Tcourse();
				cour.setCno(rs.getString("cno"));
				cour.setCname(rs.getString("cname"));
				course.add(cour);
	}
		}
		return course;
	}
	
	public List<Tknowledge> queryknowledge(String cno ,String kname)throws Exception{
		List<Tknowledge> knowledge = null;
		String sql="select * from tknowledge where cno='"+cno+"' ";
		if(kname != null && !kname.equals("")){
			sql += " and kname like '%" + kname +"%'";
		}
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			 knowledge= new ArrayList<Tknowledge>();
			while (rs.next()) {
				Tknowledge know=new Tknowledge();
				know.setKid(rs.getInt("kid"));
				know.setCno(rs.getString("cno"));
				know.setKname(rs.getString("kname"));
				knowledge.add(know);
	}
		}	
		return knowledge;	
	}
	
	public List<Tknowledge> queryknowledges(String cno)throws Exception{
		List<Tknowledge> knowledge = null;
		String sql="select * from tknowledge where cno='"+cno+"' ";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			 knowledge= new ArrayList<Tknowledge>();
			while (rs.next()) {
				Tknowledge know=new Tknowledge();
				know.setKid(rs.getInt("kid"));
				know.setCno(rs.getString("cno"));
				know.setKname(rs.getString("kname"));
				knowledge.add(know);
	}
		}	
		return knowledge;	
	}
	
	public Tknowledge queryknowledge1(int kid)throws Exception{
		Tknowledge know= null;
		String sql="select * from tknowledge where kid=? ";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,kid);
		ResultSet rs = ps.executeQuery();	 
			while (rs.next()) {
				know=new Tknowledge();
				know.setKid(rs.getInt("kid"));
				know.setCno(rs.getString("cno"));
				know.setKname(rs.getString("kname"));	
	}	
		return know;	
	}
	
	public Tquestion queryques1(int qid) throws Exception{
		Tquestion ques =null;
		String sql ="select * from tquestion where qid=?";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,qid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			ques = new Tquestion();
			ques.setQid(rs.getInt("qid"));
			ques.setQtid(rs.getInt("qtid"));
			ques.setQcont(rs.getString("qcont"));
			ques.setQans(rs.getString("qans"));
			ques.setQexp(rs.getString("qexp"));
			ques.setQurl(rs.getString("qurl"));
			ques.setIspastdue(rs.getInt("ispastdue"));	
		}
		return ques;
	}
	public void editquestion(Tquestion question) throws Exception{
		
		String sql ="update tquestion set qtid=? ,qcont=? , qans=? ,qexp=? ,qurl=? , ispastdue=? where qid=?";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
	
		 
		ps.setInt(1, question.getQtid());
		ps.setString(2, question.getQcont());
		ps.setString(3, question.getQans());
		ps.setString(4, question.getQexp());
		ps.setString(5, question.getQurl());
		ps.setInt(6, question.getIspastdue());
		ps.setInt(7, question.getQid());
		ps.executeUpdate();
	}
	public void editknowledge(Tknowledge knowledge) throws SQLException{
		String sql="update tknowledge set cno=? ,kname =?  where  kid=?";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,knowledge.getCno());
		ps.setString(2, knowledge.getKname());
		ps.setInt(3, knowledge.getKid());
		ps.executeUpdate();

	}

	public void removeknowledge(int kid) throws SQLException{
		String sql = "delete from tknowledge where kid = ? ";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,kid);
		ps.executeUpdate();
	}
	public void removequestion(int qid) throws SQLException{
		String sql = "delete from tquestion where qid = ? ";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,qid);
		ps.executeUpdate();
	}
	
	}
