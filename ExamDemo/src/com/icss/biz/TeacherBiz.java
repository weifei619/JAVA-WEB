package com.icss.biz;

import java.sql.SQLException;
import java.util.List;

import com.icss.dao.TeacherDao;
import com.icss.entity.Tcourse;
import com.icss.entity.Texam;
import com.icss.entity.Tknowledge;
import com.icss.entity.Tpaperinfo;
import com.icss.entity.Tpaperties;
import com.icss.entity.Tqk;
import com.icss.entity.Tqt;
import com.icss.entity.Tquestion;
import com.icss.entity.Tstuanscom;
import com.icss.util.Log;
public class TeacherBiz {
	
public boolean check(String tno,int examid) throws SQLException{
 boolean bRet=false;
	TeacherDao dao=new TeacherDao();
	try {
		bRet=dao.check(tno,examid);
		
		} catch (SQLException e) {
			Log.logger.error(e.getMessage());
			throw e;
		}finally{
			dao.closeConnection();
		}
	return bRet;
}	
	
	
	
public List<Texam> queryexam() throws SQLException{
	List<Texam> exam=null;
	TeacherDao dao=new TeacherDao();
	try {
		exam=dao.queryexam();
		
		} catch (SQLException e) {
			Log.logger.error(e.getMessage());
			throw e;
		}finally{
			dao.closeConnection();
		}
	
	return exam;
}
	
	
	
	
	/*移除知识点题目关联*/
	public void removekq(int kid,int qid) throws SQLException{
		TeacherDao dao=new TeacherDao();
		try {
			dao.removekq(kid, qid);
			
			} catch (SQLException e) {
				Log.logger.error(e.getMessage());
				throw e;
			}finally{
				dao.closeConnection();
			}
		
		
		
		
	}
	
	
	
public void addscore(String sno,int pid,int score) throws SQLException{
	TeacherDao dao=new TeacherDao();
	try {
		dao.addscore(sno, pid, score);
		
		} catch (SQLException e) {
			Log.logger.error(e.getMessage());
			throw e;
		}finally{
			dao.closeConnection();
		}
	
	
	
	
	
}	
	
	
	
public void editscore(String a, int b ,int c) throws SQLException{
		TeacherDao dao=new TeacherDao();
		try {
			dao.editscore(a, b, c);
			
			} catch (SQLException e) {
				Log.logger.error(e.getMessage());
				throw e;
			}finally{
				dao.closeConnection();
			}
		
		
		
	}
	
	
public List<Tstuanscom> querytst(int examid) throws SQLException{
	List<Tstuanscom> tst=null;
	TeacherDao dao=new TeacherDao();
	try {
		tst=dao.querytst(examid);
		
		} catch (SQLException e) {
			Log.logger.error(e.getMessage());
			throw e;
		}finally{
			dao.closeConnection();
		}
	
	return tst;
}
	
	public List<Tpaperinfo> querypaper() throws SQLException{
		List<Tpaperinfo> paperinfo=null;
		TeacherDao dao=new TeacherDao();
		try {
		paperinfo=dao.querypaper();
		
		} catch (SQLException e) {
			Log.logger.error(e.getMessage());
			throw e;
		}finally{
			dao.closeConnection();
		}
		return paperinfo;
	}
		
		
	
	
	
	
	/*试卷分数
	 * */
	public int queryallscore(int pid) throws SQLException{
		int score=0;
		TeacherDao dao=new TeacherDao();
		try {
			score=dao.queryallscore(pid);
		} catch (SQLException e) {
			Log.logger.error(e.getMessage());
			throw e;
		}finally{
			dao.closeConnection();
		}
		return score;
	}
	
	
	/*
	 * 刪除试卷中的题目
	 * */
	public void removepaper(int qid) throws SQLException{
		TeacherDao dao=new TeacherDao();
		try {
			dao.removepaper(qid);
		} catch (SQLException e) {
			Log.logger.error(e.getMessage());
			throw e;
		}finally{
			dao.closeConnection();
		}
	
		
	}
	/*
	 * 查看試卷中的題目
	 * */
	public List<Tpaperties> queryQ(int pid) throws SQLException{
		List<Tpaperties> paperties=null;
		TeacherDao dao=new TeacherDao();
		try{
			paperties=dao.queryQ(pid);
		}catch (SQLException e) {
			Log.logger.error(e.getMessage());
			throw e;
		}finally{
			dao.closeConnection();
		}
	
		
		return paperties;
	}
	
	
	/*
	 * 試卷中添加題目
	 * */
	public void addpaper(Tpaperties tp) throws SQLException,Exception{
		TeacherDao dao=new TeacherDao();
		
			try {
				dao.addpaper(tp);
			} catch (SQLException e) {
				Log.logger.error(e.getMessage());
				throw e;
			}finally{
				dao.closeConnection();
			}
		
		
		
		
	}
	
