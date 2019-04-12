package com.ner.bean;

import java.util.Date;

public class AttenCancel {
	private int att_id;
	private int att_emid;
	private String att_emname;
	private String att_content;
	private String att_reason;
	private Date att_beginday;
	private Date att_endday;
	private String att_state;
	private Date att_applyday;
	private Date att_cancelday;

	public int getAtt_id() {
		return att_id;
	}

	public int getAtt_emid() {
		return att_emid;
	}

	public String getAtt_emname() {
		return att_emname;
	}

	public String getAtt_content() {
		return att_content;
	}

	public String getAtt_reason() {
		return att_reason;
	}

	public Date getAtt_beginday() {
		return att_beginday;
	}

	public Date getAtt_endday() {
		return att_endday;
	}

	public String getAtt_state() {
		return att_state;
	}

	public Date getAtt_applyday() {
		return att_applyday;
	}

	public Date getAtt_cancelday() {
		return att_cancelday;
	}

	public void setAtt_id(int att_id) {
		this.att_id = att_id;
	}

	public void setAtt_emid(int att_emid) {
		this.att_emid = att_emid;
	}

	public void setAtt_emname(String att_emname) {
		this.att_emname = att_emname;
	}

	public void setAtt_content(String att_content) {
		this.att_content = att_content;
	}

	public void setAtt_reason(String att_reason) {
		this.att_reason = att_reason;
	}

	public void setAtt_beginday(Date att_beginday) {
		this.att_beginday = att_beginday;
	}

	public void setAtt_endday(Date att_endday) {
		this.att_endday = att_endday;
	}

	public void setAtt_state(String att_state) {
		this.att_state = att_state;
	}

	public void setAtt_applyday(Date att_applyday) {
		this.att_applyday = att_applyday;
	}

	public void setAtt_cancelday(Date att_cancelday) {
		this.att_cancelday = att_cancelday;
	}

}
