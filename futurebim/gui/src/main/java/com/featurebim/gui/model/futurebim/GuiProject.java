package com.featurebim.gui.model.futurebim;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.featurebim.common.model.edo.ProjectEdo;
import com.featurebim.common.model.enums.EStatus;

/**
 * The persistent class for the projects database table.
 *
 */

public class GuiProject  {
  
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
  
  
  
  public GuiProject() {
  }
  
  public static List<GuiProject> fromEdoList(final List<ProjectEdo> edoList) {
    
    final List<GuiProject> list = new ArrayList<>();
    for (final ProjectEdo edo : edoList) {
      list.add(GuiProject.fromEdo(edo));
    }
    return list;
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
  
  
  public void setStatus(final EStatus status) {
    this.status = status;
  }
  
  

  public Long getParentProjectId() {
    return parentProjectId;
  }
  
  

  public void setParentProjectId(final Long parentProjectId) {
    this.parentProjectId = parentProjectId;
  }
  
  

  public int getProjectType() {
    return projectType;
  }
  
  

  public void setProjectType(final int projectType) {
    this.projectType = projectType;
  }


  public static GuiProject fromEdo(final ProjectEdo edo) {
    final GuiProject project = new GuiProject();
    
    project.setCompanyid(edo.getCompanyid());
    project.setCreated(edo.getCreated());
    project.setDeadline(edo.getDeadline());
    project.setId(edo.getId());
    project.setProjectName(edo.getProjectName());
    project.setStartDate(edo.getStartDate());
    project.setStatus(edo.getStatus());
    project.setUpdated(edo.getUpdated());
    project.setVersion(edo.getVersion());
    project.setParentProjectId(edo.getParentProjectId());
    project.setProjectType(edo.getProjectType());
    
    return project;
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
    edo.setParentProjectId(parentProjectId);
    edo.setProjectType(projectType);

    return edo;
  }

}
