package com.ner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ner.bean.AttenModify;
import com.ner.dao.AttenModifyDao;
import com.ner.service.AttenModifyService;

@Service("AttenModifyService")
public class AttenModifyServiceImpl implements AttenModifyService {

	@Autowired
	private AttenModifyDao attenModifyDao;

	@Override
	public int addAttenModify(AttenModify attenmodify) {
		return attenModifyDao.addAttenModify(attenmodify);
	}

	@Override
	public List<AttenModify> selectAttenModifyByEmidDay(AttenModify attenModify) {
		return attenModifyDao.selectAttenModifyByEmidDay(attenModify);
	}

	@Override
	public List<AttenModify> selectAttenModifyByPreid(int att_emid) {
		return attenModifyDao.selectAttenModifyByPreid(att_emid);
	}

}
