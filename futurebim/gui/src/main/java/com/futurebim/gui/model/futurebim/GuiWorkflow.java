package com.futurebim.gui.model.futurebim;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.futurebim.common.model.edo.WorkflowEdo;
import com.futurebim.common.rest.json.FBLocalDateTimeDeserializer;
import com.futurebim.common.rest.json.FBLocalDateTimeSerializer;

/**
 * The persistent class for the projects database table.
 *
 */

public class GuiWorkflow {
  
  private Long id;
  
  private Long projectid;
  
  private int type;
  
  private String name;
  
  private Long responsible;
  
  private Long reporter;
  
  private int status;
  
  @JsonSerialize(using = FBLocalDateTimeSerializer.class)
  @JsonDeserialize(using = FBLocalDateTimeDeserializer.class)
  private LocalDateTime created;
  
  @JsonSerialize(using = FBLocalDateTimeSerializer.class)
  @JsonDeserialize(using = FBLocalDateTimeDeserializer.class)
  private LocalDateTime updated;
  
  private int version;
  
  private GuiUserFull reporterUser;
  
  private GuiUserFull responsibleUser;
  
  private String statusName;
  
  private String typeName;
  
  public GuiWorkflow() {
  }
  
  public Long getId() {
    return this.id;
  }
  
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
   * @return the type
   */
  public int getType() {
    return type;
  }
  
  /**
   * @param type the type to set
   */
  public void setType(final int type) {
    this.type = type;
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
   * @return the responsible
   */
  public Long getResponsible() {
    return responsible;
  }
  
  /**
   * @param responsible the responsible to set
   */
  public void setResponsible(final Long responsible) {
    this.responsible = responsible != null ? responsible : 0;
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
   * @return the reporterUser
   */
  public GuiUserFull getReporterUser() {
    return reporterUser;
  }

  /**
   * @param reporterUser the reporterUser to set
   */
  public GuiWorkflow setReporterUser(final GuiUserFull reporterUser) {
    this.reporterUser = reporterUser;
    return this;
  }

  /**
   * @return the responsibleUser
   */
  public GuiUserFull getResponsibleUser() {
    return responsibleUser;
  }

  /**
   * @param responsibleUser the responsibleUser to set
   */
  public GuiWorkflow setResponsibleUser(final GuiUserFull responsibleUser) {
    this.responsibleUser = responsibleUser;
    return this;
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
  public GuiWorkflow setStatusName(final String statusName) {
    this.statusName = statusName;
    return this;
  }

  /**
   * @return the typeName
   */
  public String getTypeName() {
    return typeName;
  }

  /**
   * @return the typeName
   */
  public String getResponsibleName() {
    return responsibleUser != null ? responsibleUser.getFullname() : "";
  }

  /**
   * @param typeName the typeName to set
   */
  public GuiWorkflow setTypeName(final String typeName) {
    this.typeName = typeName;
    return this;
  }

  public WorkflowEdo toEdo() {
    final WorkflowEdo edo = new WorkflowEdo();
    
    edo.setId(id);
    edo.setName(name);
    edo.setProjectid(projectid);
    edo.setReporter(reporter);
    edo.setResponsible(responsible);
    edo.setType(type);
    
    edo.setCreated(created);
    edo.setId(id);
    edo.setStatus(status);
    edo.setUpdated(updated);
    edo.setVersion(version);
    
    return edo;
  }
  
  public static GuiWorkflow fromEdo(final WorkflowEdo edo) {
    final GuiWorkflow model = new GuiWorkflow();
    
    model.setId(edo.getId());
    model.setName(edo.getName());
    model.setProjectid(edo.getProjectid());
    model.setReporter(edo.getReporter());
    model.setResponsible(edo.getResponsible());
    model.setType(edo.getType());
    
    model.setCreated(edo.getCreated());
    model.setId(edo.getId());
    model.setStatus(edo.getStatus());
    model.setUpdated(edo.getUpdated());
    model.setVersion(edo.getVersion());
    
    return model;
  }
  
  public static List<WorkflowEdo> toEdoList(final List<GuiWorkflow> list) {
    
    final List<WorkflowEdo> edoList = new ArrayList<>();
    for (final GuiWorkflow p : list) {
      edoList.add(p.toEdo());
    }
    return edoList;
  }
  
  public static List<GuiWorkflow> fromEdoList(final List<WorkflowEdo> edoList) {
    
    final List<GuiWorkflow> list = new ArrayList<>();
    if (edoList != null) {
      for (final WorkflowEdo edo : edoList) {
        list.add(GuiWorkflow.fromEdo(edo));
      }
    }
    return list;
  }
}
