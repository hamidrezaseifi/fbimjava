package com.futurebim.gui.model.futurebim;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.futurebim.common.model.edo.ProjectUserEdo;
import com.futurebim.common.rest.json.FBLocalDateTimeDeserializer;
import com.futurebim.common.rest.json.FBLocalDateTimeSerializer;

/**
 * The persistent class for the projects database table.
 *
 */

public class GuiProjectUser {

  private Long userId;

  private Long projectId;

  private Long roleId;

  private int accessType;

  private GuiUserFull user;
  
  private GuiProjectRole role;

  private String accessTypeName;
  
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
   * @return the user
   */
  public GuiUserFull getUser() {
    return user;
  }

  /**
   * @param user the user to set
   */
  public GuiProjectUser setUser(final GuiUserFull user) {
    this.user = user;
    return this;
  }
  
  /**
   * @return the role
   */
  public GuiProjectRole getRole() {
    return role;
  }
  
  /**
   * @param role the role to set
   */
  public GuiProjectUser setRole(final GuiProjectRole role) {
    this.role = role;
    return this;
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

  public String getFullname() {
    return user.getFullname();
  }

  public String getRolename() {
    return role.getName();
  }

  /**
   * @return the accessTypeName
   */
  public String getAccessTypeName() {
    return accessTypeName;
  }

  /**
   * @param accessTypeName the accessTypeName to set
   */
  public GuiProjectUser setAccessTypeName(final String accessTypeName) {
    this.accessTypeName = accessTypeName;
    return this;
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
  
  public static GuiProjectUser fromEdo(final ProjectUserEdo edo) {
    final GuiProjectUser role = new GuiProjectUser();
    
    role.setAccessType(edo.getAccessType());
    role.setProjectId(edo.getProjectId());
    role.setRoleId(edo.getRoleId());
    role.setUserId(edo.getUserId());
    role.setCreated(edo.getCreated());
    role.setUpdated(edo.getUpdated());
    
    return role;
  }
  
  public static List<GuiProjectUser> fromEdoList(final List<ProjectUserEdo> edoList) {

    final List<GuiProjectUser> list = new ArrayList<>();
    
    if (edoList != null) {
      for (final ProjectUserEdo edo : edoList) {
        list.add(GuiProjectUser.fromEdo(edo));
      }
    }
    return list;
  }
  
  public static List<ProjectUserEdo> toEdoList(final List<GuiProjectUser> list) {

    final List<ProjectUserEdo> edoList = new ArrayList<>();
    
    for (final GuiProjectUser role : list) {
      edoList.add(role.toEdo());
    }
    return edoList;
  }
}
