package com.ner.bean;

import java.util.Date;

public class AttenModify {
	private int att_id;
	private int att_preid;
	private int att_emid;
	private String att_berea;
	private Date att_bebeday;
	private Date att_beenday;
	private Date att_modday;

	public int getAtt_id() {
		return att_id;
	}

	public int getAtt_preid() {
		return att_preid;
	}

	public int getAtt_emid() {
		return att_emid;
	}

	public String getAtt_berea() {
		return att_berea;
	}

	public Date getAtt_bebeday() {
		return att_bebeday;
	}

	public Date getAtt_beenday() {
		return att_beenday;
	}

	public Date getAtt_modday() {
		return att_modday;
	}

	public void setAtt_id(int att_id) {
		this.att_id = att_id;
	}

	public void setAtt_preid(int att_preid) {
		this.att_preid = att_preid;
	}

	public void setAtt_emid(int att_emid) {
		this.att_emid = att_emid;
	}

	public void setAtt_berea(String att_berea) {
		this.att_berea = att_berea;
	}

	public void setAtt_bebeday(Date att_bebeday) {
		this.att_bebeday = att_bebeday;
	}

	public void setAtt_beenday(Date att_beenday) {
		this.att_beenday = att_beenday;
	}

	public void setAtt_modday(Date att_modday) {
		this.att_modday = att_modday;
	}

}
