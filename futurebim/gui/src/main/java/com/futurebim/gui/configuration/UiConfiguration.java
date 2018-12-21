package com.futurebim.gui.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * a class to collect gui configuration from property file
 *
 * @author rezasei
 *
 */
@Component
public class UiConfiguration {

  public final static String GERMAN_DATE_FORMAT = "dd.MM.yyyy";

  public final static String ISO_DATE_FORMAT = "yyyy-MM-dd'T'";

  public final static String ISO_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.nnnnnnnnn";

  @Value("${fb.ui.user.password.strength.acceptweak}")
  private boolean acceptWeakPassword;

  @Value("${fb.ui.user.password.strength.acceptmedium}")
  private boolean acceptMediumPassword;

  /**
   * @return the acceptWeakPassword
   */
  public boolean isAcceptWeakPassword() {
    return acceptWeakPassword;
  }

  /**
   * @param acceptWeakPassword the acceptWeakPassword to set
   */
  public void setAcceptWeakPassword(final boolean acceptWeakPassword) {
    this.acceptWeakPassword = acceptWeakPassword;
  }

  /**
   * @return the acceptMediumPassword
   */
  public boolean isAcceptMediumPassword() {
    return acceptMediumPassword;
  }

  /**
   * @param acceptMediumPassword the acceptMediumPassword to set
   */
  public void setAcceptMediumPassword(final boolean acceptMediumPassword) {
    this.acceptMediumPassword = acceptMediumPassword;
  }

  /**
   * configs regarding core
   */
  @Component
  public static class CoreAccessConfig {

    @Value("${core.rest.url.project.readall}")
    private String projectReadAllPath;

    @Value("${core.rest.url.project.read}")
    private String projectReadPath;

    @Value("${core.rest.url.project.save}")
    private String projectSavePath;

    @Value("${core.rest.url.project.delete}")
    private String projectDeletePath;

    @Value("${core.rest.url.projectrole.readall}")
    private String projectRoleReadAllPath;

    @Value("${core.rest.url.projectrole.save}")
    private String projectRoleSavePath;

    @Value("${core.rest.url.projectuser.readall}")
    private String projectUserReadAllPath;

    @Value("${core.rest.url.projectuser.save}")
    private String projectUserSavePath;

    @Value("${core.rest.url.projectuser.delete}")
    private String projectUserDeletePath;

    @Value("${core.rest.url.user.authenticate}")
    private String userAuthenticate;

    @Value("${core.rest.url.user.save}")
    private String userSave;

    @Value("${core.rest.url.user.read}")
    private String userRead;

    @Value("${core.rest.url.user.companyusers}")
    private String userCompanyUserList;

    @Value("${core.rest.url.user.setpassword}")
    private String userSetPassword;

    @Value("${core.rest.url.company.read}")
    private String companyRead;

    @Value("${core.rest.url.company.update}")
    private String companyUpdate;

    @Value("${core.rest.url.task.readall}")
    private String taskReadAll;

    @Value("${core.rest.url.task.workflow.readall}")
    private String taskWorkflowReadAll;

    @Value("${core.rest.url.task.read}")
    private String taskRead;

    @Value("${core.rest.url.task.save}")
    private String taskSave;

    @Value("${core.rest.url.task.delete}")
    private String taskDelete;
    
    @Value("${core.rest.url.workflow.readall}")
    private String workflowReadAll;

    @Value("${core.rest.url.workflow.read}")
    private String workflowRead;

    @Value("${core.rest.url.workflow.save}")
    private String workflowSave;

    @Value("${core.rest.url.workflow.delete}")
    private String workflowDelete;

    @Value("${core.rest.url.workflow.workflowtype.readall}")
    private String workflowtypeReadAll;

    @PostConstruct
    private void init() {

    }
    
    /**
     * @return the allProjectReadAllPath
     */
    public String getProjectReadAllPath() {
      return projectReadAllPath;
    }
    
    /**
     * @param allProjectReadAllPath the allProjectReadAllPath to set
     */
    public void setProjectReadAllPath(final String allProjectReadAllPath) {
      this.projectReadAllPath = allProjectReadAllPath;
    }
    
