package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the user_project_access database table.
 * 
 */
@Entity
@Table(name="user_project_access")
@NamedQuery(name="UserProjectAccess.findAll", query="SELECT u FROM UserProjectAccess u")
public class UserProjectAccess implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserProjectAccessPK id;

	private Timestamp created;

	private short status;

	//bi-directional many-to-one association to ProjectAccessType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="access_type")
	private ProjectAccessType projectAccessType;

	//bi-directional many-to-one association to Project
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="projectid")
	private Project project;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userid")
	private User user;

	public UserProjectAccess() {
	}

	public UserProjectAccessPK getId() {
		return this.id;
	}

	public void setId(UserProjectAccessPK id) {
		this.id = id;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public ProjectAccessType getProjectAccessType() {
		return this.projectAccessType;
	}

	public void setProjectAccessType(ProjectAccessType projectAccessType) {
		this.projectAccessType = projectAccessType;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}