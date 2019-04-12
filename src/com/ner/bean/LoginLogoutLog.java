package com.ner.bean;

import java.util.Date;

public class LoginLogoutLog {
	private int lo_id;
	private int lo_emid;
	private String lo_emname;
	private Date lo_logintime;
	private Date lo_logouttime;
	private String lo_emdep;
	private String le_emclassid;

	public int getLo_id() {
		return lo_id;
	}

	public void setLo_id(int lo_id) {
		this.lo_id = lo_id;
	}

	public int getLo_emid() {
		return lo_emid;
	}

	public String getLo_emname() {
		return lo_emname;
	}

	public Date getLo_logintime() {
		return lo_logintime;
	}

	public Date getLo_logouttime() {
		return lo_logouttime;
	}

	public String getLo_emdep() {
		return lo_emdep;
	}

	public String getLe_emclassid() {
		return le_emclassid;
	}

	public void setLo_emid(int lo_emid) {
		this.lo_emid = lo_emid;
	}

	public void setLo_emname(String lo_emname) {
		this.lo_emname = lo_emname;
	}

	public void setLo_logintime(Date lo_logintime) {
		this.lo_logintime = lo_logintime;
	}

	public void setLo_logouttime(Date lo_logouttime) {
		this.lo_logouttime = lo_logouttime;
	}

	public void setLo_emdep(String lo_emdep) {
		this.lo_emdep = lo_emdep;
	}

	public void setLe_emclassid(String le_emclassid) {
		this.le_emclassid = le_emclassid;
	}

	@Override
	public String toString() {
		return "LoginLogoutLog [lo_emid=" + lo_emid + ", lo_emname=" + lo_emname + ", lo_logintime=" + lo_logintime
				+ ", lo_logouttime=" + lo_logouttime + ", lo_emdep=" + lo_emdep + ", le_emclassid=" + le_emclassid
				+ "]";
	}

	public LoginLogoutLog() {
		// TODO Auto-generated constructor stub
	}

	public LoginLogoutLog(int lo_emid, String lo_emname, Date lo_logintime, Date lo_logouttime, String lo_emdep,
			String le_emclassid) {
		super();
		this.lo_emid = lo_emid;
		this.lo_emname = lo_emname;
		this.lo_logintime = lo_logintime;
		this.lo_logouttime = lo_logouttime;
		this.lo_emdep = lo_emdep;
		this.le_emclassid = le_emclassid;
	}

}
