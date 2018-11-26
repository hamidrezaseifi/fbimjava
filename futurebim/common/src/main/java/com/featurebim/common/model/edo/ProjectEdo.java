package com.featurebim.common.model.edo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.featurebim.common.model.enums.EStatus;

/**
 * The persistent class for the projects database table.
 *
 */

public class ProjectEdo {

  private Long id;

  private Long parentProjectId;

  private Long companyid;

  private int projectType;

  private LocalDateTime created;

  private LocalDate deadline;

  private String projectName;

  private LocalDate startDate;

  private EStatus status;

  private LocalDateTime updated;

  private int version;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getParentProjectId() {
    return parentProjectId;
  }

  public void setParentProjectId(final Long parentProjectId) {
    this.parentProjectId = parentProjectId;
  }

  public Long getCompanyid() {
    return companyid;
  }

  public void setCompanyid(final Long companyid) {
    this.companyid = companyid;
  }

  public int getProjectType() {
    return projectType;
  }

  public void setProjectType(final int projectType) {
    this.projectType = projectType;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public LocalDate getDeadline() {
    return deadline;
  }

  public void setDeadline(final LocalDate deadline) {
    this.deadline = deadline;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(final String projectName) {
    this.projectName = projectName;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(final LocalDate startDate) {
    this.startDate = startDate;
  }

  public EStatus getStatus() {
    return status;
  }

  public void setStatus(final EStatus status) {
    this.status = status;
  }

  public LocalDateTime getUpdated() {
    return updated;
  }

  public void setUpdated(final LocalDateTime updated) {
    this.updated = updated;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(final int version) {
    this.version = version;
  }

}
