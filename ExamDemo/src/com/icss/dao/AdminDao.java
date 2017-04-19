package com.icss.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.icss.entity.Taccount;
import com.icss.entity.Tclass;
import com.icss.entity.Texam;
import com.icss.entity.Tnotice;
import com.icss.entity.Tpaperinfo;
import com.icss.entity.Tstudent;
import com.icss.entity.Tteacher;
import com.icss.entity.TurnPage;
import com.icss.exception.ObjectNullException;

public class AdminDao extends BaseDao{
	
public void changeischeck(int examid) throws SQLException{
	String sql="update tstuansinfo set state=3 where examid=?";	
	openConnection();
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setInt(1,examid);
	ps.executeUpdate();
	
		
	}
	
	
	
	
public List<Tpaperinfo> querypaper() throws SQLException{
	List<Tpaperinfo> paperinfo=new ArrayList<Tpaperinfo>();
	String sql="select * from tpaperinfo where pstate=1";	
	openConnection();
	PreparedStatement ps = conn.prepareStatement(sql);
  ResultSet rs=ps.executeQuery();
  while(rs.next()){
	  Tpaperinfo tp=new Tpaperinfo();
	  tp.setPid(rs.getInt("pid"));
	  tp.setPtitle(rs.getString("ptitle"));
	  paperinfo.add(tp);
	  
	  
  }
		
		
		return paperinfo;
	}
	
	
	
	public void addtm(int examid,String tno) throws SQLException{
		String sql="insert into tmarkperm values(seq_id.nextval,?,?)";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, examid);
		ps.setString(2, tno);
		ps.executeQuery();
		
	}
	
	public List<Texam> querycorrect() throws SQLException{
		List<Texam> exam=null;
	String sql="select pid, examid��examtitle  from texam where ischeck=2 and examstate=3";
	openConnection();
	PreparedStatement ps = conn.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	exam=new ArrayList<Texam>();
	while(rs.next()){
		Texam e=new Texam();
		e.setExamtitle(rs.getString("examtitle"));
		e.setPid(rs.getInt("pid"));
		e.setExamid(rs.getInt("examid"));
		exam.add(e);
	}
	return exam;
	}
	
	public void removeplan(int examid) throws SQLException{
	String sql="delete texam where examid=?";
	openConnection();
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setInt(1, examid);
	ps.executeUpdate();
	
	
	}
	
	
	public Texam queryexam(int examid)throws SQLException{
		Texam ex=null;
		String sql="select *  from texam where examid =?";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, examid);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			 ex=new Texam();
			ex.setPid(rs.getInt("pid"));
			ex.setExamid(rs.getInt("examid"));
			ex.setStime(rs.getDate("stime"));
			ex.setEtime(rs.getDate("etime"));
			ex.setExamstate(rs.getString("examstate"));
			ex.setExamtitle(rs.getString("examtitle"));
			ex.setExamtype(rs.getString("examtype"));
			ex.setIscheck(rs.getString("ischeck"));
			
		
		
		}
		return ex;
	}
	
	public List<Texam> queryallexam()throws SQLException{
		List<Texam> exam=null;
		String sql="select *  from texam";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		exam=new ArrayList<Texam>();
		while(rs.next()){
			Texam ex=new Texam();
			ex.setPid(rs.getInt("pid"));
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
	
	public void editexamplan(Texam exam) throws SQLException{
		String sql="update  texam set stime=?,etime=?, examtitle=?,examtype=?,ischeck=?, examstate=? where pid=? and examid=?";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setDate(1,  new java.sql.Date(exam.getStime().getTime()));
		ps.setDate(2,  new java.sql.Date(exam.getEtime().getTime()));
		ps.setString(3, exam.getExamtitle());
		ps.setString(4, exam.getExamtype());
		ps.setString(5, exam.getIscheck());
		ps.setString(6, exam.getExamstate());
		ps.setInt(7,exam.getPid());
		ps.setInt(8, exam.getExamid());
		ps.executeQuery();
		
		
	}
	
	
	
	public void addexamplan(Texam exam) throws SQLException{
		String sql="insert into texam values(seq_id.nextval,?,?,?,?,?,?,?)";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,exam.getPid());
		ps.setDate(2,  new java.sql.Date(exam.getStime().getTime()));
		ps.setDate(3,  new java.sql.Date(exam.getEtime().getTime()));
		ps.setString(4, exam.getExamtitle());
		ps.setString(5, exam.getExamtype());
		ps.setString(6, exam.getIscheck());
		ps.setString(7, exam.getExamstate());
		ps.executeQuery();
		
		
	}
	
	
	
	public void addnotice(Tnotice notice) throws SQLException{
		String sql="insert into tnotice values(?,?,?,?)";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, notice.getNid());
		ps.setString(2, notice.getAcc_id());
		ps.setString(3, notice.getNcont());
		ps.setDate(4,  new java.sql.Date(notice.getTime().getTime()));
		ps.executeUpdate();
	}
	
	public void removenotice(int nid) throws Exception{
		String sql="delete from tnotice where nid=?";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, nid);
		ps.executeUpdate();
		
		
	}
	
	public void updatenotice(Tnotice notice) throws SQLException{
		String sql="update  tnotice set ncont=?  where nid=?";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, notice.getNcont());
		ps.setInt(2, notice.getNid());
		ps.executeUpdate();
		
		
		
		
	}
	
	
	
	
	
