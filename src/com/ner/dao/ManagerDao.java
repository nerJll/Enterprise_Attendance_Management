package com.ner.dao;

import java.util.List;

import com.ner.bean.Manager;

public interface ManagerDao {
	Manager findByName(String managerName);

	int getCount();
	
	void updateManager(Manager manager);
	
	List<Manager> selectAllManagers();
	
	void addManager(Manager manager);
	
	void deleteManager(String managerName);
}
