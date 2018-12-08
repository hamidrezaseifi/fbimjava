package com.featurebim.common.model.edo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the companies database table.
 *
 */
public class CompanyEdo {

	private Long id;

	private String comments;

	private String companyName;

	private int status;

	private int version;

	private LocalDateTime created;

	private LocalDateTime updated;

	List<CompanyPostalAddressEdo> postalAddresses = new ArrayList<>();

	List<CompanyPhoneNumberEdo> phoneNumbers = new ArrayList<>();

	List<CompanyEmailEdo> emails = new ArrayList<>();

	public CompanyEdo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(final String comments) {
		this.comments = comments;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(final String companyName) {
		this.companyName = companyName;
	}

	public LocalDateTime getCreated() {
		return this.created;
	}

	public void setCreated(final LocalDateTime created) {
		this.created = created;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(final int status) {
		this.status = status;
	}

	public LocalDateTime getUpdated() {
		return this.updated;
	}

	public void setUpdated(final LocalDateTime updated) {
		this.updated = updated;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	/**
	 * @return the postalAddress
	 */
	public List<CompanyPostalAddressEdo> getPostalAddresses() {
		return postalAddresses;
	}

	/**
	 * @param postalAddress the postalAddress to set
	 */
	public void setPostalAddresses(final List<CompanyPostalAddressEdo> postalAddresses) {
		if (postalAddresses != null) {
			this.postalAddresses = postalAddresses;
		}
	}

	/**
	 * @return the phoneNumbers
	 */
	public List<CompanyPhoneNumberEdo> getPhoneNumbers() {
		return phoneNumbers;
	}

	/**
	 * @param phoneNumbers the phoneNumbers to set
	 */
	public void setPhoneNumbers(final List<CompanyPhoneNumberEdo> phoneNumbers) {
		if (phoneNumbers != null) {
			this.phoneNumbers = phoneNumbers;
		}
	}

	/**
	 * @return the emails
	 */
	public List<CompanyEmailEdo> getEmails() {
		return emails;
	}

	/**
	 * @param emails the emails to set
	 */
	public void setEmails(final List<CompanyEmailEdo> emails) {
		if (emails != null) {
			this.emails = emails;
		}
	}

}
