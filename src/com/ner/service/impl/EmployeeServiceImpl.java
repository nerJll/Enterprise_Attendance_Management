package com.ner.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ner.bean.Employee;
import com.ner.dao.EmployeeDao;
import com.ner.service.EmployeeService;
import com.ner.utils.PageUtils;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	@Override
	public void deleteEmployee(int em_id) {
		employeeDao.deleteEmployee(em_id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Override
	public Employee selectEmployeeById(int em_id) {
		return employeeDao.selectEmployeeById(em_id);
	}

	@Override
	public List<Employee> selectAllEmployee() {
		return employeeDao.selectAllEmployee();
	}

	@Override
	public Employee selectEmployeeByAccount(String em_account) {
		return employeeDao.selectEmployeeByAccount(em_account);
	}

	@Override
	public int selectCount() {
		return employeeDao.selectCount();
	}

	@Override
	public PageUtils<Employee> findByPage(int currentPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageUtils<Employee> pageUtils = new PageUtils<Employee>();

		// 封装当前页数
		pageUtils.setCurrPage(currentPage);

		// 每页显示的数据
		int pageSize = 5;
		pageUtils.setPageSize(pageSize);

		// 封装总记录数
		int totalCount = employeeDao.selectCount();
		pageUtils.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageUtils.setTotalPage(num.intValue());

		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageUtils.getPageSize());
		// 封装每页显示的数据
		List<Employee> lists = employeeDao.findByPage(map);
		pageUtils.setLists(lists);

		return pageUtils;
	}

}
