package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the project_tasks database table.
 * 
 */
@Entity
@Table(name="project_tasks")
@NamedQuery(name="ProjectTask.findAll", query="SELECT p FROM ProjectTask p")
public class ProjectTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp created;

	@Temporal(TemporalType.DATE)
	private Date deatline;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;

	private short status;

	@Lob
	@Column(name="task_comments")
	private String taskComments;

	@Column(name="task_name")
	private String taskName;

	private Timestamp updated;

	@Column(name="user_allocated")
	private int userAllocated;

	@Column(name="user_create")
	private int userCreate;

	private int version;

	//bi-directional many-to-one association to Project
	@ManyToOne
	private Project project;

	public ProjectTask() {
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

	public String getTaskComments() {
		return this.taskComments;
	}

	public void setTaskComments(String taskComments) {
		this.taskComments = taskComments;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public int getUserAllocated() {
		return this.userAllocated;
	}

	public void setUserAllocated(int userAllocated) {
		this.userAllocated = userAllocated;
	}

	public int getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(int userCreate) {
		this.userCreate = userCreate;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}