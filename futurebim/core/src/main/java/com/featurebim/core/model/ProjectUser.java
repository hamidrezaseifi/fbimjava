package com.featurebim.core.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.featurebim.common.model.edo.ProjectUserEdo;
import com.featurebim.common.rest.json.FBLocalDateTimeDeserializer;
import com.featurebim.common.rest.json.FBLocalDateTimeSerializer;

/**
 * The persistent class for the projects database table.
 *
 */

public class ProjectUser {
  
  private Long userId;
  
  private Long projectId;
  
  private Long roleId;
  
  private int accessType;
  
  @JsonSerialize(using = FBLocalDateTimeSerializer.class)
  @JsonDeserialize(using = FBLocalDateTimeDeserializer.class)
  private LocalDateTime created;
  
  @JsonSerialize(using = FBLocalDateTimeSerializer.class)
  @JsonDeserialize(using = FBLocalDateTimeDeserializer.class)
  private LocalDateTime updated;
  
  /**
   * @return the userId
   */
  public Long getUserId() {
    return userId;
  }
  
  /**
   * @param userId the userId to set
   */
  public void setUserId(final Long id) {
    this.userId = id != null ? id : 0;;
  }
  
  /**
   * @return the projectId
   */
  public Long getProjectId() {
    return projectId;
  }
  
  /**
   * @param projectId the projectId to set
   */
  public void setProjectId(final Long id) {
    this.projectId = id != null ? id : 0;;
  }
  
  /**
   * @return the roleId
   */
  public Long getRoleId() {
    return roleId;
  }
  
  /**
   * @param roleId the roleId to set
   */
  public void setRoleId(final Long id) {
    this.roleId = id != null ? id : 0;;
  }
  
  /**
   * @return the accessType
   */
  public int getAccessType() {
    return accessType;
  }
  
  /**
   * @param accessType the accessType to set
   */
  public void setAccessType(final int accessType) {
    this.accessType = accessType;
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
  
  public ProjectUserEdo toEdo() {
    final ProjectUserEdo edo = new ProjectUserEdo();

    edo.setAccessType(accessType);
    edo.setProjectId(projectId);
    edo.setRoleId(roleId);
    edo.setUserId(userId);
    edo.setCreated(created);
    edo.setUpdated(updated);

    return edo;
  }

  public static ProjectUser fromEdo(final ProjectUserEdo edo) {
    final ProjectUser role = new ProjectUser();

    role.setAccessType(edo.getAccessType());
    role.setProjectId(edo.getProjectId());
    role.setRoleId(edo.getRoleId());
    role.setUserId(edo.getUserId());
    role.setCreated(edo.getCreated());
    role.setUpdated(edo.getUpdated());

    return role;
  }

  public static List<ProjectUser> fromEdoList(final List<ProjectUserEdo> edoList) {
    
    final List<ProjectUser> list = new ArrayList<>();

    for (final ProjectUserEdo edo : edoList) {
      list.add(ProjectUser.fromEdo(edo));
    }
    return list;
  }

  public static List<ProjectUserEdo> toEdoList(final List<ProjectUser> list) {
    
    final List<ProjectUserEdo> edoList = new ArrayList<>();

    for (final ProjectUser role : list) {
      edoList.add(role.toEdo());
    }
    return edoList;
  }
}
