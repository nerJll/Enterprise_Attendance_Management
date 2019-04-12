package com.ner.service;

import java.util.List;

import com.ner.bean.AttenModify;

public interface AttenModifyService {
	int addAttenModify(AttenModify attenmodify);

	List<AttenModify> selectAttenModifyByEmidDay(AttenModify attenModify);
	
	List<AttenModify> selectAttenModifyByPreid(int att_emid);
}
