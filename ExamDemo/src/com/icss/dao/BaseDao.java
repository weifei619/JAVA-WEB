package com.icss.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.icss.util.Log;
import com.icss.util.ReadDataBaseFile;
//import javax.naming.InitialContext;
//import javax.sql.DataSource;



public class BaseDao {
	//protected static final String JNDI_NAME = "";
	protected Connection conn;

	public Connection getConn() {
		openConnection();
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

//	public void openConnection(String jndiName) {
//		try {
//			if (conn == null || conn.isClosed()) {
//				InitialContext context = new InitialContext(); 
//				DataSource ds = (DataSource)context.lookup(jndiName);
//				conn = ds.getConnection();	
//			}
//		} catch (SQLException e) {
//			Log.logger.error(e.getMessage());
//		} catch (Exception e){
//			Log.logger.error(e.getMessage());
//		}
//
//	}

	public void openConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				ReadDataBaseFile base = ReadDataBaseFile.newInstance();
				Class.forName(base.getDriver()); // 检查驱动是否存在
				conn = DriverManager.getConnection(base.getUrl(),
						base.getUser(), base.getPwd()); // url,账号名, 密码
			}
		} catch (ClassNotFoundException e) {
			Log.logger.error(e.getMessage());
		} catch (SQLException e) {
			Log.logger.error(e.getMessage());
		}
	}

	public void closeConnection() {
		try {
			if (conn != null || !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			Log.logger.error(e.getMessage());
		}
	}

	public void autoCommit() throws Exception {
		openConnection();
		conn.setAutoCommit(false);
	}

	public void commit() throws Exception {
		if (conn != null || !conn.isClosed()) {
			conn.commit();
		}
	}

	public void rollback() {
		try {
			if (conn != null || !conn.isClosed()) {
				conn.rollback();
			}
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	/*
	 * 分页算法
	 */
	protected ResultSet executeQuery(String strSql, int iStart, int iEnd)
			throws Exception {
		String sql = "select * from (select rownum rw,td.* from (" + strSql
				+ ") td) w where w.rw >=" + iStart + " and w.rw <=" + iEnd;
		PreparedStatement ps = conn.prepareStatement(sql);
		return ps.executeQuery();
	}

	/**
	 * 总记录数
	 */
	protected int queryCount(String strSql) throws Exception {
		int RecordAllCount = 0;
		String sql = "select count(*) as allcount from (" + strSql + ")";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			RecordAllCount = rs.getInt("allcount");
		}

		return RecordAllCount;

	}

}
