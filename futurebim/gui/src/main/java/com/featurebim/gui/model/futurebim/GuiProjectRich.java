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

public class GuiProjectRich  {
  
  private Long id;
  
  private Long companyid;
  
  private LocalDateTime created;
  
  private LocalDate deatline;
  
  private String projectName;
  
  private LocalDate startDate;
  
  private EStatus status;
  
  private LocalDateTime updated;
  
  private int version;
  
  
  
  public GuiProjectRich() {
  }
  
  
  public GuiProjectRich(final ProjectEdo edo) {
    this.setCompanyid(edo.getCompanyid());
    this.setCreated(edo.getCreated());
    this.setDeatline(edo.getDeatline());
    this.setId(edo.getId());
    this.setProjectName(edo.getProjectName());
    this.setStartDate(edo.getStartDate());
    this.setStatus(edo.getStatus());
    this.setUpdated(edo.getUpdated());
    this.setVersion(edo.getVersion());


  }
  
  
  public static List<GuiProjectRich> fromEdoList(final List<ProjectEdo> edoList) {
    
    final List<GuiProjectRich> list = new ArrayList<>();
    for (final ProjectEdo edo : edoList) {
      list.add(new GuiProjectRich(edo));
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
  
  
  public void setStatus(final EStatus status) {
    this.status = status;
  }



}
