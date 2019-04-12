package com.ner.service;

import java.util.List;

import com.ner.bean.Employee;
import com.ner.utils.PageUtils;

public interface EmployeeService {
	void addEmployee(Employee employee);

	void deleteEmployee(int em_id);

	void updateEmployee(Employee employee);

	Employee selectEmployeeById(int em_id);

	List<Employee> selectAllEmployee();

	Employee selectEmployeeByAccount(String em_account);

	int selectCount();
	
	PageUtils<Employee> findByPage(int currentPage);
}
