package com.ner.bean;

import java.util.Date;

public class Employee {

	private int em_id;
	private String em_name;
	private String em_sex;
	private Date em_birthday;
	private Date em_entryday;
	private String em_department;
	private String em_classid;
	private String em_title;
	private String em_account;
	private String em_password;

	public String getEm_classid() {
		return em_classid;
	}

	public void setEm_classid(String em_classid) {
		this.em_classid = em_classid;
	}

	public int getEm_id() {
		return em_id;
	}

	public String getEm_name() {
		return em_name;
	}

	public String getEm_sex() {
		return em_sex;
	}

	public Date getEm_birthday() {
		return em_birthday;
	}

	public Date getEm_entryday() {
		return em_entryday;
	}

	public String getEm_department() {
		return em_department;
	}

	public String getEm_title() {
		return em_title;
	}

	public String getEm_account() {
		return em_account;
	}

	public String getEm_password() {
		return em_password;
	}

	public void setEm_id(int em_id) {
		this.em_id = em_id;
	}

	public void setEm_name(String em_name) {
		this.em_name = em_name;
	}

	public void setEm_sex(String em_sex) {
		this.em_sex = em_sex;
	}

	public void setEm_birthday(Date em_birthday) {
		this.em_birthday = em_birthday;
	}

	public void setEm_entryday(Date em_entryday) {
		this.em_entryday = em_entryday;
	}

	public void setEm_department(String em_department) {
		this.em_department = em_department;
	}

	public void setEm_title(String em_title) {
		this.em_title = em_title;
	}

	public void setEm_account(String em_account) {
		this.em_account = em_account;
	}

	public void setEm_password(String em_password) {
		this.em_password = em_password;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int em_id, String em_name, String em_sex, Date em_birthday, Date em_entryday, String em_department,
			String em_classid, String em_title, String em_account, String em_password) {
		super();
		this.em_id = em_id;
		this.em_name = em_name;
		this.em_sex = em_sex;
		this.em_birthday = em_birthday;
		this.em_entryday = em_entryday;
		this.em_department = em_department;
		this.em_classid = em_classid;
		this.em_title = em_title;
		this.em_account = em_account;
		this.em_password = em_password;
	}

	@Override
	public String toString() {
		return "Employee [em_id=" + em_id + ", em_name=" + em_name + ", em_sex=" + em_sex + ", em_birthday="
				+ em_birthday + ", em_entryday=" + em_entryday + ", em_department=" + em_department + ", em_classid="
				+ em_classid + ", em_title=" + em_title + ", em_account=" + em_account + ", em_password=" + em_password
				+ "]";
	}

}
