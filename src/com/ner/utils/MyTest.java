package com.ner.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class MyTest {
	@Test
	public void test1() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date em_birthday_ch = sdf.parse("1993-03-23");
		System.out.println(em_birthday_ch);
	}
	
}
