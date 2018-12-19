package com.featurebim.core.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.featurebim.common.model.edo.TaskEdo;
import com.featurebim.common.rest.json.JsonConstants;

/**
 * The persistent class for the users database table.
 *
 */
public class Task {

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

  public boolean isNew() {
    return id == null || id < 1;
  }
  
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
   * @return the projectid
   */
  public Long getProjectid() {
    return projectid;
  }

  /**
   * @param projectid the projectid to set
   */
  public void setProjectid(final Long projectid) {
    this.projectid = projectid;
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
    this.reporter = reporter;
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
    this.assignedTo = assignedTo;
  }

  /**
   * @return the startDate
   */
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

  public static Task fromEdo(final TaskEdo edo) {
    final Task model = new Task();

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

  public static List<TaskEdo> toEdoList(final List<Task> list) {

    final List<TaskEdo> edoList = new ArrayList<>();
    for (final Task p : list) {
      edoList.add(p.toEdo());
    }
    return edoList;
  }

  public static List<Task> fromEdoList(final List<TaskEdo> edoList) {

    final List<Task> list = new ArrayList<>();
    for (final TaskEdo edo : edoList) {
      list.add(Task.fromEdo(edo));
    }
    return list;
  }
}
