package com.ner.bean;

import java.util.Date;

public class Attendance {
	private int at_id;
	private int at_emid;
	private String at_emname;
	private String at_content;
	private String at_reason;
	private Date at_beginday;
	private Date at_endday;
	private String at_state;
	private Date at_applyday;
	private String at_emdep;
	private String at_emclassid;
	private String at_unrevreason;

	public int getAt_id() {
		return at_id;
	}

	public void setAt_id(int at_id) {
		this.at_id = at_id;
	}

	public int getAt_emid() {
		return at_emid;
	}

	public String getAt_emname() {
		return at_emname;
	}

	public String getAt_content() {
		return at_content;
	}

	public String getAt_reason() {
		return at_reason;
	}

	public Date getAt_beginday() {
		return at_beginday;
	}

	public Date getAt_endday() {
		return at_endday;
	}

	public String getAt_state() {
		return at_state;
	}

	public Date getAt_applyday() {
		return at_applyday;
	}

	public void setAt_emid(int at_emid) {
		this.at_emid = at_emid;
	}

	public void setAt_emname(String at_emname) {
		this.at_emname = at_emname;
	}

	public void setAt_content(String at_content) {
		this.at_content = at_content;
	}

	public void setAt_reason(String at_reason) {
		this.at_reason = at_reason;
	}

	public void setAt_beginday(Date at_beginday) {
		this.at_beginday = at_beginday;
	}

	public void setAt_endday(Date at_endday) {
		this.at_endday = at_endday;
	}

	public void setAt_state(String at_state) {
		this.at_state = at_state;
	}

	public void setAt_applyday(Date at_applyday) {
		this.at_applyday = at_applyday;
	}

	public String getAt_emdep() {
		return at_emdep;
	}

	public String getAt_emclassid() {
		return at_emclassid;
	}

	public void setAt_emdep(String at_emdep) {
		this.at_emdep = at_emdep;
	}

	public void setAt_emclassid(String at_emclassid) {
		this.at_emclassid = at_emclassid;
	}

	public Attendance() {
		// TODO Auto-generated constructor stub
	}

	public String getAt_unrevreason() {
		return at_unrevreason;
	}

	public void setAt_unrevreason(String at_unrevreason) {
		this.at_unrevreason = at_unrevreason;
	}

	public Attendance(int at_emid, String at_emname, String at_content, String at_reason, Date at_beginday,
			Date at_endday, String at_state, Date at_applyday, String at_emdep, String at_emclassid) {
		super();
		this.at_emid = at_emid;
		this.at_emname = at_emname;
		this.at_content = at_content;
		this.at_reason = at_reason;
		this.at_beginday = at_beginday;
		this.at_endday = at_endday;
		this.at_state = at_state;
		this.at_applyday = at_applyday;
		this.at_emdep = at_emdep;
		this.at_emclassid = at_emclassid;
	}

	public Attendance(int at_id, int at_emid, String at_emname, String at_content, String at_reason, Date at_beginday,
			Date at_endday, String at_state, Date at_applyday, String at_emdep, String at_emclassid) {
		super();
		this.at_id = at_id;
		this.at_emid = at_emid;
		this.at_emname = at_emname;
		this.at_content = at_content;
		this.at_reason = at_reason;
		this.at_beginday = at_beginday;
		this.at_endday = at_endday;
		this.at_state = at_state;
		this.at_applyday = at_applyday;
		this.at_emdep = at_emdep;
		this.at_emclassid = at_emclassid;
	}

	public Attendance(int at_id, int at_emid, String at_emname, String at_content, String at_reason, Date at_beginday,
			Date at_endday, String at_state, Date at_applyday, String at_emdep, String at_emclassid,
			String at_unrevreason) {
		super();
		this.at_id = at_id;
		this.at_emid = at_emid;
		this.at_emname = at_emname;
		this.at_content = at_content;
		this.at_reason = at_reason;
		this.at_beginday = at_beginday;
		this.at_endday = at_endday;
		this.at_state = at_state;
		this.at_applyday = at_applyday;
		this.at_emdep = at_emdep;
		this.at_emclassid = at_emclassid;
		this.at_unrevreason = at_unrevreason;
	}

	@Override
	public String toString() {
		return "Attendance [at_id=" + at_id + ", at_emid=" + at_emid + ", at_emname=" + at_emname + ", at_content="
				+ at_content + ", at_reason=" + at_reason + ", at_beginday=" + at_beginday + ", at_endday=" + at_endday
				+ ", at_state=" + at_state + ", at_applyday=" + at_applyday + ", at_emdep=" + at_emdep
				+ ", at_emclassid=" + at_emclassid + "]";
	}

}
