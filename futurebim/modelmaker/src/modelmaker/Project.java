package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the projects database table.
 * 
 */
@Entity
@Table(name="projects")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp created;

	@Temporal(TemporalType.DATE)
	private Date deatline;

	@Column(name="project_name")
	private String projectName;

	@Column(name="responsible_user")
	private int responsibleUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;

	private short status;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to ProjectBcfFile
	@OneToMany(mappedBy="project")
	private List<ProjectBcfFile> projectBcfFiles;

	//bi-directional many-to-one association to ProjectIfc
	@OneToMany(mappedBy="project")
	private List<ProjectIfc> projectIfcs;

	//bi-directional many-to-one association to ProjectIfcFile
	@OneToMany(mappedBy="project")
	private List<ProjectIfcFile> projectIfcFiles;

	//bi-directional many-to-one association to ProjectResponsible
	@OneToMany(mappedBy="project")
	private List<ProjectResponsible> projectResponsibles;

	//bi-directional many-to-one association to ProjectTask
	@OneToMany(mappedBy="project")
	private List<ProjectTask> projectTasks;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="companyid")
	private Company company;

	//bi-directional many-to-one association to UserProjectAccess
	@OneToMany(mappedBy="project")
	private List<UserProjectAccess> userProjectAccesses;

	public Project() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Date getDeatline() {
		return this.deatline;
	}

	public void setDeatline(Date deatline) {
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

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
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

	public List<ProjectIfc> getProjectIfcs() {
		return this.projectIfcs;
	}

	public void setProjectIfcs(List<ProjectIfc> projectIfcs) {
		this.projectIfcs = projectIfcs;
	}

	public ProjectIfc addProjectIfc(ProjectIfc projectIfc) {
		getProjectIfcs().add(projectIfc);
		projectIfc.setProject(this);

		return projectIfc;
	}

	public ProjectIfc removeProjectIfc(ProjectIfc projectIfc) {
		getProjectIfcs().remove(projectIfc);
		projectIfc.setProject(null);

		return projectIfc;
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

	public List<ProjectResponsible> getProjectResponsibles() {
		return this.projectResponsibles;
	}

	public void setProjectResponsibles(List<ProjectResponsible> projectResponsibles) {
		this.projectResponsibles = projectResponsibles;
	}

	public ProjectResponsible addProjectResponsible(ProjectResponsible projectResponsible) {
		getProjectResponsibles().add(projectResponsible);
		projectResponsible.setProject(this);

		return projectResponsible;
	}

	public ProjectResponsible removeProjectResponsible(ProjectResponsible projectResponsible) {
		getProjectResponsibles().remove(projectResponsible);
		projectResponsible.setProject(null);

		return projectResponsible;
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

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
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