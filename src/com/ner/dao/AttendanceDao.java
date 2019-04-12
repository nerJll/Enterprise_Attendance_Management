package com.ner.dao;

import java.util.List;
import java.util.Map;

import com.ner.bean.Attendance;

public interface AttendanceDao {
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

	List<Attendance> findByPage(Map<String, Object> map);

	int selectCount();

	List<Attendance> findByPageByClassid(Map<String, Object> map);

	int selectCountByClassid(String at_emclassid);

	List<Attendance> findByPageByEmid(Map<String, Object> map);

	int selectCountByEmid(int at_emid);
}
