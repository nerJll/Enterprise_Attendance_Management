package com.ner.bean;

public class Manager {
	private String managerName;
	private String managerPassword;

	public String getManagerName() {
		return managerName;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(String managerName, String managerPassword) {
		super();
		this.managerName = managerName;
		this.managerPassword = managerPassword;
	}

	@Override
	public String toString() {
		return "Manager [managerName=" + managerName + ", managerPassword=" + managerPassword + "]";
	}

}