public Tnotice querynotices(int nid) throws SQLException{
		Tnotice notice=null;
		String sql="select * from tnotice where nid='"+nid+"'";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			notice=new Tnotice();
		notice.setNid(nid);
		notice.setAcc_id(rs.getString("acc_id"));
		notice.setNcont(rs.getString("ncont"));
		notice.setTime(rs.getDate("ctime"));
		}
	return notice;
}
	
	
	
	public  List<Tstudent> queryInfo(TurnPage tp) throws Exception {
		List<Tstudent> s=null;
		String sql="select * from tstudent";
		openConnection();
		tp.RecordAllCount = queryCount(sql);
		tp.PageAllCount = (tp.RecordAllCount-1)/tp.PageCount +1;
		int iEnd = tp.CurrentPageNo * tp.PageCount;
		int iStart = (tp.CurrentPageNo-1) * tp.PageCount + 1;
		ResultSet rs = this.executeQuery(sql, iStart, iEnd);
		s = new ArrayList<Tstudent>();
		while(rs.next())
		{
		Tstudent	student=new Tstudent();
		student.setSno(rs.getString("sno"));
		student.setClassno(rs.getString("classno"));
		student.setSaddress(rs.getString("saddress"));
		student.setSage(rs.getInt("sage"));
		student.setScontact(rs.getString("scontact"));
		student.setSemail(rs.getString("semail"));
		student.setSname(rs.getString("sname"));
		student.setSschool(rs.getString("sschool"));
		student.setSgrade(rs.getString("sgrade"));
		if(rs.getInt("sgender")==1){
		student.setSgender("��");}else{
		student.setSgender("Ů");}
		s.add(student);
			
		}
		
		return s;
	}
	
	public boolean checkAccount(String sno) throws Exception {
		boolean bRet = false;
		String sql = "select uno from taccount where uno='" + sno + "'";
		openConnection();	
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			bRet = true;
			break;
		}
		
		return bRet;
	}
	
	public void editaccount(Taccount account) throws SQLException{
		String sql="update taccount set password=? where  uno=?";
		openConnection( );
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,account.getPassword());
		ps.setString(2, account.getUno());
		ps.executeUpdate();

	}
	
	public void editstudent(Tstudent student) throws SQLException{
		String sql="update tstudent set  classno=? , sname=? ,sgender=?, sage=? ,scontact=? ,semail=? ,saddress=? ,sschool=?, sgrade=?  where  sno=?";
		openConnection( );
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,student.getClassno());
		ps.setString(2,student.getSname());
		ps.setString(3,student.getSgender());
		ps.setInt(4,student.getSage());
		ps.setString(5,student.getScontact());
		ps.setString(6,student.getSemail());
		ps.setString(7,student.getSaddress());
		ps.setString(8,student.getSschool());
		ps.setString(9,student.getSgrade());
		ps.setString(10,student.getSno());
		ps.executeUpdate();

	}
	
	public void editteacher(Tteacher teacher) throws Exception{
		String sql = "update tteacher set  tname=? , tgender=? ,tcontact=? , temail=? ,ison=? where tno=?";
		openConnection();
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setString(1,teacher.getTname());
		ps.setString(2,teacher.getTgender());
		ps.setString(3,teacher.getTcontact());
		ps.setString(4,teacher.getTemail());
		ps.setString(5,teacher.getIson());
		ps.setString(6,teacher.getTno());
		ps.executeUpdate();
		
	}
	
	public void editclass(Tclass cla) throws Exception{
		String sql = "update  tclass set classname=? , isgraduate=? where classno=?";
		openConnection();
		PreparedStatement ps =conn.prepareStatement(sql);
		ps.setString(1,cla.getClassname());
		ps.setString(2,cla.getIsgraduate());
		ps.setString(3,cla.getClassno());
		ps.executeUpdate();
		
		
	}
	

	
	public Taccount checkaccount(String account) throws SQLException{
		Taccount a=null;
		String sql="select *from taccount where uno=?";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,account);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			a=new Taccount();
			a.setUno(account);
			a.setPassword(rs.getString("password"));
			a.setRole(rs.getInt("role"));
			
		}
		
		
		
		return a;	
	}
	
	
	
	public Tstudent checkstudent(String sno) throws SQLException{
		Tstudent student=null;
		String sql="select * from tstudent where sno=?";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,sno);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			student=new Tstudent();
			student.setSno(rs.getString("sno"));
			student.setClassno(rs.getString("classno"));
			student.setSaddress(rs.getString("saddress"));
			student.setSage(rs.getInt("sage"));
			student.setScontact(rs.getString("scontact"));
			student.setSemail(rs.getString("semail"));
			student.setSname(rs.getString("sname"));
			student.setSschool(rs.getString("sschool"));
			student.setSgrade(rs.getString("sgrade"));
			if(rs.getInt("sgender")==1){
			student.setSgender("��");}else{
			student.setSgender("Ů");}
		}
		return student;
	}
	
	public Tteacher  checkteacher(String tno) throws ObjectNullException, Exception{
		Tteacher teacher = null;
		String sql = "select * from tteacher where tno=?";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,tno);
		
		ResultSet rs =ps.executeQuery();
		while(rs.next()){
			teacher = new Tteacher();
			teacher.setTno(rs.getString("tno"));
			teacher.setTname(rs.getString("tname"));
			teacher.setTgender(rs.getString("tgender"));
			teacher.setTemail(rs.getString("temail"));
			teacher.setTcontact(rs.getString("tcontact"));
			teacher.setIson(rs.getString("ison"));
			if(rs.getInt("tgender")==1){
				teacher.setTgender("��");
			}else{
				teacher.setTgender("Ů");
			}
			if(rs.getInt("ison")==1){
				teacher.setIson("��");
			}else{
				teacher.setIson("��");
			}			
		}
		return teacher;
	}
	
	public Tclass  checkclass(String classno) throws ObjectNullException, Exception{
		Tclass cla = null;
		String sql = "select * from tclass where classno=?";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,classno);
		
		ResultSet rs =ps.executeQuery();
		while(rs.next()){
			cla = new Tclass();
			cla.setClassno(rs.getString("classno"));
			cla.setClassname(rs.getString("classname"));
			if(rs.getInt("isgraduate")==1){
				cla.setIsgraduate("��");
			}else{
				cla.setIsgraduate("��");
			}
		
		}
		return cla;
	}
	
	
	/**
	 * ɾ���˻�
	 * @throws Exception 
	 */
	public void deleteaccount(String uno) throws Exception{
		String sql = "delete from taccount where uno = ? ";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,uno);
		ps.executeUpdate();
		
	}
	/**
	 * ɾ��ѧ����Ϣ
	 * @param sno
	 * @throws Exception 
	 */
	public void deletestudent(String sno) throws Exception{
		String sql = "delete from tstudent where sno = ?";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,sno);
		ps.executeUpdate();
	}
	
	/**
	 * ��ݱ��ɾ����ʦ
	 * @return
	 * @throws SQLException
	 */
	public void deleteteacher(String tno) throws Exception{
		String sql = "delete from tteacher where tno = ?";
		openConnection();
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,tno);
		ps.executeUpdate();
		
	}
	
	public void deleteclass(String classno) throws Exception{
		String sql = "delete from tclass where classno = ? ";
		openConnection();
		PreparedStatement ps  = conn.prepareStatement(sql);
		ps.setString(1, classno);
		ps.executeUpdate();
		
	}
	
	
	
	public List<Tstudent> queryallstudent() throws SQLException{
		List<Tstudent> s=null;
		String sql="select * from tstudent";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		s = new ArrayList<Tstudent>(50);
		while(rs.next())
		{
		Tstudent	student=new Tstudent();
		student.setSno(rs.getString("sno"));
		student.setClassno(rs.getString("classno"));
		student.setSaddress(rs.getString("saddress"));
		student.setSage(rs.getInt("sage"));
		student.setScontact(rs.getString("scontact"));
		student.setSemail(rs.getString("semail"));
		student.setSname(rs.getString("sname"));
		student.setSschool(rs.getString("sschool"));
		student.setSgrade(rs.getString("sgrade"));
		if(rs.getInt("sgender")==1){
		student.setSgender("��");}else{
		student.setSgender("Ů");}
		s.add(student);
			
		}
		
		return s;
	}
	
	public List<Tteacher> queryallteacher() throws SQLException{
		List<Tteacher> t = null;
		String sql="select * from tteacher";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		t = new ArrayList<Tteacher>(50);
		while(rs.next()){
			Tteacher teacher = new Tteacher();
			teacher.setTno(rs.getString("tno"));
			teacher.setTname(rs.getString("tname"));
			teacher.setTcontact(rs.getString("tcontact"));
			teacher.setTemail(rs.getString("temail"));
			if(rs.getInt("tgender")==1){
				teacher.setTgender("��");
			}else{
				teacher.setTgender("Ů");
			}
			if(rs.getInt("ison")==1){
				teacher.setIson("��");
			}else{
				teacher.setIson("��");
			}
			t.add(teacher);
			
		}
		return t;
	}
	
	
	public List<Tclass> queryallclass() throws Exception{
		List<Tclass> c =null;
		String sql = "select * from tclass";
		openConnection();
		
		PreparedStatement  ps =conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		c = new ArrayList<Tclass>(40);
		while(rs.next()){
			Tclass cla = new Tclass();
			cla.setClassno(rs.getString("classno"));
			cla.setClassname(rs.getString("classname"));
			if(rs.getInt("isgraduate")  == 1){
				cla.setIsgraduate("�ѱ�ҵ");
				
			}else{
				cla.setIsgraduate("δ��ҵ");
			}
			c.add(cla);
			
		}
		
		return c;
	}
	
	
	
	public List<Tnotice> querynotice(Date bDate, Date eDate) throws SQLException{
		 List<Tnotice> notice=null;
		String sql="select *  from tnotice";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(bDate != null){
			sql += " where ctime>=to_date('" + sdf.format(bDate) + "','yyyy-mm-dd')";
		}
		if(eDate != null){
			sql += " and ctime<=to_date('" + sdf.format(eDate) + "','yyyy-mm-dd')";
		}
		openConnection();	
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
		notice=new ArrayList<Tnotice>();
		while(rs.next()){
			Tnotice n=new Tnotice();
			n.setNid(rs.getInt("nid"));
			n.setAcc_id(rs.getString("acc_id"));
			n.setNcont(rs.getString("ncont"));
			n.setTime(rs.getDate("ctime"));
			notice.add(n);
		}
		
		return notice;
	}
	public List<Tnotice> queryallnotice() throws SQLException{
		 List<Tnotice> notice=null;
		String sql="select *  from tnotice";
		openConnection();	
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
		notice=new ArrayList<Tnotice>(50);
		while(rs.next()){
			Tnotice n=new Tnotice();
			n.setNid(rs.getInt("nid"));
			n.setAcc_id(rs.getString("acc_id"));
			n.setNcont(rs.getString("ncont"));
			n.setTime(rs.getDate("ctime"));
			notice.add(n);
		}
		
		return notice;
	}
	

	
	
	public void addaccount(Taccount account) throws SQLException{
		String sql="insert into taccount values(?,?,?)";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, account.getUno());
		ps.setString(2,account.getPassword());
		ps.setInt(3,account.getRole());
		ps.executeUpdate();
		
	}
	
	public void classadd(Tclass cla)  throws Exception{
		String sql = "insert into tclass values(?,?,?)";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, cla.getClassno());
		ps.setString(2,cla.getClassname());
		ps.setString(3, cla.getIsgraduate());
		ps.executeUpdate();
		
	}
	public void teacheradd(Tteacher tea) throws Exception{
		String sql = "insert into tteacher values(?,?,?,?,?,?)";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, tea.getTno());
		ps.setString(2, tea.getTname());
		ps.setString(3, tea.getTgender());
		ps.setString(4, tea.getTcontact());
		ps.setString(5, tea.getTemail());
		ps.setString(6, tea.getIson());
		ps.executeUpdate();
		
	}
	
	
	public void studentadd(Tstudent stu) throws Exception{
		String sql = "insert into tstudent values(?,?,?,?,?,?,?,?,?,?)";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, stu.getSno());
		ps.setString(2, stu.getClassno());
		ps.setString(3, stu.getSname());
		ps.setString(4, stu.getSgender());
		ps.setInt(5, stu.getSage());
		ps.setString(6, stu.getScontact());
		ps.setString(7, stu.getSemail());
		ps.setString(8, stu.getSaddress());
		ps.setString(9, stu.getSschool());
		ps.setString(10, stu.getSgrade());
		ps.executeUpdate();
	}
	
	
	
	
	
}
