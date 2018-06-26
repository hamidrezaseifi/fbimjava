package com.futurebim.core.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.futurebim.common.model.enums.EStatus;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the projects database table.
 *
 */
@Entity
@Table(name = "projects")
public class ProjectRich extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long companyid;

  private LocalDateTime created;

  private LocalDate deatline;

  @Column(name = "project_name")
  private String projectName;

  @Column(name = "start_date")
  private LocalDate startDate;

  private EStatus status;

  private LocalDateTime updated;

  private int version;

  /*
   * private List<ProjectBcfFile> projectBcfFiles; private List<ProjectIfcFile> projectIfcFiles; private List<ProjectTask> projectTasks;
   */

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "companyid", insertable = false, updatable = false)
  private Company companyBean;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "id.projectid", targetEntity = UserProjectAccess.class)
  private List<UserProjectAccess> userProjectAccesses;

  public ProjectRich() {
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

  public LocalDate getDeatline() {
    return this.deatline;
  }

  public void setDeatline(final LocalDate deatline) {
    this.deatline = deatline;
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

  public Company getCompanyBean() {
    return this.companyBean;
  }

  public void setCompanyBean(final Company companyBean) {
    this.companyBean = companyBean;
  }

  public List<UserProjectAccess> getUserProjectAccesses() {
    return this.userProjectAccesses;
  }

  public void setUserProjectAccesses(final List<UserProjectAccess> userProjectAccesses) {
    this.userProjectAccesses = userProjectAccesses;
  }

  public UserProjectAccess addUserProjectAccess(final UserProjectAccess userProjectAccess) {
    getUserProjectAccesses().add(userProjectAccess);

    return userProjectAccess;
  }

  public UserProjectAccess removeUserProjectAccess(final UserProjectAccess userProjectAccess) {
    getUserProjectAccesses().remove(userProjectAccess);

    return userProjectAccess;
  }

}
