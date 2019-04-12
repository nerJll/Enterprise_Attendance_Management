package com.ner.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ner.bean.Attendance;
import com.ner.dao.AttendanceDao;
import com.ner.service.AttendanceService;
import com.ner.utils.PageUtils;

@Service("AttendanceService")
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	private AttendanceDao attendanceDao;

	@Override
	public void addAttendance(Attendance attendance) {
		attendanceDao.addAttendance(attendance);
	}

	@Override
	public void deleteAttendance(int at_id) {
		attendanceDao.deleteAttendance(at_id);
	}

	@Override
	public void updateAttendance(Attendance attendance) {
		attendanceDao.updateAttendance(attendance);
	}

	@Override
	public List<Attendance> selectAllAttendance() {
		return attendanceDao.selectAllAttendance();
	}

	@Override
	public List<Attendance> selectAttendanceByEmid(int at_emid) {
		return attendanceDao.selectAttendanceByEmid(at_emid);
	}

	@Override
	public List<Attendance> selectAttendanceByClassid(String at_emclassid) {
		return attendanceDao.selectAttendanceByClassid(at_emclassid);
	}

	@Override
	public List<Attendance> selectAttendanceByDep(String at_emdep) {
		return attendanceDao.selectAttendanceByDep(at_emdep);
	}

	@Override
	public Attendance selectAttendanceById(int at_id) {
		return attendanceDao.selectAttendanceById(at_id);
	}

	@Override
	public List<Attendance> selectClassUnRieveAttenByClassid(String at_emclassid) {
		return attendanceDao.selectClassUnRieveAttenByClassid(at_emclassid);
	}

	@Override
	public void updateUnRevReason(Attendance attendance) {
		attendanceDao.updateUnRevReason(attendance);
	}

	@Override
	public List<Attendance> selectAllUnRieveAtten() {
		return attendanceDao.selectAllUnRieveAtten();
	}

	@Override
	public List<Attendance> selectVacAppLogByEmid(Attendance attendance) {
		return attendanceDao.selectVacAppLogByEmid(attendance);
	}

	@Override
	public int selectCount() {
		return attendanceDao.selectCount();
	}

	@Override
	public PageUtils<Attendance> findByPage(int currentPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageUtils<Attendance> pageUtils = new PageUtils<Attendance>();

		// 封装当前页数
		pageUtils.setCurrPage(currentPage);

		// 每页显示的数据
		int pageSize = 8;
		pageUtils.setPageSize(pageSize);

		// 封装总记录数
		int totalCount = attendanceDao.selectCount();
		pageUtils.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageUtils.setTotalPage(num.intValue());

		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageUtils.getPageSize());
		// 封装每页显示的数据
		List<Attendance> lists = attendanceDao.findByPage(map);
		pageUtils.setLists(lists);

		return pageUtils;
	}

	@Override
	public PageUtils<Attendance> findByPageByClassid(int currentPage, String at_emclassid) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageUtils<Attendance> pageUtils = new PageUtils<Attendance>();

		// 封装当前页数
		pageUtils.setCurrPage(currentPage);

		// 每页显示的数据
		int pageSize = 8;
		pageUtils.setPageSize(pageSize);

		// 封装总记录数
		int totalCount = attendanceDao.selectCountByClassid(at_emclassid);
		pageUtils.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageUtils.setTotalPage(num.intValue());

		map.put("at_emclassid", at_emclassid);
		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageUtils.getPageSize());
		// 封装每页显示的数据
		List<Attendance> lists = attendanceDao.findByPageByClassid(map);
		pageUtils.setLists(lists);

		return pageUtils;
	}

	@Override
	public int selectCountByClassid(String at_classid) {
		return attendanceDao.selectCountByClassid(at_classid);
	}

	@Override
	public int selectCountByEmid(int at_emid) {
		return attendanceDao.selectCountByEmid(at_emid);
	}

	@Override
	public PageUtils<Attendance> findByPageByEmid(int currentPage, int at_emid) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageUtils<Attendance> pageUtils = new PageUtils<Attendance>();

		// 封装当前页数
		pageUtils.setCurrPage(currentPage);

		// 每页显示的数据
		int pageSize = 5;
		pageUtils.setPageSize(pageSize);

		// 封装总记录数
		int totalCount = attendanceDao.selectCountByEmid(at_emid);
		pageUtils.setTotalCount(totalCount);

		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);// 向上取整
		pageUtils.setTotalPage(num.intValue());

		map.put("at_emid", at_emid);
		map.put("start", (currentPage - 1) * pageSize);
		map.put("size", pageUtils.getPageSize());
		// 封装每页显示的数据
		List<Attendance> lists = attendanceDao.findByPageByEmid(map);
		pageUtils.setLists(lists);

		return pageUtils;
	}

}
