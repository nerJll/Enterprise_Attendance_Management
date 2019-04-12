package com.ner.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ner.bean.LoginLogoutLog;
import com.ner.dao.LoginLogoutLogDao;

@Repository("LoginLogoutLogDao")
public class LoginLogoutLogDaoImpl extends SqlSessionDaoSupport implements LoginLogoutLogDao {

	private final static String SQLMAPPERPATH = "com.ner.bean.LoginLogoutLog.";

	@Autowired
	public void SqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public void addLoginLog(LoginLogoutLog loginLogoutLog) {
		getSqlSession().insert(SQLMAPPERPATH + "addLoginLog", loginLogoutLog);
	}

	@Override
	public void addLogoutLog(LoginLogoutLog loginLogoutLog) {
		getSqlSession().update(SQLMAPPERPATH + "addLogoutLog", loginLogoutLog);
	}

	@Override
	public List<LoginLogoutLog> selectLoginoutByEmidDate(LoginLogoutLog loginLogoutLog) {
		return getSqlSession().selectList(SQLMAPPERPATH + "selectLoginoutByEmidDate", loginLogoutLog);
	}

}
