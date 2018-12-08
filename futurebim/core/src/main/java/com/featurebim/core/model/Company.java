package com.featurebim.core.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.featurebim.common.model.edo.CompanyEdo;

/**
 * The persistent class for the companies database table.
 *
 */
public class Company {

  private Long id;

  private String comments;

  private String companyName;

  private int status;

  private int version;

  private LocalDateTime created;

  private LocalDateTime updated;

  List<CompanyPostalAddress> postalAddresses = new ArrayList<>();

  List<CompanyPhoneNumber> phoneNumbers = new ArrayList<>();

  List<CompanyEmail> emails = new ArrayList<>();
  
  public Company() {
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
  public List<CompanyPostalAddress> getPostalAddress() {
    return postalAddresses;
  }

  /**
   * @param postalAddresses the postalAddress to set
   */
  public void setPostalAddresses(final List<CompanyPostalAddress> postalAddresses) {
    this.postalAddresses = postalAddresses;
  }

  /**
   * @param postalAddress the postalAddress to set
   */
  public void addPostalAddresses(final CompanyPostalAddress postalAddress) {
    this.postalAddresses.add(postalAddress);
  }

  /**
   * @return the phoneNumbers
   */
  public List<CompanyPhoneNumber> getPhoneNumbers() {
    return phoneNumbers;
  }

  /**
   * @param phoneNumbers the phoneNumbers to set
   */
  public void setPhoneNumbers(final List<CompanyPhoneNumber> phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
  }

  /**
   * @param phoneNumbers the phoneNumbers to set
   */
  public void addPhoneNumber(final CompanyPhoneNumber phoneNumber) {
    this.phoneNumbers.add(phoneNumber);
  }

  /**
   * @return the email
   */
  public List<CompanyEmail> getEmails() {
    return emails;
  }

  /**
   * @param email the email to set
   */
  public void setEmails(final List<CompanyEmail> emails) {
    this.emails = emails;
  }

  @Override
  public String toString() {
    return "id=" + id + ", name=" + companyName + ", updated=" + updated;
  }

  public CompanyEdo toEdo() {
    final CompanyEdo edo = new CompanyEdo();
    edo.setComments(comments);
    edo.setCompanyName(companyName);
    edo.setCreated(created);
    edo.setId(id);
    edo.setStatus(status);
    edo.setUpdated(updated);
    edo.setVersion(version);
    edo.setEmails(CompanyEmail.toEdoList(emails));
    edo.setPostalAddresses(CompanyPostalAddress.toEdoList(postalAddresses));
    edo.setPhoneNumbers(CompanyPhoneNumber.toEdoList(phoneNumbers));
    
    return edo;
  }

  public static Company fromEdo(final CompanyEdo edo) {
    final Company company = new Company();

    company.setComments(edo.getComments());
    company.setCompanyName(edo.getCompanyName());
    company.setCreated(edo.getCreated());
    company.setId(edo.getId());
    company.setStatus(edo.getStatus());
    company.setUpdated(edo.getUpdated());
    company.setVersion(edo.getVersion());
    company.setPhoneNumbers(CompanyPhoneNumber.fromEdoList(edo.getPhoneNumbers()));
    company.setPostalAddresses(CompanyPostalAddress.fromEdoList(edo.getPostalAddresses()));
    company.setEmails(CompanyEmail.fromEdoList(edo.getEmails()));

    return company;
  }

  public static List<CompanyEdo> toEdoList(final List<Company> list) {

    final List<CompanyEdo> edoList = new ArrayList<>();
    for (final Company p : list) {
      edoList.add(p.toEdo());
    }
    return edoList;
  }
}