	/*
	 * 编辑试卷信息
	 * */
	public void updatetest(Tpaperinfo paperinfo) throws SQLException{
		TeacherDao dao=new TeacherDao();
		try{
		dao.updatetest(paperinfo);
		}catch(SQLException e){
			Log.logger.error(e.getMessage());
			throw e;
				
		}finally{
			dao.closeConnection();
		}
	}	
		/*删除试卷
		 * */
		public  void removepaperinfo(int pid) throws SQLException{
	TeacherDao dao=new TeacherDao();
	try{
	dao.removepaperinfo(pid);
	}catch(SQLException e){
		Log.logger.error(e.getMessage());
		throw e;
			
	}finally{
		dao.closeConnection();
	}
			
		}
		
	
	
	
	
	/*
	 * ID查询试卷
	 * */
	public Tpaperinfo querypaperinfos(int pid) throws SQLException{
		Tpaperinfo paperinfo=null;
		TeacherDao dao=new TeacherDao();
		try{
		paperinfo=dao.querypaperinfos(pid);
		}catch(SQLException e){
			Log.logger.error(e.getMessage());
			throw e;
				
		}finally{
			dao.closeConnection();
		}
		
		return paperinfo;
	}
	/*所有试卷
	 * */
	public List<Tpaperinfo> queryallpaper() throws SQLException{
	List	<Tpaperinfo> paper=null;
	TeacherDao dao=new TeacherDao();
	try{
	paper=dao.queryallpaper();
	}catch(SQLException e){
		Log.logger.error(e.getMessage());
		throw e;
			
	}finally{
		dao.closeConnection();
	}
	
	return paper;
		
		
		
	}
	/*
	 * 知识点详情
	 * */
	public List<Tqk> querytqk(int kid) throws SQLException{
		List<Tqk> tqk=null;
		TeacherDao dao=new TeacherDao();
		try {
			tqk=dao.querytqk(kid);
		} catch (SQLException e) {
			Log.logger.error(e.getMessage());
			throw e;
			
		}finally{
			dao.closeConnection();
		}
		return tqk;
	}
	
	
	
	/**
	 * 移除关系
	 * @throws SQLException 
	 * */
	public void removetqk(int qid) throws SQLException{
		TeacherDao dao=new TeacherDao();
		try {
			dao.removetqk(qid);
		} catch (SQLException e) {
			Log.logger.error(e.getMessage());
			throw e;
			
		}finally{
			dao.closeConnection();
		}
		
		
	}
	
	/*
	 * 查询试题
	 * */
	public List<Tquestion> querytq(String kid,String qtid) throws Exception{
		List<Tquestion> question=null;
		TeacherDao dao=new TeacherDao();
		try{
		question=dao.queryq(kid, qtid);
	}
	catch(Exception e){
		Log.logger.error(e.getMessage());
		throw e;
	}
	finally{
		
		dao.closeConnection();
	}

		
		
		
	
		
		return question;
	}
	
	
	
	/**
	 * 查询试卷
	 * @throws Exception 
	 * 
	 * */
	public List<Tpaperinfo> querypaperinfo(String ptitle) throws Exception{
		List<Tpaperinfo> paperinfo=null;
		TeacherDao dao=new TeacherDao();
		try{
		paperinfo=dao.querypaperinfo(ptitle);
	}
	catch(Exception e){
		Log.logger.error(e.getMessage());
		throw e;
	}
	finally{
		
		dao.closeConnection();
	}

		
		
		
		return paperinfo;
	}
	
	
	
	
	
	/**
	 * 添加试卷
	 * @throws Exception 
	 * **/
	public void addtest(Tpaperinfo tp) throws Exception{
		TeacherDao dao=new TeacherDao();
		try{
		dao.addtest(tp);
		}
			catch(Exception e){
				Log.logger.error(e.getMessage());
				throw e;
			}
			finally{
				
				dao.closeConnection();
			}
		
		
		
		
	}
	
	/**
	 * 向知识点中添加题目
	 * @throws Exception 
	 * 
	 * */
	public void addqu(int kid,int qid) throws Exception{
		TeacherDao dao=new TeacherDao();
		try{
		dao.addqu(kid, qid);
		}
			catch(Exception e){
				Log.logger.error(e.getMessage());
				throw e;
			}
			finally{
				
				dao.closeConnection();
			}
		
		
	}
	
	
	
