package com.ner.service;

import java.util.List;

import com.ner.bean.Manager;

public interface ManagerService {
	Manager findByName(String managerName);

	int getCount();

	void updateManager(Manager manager);

	List<Manager> selectAllManagers();

	void addManager(Manager manager);

	void deleteManager(String managerName);
}
