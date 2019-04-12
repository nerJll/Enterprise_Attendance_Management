package com.ner.service;

import java.util.List;

import com.ner.bean.AttenCancel;

public interface AttenCancelService {
	int addAttenCancelLog(AttenCancel attenCancel);

	List<AttenCancel> selectAttenCanByEmidDay(AttenCancel attenCancel);
}
