package com.ner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ner.bean.AttenCancel;
import com.ner.dao.AttenCancelDao;
import com.ner.service.AttenCancelService;

@Service("AttenCancelService")
public class AttenCancelServiceImpl implements AttenCancelService {

	@Autowired
	private AttenCancelDao attenCancelDao;

	@Override
	public int addAttenCancelLog(AttenCancel attenCancel) {
		return attenCancelDao.addAttenCancelLog(attenCancel);
	}

	@Override
	public List<AttenCancel> selectAttenCanByEmidDay(AttenCancel attenCancel) {
		return attenCancelDao.selectAttenCanByEmidDay(attenCancel);
	}

}
