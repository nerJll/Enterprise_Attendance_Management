package com.ner.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ner.bean.Attendance;
import com.ner.dao.AttendanceDao;

@Repository("AttendanceDao")
public class AttendanceDaoImpl extends SqlSessionDaoSupport implements AttendanceDao {

	private final static String SQLMAPPERPATH = "com.ner.bean.AttendanceMapper.";

	@Autowired
	public void SqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public void addAttendance(Attendance attendance) {
		getSqlSession().insert(SQLMAPPERPATH + "addAttendance", attendance);
	}

	@Override
	public void deleteAttendance(int at_id) {
		getSqlSession().delete(SQLMAPPERPATH + "deleteAttendance", at_id);
	}

	@Override
	public void updateAttendance(Attendance attendance) {
		getSqlSession().update(SQLMAPPERPATH + "updateAttendance", attendance);
	}

	@Override
	public List<Attendance> selectAllAttendance() {
		return getSqlSession().selectList(SQLMAPPERPATH + "selectAllAttendance");
	}

	@Override
	public List<Attendance> selectAttendanceByEmid(int at_emid) {
		return getSqlSession().selectList(SQLMAPPERPATH + "selectAttendanceByEmid", at_emid);
	}

	@Override
	public List<Attendance> selectAttendanceByClassid(String at_emclassid) {
		return getSqlSession().selectList(SQLMAPPERPATH + "selectAttendanceByClassid", at_emclassid);
	}

	@Override
	public List<Attendance> selectAttendanceByDep(String at_emdep) {
		return getSqlSession().selectList(SQLMAPPERPATH + "selectAttendanceByDep", at_emdep);
	}

	@Override
	public Attendance selectAttendanceById(int at_id) {
		return getSqlSession().selectOne(SQLMAPPERPATH + "selectAttendanceById", at_id);
	}

	@Override
	public List<Attendance> selectClassUnRieveAttenByClassid(String at_emclassid) {
		return getSqlSession().selectList(SQLMAPPERPATH + "selectClassUnRieveAttenByClassid", at_emclassid);
	}

	@Override
	public void updateUnRevReason(Attendance attendance) {
		getSqlSession().update(SQLMAPPERPATH + "updateUnRevReason", attendance);
	}

	@Override
	public List<Attendance> selectAllUnRieveAtten() {
		return getSqlSession().selectList(SQLMAPPERPATH + "selectAllUnRieveAtten");
	}

	@Override
	public List<Attendance> selectVacAppLogByEmid(Attendance attendance) {
		return getSqlSession().selectList(SQLMAPPERPATH + "selectVacAppLogByEmid", attendance);
	}

	@Override
	public List<Attendance> findByPage(Map<String, Object> map) {
		return getSqlSession().selectList(SQLMAPPERPATH + "findByPage", map);
	}

	@Override
	public int selectCount() {
		return (Integer) getSqlSession().selectOne(SQLMAPPERPATH + "selectCount");
	}

	@Override
	public List<Attendance> findByPageByClassid(Map<String, Object> map) {
		return getSqlSession().selectList(SQLMAPPERPATH + "findByPageByClassid", map);
	}

	@Override
	public int selectCountByClassid(String at_emclassid) {
		return (Integer) getSqlSession().selectOne(SQLMAPPERPATH + "selectCountByClassid", at_emclassid);
	}

	@Override
	public List<Attendance> findByPageByEmid(Map<String, Object> map) {
		return getSqlSession().selectList(SQLMAPPERPATH + "findByPageByEmid", map);
	}

	@Override
	public int selectCountByEmid(int at_emid) {
		return (Integer) getSqlSession().selectOne(SQLMAPPERPATH + "selectCountByEmid", at_emid);
	}

}
