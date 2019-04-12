package com.ner.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ner.bean.Manager;
import com.ner.dao.ManagerDao;

@Repository("ManagerDao")
public class ManagerDaoImpl extends SqlSessionDaoSupport implements ManagerDao {

	private final static String SQLMAPPERPATH = "com.ner.bean.ManagerMapper.";
	
	@Autowired
	public void SqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public Manager findByName(String managerName) {
		return getSqlSession().selectOne(SQLMAPPERPATH + "findByName", managerName);
	}

	@Override
	public int getCount() {
		return (Integer) getSqlSession().selectOne(SQLMAPPERPATH + "getCount");
	}

	@Override
	public void updateManager(Manager manager) {
		getSqlSession().update(SQLMAPPERPATH + "updateManager", manager);
	}

	@Override
	public List<Manager> selectAllManagers() {
		return getSqlSession().selectList(SQLMAPPERPATH + "selectAllManagers");
	}

	@Override
	public void addManager(Manager manager) {
		getSqlSession().insert(SQLMAPPERPATH + "addManager",manager);
	}

	@Override
	public void deleteManager(String managerName) {
		getSqlSession().delete(SQLMAPPERPATH + "deleteManager",managerName);
	}

}
