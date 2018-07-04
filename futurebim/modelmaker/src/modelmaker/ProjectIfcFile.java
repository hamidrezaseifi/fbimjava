package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the project_ifc_files database table.
 * 
 */
@Entity
@Table(name="project_ifc_files")
@NamedQuery(name="ProjectIfcFile.findAll", query="SELECT p FROM ProjectIfcFile p")
public class ProjectIfcFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp created;

	@Column(name="file_name")
	private String fileName;

	@Column(name="file_path")
	private String filePath;

	private short status;

	private Timestamp updated;

	//bi-directional many-to-one association to Project
	@ManyToOne(fetch=FetchType.LAZY)
	private Project project;

	public ProjectIfcFile() {
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

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}