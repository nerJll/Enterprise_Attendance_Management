package com.ner.service;

import java.util.List;

import com.ner.bean.Attendance;
import com.ner.utils.PageUtils;

public interface AttendanceService {
	void addAttendance(Attendance attendance);

	void deleteAttendance(int at_id);

	void updateAttendance(Attendance attendance);

	List<Attendance> selectAllAttendance();

	Attendance selectAttendanceById(int at_id);

	List<Attendance> selectAttendanceByEmid(int at_emid);

	List<Attendance> selectAttendanceByClassid(String at_emclassid);

	List<Attendance> selectAttendanceByDep(String at_emdep);

	List<Attendance> selectClassUnRieveAttenByClassid(String at_emclassid);

	void updateUnRevReason(Attendance attendance);

	List<Attendance> selectAllUnRieveAtten();

	List<Attendance> selectVacAppLogByEmid(Attendance attendance);

	int selectCount();

	PageUtils<Attendance> findByPage(int currentPage);

	PageUtils<Attendance> findByPageByClassid(int currentPage, String at_emclassid);

	int selectCountByClassid(String at_emclassid);

	int selectCountByEmid(int at_emid);
	
	PageUtils<Attendance> findByPageByEmid(int currentPage, int at_emid);
}
