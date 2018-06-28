package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_project database table.
 * 
 */
@Entity
@Table(name="ifc_project")
@NamedQuery(name="IfcProject.findAll", query="SELECT i FROM IfcProject i")
public class IfcProject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	private String phase;

	@Column(name="project_long_name")
	private String projectLongName;

	@Column(name="project_name")
	private String projectName;

	private short status;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to ProjectIfc
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ifc_id")
	private ProjectIfc projectIfc;

	//bi-directional many-to-one association to IfcProjectSite
	@OneToMany(mappedBy="ifcProject")
	private List<IfcProjectSite> ifcProjectSites;

	public IfcProject() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getPhase() {
		return this.phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getProjectLongName() {
		return this.projectLongName;
	}

	public void setProjectLongName(String projectLongName) {
		this.projectLongName = projectLongName;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

	public ProjectIfc getProjectIfc() {
		return this.projectIfc;
	}

	public void setProjectIfc(ProjectIfc projectIfc) {
		this.projectIfc = projectIfc;
	}

	public List<IfcProjectSite> getIfcProjectSites() {
		return this.ifcProjectSites;
	}

	public void setIfcProjectSites(List<IfcProjectSite> ifcProjectSites) {
		this.ifcProjectSites = ifcProjectSites;
	}

	public IfcProjectSite addIfcProjectSite(IfcProjectSite ifcProjectSite) {
		getIfcProjectSites().add(ifcProjectSite);
		ifcProjectSite.setIfcProject(this);

		return ifcProjectSite;
	}

	public IfcProjectSite removeIfcProjectSite(IfcProjectSite ifcProjectSite) {
		getIfcProjectSites().remove(ifcProjectSite);
		ifcProjectSite.setIfcProject(null);

		return ifcProjectSite;
	}

}