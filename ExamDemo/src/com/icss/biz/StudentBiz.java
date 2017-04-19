package com.icss.biz;

import java.sql.SQLException;
import java.util.List;

import com.icss.dao.StudentDao;
import com.icss.entity.Taccount;
import com.icss.entity.Tpaperinfo;

import com.icss.entity.Tstuansinfo;
import com.icss.entity.Tstudent;
import com.icss.exception.ObjectNullException;
import com.icss.util.Log;

public class StudentBiz {
	public int querypids( String sno) throws SQLException{
		int examid=0;
		StudentDao dao=new StudentDao();
		try{
			examid=dao.querypids(sno);
		} catch (SQLException e) {
			Log.logger.error(e.getMessage());
			throw e;
		}

		finally {
			dao.closeConnection();
		}


		return examid;
	}
	
	
	
public int querypid( String sno,int examid) throws SQLException{
	int pid=0;
	StudentDao dao=new StudentDao();
	try{
		pid=dao.querypid(sno,examid);
	} catch (SQLException e) {
		Log.logger.error(e.getMessage());
		throw e;
	}

	finally {
		dao.closeConnection();
	}


	return pid;
}
	
	
	
public List<Tstuansinfo> querypapers(String sno) throws SQLException{
	List<Tstuansinfo>  t=null;
	StudentDao dao=new StudentDao();
	try{
		t=dao.querypapers(sno);
	} catch (SQLException e) {
		Log.logger.error(e.getMessage());
		throw e;
	}

	finally {
		dao.closeConnection();
	}


	
	return t;
}	
	
	
	
	
public List<Tstuansinfo> querypaper(String sno) throws SQLException{
	List<Tstuansinfo>  t=null;
	StudentDao dao=new StudentDao();
	try{
		t=dao.querypaper(sno);
	} catch (SQLException e) {
		Log.logger.error(e.getMessage());
		throw e;
	}

	finally {
		dao.closeConnection();
	}


	
	return t;
}	
	
	
	
	
	
	public void addtstuansinfo(int examid,String sno) throws Exception{
		StudentDao dao=new StudentDao();
		try{
			dao.addtstuansinfo(examid, sno);
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
			throw e;
		}

		finally {
			dao.closeConnection();
		}
	
	
	
	}
	
	public void addts(int pid,int qid,String an) throws Exception{
		StudentDao dao=new StudentDao();
		try{
			dao.addts(pid, qid, an);
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
			throw e;
		}

		finally {
			dao.closeConnection();
		}
		
		
	}
	
	public Taccount checkaccount(String account) throws Exception {
		Taccount a=null;
		StudentDao dao = new StudentDao();
		try{
		a=dao.checkaccount(account);
	} catch (Exception e) {
		Log.logger.error(e.getMessage());
		throw e;
	}

	finally {
		dao.closeConnection();
	}
		return a;
	}

	
	
	public Tstudent  checkstudent(String sno) throws ObjectNullException, Exception{
		Tstudent student=null;
		StudentDao dao=new StudentDao();
		try{
		  student=dao.checkstudent(sno);
			}catch(Exception e){
			Log.logger.error(e.getMessage());
			throw e ;

	}finally{
		dao.closeConnection();
		
	}
		return student;
	}
	

	
	public void editstudent(Tstudent student) throws Exception{
		StudentDao dao=new StudentDao();
		try {
			dao.editstudent(student);
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
			throw e;
		}

		finally {
			dao.closeConnection();
		}
	}
	
	public boolean checkAccount(String sno) throws Exception{
		boolean bRet=false;
		StudentDao dao=new StudentDao();
		bRet=dao.checkAccount(sno);
		dao.closeConnection();
		return bRet;
	}
	public boolean checkAccount1(String sno,String pw) throws Exception{
		boolean bRet=false;
		StudentDao dao=new StudentDao();
		bRet=dao.checkAccount1(sno,pw);
		dao.closeConnection();
		return bRet;
	}
	
	public void eidtpwd(String sno ,String password) throws Exception{
		StudentDao dao = new StudentDao();
		try{
		dao.eidtpwd(sno, password);
		}catch(Exception e){
			Log.logger.error(e.getMessage());
			
		}finally{
			dao.closeConnection();
		}
		
	}
	public List<Tpaperinfo> queryallpaper() throws SQLException{
		List	<Tpaperinfo> paper=null;
		StudentDao dao=new StudentDao();
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
	
	public int queryscore(String  sno , int sansid) throws Exception {
		
	        int score=0;
		 StudentDao dao = new StudentDao();
		 try{
		score=dao.queryscore(sno, sansid);
		 }catch(Exception e){
			 Log.logger.error(e.getMessage());
		 }finally{
			 dao.closeConnection();
		 }
		
		
		return score;
	}
	

}
