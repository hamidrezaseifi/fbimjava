package com.featurebim.common.model.edo;

import java.time.LocalDateTime;

/**
 * The persistent class for the companies database table.
 *
 */
public class CompanyPhoneNumberEdo {

	private Long id;

	private Long companyid;

	private String telephone_name;

	private String phonenumner;

	private String comments;

	private int status;

	private int version;

	private LocalDateTime created;

	private LocalDateTime updated;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @return the companyid
	 */
	public Long getCompanyid() {
		return companyid;
	}

	/**
	 * @param companyid the companyid to set
	 */
	public void setCompanyid(final Long companyid) {
		this.companyid = companyid;
	}

	/**
	 * @return the telephone_name
	 */
	public String getTelephone_name() {
		return telephone_name;
	}

	/**
	 * @param telephone_name the telephone_name to set
	 */
	public void setTelephoneName(final String telephone_name) {
		this.telephone_name = telephone_name;
	}

	/**
	 * @return the telephonenumner
	 */
	public String getPhonenumner() {
		return phonenumner;
	}

	/**
	 * @param telephonenumner the telephonenumner to set
	 */
	public void setPhonenumner(final String telephonenumner) {
		this.phonenumner = telephonenumner;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(final String comments) {
		this.comments = comments;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(final int status) {
		this.status = status;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(final int version) {
		this.version = version;
	}

	/**
	 * @return the created
	 */
	public LocalDateTime getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(final LocalDateTime created) {
		this.created = created;
	}

	/**
	 * @return the updated
	 */
	public LocalDateTime getUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(final LocalDateTime updated) {
		this.updated = updated;
	}

}
