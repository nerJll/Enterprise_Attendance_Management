package com.ner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ner.bean.LoginLogoutLog;
import com.ner.dao.LoginLogoutLogDao;
import com.ner.service.LoginLogoutLogService;

@Service("LoginLogoutLogService")
public class LoginLogoutLogServiceImpl implements LoginLogoutLogService {

	@Autowired
	private LoginLogoutLogDao loginLogoutLogDao;

	@Override
	public void addLoginLog(LoginLogoutLog loginLogoutLog) {
		loginLogoutLogDao.addLoginLog(loginLogoutLog);
	}

	@Override
	public void addLogoutLog(LoginLogoutLog loginLogoutLog) {
		loginLogoutLogDao.addLogoutLog(loginLogoutLog);
	}

	@Override
	public List<LoginLogoutLog> selectLoginoutByEmidDate(LoginLogoutLog loginLogoutLog) {
		return loginLogoutLogDao.selectLoginoutByEmidDate(loginLogoutLog);
	}

}
