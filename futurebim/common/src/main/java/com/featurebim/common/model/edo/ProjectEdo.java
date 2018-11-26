package com.featurebim.common.model.edo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.featurebim.common.model.enums.EStatus;

/**
 * The persistent class for the projects database table.
 *
 */

public class ProjectEdo {

  protected Long id;

  protected Long companyid;

  protected LocalDate deadline;

  protected String projectName;

  protected LocalDate startDate;

  protected EStatus status;

  protected LocalDateTime created;

  protected LocalDateTime updated;

  protected int version;

  public ProjectEdo() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getCompanyid() {
    return companyid;
  }

  public void setCompanyid(final Long companyid) {
    this.companyid = companyid;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public LocalDate getDeadline() {
    return this.deadline;
  }

  public void setDeadline(final LocalDate deatline) {
    this.deadline = deatline;
  }

  public String getProjectName() {
    return this.projectName;
  }

  public void setProjectName(final String projectName) {
    this.projectName = projectName;
  }

  public LocalDate getStartDate() {
    return this.startDate;
  }

  public void setStartDate(final LocalDate startDate) {
    this.startDate = startDate;
  }

  public EStatus getStatus() {
    return this.status;
  }

  public void setStatus(final EStatus status) {
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

}
