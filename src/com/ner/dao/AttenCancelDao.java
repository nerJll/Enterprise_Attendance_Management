package com.ner.dao;

import java.util.List;

import com.ner.bean.AttenCancel;

public interface AttenCancelDao {
	int addAttenCancelLog(AttenCancel attenCancel);

	List<AttenCancel> selectAttenCanByEmidDay(AttenCancel attenCancel);
}
