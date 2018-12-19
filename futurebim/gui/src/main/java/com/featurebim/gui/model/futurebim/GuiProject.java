package com.featurebim.gui.model.futurebim;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.featurebim.common.model.edo.ProjectEdo;
import com.featurebim.common.rest.json.FBLocalDateDeserializer;
import com.featurebim.common.rest.json.FBLocalDateSerializer;
import com.featurebim.gui.model.enums.EGuiProjectStatus;

/**
 * The persistent class for the projects database table.
 *
 */

public class GuiProject {
  
  private Long id;
  
  private Long parentProjectId;
  
  private Long companyid;
  
  private int projectType;
  
  private String projectTypeName;
  
  private String projectName;
  
  @JsonSerialize(using = FBLocalDateSerializer.class)
  @JsonDeserialize(using = FBLocalDateDeserializer.class)
  private LocalDate startDate;
  
  @JsonSerialize(using = FBLocalDateSerializer.class)
  @JsonDeserialize(using = FBLocalDateDeserializer.class)
  private LocalDate deadline;
  
  private EGuiProjectStatus status;
  
  private String statusName;
  
  private LocalDateTime created;
  
  private LocalDateTime updated;
  
  private int version;
  
  private List<GuiProjectUser> users = null;
  
  private List<GuiTask> tasks = null;
  
  public GuiProject() {
  }
  
  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long id) {
    this.id = id != null ? id : 0;
  }
  
  public Long getParentProjectId() {
    return parentProjectId;
  }
  
  public void setParentProjectId(final Long parentid) {
    this.parentProjectId = parentid != null ? parentid : 0;
  }
  
  public Long getCompanyid() {
    return companyid;
  }
  
  public void setCompanyid(final Long companyid) {
    this.companyid = companyid != null ? companyid : 0;
  }
  
  public int getProjectType() {
    return projectType;
  }
  
  public void setProjectType(final int projectType) {
    this.projectType = projectType;
  }

  /**
   * @return the projectTypeName
   */
  public String getProjectTypeName() {
    return projectTypeName;
  }

  /**
   * @param projectTypeName the projectTypeName to set
   */
  public void setProjectTypeName(final String projectTypeName) {
    this.projectTypeName = projectTypeName;
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
  
  public int getStatus() {
    return this.status.getId();
  }
  
  public EGuiProjectStatus getStatusEnum() {
    return this.status;
  }
  
  public void setStatus(final int status) {
    this.status = EGuiProjectStatus.fromId(status);
  }
  
  /**
   * @return the statusName
   */
  public String getStatusName() {
    return statusName;
  }
  
  /**
   * @param statusName the statusName to set
   */
  public void setStatusName(final String statusName) {
    this.statusName = statusName;
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
   * @return the users
   */
  public List<GuiProjectUser> getUsers() {
    return users;
  }

  /**
   * @param users the users to set
   */
  public void setUsers(final List<GuiProjectUser> users) {
    this.users = users;
  }

  /**
   * @return the tasks
   */
  public List<GuiTask> getTasks() {
    return tasks;
  }
  
  /**
   * @param tasks the tasks to set
   */
  public void setTasks(final List<GuiTask> tasks) {
    this.tasks = tasks;
  }
  
  public ProjectEdo toEdo() {
    final ProjectEdo edo = new ProjectEdo();
    edo.setCompanyid(companyid);
    edo.setProjectType(projectType);
    edo.setDeadline(deadline);
    edo.setProjectName(projectName);
    edo.setStartDate(startDate);
    edo.setStatus(status.getId());
    edo.setCreated(created);
    edo.setId(id);
    edo.setUpdated(updated);
    edo.setVersion(version);
    edo.setParentProjectId(parentProjectId);
    edo.setProjectType(projectType);
    
    return edo;
  }

  public static GuiProject fromEdo(final ProjectEdo edo) {
    final GuiProject project = new GuiProject();
    
    project.setCompanyid(edo.getCompanyid());
    project.setDeadline(edo.getDeadline());
    project.setProjectName(edo.getProjectName());
    project.setStartDate(edo.getStartDate());
    project.setProjectType(edo.getProjectType());
    project.setParentProjectId(edo.getParentProjectId());
    project.setCreated(edo.getCreated());
    project.setId(edo.getId());
    project.setStatus(edo.getStatus());
    project.setUpdated(edo.getUpdated());
    project.setVersion(edo.getVersion());
    
    return project;
  }
  
  public static GuiProject createNew(final Long companyId, final Long parentProject, final String title) {
    final GuiProject project = new GuiProject();
    
    project.setCompanyid(companyId);
    project.setProjectType(0);
    project.setParentProjectId(parentProject);
    project.setId(0L);
    project.setStatus(1);
    project.setVersion(1);
    project.setStartDate(LocalDate.now());
    project.setProjectName(title);
    
    return project;
  }
  
  public static List<ProjectEdo> toEdoList(final List<GuiProject> list) {
    
    final List<ProjectEdo> edoList = new ArrayList<>();
    for (final GuiProject p : list) {
      edoList.add(p.toEdo());
    }
    return edoList;
  }
  
  public static List<GuiProject> fromEdoList(final List<ProjectEdo> edoList) {
    
    final List<GuiProject> list = new ArrayList<>();
    for (final ProjectEdo edo : edoList) {
      list.add(GuiProject.fromEdo(edo));
    }
    return list;
  }
  
}
