package com.futurebim.gui.model.futurebim;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.futurebim.common.model.edo.TaskEdo;
import com.futurebim.common.model.enums.ETaskStatus;
import com.futurebim.common.rest.json.JsonConstants;
import com.futurebim.gui.model.futurebim.base.IDateLimited;

/**
 * The persistent class for the users database table.
 *
 */
public class GuiTask implements IDateLimited {

  private Long id;

  private Long projectid;

  private String name;

  private String comments;

  private Long reporter;

  private Long assignedTo;

  @JsonFormat(pattern = JsonConstants.DATE_FORMAT_ISO)
  private LocalDate startDate;

  @JsonFormat(pattern = JsonConstants.DATE_FORMAT_ISO)
  private LocalDate deadline;

  private int status;

  private int version;

  @JsonFormat(pattern = JsonConstants.DATETIME_FORMAT_ISO)
  private LocalDateTime created;

  @JsonFormat(pattern = JsonConstants.DATETIME_FORMAT_ISO)
  private LocalDateTime updated;

  private GuiUserFull reporterUser;

  private GuiUserFull assignedToUser;

  private String statusName;

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
    this.id = id != null ? id : 0;
  }

  /**
   * @return the projectid
   */
  public Long getProjectid() {
    return projectid;
  }

  /**
   * @param projectid the projectid to set
   */
  public void setProjectid(final Long projectid) {
    this.projectid = projectid != null ? projectid : 0;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(final String name) {
    this.name = name;
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
   * @return the reporter
   */
  public Long getReporter() {
    return reporter;
  }

  /**
   * @param reporter the reporter to set
   */
  public void setReporter(final Long reporter) {
    this.reporter = reporter != null ? reporter : 0;
  }

  /**
   * @return the assignedTo
   */
  public Long getAssignedTo() {
    return assignedTo;
  }

  /**
   * @param assignedTo the assignedTo to set
   */
  public void setAssignedTo(final Long assignedTo) {
    this.assignedTo = assignedTo != null ? assignedTo : 0;
  }

  /**
   * @return the startDate
   */
  @Override
  public LocalDate getStartDate() {
    return startDate;
  }

  /**
   * @param startDate the startDate to set
   */
  public void setStartDate(final LocalDate startDate) {
    this.startDate = startDate;
  }

  /**
   * @return the deadline
   */
  @Override
  public LocalDate getDeadline() {
    return deadline;
  }

  /**
   * @param deadline the deadline to set
   */
  public void setDeadline(final LocalDate deadline) {
    this.deadline = deadline;
  }

  /**
   * @return the status
   */
  public int getStatus() {
    return status;
  }

  /**
   * @return the status
   */
  public ETaskStatus getStatusEnum() {
    return ETaskStatus.fromDbValue(status);
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

  /**
   * @return the reporterUser
   */
  public GuiUserFull getReporterUser() {
    return reporterUser;
  }

  /**
   * @param reporterUser the reporterUser to set
   */
  public GuiTask setReporterUser(final GuiUserFull reporterUser) {
    this.reporterUser = reporterUser;
    return this;
  }

  /**
   * @return the assignedToUser
   */
  public GuiUserFull getAssignedToUser() {
    return assignedToUser;
  }

  /**
   * @param assignedToUser the assignedToUser to set
   */
  public GuiTask setAssignedToUser(final GuiUserFull assignedToUser) {
    this.assignedToUser = assignedToUser;
    return this;
  }
  
  public String getAssignedName() {
    return assignedToUser != null ? assignedToUser.getFullname() : "";
  }
  
  public String getReporterName() {
    return reporterUser != null ? reporterUser.getFullname() : "";
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
  public GuiTask setStatusName(final String statusName) {
    this.statusName = statusName;
    return this;
  }
  
  public TaskEdo toEdo() {
    final TaskEdo edo = new TaskEdo();
    edo.setAssignedTo(assignedTo);
    edo.setComments(comments);
    edo.setDeadline(deadline);
    edo.setId(id);
    edo.setName(name);
    edo.setProjectid(projectid);
    edo.setReporter(reporter);
    edo.setStartDate(startDate);

    edo.setCreated(created);
    edo.setId(id);
    edo.setStatus(status);
    edo.setUpdated(updated);
    edo.setVersion(version);

    return edo;
  }

  public static GuiTask fromEdo(final TaskEdo edo) {
    final GuiTask model = new GuiTask();

    model.setAssignedTo(edo.getAssignedTo());
    model.setComments(edo.getComments());
    model.setDeadline(edo.getDeadline());
    model.setId(edo.getId());
    model.setName(edo.getName());
    model.setProjectid(edo.getProjectid());
    model.setReporter(edo.getReporter());
    model.setStartDate(edo.getStartDate());

    model.setCreated(edo.getCreated());
    model.setId(edo.getId());
    model.setStatus(edo.getStatus());
    model.setUpdated(edo.getUpdated());
    model.setVersion(edo.getVersion());

    return model;
  }

  public static List<TaskEdo> toEdoList(final List<GuiTask> list) {

    final List<TaskEdo> edoList = new ArrayList<>();
    for (final GuiTask p : list) {
      edoList.add(p.toEdo());
    }
    return edoList;
  }

  public static List<GuiTask> fromEdoList(final List<TaskEdo> edoList) {

    final List<GuiTask> list = new ArrayList<>();
    if (edoList != null) {
      for (final TaskEdo edo : edoList) {
        list.add(GuiTask.fromEdo(edo));
      }
    }
    return list;
  }
}
