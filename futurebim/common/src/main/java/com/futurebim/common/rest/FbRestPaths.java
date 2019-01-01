package com.futurebim.common.rest;

public class FbRestPaths {

	public static class Core {

		public static final String CORE_BASE = "http://localhost:1010";

		public static final String PROJECT_BASE = "/project";

		public static final String PROJECT_READ_BASE = "/read/{projectid}";
		public static final String PROJECT_READ = PROJECT_BASE + PROJECT_READ_BASE;

		public static final String PROJECT_READALLCOMPANY_BASE = "/comapny/readall/{companyid}";
		public static final String PROJECT_READALLCOMPANY = PROJECT_BASE + PROJECT_READALLCOMPANY_BASE;

		public static final String PROJECT_SAVE_BASE = "/save";
		public static final String PROJECT_SAVE = PROJECT_BASE + PROJECT_SAVE_BASE;

		public static final String PROJECT_DELETE_BASE = "/delete";
		public static final String PROJECT_DELETE = PROJECT_BASE + PROJECT_DELETE_BASE;

		public static final String PROJECTROLE_READALL_BASE = "/role/readall/{companyid}";
		public static final String PROJECTROLE_READALL = PROJECT_BASE + PROJECTROLE_READALL_BASE;

		public static final String PROJECTROLE_SAVE_BASE = "/role/save";
		public static final String PROJECTROLE_SAVE = PROJECT_BASE + PROJECTROLE_SAVE_BASE;

		public static final String PROJECTUSER_READALL_BASE = "/user/readall/{projectid}";
		public static final String PROJECTUSER_READALL = PROJECT_BASE + PROJECTUSER_READALL_BASE;

		public static final String PROJECTUSER_SAVE_BASE = "/user/save";
		public static final String PROJECTUSER_SAVE = PROJECT_BASE + PROJECTUSER_SAVE_BASE;

		public static final String PROJECTUSER_DELETE_BASE = "/user/delete";
		public static final String PROJECTUSER_DELETE = PROJECT_BASE + PROJECTUSER_DELETE_BASE;

		public static final String USER_BASE = "/user";

		public static final String USER_AUTHENTICATE_BASE = "/authenticate";
		public static final String USER_AUTHENTICATE = USER_BASE + "/authenticate";

		public static final String USER_SAVE_BASE = "/save";
		public static final String USER_SAVE = USER_BASE + USER_SAVE_BASE;

		public static final String USER_SETPASSWORD_BASE = "/setpassword";
		public static final String USER_SETPASSWORD = USER_BASE + USER_SETPASSWORD_BASE;

		public static final String USER_COMPANYUSERS_BASE = "/comapny/readall/{companyid}";
		public static final String USER_COMPANYUSERS = USER_BASE + USER_COMPANYUSERS_BASE;

		public static final String USER_READ_BASE = "/read/{userid}";
		public static final String USER_READ = USER_BASE + USER_READ_BASE;

		public static final String COMPANY_BASE = "/company";

		public static final String COMPANY_READ_BASE = "/read/{companyid}";
		public static final String COMPANY_READ = COMPANY_BASE + COMPANY_READ_BASE;

		public static final String COMPANY_UPDATE_BASE = "/update";
		public static final String COMPANY_UPDATE = COMPANY_BASE + COMPANY_UPDATE_BASE;

		public static final String COMPANY_DELETE_BASE = "/delete";
		public static final String COMPANY_DELETE = COMPANY_BASE + COMPANY_DELETE_BASE;

		public static final String COMPANY_ALL_BASE = "/all";
		public static final String COMPANY_ALL = COMPANY_BASE + COMPANY_ALL_BASE;

		public static final String TASK_BASE = "/task";

		public static final String TASK_PROJECT_READALL_BASE = "/project/readall/{projectid}";
		public static final String TASK_PROJECT_READALL = TASK_BASE + TASK_PROJECT_READALL_BASE;

		public static final String TASK_WORKFLOW_READALL_BASE = "/workflow/readall/{workflowid}";
		public static final String TASK_WORKFLOW_READALL = TASK_BASE + TASK_WORKFLOW_READALL_BASE;

		public static final String TASK_WORKFLOW_ADD_BASE = "/workflow/add/{workflowid}/{taskid}";
		public static final String TASK_WORKFLOW_ADD = TASK_BASE + TASK_WORKFLOW_ADD_BASE;

		public static final String TASK_WORKFLOW_DELETE_BASE = "/workflow/delete/{workflowid}/{taskid}";
		public static final String TASK_WORKFLOW_DELETE = TASK_BASE + TASK_WORKFLOW_DELETE_BASE;

		public static final String TASK_READ_BASE = "/read/{taskid}";
		public static final String TASK_READ = TASK_BASE + TASK_READ_BASE;

		public static final String TASK_SAVE_BASE = "/save";
		public static final String TASK_SAVE = TASK_BASE + TASK_SAVE_BASE;

		public static final String TASK_DELETE_BASE = "/delete";
		public static final String TASK_DELETE = TASK_BASE + TASK_DELETE_BASE;

		public static final String WORKFLOW_BASE = "/workflow";

		public static final String WORKFLOW_READALL_BASE = "/project/readall/{projectid}";
		public static final String WORKFLOW_READALL = WORKFLOW_BASE + WORKFLOW_READALL_BASE;

		public static final String WORKFLOW_READ_BASE = "/read/{workflowid}";
		public static final String WORKFLOW_READ = WORKFLOW_BASE + WORKFLOW_READ_BASE;

		public static final String WORKFLOW_SAVE_BASE = "/save";
		public static final String WORKFLOW_SAVE = WORKFLOW_BASE + WORKFLOW_SAVE_BASE;

		public static final String WORKFLOW_DELETE_BASE = "/delete";
		public static final String WORKFLOW_DELETE = WORKFLOW_BASE + WORKFLOW_DELETE_BASE;

		public static final String WORKFLOW_WORKFLOWTYPE_READALL_BASE = "/workflowtype/readall";
		public static final String WORKFLOW_WORKFLOWTYPE_READALL = WORKFLOW_BASE + WORKFLOW_WORKFLOWTYPE_READALL_BASE;

		public static final String WORKFLOW_CHECKVERSION_BASE = "/workflowtype/checkversion";
		public static final String WORKFLOW_CHECKVERSION = WORKFLOW_BASE + WORKFLOW_CHECKVERSION_BASE;

		public static final String GENERALDATA_BASE = "/general";

		public static final String GENERALDATA_VALUELIST_BASE = "/valuelist";
		public static final String GENERALDATA_VALUELIST = GENERALDATA_BASE + GENERALDATA_VALUELIST_BASE;

	}
}
