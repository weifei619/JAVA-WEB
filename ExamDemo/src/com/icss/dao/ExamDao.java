
package com.icss.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.icss.entity.Tpaperties;
public class ExamDao extends BaseDao{
	
	public List<Tpaperties> queryBychioce(int pid) throws Exception{
		List<Tpaperties>  tp= new ArrayList<Tpaperties>(50);
		String sql = "select * from tpaperties tp,tquestion tq where tp.pid=? and tq.qtid=1 and tq.qid=tp.qid";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, pid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Tpaperties t=new Tpaperties();
			t.setQid(rs.getInt("qid"));
			t.setQcont(rs.getString("qcont"));
			t.setScore(rs.getInt("score"));
			t.setSeq(rs.getInt("seq"));
			tp.add(t);		
		}
			rs.close();
			ps.close();
		return tp;
	}
	
	public List<Tpaperties> queryBycompletion(int pid) throws Exception{
		List<Tpaperties>  tp= new ArrayList<Tpaperties>(50);
		String sql = "select * from tpaperties tp,tquestion tq where tp.pid=? and tq.qtid=2 and tq.qid=tp.qid";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, pid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Tpaperties t=new Tpaperties();
			t.setQid(rs.getInt("qid"));
			t.setQcont(rs.getString("qcont"));
			t.setScore(rs.getInt("score"));
			t.setSeq(rs.getInt("seq"));
			tp.add(t);		
		}
		rs.close();
	      ps.close();
		return tp;
	}
	public List<Tpaperties> queryByjudge(int pid) throws Exception{
		List<Tpaperties>  tp= new ArrayList<Tpaperties>(50);
		String sql = "select * from tpaperties tp,tquestion tq where tp.pid=? and tq.qtid=3 and tq.qid=tp.qid";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, pid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Tpaperties t=new Tpaperties();
			t.setQid(rs.getInt("qid"));
			t.setQcont(rs.getString("qcont"));
			t.setScore(rs.getInt("score"));
			t.setSeq(rs.getInt("seq"));
			tp.add(t);		
		}
		rs.close();
	      ps.close();
		return tp;
	}
	public List<Tpaperties> queryByanswer(int pid) throws Exception{
		List<Tpaperties>  tp= new ArrayList<Tpaperties>(50);
		String sql = "select * from tpaperties tp,tquestion tq where tp.pid=? and tq.qtid=4 and tq.qid=tp.qid";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, pid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Tpaperties t=new Tpaperties();
			t.setQid(rs.getInt("qid"));
			t.setQcont(rs.getString("qcont"));
			t.setScore(rs.getInt("score"));
			t.setSeq(rs.getInt("seq"));
			tp.add(t);		
		}
		rs.close();
	      ps.close();
		return tp;
	}
	public List<Tpaperties> queryByapplication(int pid) throws Exception{
		List<Tpaperties>  tp= new ArrayList<Tpaperties>(50);
		String sql = "select * from tpaperties tp,tquestion tq where tp.pid=? and tq.qtid=5 and tq.qid=tp.qid";
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, pid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Tpaperties t=new Tpaperties();
			t.setQid(rs.getInt("qid"));
			t.setQcont(rs.getString("qcont"));
			t.setScore(rs.getInt("score"));
			t.setSeq(rs.getInt("seq"));
			tp.add(t);		
		}
		rs.close();
	      ps.close();
		return tp;
	}
	
	
	
	
}