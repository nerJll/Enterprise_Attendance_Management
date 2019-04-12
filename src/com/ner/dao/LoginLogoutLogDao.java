package com.ner.dao;

import java.util.List;

import com.ner.bean.LoginLogoutLog;

public interface LoginLogoutLogDao {
	void addLoginLog(LoginLogoutLog loginLogoutLog);

	void addLogoutLog(LoginLogoutLog loginLogoutLog);

	List<LoginLogoutLog> selectLoginoutByEmidDate(LoginLogoutLog loginLogoutLog);
}
