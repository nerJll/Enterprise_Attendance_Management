package com.ner.dao;

import java.util.List;
import java.util.Map;

import com.ner.bean.Employee;

public interface EmployeeDao {
	void addEmployee(Employee employee);

	void deleteEmployee(int em_id);

	void updateEmployee(Employee employee);

	Employee selectEmployeeById(int em_id);

	List<Employee> selectAllEmployee();

	Employee selectEmployeeByAccount(String em_account);

	List<Employee> findByPage(Map<String, Object> map);
	
	int selectCount();
}
