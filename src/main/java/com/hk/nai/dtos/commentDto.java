package com.hk.nai.dtos;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class commentDto implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	
	private String ac_name;
	private String m_id;
	private String ac_comment;
	private Float ac_score;
	private Date cmt_date;
	
	public Date getCmt_date() {
		return cmt_date;
	}
	public void setCmt_date(Date cmt_date) {
		this.cmt_date = cmt_date;
	}
	public String getAc_name() {
		return ac_name;
	}
	public void setAc_name(String ac_name) {
		this.ac_name = ac_name;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getAc_comment() {
		return ac_comment;
	}
	public void setAc_comment(String ac_comment) {
		this.ac_comment = ac_comment;
	}
	public Float getAc_score() {
		return ac_score;
	}
	public void setAc_score(Float ac_score) {
		this.ac_score = ac_score;
	}
	
	@Override
	public String toString() {
		return "InfoDto [ac_name=" + ac_name + ", m_id=" + m_id + ", ac_comment=" + ac_comment + ", ac_score="
				+ ac_score + "]";
	}
	
	
	
}
