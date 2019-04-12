package com.ner.dao;

import java.util.List;

import com.ner.bean.AttenModify;

public interface AttenModifyDao {
	int addAttenModify(AttenModify attenmodify);

	List<AttenModify> selectAttenModifyByEmidDay(AttenModify attenModify);
	
	List<AttenModify> selectAttenModifyByPreid(int att_emid);
}
