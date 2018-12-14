package com.featurebim.gui.model.futurebim;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.featurebim.common.model.edo.CompanyEmailEdo;

/**
 * The persistent class for the companies database table.
 *
 */
public class GuiCompanyEmail {

  private Long id;

  private Long companyid;

  private String email_name;

  private String email;

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
   * @return the email_name
   */
  public String getEmailName() {
    return email_name;
  }

  /**
   * @param email_name the email_name to set
   */
  public void setEmailName(final String email_name) {
    this.email_name = email_name;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(final String email) {
    this.email = email;
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

  public CompanyEmailEdo toEdo() {
    final CompanyEmailEdo edo = new CompanyEmailEdo();
    edo.setComments(comments);
    edo.setId(id);
    edo.setStatus(status);
    edo.setVersion(version);
    edo.setCompanyid(companyid);
    edo.setEmail(email);
    edo.setEmailName(email_name);

    return edo;
  }

  public static GuiCompanyEmail fromEdo(final CompanyEmailEdo edo) {
    final GuiCompanyEmail number = new GuiCompanyEmail();

    number.setComments(edo.getComments());
    number.setCreated(edo.getCreated());
    number.setId(edo.getId());
    number.setStatus(edo.getStatus());
    number.setUpdated(edo.getUpdated());
    number.setVersion(edo.getVersion());
    number.setCompanyid(edo.getCompanyid());
    number.setEmail(edo.getEmail());
    number.setEmailName(edo.getEmailName());

    return number;
  }

  public static List<GuiCompanyEmail> fromEdoList(final List<CompanyEmailEdo> edoList) {

    final List<GuiCompanyEmail> list = new ArrayList<>();
    for (final CompanyEmailEdo edo : edoList) {
      list.add(GuiCompanyEmail.fromEdo(edo));
    }
    return list;
  }

  public static List<CompanyEmailEdo> toEdoList(final List<GuiCompanyEmail> list) {

    final List<CompanyEmailEdo> edoList = new ArrayList<>();
    for (final GuiCompanyEmail p : list) {
      edoList.add(p.toEdo());
    }
    return edoList;
  }
}
