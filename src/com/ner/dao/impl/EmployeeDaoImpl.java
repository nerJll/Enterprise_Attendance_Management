package com.ner.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ner.bean.Employee;
import com.ner.dao.EmployeeDao;

@Repository("EmployeeDao")
public class EmployeeDaoImpl extends SqlSessionDaoSupport implements EmployeeDao {

	private final static String SQLMAPPERPATH = "com.ner.bean.EmployeeMapper.";

	@Autowired
	public void SqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public void addEmployee(Employee employee) {
		getSqlSession().insert(SQLMAPPERPATH + "addEmployee", employee);
	}

	@Override
	public void deleteEmployee(int em_id) {
		getSqlSession().delete(SQLMAPPERPATH + "deleteEmployee", em_id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		getSqlSession().update(SQLMAPPERPATH + "updateEmployee", employee);
	}

	@Override
	public Employee selectEmployeeById(int em_id) {
		return getSqlSession().selectOne(SQLMAPPERPATH + "selectEmployeeById", em_id);
	}

	@Override
	public List<Employee> selectAllEmployee() {
		return getSqlSession().selectList(SQLMAPPERPATH + "selectAllEmployee");
	}

	@Override
	public Employee selectEmployeeByAccount(String em_account) {
		return getSqlSession().selectOne(SQLMAPPERPATH + "selectEmployeeByAccount", em_account);
	}

	@Override
	public List<Employee> findByPage(Map<String, Object> map) {
		return getSqlSession().selectList(SQLMAPPERPATH + "findByPage", map);
	}

	@Override
	public int selectCount() {
		return (Integer) getSqlSession().selectOne(SQLMAPPERPATH + "selectCount");
	}

}
