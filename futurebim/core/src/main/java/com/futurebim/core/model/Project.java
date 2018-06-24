package com.futurebim.core.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the projects database table.
 * 
 */
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private LocalDateTime created;

	private LocalDate deatline;

	private String projectName;

	private int responsibleUser;

	private LocalDate startDate;

	private short status;

	private LocalDateTime updated;

	private int version;

	private List<ProjectBcfFile> projectBcfFiles;

	private List<ProjectIfcFile> projectIfcFiles;

	private List<ProjectTask> projectTasks;

	private Company companyBean;

	private List<UserProjectAccess> userProjectAccesses;

	public Project() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getResponsibleUser() {
		return this.responsibleUser;
	}

	public void setResponsibleUser(int responsibleUser) {
		this.responsibleUser = responsibleUser;
	}

	public LocalDate getStartDate() {
		return this.startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
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

	public List<ProjectBcfFile> getProjectBcfFiles() {
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
	}

	public Company getCompanyBean() {
		return this.companyBean;
	}

	public void setCompanyBean(Company companyBean) {
		this.companyBean = companyBean;
	}

	public List<UserProjectAccess> getUserProjectAccesses() {
		return this.userProjectAccesses;
	}

	public void setUserProjectAccesses(List<UserProjectAccess> userProjectAccesses) {
		this.userProjectAccesses = userProjectAccesses;
	}

	public UserProjectAccess addUserProjectAccess(UserProjectAccess userProjectAccess) {
		getUserProjectAccesses().add(userProjectAccess);
		userProjectAccess.setProject(this);

		return userProjectAccess;
	}

	public UserProjectAccess removeUserProjectAccess(UserProjectAccess userProjectAccess) {
		getUserProjectAccesses().remove(userProjectAccess);
		userProjectAccess.setProject(null);

		return userProjectAccess;
	}

}