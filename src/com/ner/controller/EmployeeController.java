package com.ner.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ner.bean.AttenCancel;
import com.ner.bean.AttenModify;
import com.ner.bean.Attendance;
import com.ner.bean.Employee;
import com.ner.bean.LoginLogoutLog;
import com.ner.dao.LoginLogoutLogDao;
import com.ner.service.AttenCancelService;
import com.ner.service.AttenModifyService;
import com.ner.service.AttendanceService;
import com.ner.service.EmployeeService;
import com.ner.utils.PageUtils;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private AttendanceService attendanceService;
	@Autowired
	private LoginLogoutLogDao loginLogoutLogDao;
	@Autowired
	private AttenModifyService attenModifyService;
	@Autowired
	private AttenCancelService attenCancelService;

	private final static String UN_STATE = "未审核";

	// 修改密码
	@RequestMapping("/toUpdatePassword.do")
	public String toUpdatePassword() {
		return "employee_update_password";
	}

	@RequestMapping("/updatePassword.do")
	public String updatePassword(@RequestParam("account") String em_account,
			@RequestParam("password0") String em_password0, @RequestParam("password1") String em_password1,
			HttpSession session) {
		Employee employee = employeeService.selectEmployeeByAccount(em_account);
		if (em_password0.equals(employee.getEm_password())) {
			employee.setEm_password(em_password1);
			employeeService.updateEmployee(employee);
			session.setAttribute("success", "修改");
			session.removeAttribute("update_password_error");
			return "success";
		} else {
			session.setAttribute("update_password_error", "原密码错误");
			return "forward:/employee/toUpdatePassword.do";
		}
	}

	// 加班申请
	@RequestMapping("/toApplyOvertime.do")
	public String toApplyOvertime() {
		return "apply_overtime";
	}

	// 请假申请
	@RequestMapping("/toApplyLeave.do")
	public String toApplyLeave() {
		return "apply_leave";
	}

	// 公休申请
	@RequestMapping("/toApplyOffDay.do")
	public String toApplyOffDay() {
		return "apply_offday";
	}

	// 补休申请
	@RequestMapping("/toApplyDefer.do")
	public String toApplyDefer() {
		return "apply_defer";
	}

	@RequestMapping("/applyLeave.do")
	public String applyOvertime(@RequestParam("id") int at_emid, @RequestParam("name") String at_emname,
			@RequestParam("content") String at_content, @RequestParam("reason") String at_reason,
			@RequestParam("beginday") String at_beginday, @RequestParam("endday") String at_endday, HttpSession session)
			throws ParseException {
		Employee employee = employeeService.selectEmployeeById(at_emid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date at_beginday_ch = sdf.parse(at_beginday);
		Date at_endday_ch = sdf.parse(at_endday);
		Date at_applyday = sdf.parse(sdf.format(new Date()));
		Attendance attendance = new Attendance(at_emid, at_emname, at_content, at_reason, at_beginday_ch, at_endday_ch,
				UN_STATE, at_applyday, employee.getEm_department(), employee.getEm_classid());
		attendanceService.addAttendance(attendance);
		session.setAttribute("success", "申请");
		return "success";
	}

	// 查看我的申请记录
	@RequestMapping("/toSelectMyApplyLog.do")
	public String toSelectMyApplyLog(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
			HttpSession session) {

		session.removeAttribute("myAttendances");

		Employee employee = (Employee) session.getAttribute("employee");

		/*
		 * List<Attendance> attendances =
		 * attendanceService.selectAttendanceByEmid(employee.getEm_id()); if
		 * (attendances.size() == 0) {
		 * session.setAttribute("select_my_attendance_error", "无申请记录"); return
		 * "select_my_attendance"; } else {
		 * session.setAttribute("myAttendances", attendances);
		 * session.removeAttribute("select_my_attendance_error"); return
		 * "select_my_attendance"; }
		 */

		PageUtils<Attendance> myAttendaces = attendanceService.findByPageByEmid(currentPage, employee.getEm_id());

		if (myAttendaces.getLists().size() == 0) {
			session.setAttribute("select_my_attendance_error", "无申请记录");
			return "select_my_attendance";
		} else {
			session.removeAttribute("select_my_attendance_error");
			session.setAttribute("pagemsg", myAttendaces);// 回显分页数据
			return "select_my_attendance";
		}
	}

	// 修改申请
	@RequestMapping("/toUpdateAttendance.do")
	public String toUpdateAttendance(@RequestParam("at_id") int at_id, HttpSession session) {
		Attendance attendance = attendanceService.selectAttendanceById(at_id);
		session.setAttribute("before_update_attendance", attendance);
		return "update_attendance";
	}

	@RequestMapping("/updateAttendance.do")
	public String updateAttendance(@RequestParam("id") int at_emid, @RequestParam("name") String at_emname,
			@RequestParam("content") String at_content, @RequestParam("reason") String at_reason,
			@RequestParam("beginday") String at_beginday, @RequestParam("endday") String at_endday, HttpSession session)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// 修改切面
		Attendance preAtten = (Attendance) session.getAttribute("before_update_attendance");
		AttenModify attenModify = new AttenModify();
		attenModify.setAtt_preid(preAtten.getAt_id());
		attenModify.setAtt_emid(preAtten.getAt_emid());
		attenModify.setAtt_berea(preAtten.getAt_reason());
		attenModify.setAtt_bebeday(preAtten.getAt_beginday());
		attenModify.setAtt_beenday(preAtten.getAt_endday());
		attenModify.setAtt_modday(sdf.parse(sdf.format(new Date())));
		attenModifyService.addAttenModify(attenModify);

		Employee employee = employeeService.selectEmployeeById(at_emid);
		Date at_beginday_ch = sdf.parse(at_beginday);
		Date at_endday_ch = sdf.parse(at_endday);
		Date at_applyday = sdf.parse(sdf.format(new Date()));
		int at_id = preAtten.getAt_id();
		Attendance attendance = new Attendance(at_id, at_emid, at_emname, at_content, at_reason, at_beginday_ch,
				at_endday_ch, UN_STATE, at_applyday, employee.getEm_department(), employee.getEm_classid());
		attendanceService.updateAttendance(attendance);
		session.removeAttribute("myDepLog");
		session.setAttribute("success", "修改");
		return "success";
	}

	// 删除记录
	@RequestMapping("/toDeleteAttendance.do")
	public String toDeleteAttendance(@RequestParam("at_id") int at_id) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// 删除切面
		Attendance beCanAtten = attendanceService.selectAttendanceById(at_id);
		AttenCancel attenCancel = new AttenCancel();
		attenCancel.setAtt_emid(beCanAtten.getAt_emid());
		attenCancel.setAtt_emname(beCanAtten.getAt_emname());
		attenCancel.setAtt_content(beCanAtten.getAt_content());
		attenCancel.setAtt_reason(beCanAtten.getAt_reason());
		attenCancel.setAtt_beginday(beCanAtten.getAt_beginday());
		attenCancel.setAtt_endday(beCanAtten.getAt_endday());
		attenCancel.setAtt_state("已取消");
		attenCancel.setAtt_applyday(beCanAtten.getAt_applyday());
		attenCancel.setAtt_cancelday(sdf.parse(sdf.format(new Date())));
		attenCancelService.addAttenCancelLog(attenCancel);

		attendanceService.deleteAttendance(at_id);
		return "forward:/employee/toSelectMyApplyLog.do";
	}

	// 查看部门今明两天考勤申请
	@RequestMapping("/toSelectMyDepLog.do")
	public String toSelectMyDepLog(HttpSession session) {

		session.removeAttribute("myDepLog");

		Employee employee = (Employee) session.getAttribute("employee");
		List<Attendance> attendances = attendanceService.selectAttendanceByDep(employee.getEm_department());
		if (attendances.size() == 0) {
			session.setAttribute("select_my_dep_log_error", "无申请记录");
			return "select_my_dep_log";
		} else {
			session.removeAttribute("select_my_dep_log_error");
			session.setAttribute("myDepLog", attendances);
			return "select_my_dep_log";
		}

	}

	// 查看班组考勤记录
	@RequestMapping("/toSelectMyClassLog.do")
	public String toSelectMyClassLog(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
			HttpSession session) {

		session.removeAttribute("myClassLog");

		Employee employee = (Employee) session.getAttribute("employee");

		/*
		 * List<Attendance> attendances =
		 * attendanceService.selectAttendanceByClassid(employee.getEm_classid())
		 * ; if (attendances.size() == 0) {
		 * session.setAttribute("select_my_class_log_error", "无申请记录"); return
		 * "select_my_class_log"; } else {
		 * session.removeAttribute("select_my_class_log_error");
		 * session.setAttribute("myClassLog", attendances); return
		 * "select_my_class_log"; }
		 */

		PageUtils<Attendance> classAttendaces = attendanceService.findByPageByClassid(currentPage,
				employee.getEm_classid());

		if (classAttendaces.getLists().size() == 0) {
			session.setAttribute("select_my_class_log_error", "无申请记录");
			return "select_my_class_log";
		} else {
			session.removeAttribute("select_my_class_log_error");
			session.setAttribute("pagemsg", classAttendaces);// 回显分页数据
			return "select_my_class_log";
		}

	}

	// 审核本班考勤记录
	@RequestMapping("/toRevieClassAtten.do")
	public String toRevieClassAtten(HttpSession session) {

		session.removeAttribute("revieMyClassLog");

		Employee employee = (Employee) session.getAttribute("employee");
		List<Attendance> attendances = attendanceService.selectClassUnRieveAttenByClassid(employee.getEm_classid());
		if (attendances.size() == 0) {
			session.setAttribute("revie_my_class_log_error", "无申请记录");
			session.removeAttribute("revieMyClassLog");
			return "revie_my_class_log";
		} else {
			session.removeAttribute("revie_my_class_log_error");
			session.setAttribute("revieMyClassLog", attendances);
			return "revie_my_class_log";
		}
	}

	@RequestMapping("/toCheckClassAtten.do")
	public String toCheckClassAtten(@RequestParam("at_id") int at_id, HttpSession session) {
		Attendance beforeRevieAttendance = attendanceService.selectAttendanceById(at_id);
		session.setAttribute("beforeRevieAttendance", beforeRevieAttendance);
		return "check_my_class_log";
	}

	// 通过
	@RequestMapping("/ReviePass.do")
	public String ReviePass(HttpSession session) {
		Attendance passAttendance = (Attendance) session.getAttribute("beforeRevieAttendance");
		passAttendance.setAt_state("通过");
		attendanceService.updateAttendance(passAttendance);
		session.removeAttribute("beforeRevieAttendance");
		return "revie_complete";
	}

	// 不通过
	@RequestMapping("/writeUnRevReason.do")
	public String writeUnRevReason(@RequestParam("at_unrevreason") String at_unrevreason, HttpSession session) {
		Attendance unPassAttendance = (Attendance) session.getAttribute("beforeRevieAttendance");
		unPassAttendance.setAt_unrevreason(at_unrevreason);
		attendanceService.updateUnRevReason(unPassAttendance);
		session.removeAttribute("beforeRevieAttendance");
		return "revie_complete";
	}

	// 查看原因
	@RequestMapping("/toSelectReason.do")
	public String toSelectReason(@RequestParam("at_id") int at_id, HttpSession session) {
		Attendance myUnrieReason = attendanceService.selectAttendanceById(at_id);
		session.setAttribute("myUnrieReason", myUnrieReason);
		return "check_my_unrie_reason";
	}

	// 查看所有考勤申请
	@RequestMapping("/toSelectAllDepLog.do")
	public String toSelectAllDepLog(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
			HttpSession session) {
		session.removeAttribute("allAttendaces");

		PageUtils<Attendance> allAttendaces = attendanceService.findByPage(currentPage);

		if (allAttendaces.getLists().size() == 0) {
			session.setAttribute("select_all_dep_log_error", "无申请记录");
			return "select_all_dep_log";
		} else {
			session.removeAttribute("select_all_dep_log_error");
			session.setAttribute("pagemsg", allAttendaces);// 回显分页数据
			return "select_all_dep_log";
		}
	}

	// 审核员工考勤
	@RequestMapping("/toRevieAllAtten.do")
	public String toRevieAllAtten(HttpSession session) {
		session.removeAttribute("revieAllDepLog");

		List<Attendance> allUnrieAtten = attendanceService.selectAllUnRieveAtten();
		if (allUnrieAtten.size() == 0) {
			session.setAttribute("revie_all_dep_log_error", "无申请记录");
			session.removeAttribute("revieAllDepLog");
			return "revie_all_dep_log";
		} else {
			session.removeAttribute("revie_all_dep_log_error");
			session.setAttribute("revieAllDepLog", allUnrieAtten);
			return "revie_all_dep_log";
		}
	}

	@RequestMapping("/toCheckAllDepAtten.do")
	public String toCheckAllDepAtten(@RequestParam("at_id") int at_id, HttpSession session) {
		Attendance beforeRevieAllAttendance = attendanceService.selectAttendanceById(at_id);
		session.setAttribute("beforeRevieAllAttendance", beforeRevieAllAttendance);
		return "check_all_dep_log";
	}

	// 通过
	@RequestMapping("/RevieAllPass.do")
	public String RevieAllPass(HttpSession session) {
		Attendance passAttendance = (Attendance) session.getAttribute("beforeRevieAllAttendance");
		passAttendance.setAt_state("通过");
		attendanceService.updateAttendance(passAttendance);
		session.removeAttribute("beforeRevieAllAttendance");
		return "revie_all_complete";
	}

	// 不通过
	@RequestMapping("/writeAllUnRevReason.do")
	public String writeAllUnRevReason(@RequestParam("at_unrevreason") String at_unrevreason, HttpSession session) {
		Attendance unPassAttendance = (Attendance) session.getAttribute("beforeRevieAllAttendance");
		unPassAttendance.setAt_unrevreason(at_unrevreason);
		attendanceService.updateUnRevReason(unPassAttendance);
		session.removeAttribute("beforeRevieAllAttendance");
		return "revie_all_complete";
	}

	// 查看班级登陆日志
	@RequestMapping("/toSelectClassLogLog.do")
	public String toSelectClassLogLog() {
		return "select_class_log_log";
	}

	@RequestMapping("/selectClassLogLog.do")
	public String selectClassLogLog(@RequestParam("id") int em_id, @RequestParam("begindate") String lo_logintime0,
			@RequestParam("enddate") String lo_logouttime0, HttpSession session) throws ParseException {
		Employee monitor = (Employee) session.getAttribute("employee");
		Employee employee = employeeService.selectEmployeeById(em_id);
		if (employee == null) {
			session.setAttribute("select_class_log_log_error", "工号不存在!");
			return "forward:/employee/toSelectClassLogLog.do";
		} else if (monitor.getEm_classid().equals(employee.getEm_classid())) {
			session.removeAttribute("select_class_log_log_error");

			//格式化前端传来的时间型数据，并去掉H5时间控件中的'T'字符
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			LoginLogoutLog loginLogoutLog = new LoginLogoutLog();
			loginLogoutLog.setLo_emid(em_id);
			String lo_logintime1 = lo_logintime0.replace("T", " ");
			String lo_logouttime1 = lo_logouttime0.replace("T", " ");
			Date logintime = sdf.parse(sdf.format(sdf.parse(lo_logintime1)));
			Date logouttime = sdf.parse(sdf.format(sdf.parse(lo_logouttime1)));

			loginLogoutLog.setLo_logintime(logintime);
			loginLogoutLog.setLo_logouttime(logouttime);

			List<LoginLogoutLog> loginLogoutLogs = loginLogoutLogDao.selectLoginoutByEmidDate(loginLogoutLog);
			if (loginLogoutLogs.size() == 0) {
				session.setAttribute("select_class_log_log_null", "该时间段内无登陆记录");
			} else {
				session.removeAttribute("select_class_log_log_null");
			}

			session.setAttribute("loginLogoutLogs", loginLogoutLogs);
			return "select_class_log_log_success";
		} else {
			session.setAttribute("select_class_log_log_error", "所查询工号非本班组员工！");
			return "forward:/employee/toSelectClassLogLog.do";
		}
	}

	// 查看班组假期申请日志
	@RequestMapping("/toSelectClassVacAppLog.do")
	public String toSelectClassVacAppLog() {
		return "select_class_vac_app_log";
	}

	@RequestMapping("/selectClassVacAppLog.do")
	public String selectClassVacAppLog(@RequestParam("id") int em_id, @RequestParam("beginday") String lo_logintime,
			@RequestParam("endday") String lo_logouttime, HttpSession session) throws ParseException {
		Employee monitor = (Employee) session.getAttribute("employee");
		Employee employee = employeeService.selectEmployeeById(em_id);
		if (employee == null) {
			session.setAttribute("select_class_vac_app_log_error", "工号不存在!");
			return "forward:/employee/toSelectClassVacAppLog.do";
		} else if (monitor.getEm_classid().equals(employee.getEm_classid())) {
			session.removeAttribute("select_class_vac_app_log_error");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Attendance attendance = new Attendance();
			attendance.setAt_emid(em_id);
			Date beginday = sdf.parse(sdf.format(sdf.parse(lo_logintime)));
			Date endday = sdf.parse(sdf.format(sdf.parse(lo_logouttime)));

			attendance.setAt_beginday(beginday);
			attendance.setAt_endday(endday);

			List<Attendance> vacAppLogAttens = attendanceService.selectVacAppLogByEmid(attendance);
			if (vacAppLogAttens.size() == 0) {
				session.setAttribute("select_class_vac_app_log_null", "该时间段内无申请记录");
			} else {
				session.removeAttribute("select_class_vac_app_log_null");
			}

			session.setAttribute("vacAppLogAttens", vacAppLogAttens);
			return "select_class_vac_app_log_success";
		} else {
			session.setAttribute("select_class_vac_app_log_error", "所查询工号非本班组员工！");
			return "forward:/employee/toSelectClassVacAppLog.do";
		}
	}

	// 查看班组假期修改日志
	@RequestMapping("/toSelectClassVacModLog.do")
	public String toSelectClassVacModLog() {
		return "select_class_vac_mod_log";
	}

	@RequestMapping("/selectClassVacModLog.do")
	public String selectClassVacModLog(@RequestParam("id") int em_id, @RequestParam("beginday") String lo_logintime,
			@RequestParam("endday") String lo_logouttime, HttpSession session) throws ParseException {
		Employee monitor = (Employee) session.getAttribute("employee");
		Employee employee = employeeService.selectEmployeeById(em_id);
		if (employee == null) {
			session.setAttribute("select_class_vac_mod_log_error", "工号不存在!");
			return "forward:/employee/toSelectClassVacModLog.do";
		} else if (monitor.getEm_classid().equals(employee.getEm_classid())) {
			session.removeAttribute("select_class_vac_mod_log_error");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			AttenModify attenModify = new AttenModify();
			attenModify.setAtt_emid(em_id);
			Date beginday = sdf.parse(sdf.format(sdf.parse(lo_logintime)));
			Date endday = sdf.parse(sdf.format(sdf.parse(lo_logouttime)));
			attenModify.setAtt_bebeday(beginday);
			attenModify.setAtt_beenday(endday);

			List<AttenModify> classAttenModifyLogs = attenModifyService.selectAttenModifyByEmidDay(attenModify);

			if (classAttenModifyLogs.size() == 0) {
				session.setAttribute("select_class_vac_mod_log_null", "该时间段内无修改记录");
			} else {
				session.removeAttribute("select_class_vac_mod_log_null");
				List<Attendance> classAftAttendances = new ArrayList<>();
				Iterator<AttenModify> iterator = classAttenModifyLogs.iterator();
				if (iterator.hasNext()) {
					int att_preid = ((AttenModify) (iterator.next())).getAtt_preid();
					Attendance aftAttendance = attendanceService.selectAttendanceById(att_preid);
					classAftAttendances.add(aftAttendance);
				}
				session.setAttribute("classAftAttendances", classAftAttendances);
			}

			return "select_class_vac_mod_log_success";
		} else {
			session.setAttribute("select_class_vac_mod_log_error", "所查询工号非本班组员工！");
			return "forward:/employee/toSelectClassVacModLog.do";
		}
	}

	@RequestMapping(value = "/toSelectPreModAtten.do", method = RequestMethod.GET)
	public String toSelectPreModAtten(@RequestParam("at_id") int att_preid, HttpSession session) {
		List<AttenModify> classPreAttendances = attenModifyService.selectAttenModifyByPreid(att_preid);
		session.setAttribute("classPreAttendances", classPreAttendances);
		return "select_class_pre_atten";
	}

	// 查看班组假期删除日志
	@RequestMapping("/toSelectClassVacCanLog.do")
	public String toSelectClassVacCanLog() {
		return "select_class_vac_can_log";
	}

	@RequestMapping("/selectClassVacCanLog.do")
	public String selectClassVacCanLog(@RequestParam("id") int em_id, @RequestParam("beginday") String lo_logintime,
			@RequestParam("endday") String lo_logouttime, HttpSession session) throws ParseException {
		Employee monitor = (Employee) session.getAttribute("employee");
		Employee employee = employeeService.selectEmployeeById(em_id);
		if (employee == null) {
			session.setAttribute("select_class_vac_can_log_error", "工号不存在!");
			return "forward:/employee/toSelectClassVacCanLog.do";
		} else if (monitor.getEm_classid().equals(employee.getEm_classid())) {
			session.removeAttribute("select_class_vac_can_log_error");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			AttenCancel classAttendance = new AttenCancel();
			classAttendance.setAtt_emid(em_id);
			Date beginday = sdf.parse(sdf.format(sdf.parse(lo_logintime)));
			Date endday = sdf.parse(sdf.format(sdf.parse(lo_logouttime)));

			classAttendance.setAtt_beginday(beginday);
			classAttendance.setAtt_endday(endday);

			List<AttenCancel> classAttenCancels = attenCancelService.selectAttenCanByEmidDay(classAttendance);
			if (classAttenCancels.size() == 0) {
				session.setAttribute("select_class_vac_can_log_null", "该时间段内无删除记录");
			} else {
				session.removeAttribute("select_class_vac_can_log_null");
			}

			session.setAttribute("classAttenCancels", classAttenCancels);
			return "select_class_vac_can_log_success";
		} else {
			session.setAttribute("select_class_vac_can_log_error", "所查询工号非本班组员工！");
			return "forward:/employee/toSelectClassVacCanLog.do";
		}
	}

	// 查询员工登陆日志
	@RequestMapping("/toSelectLogLog.do")
	public String toSelectLogLog() {
		return "select_log_log";
	}

	@RequestMapping("/selectLogLog.do")
	public String selectLogLog(@RequestParam("id") int em_id, @RequestParam("begindate") String lo_logintime0,
			@RequestParam("enddate") String lo_logouttime0, HttpSession session) throws ParseException {
		Employee employee = employeeService.selectEmployeeById(em_id);
		if (employee == null) {
			session.setAttribute("select_log_log_error", "工号不存在!");
			return "forward:/employee/toSelectLogLog.do";
		} else {
			session.removeAttribute("select_log_log_error");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			LoginLogoutLog loginLogoutLog = new LoginLogoutLog();
			loginLogoutLog.setLo_emid(em_id);
			String lo_logintime1 = lo_logintime0.replace("T", " ");
			String lo_logouttime1 = lo_logouttime0.replace("T", " ");
			Date logintime = sdf.parse(sdf.format(sdf.parse(lo_logintime1)));
			Date logouttime = sdf.parse(sdf.format(sdf.parse(lo_logouttime1)));

			loginLogoutLog.setLo_logintime(logintime);
			loginLogoutLog.setLo_logouttime(logouttime);

			List<LoginLogoutLog> loginLogoutLogs = loginLogoutLogDao.selectLoginoutByEmidDate(loginLogoutLog);
			if (loginLogoutLogs.size() == 0) {
				session.setAttribute("select_log_log_null", "该时间段内无登陆记录");
			} else {
				session.removeAttribute("select_log_log_null");
			}

			session.setAttribute("loginLogoutLogs", loginLogoutLogs);
			return "select_log_log_success";
		}
	}

	// 查看员工假期申请日志
	@RequestMapping("/toSelectVacAppLog.do")
	public String toSelectVacAppLog() {
		return "select_vac_app_log";
	}

	@RequestMapping("/selectVacAppLog.do")
	public String selectVacAppLog(@RequestParam("id") int em_id, @RequestParam("beginday") String lo_logintime,
			@RequestParam("endday") String lo_logouttime, HttpSession session) throws ParseException {
		Employee employee = employeeService.selectEmployeeById(em_id);
		if (employee == null) {
			session.setAttribute("select_vac_app_log_error", "工号不存在!");
			return "forward:/employee/toSelectVacAppLog.do";
		} else {
			session.removeAttribute("select_vac_app_log_error");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Attendance attendance = new Attendance();
			attendance.setAt_emid(em_id);
			Date beginday = sdf.parse(sdf.format(sdf.parse(lo_logintime)));
			Date endday = sdf.parse(sdf.format(sdf.parse(lo_logouttime)));

			attendance.setAt_beginday(beginday);
			attendance.setAt_endday(endday);

			List<Attendance> vacAppLogAttens = attendanceService.selectVacAppLogByEmid(attendance);
			if (vacAppLogAttens.size() == 0) {
				session.setAttribute("select_vac_app_log_null", "该时间段内无申请记录");
			} else {
				session.removeAttribute("select_vac_app_log_null");
			}

			session.setAttribute("vacAppLogAttens", vacAppLogAttens);
			return "select_vac_app_log_success";
		}
	}

	// 查看员工假期修改记录
	@RequestMapping("/toSelectVacModLog.do")
	public String toSelectVacModLog() {
		return "select_vac_mod_log";
	}

	@RequestMapping("/selectVacModLog.do")
	public String SelectVacModLog(@RequestParam("id") int em_id, @RequestParam("beginday") String lo_logintime,
			@RequestParam("endday") String lo_logouttime, HttpSession session) throws ParseException {
		Employee employee = employeeService.selectEmployeeById(em_id);
		if (employee == null) {
			session.setAttribute("select_vac_mod_log_error", "工号不存在!");
			return "forward:/employee/toSelectVacModLog.do";
		} else {
			session.removeAttribute("select_vac_mod_log_error");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			AttenModify attenModify = new AttenModify();
			attenModify.setAtt_emid(em_id);
			Date beginday = sdf.parse(sdf.format(sdf.parse(lo_logintime)));
			Date endday = sdf.parse(sdf.format(sdf.parse(lo_logouttime)));
			attenModify.setAtt_bebeday(beginday);
			attenModify.setAtt_beenday(endday);

			List<AttenModify> attenModifyLogs = attenModifyService.selectAttenModifyByEmidDay(attenModify);

			if (attenModifyLogs.size() == 0) {
				session.setAttribute("select_vac_mod_log_null", "该时间段内无修改记录");
			} else {
				session.removeAttribute("select_vac_mod_log_null");
				List<Attendance> aftAttendances = new ArrayList<>();
				Iterator<AttenModify> iterator = attenModifyLogs.iterator();
				if (iterator.hasNext()) {
					int att_preid = ((AttenModify) (iterator.next())).getAtt_preid();
					Attendance aftAttendance = attendanceService.selectAttendanceById(att_preid);
					aftAttendances.add(aftAttendance);
				}
				session.setAttribute("aftAttendances", aftAttendances);
			}

			return "select_vac_mod_log_success";
		}
	}

	@RequestMapping("/toSelectModAtten.do")
	public String toSelectModAtten(@RequestParam("at_id") int att_preid, HttpSession session) {
		List<AttenModify> preAttendances = attenModifyService.selectAttenModifyByPreid(att_preid);
		session.setAttribute("preAttendances", preAttendances);
		return "select_pre_atten";
	}

	// 查看员工假期删除记录
	@RequestMapping("/toSelectVacCanLog.do")
	public String toSelectVacCanLog() {
		return "select_vac_can_log";
	}

	@RequestMapping("/selectVacCanLog.do")
	public String selectVacCanLog(@RequestParam("id") int em_id, @RequestParam("beginday") String lo_logintime,
			@RequestParam("endday") String lo_logouttime, HttpSession session) throws ParseException {
		Employee employee = employeeService.selectEmployeeById(em_id);
		if (employee == null) {
			session.setAttribute("select_vac_can_log_error", "工号不存在!");
			return "forward:/employee/toSelectVacCanLog.do";
		} else {
			session.removeAttribute("select_vac_can_log_error");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			AttenCancel attendance = new AttenCancel();
			attendance.setAtt_emid(em_id);
			Date beginday = sdf.parse(sdf.format(sdf.parse(lo_logintime)));
			Date endday = sdf.parse(sdf.format(sdf.parse(lo_logouttime)));

			attendance.setAtt_beginday(beginday);
			attendance.setAtt_endday(endday);

			List<AttenCancel> attenCancels = attenCancelService.selectAttenCanByEmidDay(attendance);
			if (attenCancels.size() == 0) {
				session.setAttribute("select_vac_can_log_null", "该时间段内无删除记录");
			} else {
				session.removeAttribute("select_vac_can_log_null");
			}

			session.setAttribute("attenCancels", attenCancels);
			return "select_vac_can_log_success";
		}
	}
}
