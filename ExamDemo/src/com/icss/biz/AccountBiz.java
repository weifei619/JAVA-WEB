package com.icss.biz;

import com.icss.dao.TaccountDao;
import com.icss.entity.Taccount;
import com.icss.exception.ObjectNullException;
import com.icss.util.Log;

public class AccountBiz {
  public  Taccount  login(String account,String pwd,String role) throws ObjectNullException,Exception{
	  Taccount a=null;
		if (account != null && !account.equals("") && pwd != null
				&& !pwd.equals("")) {
			
			TaccountDao dao = new TaccountDao();

			try {
				a = dao.login(account, pwd,role);
			} catch (Exception e) {
				Log.logger.error(e.getMessage());
				throw e;
			} finally {
				dao.closeConnection();
			}
		}
		if(a == null){
			throw new ObjectNullException("登陆出错：用户名或密码错误");
		}
		 
	  return a;
  }
  }
