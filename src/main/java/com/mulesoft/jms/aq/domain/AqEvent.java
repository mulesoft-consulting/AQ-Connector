package com.mulesoft.jms.aq.domain;

import java.sql.Date;

public class AqEvent {
	private Date datetime;
	private String id;
	private String payload;
	
	public AqEvent() {
	}

	public AqEvent(Date datetime, String id, String payload) {
		this.datetime = datetime;
		this.id = id;
		this.payload = payload;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
}
