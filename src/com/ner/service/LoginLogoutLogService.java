package com.ner.service;

import java.util.List;

import com.ner.bean.LoginLogoutLog;

public interface LoginLogoutLogService {
	void addLoginLog(LoginLogoutLog loginLogoutLog);

	void addLogoutLog(LoginLogoutLog loginLogoutLog);

	List<LoginLogoutLog> selectLoginoutByEmidDate(LoginLogoutLog loginLogoutLog);
}
