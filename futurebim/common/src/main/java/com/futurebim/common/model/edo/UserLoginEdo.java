package com.futurebim.common.model.edo;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.futurebim.common.rest.json.JsonConstants;
import com.futurebim.common.rest.xml.LocalDateTimeAdapter;

/**
 * The persistent class for the users database table.
 *
 */
public class UserLoginEdo {

	private String username;

	private String password;

	private String companyIdent;

	@XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
	@JsonFormat(pattern = JsonConstants.DATETIME_FORMAT_ISO)
	private LocalDateTime created;

	public UserLoginEdo() {
		created = LocalDateTime.now();
	}

	public UserLoginEdo(final String username, final String password, final String companyIdent) {
		created = LocalDateTime.now();
		this.password = password;
		this.username = username;
		this.companyIdent = companyIdent;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * @return the companyIdent
	 */
	public String getCompanyIdent() {
		return companyIdent;
	}

	/**
	 * @param companyIdent the companyIdent to set
	 */
	public void setCompanyIdent(final String companyIdent) {
		this.companyIdent = companyIdent;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(final LocalDateTime created) {
		this.created = created;
	}

}
