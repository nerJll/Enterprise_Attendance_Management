package com.ner.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ner.bean.Employee;
import com.ner.bean.Manager;
import com.ner.dao.ManagerDao;
import com.ner.service.EmployeeService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ManagerDao managerDao;

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// 添加员工
	@RequestMapping("/toAddEmployee.do")
	public String toAddEmployee() {
		return "add_employee";
	}

	@RequestMapping("/addEmployee.do")
	public String addEmployee(@RequestParam("id") int em_id, @RequestParam("name") String em_name,
			@RequestParam("sex") String em_sex, @RequestParam("birthday") String em_birthday,
			@RequestParam("entryday") String em_entryday, @RequestParam("department") String em_department,
			@RequestParam("classid") String em_classid, @RequestParam("title") String em_title,
			@RequestParam("account") String em_account, @RequestParam("password") String em_password,
			HttpSession session) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date em_birthday_ch = sdf.parse(em_birthday);
		Date em_entryday_ch = sdf.parse(em_entryday);
		Employee employee = new Employee(em_id, em_name, em_sex, em_birthday_ch, em_entryday_ch, em_department,
				em_classid, em_title, em_account, em_password);
		if (employeeService.selectEmployeeById(em_id) != null) {
			session.setAttribute("add_employee_error", "工号已存在");
			return "forward:/manager/toAddEmployee.do";
		} else {
			employeeService.addEmployee(employee);
			session.setAttribute("success", "添加");
			session.removeAttribute("add_employee_error");
			return "success";
		}
	}

	// 查看所有员工
	@RequestMapping("/toSelectAllEmployees.do")
	public String toSelectAllEmployees(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
			HttpSession session) throws ParseException {
		/*
		 * List<Employee> employees = employeeService.selectAllEmployee();
		 * session.setAttribute("employees", employees); return
		 * "select_all_employees";
		 */
		session.setAttribute("pagemsg", employeeService.findByPage(currentPage));// 回显分页数据
		return "select_all_employees";

	}

	// 删除员工
	@RequestMapping("/toDeleteEmployee.do")
	public String deleteEmployee(@RequestParam("em_id") int em_id, HttpSession session) {
		employeeService.deleteEmployee(em_id);
		session.setAttribute("success", "删除");
		return "forward:/manager/toSelectAllEmployees.do";
	}

	// 修改员工信息
	@RequestMapping("/toUpdateEmployee.do")
	public String toUpdateEmployee(@RequestParam("em_id") int em_id, HttpSession session) {
		Employee employee = employeeService.selectEmployeeById(em_id);
		session.setAttribute("beforeUpdate_Employee", employee);
		return "update_employee";
	}

	@RequestMapping("/updateEmployee.do")
	public String updateEmployee(@RequestParam("id") int em_id, @RequestParam("name") String em_name,
			@RequestParam("sex") String em_sex, @RequestParam("birthday") String em_birthday,
			@RequestParam("entryday") String em_entryday, @RequestParam("department") String em_department,
			@RequestParam("classid") String em_classid, @RequestParam("title") String em_title,
			@RequestParam("account") String em_account, @RequestParam("password") String em_password,
			HttpSession session) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date em_birthday_ch = sdf.parse(em_birthday);
		Date em_entryday_ch = sdf.parse(em_entryday);
		Employee employee = new Employee(em_id, em_name, em_sex, em_birthday_ch, em_entryday_ch, em_department,
				em_classid, em_title, em_account, em_password);
		employeeService.updateEmployee(employee);
		session.setAttribute("success", "修改");
		return "success";
	}

	// 查找员工
	@RequestMapping("/toSelectEmployee.do")
	public String toSelectEmployee() {
		return "select_employee";
	}

	@RequestMapping("/selectEmployee.do")
	public String selectEmployee(@RequestParam("id") int em_id, HttpSession session) {
		Employee employee = employeeService.selectEmployeeById(em_id);
		if (employee == null) {
			session.setAttribute("select_employee_error", "工号不存在");
			return "forward:/manager/toSelectEmployee.do";
		} else {
			session.setAttribute("select_employee", employee);
			session.removeAttribute("select_employee_error");
			return "select_employee_success";
		}
	}

	// 修改密码
	@RequestMapping("/toUpdatePassword.do")
	public String toUpdatePassword() {
		return "manager_update_password";
	}

	@RequestMapping("/updatePassword.do")
	public String updatePassword(@RequestParam("name") String managerName,
			@RequestParam("password0") String managerPassword0, @RequestParam("password1") String managerPassword1,
			HttpSession session) {
		Manager manager = managerDao.findByName(managerName);
		if (managerPassword0.equals(manager.getManagerPassword())) {
			manager.setManagerPassword(managerPassword1);
			managerDao.updateManager(manager);
			session.setAttribute("success", "修改");
			session.removeAttribute("update_password_error");
			return "success";
		} else {
			session.setAttribute("update_password_error", "原密码错误");
			return "forward:/manager/toUpdatePassword.do";
		}
	}

	// 查找所有管理员
	@RequestMapping("/toSelectAllManagers.do")
	public String toSelectAllManagers(HttpSession session) {
		List<Manager> managers = managerDao.selectAllManagers();
		session.setAttribute("managers", managers);
		return "select_all_managers";
	}

	// 删除管理员
	@RequestMapping("/toDeleteManager.do")
	public String toDeleteManager(@RequestParam("managerName") String managerName, HttpSession session) {
		managerDao.deleteManager(managerName);
		return "forward:/manager/toSelectAllManagers.do";
	}

	// 添加管理员
	@RequestMapping("/toAddManager.do")
	public String toAddManager() {
		return "add_manager";
	}

	@RequestMapping("/addManager.do")
	public String addManager(@RequestParam("name") String managerName, @RequestParam("password") String managerPassword,
			HttpSession session) {
		Manager manager = new Manager(managerName, managerPassword);
		if (managerDao.findByName(managerName) != null) {
			session.setAttribute("add_manager_error", "账号已存在");
			return "forward:/manager/toAddManager.do";
		} else {
			managerDao.addManager(manager);
			session.setAttribute("success", "添加");
			session.removeAttribute("add_manager_error");
			return "success";
		}
	}

	// 查找管理员
	@RequestMapping("/toSelectManager.do")
	public String toSelectManager() {
		return "select_manager";
	}

	@RequestMapping("/selectManager.do")
	public String selectManager(@RequestParam("name") String managerName, HttpSession session) {
		Manager manager = managerDao.findByName(managerName);
		if (manager == null) {
			session.setAttribute("select_manager_error", "账号不存在");
			return "forward:/manager/toSelectManager.do";
		} else {
			session.removeAttribute("select_manager_error");
			session.setAttribute("select_manager", manager);
			return "select_manager_success";
		}
	}
}
