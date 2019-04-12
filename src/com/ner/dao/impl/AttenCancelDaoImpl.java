package com.ner.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ner.bean.AttenCancel;
import com.ner.dao.AttenCancelDao;

@Repository("AttenCancelDao")
public class AttenCancelDaoImpl extends SqlSessionDaoSupport implements AttenCancelDao {

	private final static String SQLMAPPERPATH = "com.ner.bean.AttenCancelMapper.";

	@Autowired
	public void SqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int addAttenCancelLog(AttenCancel attenCancel) {
		return getSqlSession().insert(SQLMAPPERPATH + "addAttenCancelLog", attenCancel);
	}

	@Override
	public List<AttenCancel> selectAttenCanByEmidDay(AttenCancel attenCancel) {
		return getSqlSession().selectList(SQLMAPPERPATH + "selectAttenCanByEmidDay", attenCancel);
	}

}
