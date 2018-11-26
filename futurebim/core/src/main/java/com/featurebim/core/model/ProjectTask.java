package com.featurebim.core.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.featurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the project_tasks database table.
 *
 */
public class ProjectTask extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  private int id;

  private LocalDateTime created;

  private LocalDate deatline;

  private LocalDate startDate;

  private short status;

  private String taskComments;

  private String taskName;

  private LocalDateTime updated;

  private int userAllocated;

  private int userCreate;

  private int version;

  private Project project;

  public ProjectTask() {
  }

  public int getId() {
    return this.id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public LocalDate getDeatline() {
    return this.deatline;
  }

  public void setDeatline(final LocalDate deatline) {
    this.deatline = deatline;
  }

  public LocalDate getStartDate() {
    return this.startDate;
  }

  public void setStartDate(final LocalDate startDate) {
    this.startDate = startDate;
  }

  public short getStatus() {
    return this.status;
  }

  public void setStatus(final short status) {
    this.status = status;
  }

  public String getTaskComments() {
    return this.taskComments;
  }

  public void setTaskComments(final String taskComments) {
    this.taskComments = taskComments;
  }

  public String getTaskName() {
    return this.taskName;
  }

  public void setTaskName(final String taskName) {
    this.taskName = taskName;
  }

  public LocalDateTime getUpdated() {
    return this.updated;
  }

  public void setUpdated(final LocalDateTime updated) {
    this.updated = updated;
  }

  public int getUserAllocated() {
    return this.userAllocated;
  }

  public void setUserAllocated(final int userAllocated) {
    this.userAllocated = userAllocated;
  }

  public int getUserCreate() {
    return this.userCreate;
  }

  public void setUserCreate(final int userCreate) {
    this.userCreate = userCreate;
  }

  public int getVersion() {
    return this.version;
  }

  public void setVersion(final int version) {
    this.version = version;
  }

  public Project getProject() {
    return this.project;
  }

  public void setProject(final Project project) {
    this.project = project;
  }

}
