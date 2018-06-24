package com.futurebim.common.models;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * The persistent class for the telephonesnumbers database table.
 * 
 */
public class Telephonesnumber implements Serializable {
	private static final long serialVersionUID = 1L;

	private TelephonesnumberPK id;

	private String cityCode;

	private String comments;

	private String countryCode;

	private LocalDateTime created;

	private String subscriber;

	private String telephoneName;

	private LocalDateTime updated;

	private int version;

	public Telephonesnumber() {
	}

	public TelephonesnumberPK getId() {
		return this.id;
	}

	public void setId(TelephonesnumberPK id) {
		this.id = id;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public LocalDateTime getCreated() {
		return this.created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public String getSubscriber() {
		return this.subscriber;
	}

	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}

	public String getTelephoneName() {
		return this.telephoneName;
	}

	public void setTelephoneName(String telephoneName) {
		this.telephoneName = telephoneName;
	}

	public LocalDateTime getUpdated() {
		return this.updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}