    /**
     * @return the allProjectReadPath
     */
    public String getProjectReadPath() {
      return projectReadPath;
    }
    
    /**
     * @param allProjectReadPath the allProjectReadPath to set
     */
    public void setProjectReadPath(final String allProjectReadPath) {
      this.projectReadPath = allProjectReadPath;
    }

    /**
     * @return the allProjectSavePath
     */
    public String getProjectSavePath() {
      return projectSavePath;
    }

    /**
     * @param allProjectSavePath the allProjectSavePath to set
     */
    public void setProjectSavePath(final String allProjectSavePath) {
      this.projectSavePath = allProjectSavePath;
    }
    
    /**
     * @return the projectDeletePath
     */
    public String getProjectDeletePath() {
      return projectDeletePath;
    }
    
    /**
     * @param projectDeletePath the projectDeletePath to set
     */
    public void setProjectDeletePath(final String projectDeletePath) {
      this.projectDeletePath = projectDeletePath;
    }
    
    /**
     * @return the userAuthenticate
     */
    public String getUserAuthenticate() {
      return userAuthenticate;
    }

    /**
     * @param userAuthenticate the userAuthenticate to set
     */
    public void setUserAuthenticate(final String userAuthenticate) {
      this.userAuthenticate = userAuthenticate;
    }

    /**
     * @return the userSave
     */
    public String getUserSave() {
      return userSave;
    }
    
    /**
     * @param userSave the userSave to set
     */
    public void setUserSave(final String userSave) {
      this.userSave = userSave;
    }
    
    /**
     * @return the userSetPassword
     */
    public String getUserSetPassword() {
      return userSetPassword;
    }
    
    /**
     * @param userSetPassword the userSetPassword to set
     */
    public void setUserSetPassword(final String userSetPassword) {
      this.userSetPassword = userSetPassword;
    }

    /**
     * @return the companyRead
     */
    public String getCompanyRead() {
      return companyRead;
    }

    /**
     * @param companyRead the companyRead to set
     */
    public void setCompanyRead(final String companyRead) {
      this.companyRead = companyRead;
    }

    /**
     * @return the companyUpdate
     */
    public String getCompanyUpdate() {
      return companyUpdate;
    }

    /**
     * @param companyUpdate the companyUpdate to set
     */
    public void setCompanyUpdate(final String companyUpdate) {
      this.companyUpdate = companyUpdate;
    }

    /**
     * @return the userCompanyUserList
     */
    public String getUserCompanyUserList() {
      return userCompanyUserList;
    }

    /**
     * @param userCompanyUserList the userCompanyUserList to set
     */
    public void setUserCompanyUserList(final String userCompanyUserList) {
      this.userCompanyUserList = userCompanyUserList;
    }

    /**
     * @return the projectUserReadAllPath
     */
    public String getProjectUserReadAllPath() {
      return projectUserReadAllPath;
    }

    /**
     * @param projectUserReadAllPath the projectUserReadAllPath to set
     */
    public void setProjectUserReadAllPath(final String projectUserReadAllPath) {
      this.projectUserReadAllPath = projectUserReadAllPath;
    }

    /**
     * @return the projectUserSavePath
     */
    public String getProjectUserSavePath() {
      return projectUserSavePath;
    }

    /**
     * @param projectUserSavePath the projectUserSavePath to set
     */
    public void setProjectUserSavePath(final String projectUserSavePath) {
      this.projectUserSavePath = projectUserSavePath;
    }
    
    /**
     * @return the projectUserDeletePath
     */
    public String getProjectUserDeletePath() {
      return projectUserDeletePath;
    }
    
    /**
     * @param projectUserDeletePath the projectUserDeletePath to set
     */
    public void setProjectUserDeletePath(final String projectUserDeletePath) {
      this.projectUserDeletePath = projectUserDeletePath;
    }
    
    /**
     * @return the projectRoleReadAllPath
     */
    public String getProjectRoleReadAllPath() {
      return projectRoleReadAllPath;
    }
    
