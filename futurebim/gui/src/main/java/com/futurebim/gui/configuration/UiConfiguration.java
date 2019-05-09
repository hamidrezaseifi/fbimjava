package com.futurebim.gui.configuration;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

		private final Logger log = LoggerFactory.getLogger(getClass());

		@Value("${fb.ui.urls.core.base}")
		private String coreBaseUrl;

		@PostConstruct
		private void init() {
			log.info("CORE Base URL: {}", coreBaseUrl);

		}

		/**
		 * @return the allProjectReadAllPath
		 */
		public String getProjectReadAllPath() {
			return coreBaseUrl + FbRestPaths.Core.PROJECT_READALLCOMPANY;
		}

		/**
		 * @return the allProjectReadPath
		 */
		public String getProjectReadPath() {
			return coreBaseUrl + FbRestPaths.Core.PROJECT_READ;
		}

		/**
		 * @return the allProjectSavePath
		 */
		public String getProjectSavePath() {
			return coreBaseUrl + FbRestPaths.Core.PROJECT_SAVE;
		}

		/**
		 * @return the projectDeletePath
		 */
		public String getProjectDeletePath() {
			return coreBaseUrl + FbRestPaths.Core.PROJECT_DELETE;
		}

		/**
		 * @return the userAuthenticate
		 */
		public String getUserAuthenticate() {
			return coreBaseUrl + FbRestPaths.Core.USER_AUTHENTICATE;
		}

		/**
		 * @return the userSave
		 */
		public String getUserSave() {
			return coreBaseUrl + FbRestPaths.Core.USER_SAVE;
		}

		/**
		 * @return the userDelete
		 */
		public String getUserDelete() {
			return coreBaseUrl + FbRestPaths.Core.USER_DELETE;
		}

		/**
		 * @return the userSetPassword
		 */
		public String getUserSetPassword() {
			return coreBaseUrl + FbRestPaths.Core.USER_SETPASSWORD;
		}

		/**
		 * @return the companyRead
		 */
		public String getCompanyRead() {
			return coreBaseUrl + FbRestPaths.Core.COMPANY_READ;
		}

		/**
		 * @return the companyUpdate
		 */
		public String getCompanyUpdate() {
			return coreBaseUrl + FbRestPaths.Core.COMPANY_UPDATE;
		}

		/**
		 * @return the userCompanyUserList
		 */
		public String getUserCompanyUserList() {
			return coreBaseUrl + FbRestPaths.Core.USER_COMPANYUSERS;
		}

		/**
		 * @return the projectUserReadAllPath
		 */
		public String getProjectUserReadAllPath() {
			return coreBaseUrl + FbRestPaths.Core.PROJECTUSER_READALL;
		}

		/**
		 * @return the projectUserSavePath
		 */
		public String getProjectUserSavePath() {
			return coreBaseUrl + FbRestPaths.Core.PROJECTUSER_SAVE;
		}

		/**
		 * @return the projectUserDeletePath
		 */
		public String getProjectUserDeletePath() {
			return coreBaseUrl + FbRestPaths.Core.PROJECTUSER_DELETE;
		}

		/**
		 * @return the projectRoleReadAllPath
		 */
		public String getProjectRoleReadAllPath() {
			return coreBaseUrl + FbRestPaths.Core.PROJECTROLE_READALL;
		}

		/**
		 * @return the projectRoleSavePath
		 */
		public String getProjectRoleSavePath() {
			return coreBaseUrl + FbRestPaths.Core.PROJECTROLE_SAVE;
		}

		/**
		 * @return the userRead
		 */
		public String getUserReadUrl() {
			return coreBaseUrl + FbRestPaths.Core.USER_READ;
		}

		/**
		 * @return the taskReadAll
		 */
		public String getTaskProjectReadAllUrl() {
			return coreBaseUrl + FbRestPaths.Core.TASK_PROJECT_READALL;
		}

		/**
		 * @return the taskWorkflowReadAll
		 */
		public String getTaskWorkflowReadAllUrl() {
			return coreBaseUrl + FbRestPaths.Core.TASK_WORKFLOW_READALL;
		}

		/**
		 * @return the taskRead
		 */
		public String getTaskReadUrl() {
			return coreBaseUrl + FbRestPaths.Core.TASK_READ;
		}

		/**
		 * @return the taskSave
		 */
		public String getTaskWorkflowAddUrl() {
			return coreBaseUrl + FbRestPaths.Core.TASK_WORKFLOW_ADD;
		}

		/**
		 * @return the taskSave
		 */
		public String getTaskWorkflowDeleteUrl() {
			return coreBaseUrl + FbRestPaths.Core.TASK_WORKFLOW_DELETE;
		}

		/**
		 * @return the taskSave
		 */
		public String getTaskSaveUrl() {
			return coreBaseUrl + FbRestPaths.Core.TASK_SAVE;
		}

		/**
		 * @return the taskDelete
		 */
		public String getTaskDeleteUrl() {
			return coreBaseUrl + FbRestPaths.Core.TASK_DELETE;
		}

		/**
		 * @return the workflowReadAll
		 */
		public String getWorkflowReadAllUrl() {
			return coreBaseUrl + FbRestPaths.Core.WORKFLOW_READALL;
		}

		/**
		 * @return the workflowRead
		 */
		public String getWorkflowReadUrl() {
			return coreBaseUrl + FbRestPaths.Core.WORKFLOW_READ;
		}

		/**
		 * @return the workflowSave
		 */
		public String getWorkflowSaveUrl() {
			return coreBaseUrl + FbRestPaths.Core.WORKFLOW_SAVE;
		}

		/**
		 * @return the workflowDelete
		 */
		public String getWorkflowDeleteUrl() {
			return coreBaseUrl + FbRestPaths.Core.WORKFLOW_DELETE;
		}

		/**
		 * @return the workflowtypeReadAll
		 */
		public String getWorkflowtypeReadAllUrl() {
			return coreBaseUrl + FbRestPaths.Core.WORKFLOW_WORKFLOWTYPE_READALL;
		}

		/**
		 * @return the workflowCheck
		 */
		public String getWorkflowCheckUrl() {
			return coreBaseUrl + FbRestPaths.Core.WORKFLOW_CHECKVERSION;
		}

		/**
		 * @return the workflowCheck
		 */
		public String getAllSystemMenuUrl() {
			return coreBaseUrl + FbRestPaths.Core.SYSTEMMENU_ALLLIST;
		}

	}

}