	/**
	 * 查题型id 题型名
	 */
	public List<Tqt> queryqtid()throws Exception {
		List<Tqt>tqt=null;
		TeacherDao dao=new TeacherDao();
		try{
		tqt=dao.queryqtid();
		}
		catch(Exception e){
			Log.logger.error(e.getMessage());
			throw e;
		}
		finally{
			
			dao.closeConnection();
		}
		return tqt;	
	}
	public List<Tknowledge>  queryknowledge(String cno ,String kname)throws Exception{
		List<Tknowledge> knowledge =null;
		TeacherDao dao = new TeacherDao();
		try{
			knowledge = dao.queryknowledge(cno , kname);
		}catch(Exception e){
			Log.logger.error(e.getMessage());
			throw e;
		}finally{
			dao.closeConnection();
		}
		return knowledge;
	}
	public List<Tknowledge>  queryknowledges(String cno )throws Exception{
		List<Tknowledge> knowledge =null;
		TeacherDao dao = new TeacherDao();
		try{
			knowledge = dao.queryknowledges(cno);
		}catch(Exception e){
			Log.logger.error(e.getMessage());
			throw e;
		}finally{
			dao.closeConnection();
		}
		return knowledge;
	}

	
	
	public Tknowledge  queryknowledge1(int kid)throws Exception{
		Tknowledge knowledge =null;
		TeacherDao dao = new TeacherDao();
		try{
			knowledge = dao.queryknowledge1(kid);
		}catch(Exception e){
			Log.logger.error(e.getMessage());
			throw e;
		}finally{
			dao.closeConnection();
		}
		return knowledge;
	}
	
	
	public Tquestion queryques1(int qid) throws Exception{
		Tquestion ques =null;
		TeacherDao dao = new TeacherDao();
		try{
			ques = dao.queryques1(qid);
		}catch(Exception e ){
			Log.logger.error(e.getMessage());
			throw e ;
		}finally{
			dao.closeConnection();
		}
		return ques;
	}
	
	
	public List<Tknowledge>  queryallknowledge()throws Exception{
		List<Tknowledge> knowledge =null;
		TeacherDao dao = new TeacherDao();
		try{
			knowledge = dao.queryallknowledge();
		}catch(Exception e){
			Log.logger.error(e.getMessage());
			throw e;
		}finally{
			dao.closeConnection();
		}
		return knowledge;
	}
	
	public List<Tquestion> queryallquestion()throws Exception{
		List<Tquestion> ques =null;
		TeacherDao dao = new TeacherDao();
		try{
			ques = dao.queryallquestion();
		}catch(Exception e){
			Log.logger.error(e.getMessage());
		}finally{
			dao.closeConnection();
		}
		
		return ques;
	}
	
	
	
public List<Tquestion> queryquestion(int qid , String qcont)throws Exception{
	List<Tquestion> q=null;
	TeacherDao dao=new TeacherDao();
	try {
		q=dao.queryquestion(qid, qcont);
	} catch (SQLException e) {
		Log.logger.error(e.getMessage());
		throw e;
	}finally{
		dao.closeConnection();
	}
	
return q;	
}


public void addknowledge(Tknowledge kno)throws Exception{
	TeacherDao dao = new TeacherDao();
	try{
	dao.addknowledge(kno);
	}catch(Exception e ){
		Log.logger.error(e.getMessage());
		
	}finally{
		dao.closeConnection();
	}
	
}
public void addquestion(Tquestion question)throws Exception {
	TeacherDao dao = new TeacherDao();
	try{
	dao.addquestion(question);
	}catch(Exception e ){
		Log.logger.error(e.getMessage());
		
	}finally{
		dao.closeConnection();
	}
	
}


public List<Tcourse> querycno()throws Exception {
	List<Tcourse> course = null;
	TeacherDao dao=new TeacherDao();
	try{
	course=dao.querycno();
	}
	catch(Exception e){
		Log.logger.error(e.getMessage());
		throw e;
	}
	finally{
		
		dao.closeConnection();
	}
	return course;	
}

public void editknowledge(Tknowledge knowledge) throws Exception{
	TeacherDao dao = new TeacherDao();
	try{
	dao.editknowledge(knowledge);
	}catch(Exception e){
		Log.logger.error(e.getMessage());
		throw e;
	}finally{
		dao.closeConnection();
	}
}

public void editquestion(Tquestion question) throws Exception{
	TeacherDao dao = new TeacherDao();
	try{
		dao.editquestion(question);
	}catch(Exception e ){
		Log.logger.error(e.getMessage());
		throw e;
	}finally{
		dao.closeConnection();
	}
	
	
}

public void removeknowledge(int kid) throws SQLException{
	TeacherDao dao = new TeacherDao();
	
	try {
		dao.removeknowledge(kid);
	} catch (SQLException e) {
		throw e;
		
	}finally{
		dao.closeConnection();
	}

}

public void removequestion(int qid) throws SQLException{
	TeacherDao dao = new TeacherDao();
	try{
	dao.removequestion(qid);
	}catch(SQLException e ){
		Log.logger.error(e.getMessage());
		throw e;
	}finally{
		dao.closeConnection();
	}
	
}
}
