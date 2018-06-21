package com.featurebim.core.model;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * The persistent class for the emails database table.
 * 
 */
public class Email implements Serializable {
	private static final long serialVersionUID = 1L;

	private EmailPK id;

	private String comments;

	private LocalDateTime created;

	private String emailName;

	private String emailaddress;

	private LocalDateTime updated;

	private int version;

	public Email() {
	}

	public EmailPK getId() {
		return this.id;
	}

	public void setId(EmailPK id) {
		this.id = id;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDateTime getCreated() {
		return this.created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public String getEmailName() {
		return this.emailName;
	}

	public void setEmailName(String emailName) {
		this.emailName = emailName;
	}

	public String getEmailaddress() {
		return this.emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
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