package com.ner.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ner.bean.AttenModify;
import com.ner.dao.AttenModifyDao;

@Repository("AttenModifyDao")
public class AttenModifyDaoImpl extends SqlSessionDaoSupport implements AttenModifyDao {

	private final static String SQLMAPPERPATH = "com.ner.bean.AttenModify.";

	@Autowired
	public void SqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int addAttenModify(AttenModify attenmodify) {
		return getSqlSession().insert(SQLMAPPERPATH + "addAttenModify", attenmodify);
	}

	@Override
	public List<AttenModify> selectAttenModifyByEmidDay(AttenModify attenModify) {
		return getSqlSession().selectList(SQLMAPPERPATH + "selectAttenModifyByEmidDay", attenModify);
	}

	@Override
	public List<AttenModify> selectAttenModifyByPreid(int att_emid) {
		return getSqlSession().selectList(SQLMAPPERPATH + "selectAttenModifyByPreid", att_emid);
	}

}
