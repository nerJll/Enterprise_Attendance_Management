package com.ner.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ner.bean.Employee;
import com.ner.bean.LoginLogoutLog;
import com.ner.bean.Manager;
import com.ner.service.EmployeeService;
import com.ner.service.LoginLogoutLogService;
import com.ner.service.ManagerService;

@Controller
@RequestMapping("/log")
public class LoginAndLongoutController {
	@Autowired
	private ManagerService managerService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private LoginLogoutLogService loginLogoutLogService;

	// 登陆
	@RequestMapping("/login.do")
	public String login(@RequestParam("name") String name, @RequestParam("password") String password,
			@RequestParam("user_type") String user_type, HttpSession session) throws ParseException {
		if (user_type.equals("manager")) { // 管理员
			Manager manager = managerService.findByName(name);
			if (manager != null) {
				if (manager.getManagerPassword().equals(password)) {
					session.setAttribute("manager", manager);
					session.removeAttribute("login_error");
					return "manager_page";
				} else {
					session.setAttribute("login_error", "密码错误");
					return "forward:/";
				}
			} else {
				session.setAttribute("login_error", "用户名不存在");
				return "forward:/";
			}
		} else {
			Employee employee = employeeService.selectEmployeeByAccount(name);
			if (employee != null) {
				if (employee.getEm_password().equals(password)) {
					session.removeAttribute("login_error");

					// 登陆切面
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date lo_logintime = sdf.parse(sdf.format(new Date()));
					LoginLogoutLog loginLogoutLog = new LoginLogoutLog();
					loginLogoutLog.setLo_emid(employee.getEm_id());
					loginLogoutLog.setLo_emname(employee.getEm_name());
					loginLogoutLog.setLo_logintime(lo_logintime);
					loginLogoutLog.setLo_emdep(employee.getEm_department());
					loginLogoutLog.setLe_emclassid(employee.getEm_classid());
					loginLogoutLogService.addLoginLog(loginLogoutLog);
					session.setAttribute("loginLogoutLog", loginLogoutLog);

					session.setAttribute("employee", employee);

					if ((employee.getEm_id() / 10000) == 1) { // 领导
						return "leader_page";
					} else if ((employee.getEm_id() / 10000) == 2) { // 班长
						return "monitor_page";
					} else { // 员工
						return "employee_page";
					}
				} else {
					session.setAttribute("login_error", "密码错误");
					return "forward:/";
				}
			} else {
				session.setAttribute("login_error", "用户名不存在");
				return "forward:/";
			}
		}
	}

	// 退出
	@RequestMapping(value = "/logout.do")
	public String logout(HttpSession session, ModelMap map) throws ParseException {
		try {
			// 登出切面
			LoginLogoutLog loginLogoutLog = (LoginLogoutLog) session.getAttribute("loginLogoutLog");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date lo_logouttime = sdf.parse(sdf.format(new Date()));
			loginLogoutLog.setLo_logouttime(lo_logouttime);
			loginLogoutLogService.addLogoutLog(loginLogoutLog);
		} catch (Exception e) {
		}
		session.invalidate();
		return "redirect:/";
	}
}
