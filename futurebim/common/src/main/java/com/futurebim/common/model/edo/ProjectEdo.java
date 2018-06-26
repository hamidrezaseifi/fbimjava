package com.futurebim.common.model.edo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.futurebim.common.model.enums.EStatus;


/**
 * The persistent class for the projects database table.
 * 
 */

public class ProjectEdo  {

  private Long id;

  private Long companyid;

	private LocalDateTime created;

	private LocalDate deatline;

	private String projectName;

	private LocalDate startDate;

	private EStatus status;

	private LocalDateTime updated;

	private int version;

	/*private List<ProjectBcfFile> projectBcfFiles;

	private List<ProjectIfcFile> projectIfcFiles;

	private List<ProjectTask> projectTasks;*/

	private CompanyReferenceEdo companyBean;

	private List<UserProjectAccessReferenceEdo> userProjectAccesses;

	public ProjectEdo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
  public Long getCompanyid() {
    return companyid;
  }
  
  public void setCompanyid(Long companyid) {
    this.companyid = companyid;
  }

  public LocalDateTime getCreated() {
		return this.created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDate getDeatline() {
		return this.deatline;
	}

	public void setDeatline(LocalDate deatline) {
		this.deatline = deatline;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public LocalDate getStartDate() {
		return this.startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public EStatus getStatus() {
		return this.status;
	}

	public void setStatus(EStatus status) {
		this.status = status;
	}

	public LocalDateTime getUpdated() {
		return this.updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	/*public List<ProjectBcfFile> getProjectBcfFiles() {
		return this.projectBcfFiles;
	}

	public void setProjectBcfFiles(List<ProjectBcfFile> projectBcfFiles) {
		this.projectBcfFiles = projectBcfFiles;
	}

	public ProjectBcfFile addProjectBcfFile(ProjectBcfFile projectBcfFile) {
		getProjectBcfFiles().add(projectBcfFile);
		projectBcfFile.setProject(this);

		return projectBcfFile;
	}

	public ProjectBcfFile removeProjectBcfFile(ProjectBcfFile projectBcfFile) {
		getProjectBcfFiles().remove(projectBcfFile);
		projectBcfFile.setProject(null);

		return projectBcfFile;
	}

	public List<ProjectIfcFile> getProjectIfcFiles() {
		return this.projectIfcFiles;
	}

	public void setProjectIfcFiles(List<ProjectIfcFile> projectIfcFiles) {
		this.projectIfcFiles = projectIfcFiles;
	}

	public ProjectIfcFile addProjectIfcFile(ProjectIfcFile projectIfcFile) {
		getProjectIfcFiles().add(projectIfcFile);
		projectIfcFile.setProject(this);

		return projectIfcFile;
	}

	public ProjectIfcFile removeProjectIfcFile(ProjectIfcFile projectIfcFile) {
		getProjectIfcFiles().remove(projectIfcFile);
		projectIfcFile.setProject(null);

		return projectIfcFile;
	}

	public List<ProjectTask> getProjectTasks() {
		return this.projectTasks;
	}

	public void setProjectTasks(List<ProjectTask> projectTasks) {
		this.projectTasks = projectTasks;
	}

	public ProjectTask addProjectTask(ProjectTask projectTask) {
		getProjectTasks().add(projectTask);
		projectTask.setProject(this);

		return projectTask;
	}

	public ProjectTask removeProjectTask(ProjectTask projectTask) {
		getProjectTasks().remove(projectTask);
		projectTask.setProject(null);

		return projectTask;
	}*/

	public CompanyReferenceEdo getCompanyBean() {
		return this.companyBean;
	}

	public void setCompanyBean(CompanyReferenceEdo companyBean) {
		this.companyBean = companyBean;
	}

	public List<UserProjectAccessReferenceEdo> getUserProjectAccesses() {
		return this.userProjectAccesses;
	}

	public void setUserProjectAccesses(List<UserProjectAccessReferenceEdo> userProjectAccesses) {
		this.userProjectAccesses = userProjectAccesses;
	}

	public UserProjectAccessReferenceEdo addUserProjectAccess(UserProjectAccessReferenceEdo userProjectAccess) {
		getUserProjectAccesses().add(userProjectAccess);
		userProjectAccess.setProjectid(this.id);

		return userProjectAccess;
	}

	public UserProjectAccessReferenceEdo removeUserProjectAccess(UserProjectAccessReferenceEdo userProjectAccess) {
		getUserProjectAccesses().remove(userProjectAccess);
		userProjectAccess.setProjectid(0L);

		return userProjectAccess;
	}

}