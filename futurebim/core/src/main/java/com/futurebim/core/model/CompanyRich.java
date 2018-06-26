package com.futurebim.core.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.futurebim.common.model.enums.EStatus;

/**
 * The persistent class for the companies database table.
 *
 */
@Entity
@Table(name = "companies")
public class CompanyRich extends Company {

  private static final long serialVersionUID = 1L;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "companyid", targetEntity = User.class)
  private List<User> users = new ArrayList<>();

  // @JsonIgnore
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "companyid", targetEntity = Project.class)
  private List<Project> projects = new ArrayList<>();

  public CompanyRich() {
  }

  public CompanyRich(final String name, final String comments) {
    this.companyName = name;
    this.comments = comments;
    this.status = EStatus.Active;
    this.created = LocalDateTime.now();
    this.updated = LocalDateTime.now();
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(final List<User> users) {
    this.users = users;
  }

  public List<Project> getProjects() {
    return projects;
  }

  public void setProjects(final List<Project> projects) {
    this.projects = projects;
  }

  @Override
  public String toString() {
    return "id=" + id + ", name=" + companyName + ", updated=" + updated;
  }

}
