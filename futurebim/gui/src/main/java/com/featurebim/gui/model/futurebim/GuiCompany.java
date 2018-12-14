package com.featurebim.gui.model.futurebim;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.featurebim.common.model.edo.CompanyEdo;
import com.featurebim.gui.model.enums.EGuiCompanyStatus;

/**
 * The persistent class for the companies database table.
 *
 */
public class GuiCompany {
  
  private Long id;
  
  private String identname;
  
  private String comments;
  
  private String companyName;
  
  private EGuiCompanyStatus status;
  
  private int version;
  
  private LocalDateTime created;
  
  private LocalDateTime updated;
  
  List<GuiCompanyPostalAddress> postalAddresses = new ArrayList<>();
  
  List<GuiCompanyPhoneNumber> phoneNumbers = new ArrayList<>();
  
  List<GuiCompanyEmail> emails = new ArrayList<>();

  List<Long> contactPersons = new ArrayList<>();
  
  public GuiCompany() {
  }
  
  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long id) {
    this.id = id;
  }
  
  /**
   * @return the identname
   */
  public String getIdentname() {
    return identname;
  }
  
  /**
   * @param identname the identname to set
   */
  public void setIdentname(final String identname) {
    this.identname = identname;
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
    return this.status.getId();
  }
  
  public EGuiCompanyStatus getStatusEnum() {
    return this.status;
  }

  public void setStatus(final int status) {
    this.status = EGuiCompanyStatus.fromId(status);
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
   * @return the postalAddresses
   */
  public List<GuiCompanyPostalAddress> getPostalAddresses() {
    return postalAddresses;
  }

  /**
   * @param postalAddresses the postalAddresses to set
   */
  public void setPostalAddresses(final List<GuiCompanyPostalAddress> postalAddresses) {
    if (postalAddresses != null) {
      this.postalAddresses = postalAddresses;
    }
  }

  /**
   * @return the phoneNumbers
   */
  public List<GuiCompanyPhoneNumber> getPhoneNumbers() {
    return phoneNumbers;
  }

  /**
   * @param phoneNumbers the phoneNumbers to set
   */
  public void setPhoneNumbers(final List<GuiCompanyPhoneNumber> phoneNumbers) {
    if (phoneNumbers != null) {
      this.phoneNumbers = phoneNumbers;
    }
  }

  /**
   * @return the emails
   */
  public List<GuiCompanyEmail> getEmails() {
    return emails;
  }

  /**
   * @param emails the emails to set
   */
  public void setEmails(final List<GuiCompanyEmail> emails) {
    if (emails != null) {
      this.emails = emails;
    }
  }

  /**
   * @return the contactPersons
   */
  public List<Long> getContactPersons() {
    return contactPersons;
  }

  /**
   * @param contactPersons the contactPersons to set
   */
  public void setContactPersons(final List<Long> contactPersons) {
    this.contactPersons = contactPersons;
  }

  public CompanyEdo toEdo() {
    final CompanyEdo edo = new CompanyEdo();
    edo.setComments(comments);
    edo.setCompanyName(companyName);
    edo.setId(id);
    edo.setIdentname(identname);
    edo.setStatus(status.getId());
    edo.setVersion(version);
    edo.setPostalAddresses(GuiCompanyPostalAddress.toEdoList(postalAddresses));
    edo.setPhoneNumbers(GuiCompanyPhoneNumber.toEdoList(phoneNumbers));
    edo.setEmails(GuiCompanyEmail.toEdoList(emails));
    edo.setContactPersons(contactPersons);
    
    return edo;
  }
  
  public static GuiCompany fromEdo(final CompanyEdo edo) {
    final GuiCompany company = new GuiCompany();
    
    company.setComments(edo.getComments());
    company.setCompanyName(edo.getCompanyName());
    company.setCreated(edo.getCreated());
    company.setId(edo.getId());
    company.setIdentname(edo.getIdentname());
    company.setStatus(edo.getStatus());
    company.setUpdated(edo.getUpdated());
    company.setVersion(edo.getVersion());
    company.setPostalAddresses(GuiCompanyPostalAddress.fromEdoList(edo.getPostalAddresses()));
    company.setPhoneNumbers(GuiCompanyPhoneNumber.fromEdoList(edo.getPhoneNumbers()));
    company.setEmails(GuiCompanyEmail.fromEdoList(edo.getEmails()));
    company.setContactPersons(edo.getContactPersons());

    return company;
  }
  
  public static List<CompanyEdo> toEdoList(final List<GuiCompany> list) {
    
    final List<CompanyEdo> edoList = new ArrayList<>();
    for (final GuiCompany p : list) {
      edoList.add(p.toEdo());
    }
    return edoList;
  }
}
