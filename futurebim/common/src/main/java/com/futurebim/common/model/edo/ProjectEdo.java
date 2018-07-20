package com.futurebim.common.model.edo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.futurebim.common.model.edo.ifc.ProjectIfcProxyEdo;
import com.futurebim.common.model.enums.EStatus;

/**
 * The persistent class for the projects database table.
 *
 */

public class ProjectEdo {

  protected Long id;

  protected Long companyid;

  protected LocalDate deatline;

  protected String projectName;

  protected LocalDate startDate;

  protected EStatus status;

  protected LocalDateTime created;

  protected LocalDateTime updated;

  protected int version;

  @JacksonXmlElementWrapper(localName = "ProjectIfcList")
  @JacksonXmlProperty(localName = "ProjectIfc")
  private List<ProjectIfcProxyEdo> ProjectIfcProxyList = new ArrayList<>();

  public ProjectEdo() {
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

  public List<ProjectIfcProxyEdo> getProjectIfcProxyList() {
    return ProjectIfcProxyList;
  }

  public void setProjectIfcProxyList(final List<ProjectIfcProxyEdo> projectIfcProxyList) {
    ProjectIfcProxyList = projectIfcProxyList;
  }

  public void addProjectIfcProxy(final ProjectIfcProxyEdo projectIfcProxy) {
    ProjectIfcProxyList.add(projectIfcProxy);
  }

}
