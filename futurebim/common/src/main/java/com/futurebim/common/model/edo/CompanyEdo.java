package com.futurebim.common.model.edo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.futurebim.common.model.enums.EStatus;

/**
 * The persistent class for the companies database table.
 *
 */
public class CompanyEdo {

  private Long id;

  private String comments;

  private String companyName;

  private EStatus status;

  private int version;

  private LocalDateTime created;

  private LocalDateTime updated;

  private List<UserReferenceEdo> users = new ArrayList<>();

  private List<ProjectReferenceEdo> projects = new ArrayList<>();

  public CompanyEdo() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
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

  public List<UserReferenceEdo> getUsers() {
    return users;
  }

  public void setUsers(final List<UserReferenceEdo> users) {
    this.users = users;
  }

  public List<ProjectReferenceEdo> getProjects() {
    return projects;
  }

  public void setProjects(final List<ProjectReferenceEdo> projects) {
    this.projects = projects;
  }

  @Override
  public String toString() {
    return "id=" + id + ", name=" + companyName + ", updated=" + updated;
  }

}