    /**
     * @param projectRoleReadAllPath the projectRoleReadAllPath to set
     */
    public void setProjectRoleReadAllPath(final String projectRoleReadAllPath) {
      this.projectRoleReadAllPath = projectRoleReadAllPath;
    }
    
    /**
     * @return the projectRoleSavePath
     */
    public String getProjectRoleSavePath() {
      return projectRoleSavePath;
    }
    
    /**
     * @param projectRoleSavePath the projectRoleSavePath to set
     */
    public void setProjectRoleSavePath(final String projectRoleSavePath) {
      this.projectRoleSavePath = projectRoleSavePath;
    }
    
    /**
     * @return the userRead
     */
    public String getUserRead() {
      return userRead;
    }
    
    /**
     * @param userRead the userRead to set
     */
    public void setUserRead(final String userRead) {
      this.userRead = userRead;
    }
    
    /**
     * @return the taskReadAll
     */
    public String getTaskReadAll() {
      return taskReadAll;
    }
    
    /**
     * @param taskReadAll the taskReadAll to set
     */
    public void setTaskReadAll(final String taskReadAll) {
      this.taskReadAll = taskReadAll;
    }
    
    /**
     * @return the taskWorkflowReadAll
     */
    public String getTaskWorkflowReadAll() {
      return taskWorkflowReadAll;
    }
    
    /**
     * @param taskWorkflowReadAll the taskWorkflowReadAll to set
     */
    public void setTaskWorkflowReadAll(final String taskWorkflowReadAll) {
      this.taskWorkflowReadAll = taskWorkflowReadAll;
    }
    
    /**
     * @return the taskRead
     */
    public String getTaskRead() {
      return taskRead;
    }
    
    /**
     * @param taskRead the taskRead to set
     */
    public void setTaskRead(final String taskRead) {
      this.taskRead = taskRead;
    }
    
    /**
     * @return the taskSave
     */
    public String getTaskSave() {
      return taskSave;
    }
    
    /**
     * @param taskSave the taskSave to set
     */
    public void setTaskSave(final String taskSave) {
      this.taskSave = taskSave;
    }
    
    /**
     * @return the taskDelete
     */
    public String getTaskDelete() {
      return taskDelete;
    }
    
    /**
     * @param taskDelete the taskDelete to set
     */
    public void setTaskDelete(final String taskDelete) {
      this.taskDelete = taskDelete;
    }

    /**
     * @return the workflowReadAll
     */
    public String getWorkflowReadAll() {
      return workflowReadAll;
    }

    /**
     * @param workflowReadAll the workflowReadAll to set
     */
    public void setWorkflowReadAll(final String workflowReadAll) {
      this.workflowReadAll = workflowReadAll;
    }

    /**
     * @return the workflowRead
     */
    public String getWorkflowRead() {
      return workflowRead;
    }

    /**
     * @param workflowRead the workflowRead to set
     */
    public void setWorkflowRead(final String workflowRead) {
      this.workflowRead = workflowRead;
    }

    /**
     * @return the workflowSave
     */
    public String getWorkflowSave() {
      return workflowSave;
    }

    /**
     * @param workflowSave the workflowSave to set
     */
    public void setWorkflowSave(final String workflowSave) {
      this.workflowSave = workflowSave;
    }

    /**
     * @return the workflowDelete
     */
    public String getWorkflowDelete() {
      return workflowDelete;
    }

    /**
     * @param workflowDelete the workflowDelete to set
     */
    public void setWorkflowDelete(final String workflowDelete) {
      this.workflowDelete = workflowDelete;
    }
    
    /**
     * @return the workflowtypeReadAll
     */
    public String getWorkflowtypeReadAll() {
      return workflowtypeReadAll;
    }
    
    /**
     * @param workflowtypeReadAll the workflowtypeReadAll to set
     */
    public void setWorkflowtypeReadAll(final String workflowtypeReadAll) {
      this.workflowtypeReadAll = workflowtypeReadAll;
    }
    
  }

}
