package com.featurebim.core.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.featurebim.common.model.edo.ProjectEdo;
import com.featurebim.common.model.enums.EStatus;
import com.featurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the projects database table.
 *
 */
public class Project extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

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

  public Project() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getParentProjectId() {
    return parentProjectId;
  }

  public void setParentProjectId(final Long parentid) {
    this.parentProjectId = parentid;
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

  public void setDeadline(final LocalDateTime deatline) {
    this.deadline = deatline.toLocalDate();
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

  public void setStartDate(final LocalDateTime startDate) {
    this.startDate = startDate.toLocalDate();
  }

  public EStatus getStatus() {
    return this.status;
  }

  public void setStatus(final Long status) {
    this.status = EStatus.ofId(status);
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

  public ProjectEdo toEdo() {
    final ProjectEdo edo = new ProjectEdo();
    edo.setCompanyid(companyid);
    edo.setDeadline(deadline);
    edo.setProjectName(projectName);
    edo.setStartDate(startDate);
    edo.setStatus(status);
    edo.setCreated(created);
    edo.setId(id);
    edo.setUpdated(updated);
    edo.setVersion(version);

    return edo;
  }

  public static List<ProjectEdo> toEdoList(final List<Project> list) {

    final List<ProjectEdo> edoList = new ArrayList<>();
    for (final Project p : list) {
      edoList.add(p.toEdo());
    }
    return edoList;
  }
}
