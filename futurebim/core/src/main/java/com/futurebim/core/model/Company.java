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
public class Company extends CompanyReference {

  private static final long serialVersionUID = 1L;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "companyid", targetEntity = UserReference.class)
  private List<UserReference> users = new ArrayList<>();

  // @JsonIgnore
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "companyid", targetEntity = ProjectReference.class)
  private List<ProjectReference> projects = new ArrayList<>();

  public Company() {
  }

  public Company(final String name, final String comments) {
    this.companyName = name;
    this.comments = comments;
    this.status = EStatus.Active;
    this.created = LocalDateTime.now();
    this.updated = LocalDateTime.now();
  }

  public List<UserReference> getUsers() {
    return users;
  }

  public void setUsers(final List<UserReference> users) {
    this.users = users;
  }

  public List<ProjectReference> getProjects() {
    return projects;
  }

  public void setProjects(final List<ProjectReference> projects) {
    this.projects = projects;
  }

  @Override
  public String toString() {
    return "id=" + id + ", name=" + companyName + ", updated=" + updated;
  }

}
