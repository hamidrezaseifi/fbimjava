package com.futurebim.gui.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.futurebim.common.rest.FbRestPaths;

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

    /*
     * @Value("${core.rest.url.project.readall}") private String projectReadAllPath;
     * @Value("${core.rest.url.project.read}") private String projectReadPath;
     * @Value("${core.rest.url.project.save}") private String projectSavePath;
     * @Value("${core.rest.url.project.delete}") private String projectDeletePath;
     * @Value("${core.rest.url.projectrole.readall}") private String projectRoleReadAllPath;
     * @Value("${core.rest.url.projectrole.save}") private String projectRoleSavePath;
     * @Value("${core.rest.url.projectuser.readall}") private String projectUserReadAllPath;
     * @Value("${core.rest.url.projectuser.save}") private String projectUserSavePath;
     * @Value("${core.rest.url.projectuser.delete}") private String projectUserDeletePath;
     * @Value("${core.rest.url.user.authenticate}") private String userAuthenticate;
     * @Value("${core.rest.url.user.save}") private String userSave;
     * @Value("${core.rest.url.user.read}") private String userRead;
     * @Value("${core.rest.url.user.companyusers}") private String userCompanyUserList;
     * @Value("${core.rest.url.user.setpassword}") private String userSetPassword;
     * @Value("${core.rest.url.company.read}") private String companyRead;
     * @Value("${core.rest.url.company.update}") private String companyUpdate;
     * @Value("${core.rest.url.task.readall}") private String taskReadAll;
     * @Value("${core.rest.url.task.workflow.readall}") private String taskWorkflowReadAll;
     * @Value("${core.rest.url.task.read}") private String taskRead;
     * @Value("${core.rest.url.task.save}") private String taskSave;
     * @Value("${core.rest.url.task.delete}") private String taskDelete;
     * @Value("${core.rest.url.workflow.readall}") private String workflowReadAll;
     * @Value("${core.rest.url.workflow.read}") private String workflowRead;
     * @Value("${core.rest.url.workflow.save}") private String workflowSave;
     * @Value("${core.rest.url.workflow.delete}") private String workflowDelete;
     * @Value("${core.rest.url.workflow.workflowtype.readall}") private String workflowtypeReadAll;
     */

    @PostConstruct
    private void init() {

    }
    
    /**
     * @return the allProjectReadAllPath
     */
    public String getProjectReadAllPath() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.PROJECT_READALLCOMPANY;
    }
    
    /**
     * @return the allProjectReadPath
     */
    public String getProjectReadPath() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.PROJECT_READ;
    }

    /**
     * @return the allProjectSavePath
     */
    public String getProjectSavePath() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.PROJECT_SAVE;
    }

    /**
     * @return the projectDeletePath
     */
    public String getProjectDeletePath() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.PROJECT_DELETE;
    }

    /**
     * @return the userAuthenticate
     */
    public String getUserAuthenticate() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.USER_AUTHENTICATE;
    }

    /**
     * @return the userSave
     */
    public String getUserSave() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.USER_SAVE;
    }

    /**
     * @return the userSetPassword
     */
    public String getUserSetPassword() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.USER_SETPASSWORD;
    }

    /**
     * @return the companyRead
     */
    public String getCompanyRead() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.COMPANY_READ;
    }

    /**
     * @return the companyUpdate
     */
    public String getCompanyUpdate() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.COMPANY_UPDATE;
    }

    /**
     * @return the userCompanyUserList
     */
    public String getUserCompanyUserList() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.USER_COMPANYUSERS;
    }

    /**
     * @return the projectUserReadAllPath
     */
    public String getProjectUserReadAllPath() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.PROJECTUSER_READALL;
    }

    /**
     * @return the projectUserSavePath
     */
    public String getProjectUserSavePath() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.PROJECTUSER_SAVE;
    }

    /**
     * @return the projectUserDeletePath
     */
    public String getProjectUserDeletePath() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.PROJECTUSER_DELETE;
    }

    /**
     * @return the projectRoleReadAllPath
     */
    public String getProjectRoleReadAllPath() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.PROJECTROLE_READALL;
    }

    /**
     * @return the projectRoleSavePath
     */
    public String getProjectRoleSavePath() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.PROJECTROLE_SAVE;
    }

    /**
     * @return the userRead
     */
    public String getUserRead() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.USER_READ;
    }
    
    /**
     * @return the taskReadAll
     */
    public String getTaskProjectReadAll() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.TASK_PROJECT_READALL;
    }
    
    /**
     * @return the taskWorkflowReadAll
     */
    public String getTaskWorkflowReadAll() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.TASK_WORKFLOW_READALL;
    }
    
    /**
     * @return the taskRead
     */
    public String getTaskRead() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.TASK_READ;
    }
    
    /**
     * @return the taskSave
     */
    public String getTaskSave() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.TASK_SAVE;
    }
    
    /**
     * @return the taskDelete
     */
    public String getTaskDelete() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.TASK_DELETE;
    }
    
    /**
     * @return the workflowReadAll
     */
    public String getWorkflowReadAll() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.WORKFLOW_READALL;
    }
    
    /**
     * @return the workflowRead
     */
    public String getWorkflowRead() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.WORKFLOW_READ;
    }
    
    /**
     * @return the workflowSave
     */
    public String getWorkflowSave() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.WORKFLOW_SAVE;
    }
    
    /**
     * @return the workflowDelete
     */
    public String getWorkflowDelete() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.WORKFLOW_DELETE;
    }
    
    /**
     * @return the workflowtypeReadAll
     */
    public String getWorkflowtypeReadAll() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.WORKFLOW_WORKFLOWTYPE_READALL;
    }
    
    /**
     * @return the workflowCheck
     */
    public String getWorkflowCheck() {
      return FbRestPaths.Core.CORE_BASE + FbRestPaths.Core.WORKFLOW_CHECKVERSION;
    }
    
  }

}
