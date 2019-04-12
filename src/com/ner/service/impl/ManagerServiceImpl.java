package com.ner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ner.bean.Manager;
import com.ner.dao.ManagerDao;
import com.ner.service.ManagerService;

@Service("ManagerService")
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private ManagerDao managerDao;

	@Override
	public Manager findByName(String managerName) {
		return managerDao.findByName(managerName);
	}

	@Override
	public int getCount() {
		return managerDao.getCount();
	}

	@Override
	public void updateManager(Manager manager) {
		managerDao.updateManager(manager);
	}

	@Override
	public List<Manager> selectAllManagers() {
		return managerDao.selectAllManagers();
	}

	@Override
	public void addManager(Manager manager) {
		managerDao.addManager(manager);
	}

	@Override
	public void deleteManager(String managerName) {
		managerDao.deleteManager(managerName);
	}

}
