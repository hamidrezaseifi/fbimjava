package com.featurebim.core.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.featurebim.common.model.edo.ProjectRoleEdo;
import com.featurebim.common.rest.json.FBLocalDateTimeDeserializer;
import com.featurebim.common.rest.json.FBLocalDateTimeSerializer;

/**
 * The persistent class for the projects database table.
 *
 */

public class ProjectRole {
  
  private Long id;
  
  private Long companyid;
  
  private String name;
  
  private Long createdBy;
  
  private int version;
  
  private int status;
  
  @JsonSerialize(using = FBLocalDateTimeSerializer.class)
  @JsonDeserialize(using = FBLocalDateTimeDeserializer.class)
  private LocalDateTime created;
  
  @JsonSerialize(using = FBLocalDateTimeSerializer.class)
  @JsonDeserialize(using = FBLocalDateTimeDeserializer.class)
  private LocalDateTime updated;
  
  public ProjectRole() {
  }
  
  public boolean isNew() {
    return id == null || id < 1;
  }

  public Long getId() {
    return this.id;
  }
  
  public void setId(final Long id) {
    this.id = id != null ? id : 0;
  }
  
  public Long getCompanyid() {
    return companyid;
  }
  
  public void setCompanyid(final Long companyid) {
    this.companyid = companyid != null ? companyid : 0;
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
   * @return the createdBy
   */
  public Long getCreatedBy() {
    return createdBy;
  }
  
  /**
   * @param createdBy the createdBy to set
   */
  public void setCreatedBy(final Long createdBy) {
    this.createdBy = createdBy != null ? createdBy : 0;
  }
  
  public LocalDateTime getCreated() {
    return this.created;
  }
  
  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }
  
  public int getStatus() {
    return this.status;
  }
  
  public void setStatus(final int status) {
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

  public ProjectRoleEdo toEdo() {
    final ProjectRoleEdo edo = new ProjectRoleEdo();

    edo.setCompanyid(companyid);
    edo.setCreated(created);
    edo.setCreatedBy(createdBy);
    edo.setId(id);
    edo.setName(name);
    edo.setStatus(status);
    edo.setUpdated(updated);
    edo.setVersion(version);

    return edo;
  }

  public static ProjectRole fromEdo(final ProjectRoleEdo edo) {
    final ProjectRole role = new ProjectRole();

    role.setCompanyid(edo.getCompanyid());
    role.setCreated(edo.getCreated());
    role.setCreatedBy(edo.getCreatedBy());
    role.setId(edo.getId());
    role.setName(edo.getName());
    role.setStatus(edo.getStatus());
    role.setUpdated(edo.getUpdated());
    role.setVersion(edo.getVersion());

    return role;
  }

  public static List<ProjectRole> fromEdoList(final List<ProjectRoleEdo> edoList) {
    
    final List<ProjectRole> list = new ArrayList<>();

    for (final ProjectRoleEdo edo : edoList) {
      list.add(ProjectRole.fromEdo(edo));
    }
    return list;
  }

  public static List<ProjectRoleEdo> toEdoList(final List<ProjectRole> list) {
    
    final List<ProjectRoleEdo> edoList = new ArrayList<>();

    for (final ProjectRole role : list) {
      edoList.add(role.toEdo());
    }
    return edoList;
  }
}
