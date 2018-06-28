package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the project_ifc database table.
 * 
 */
@Entity
@Table(name="project_ifc")
@NamedQuery(name="ProjectIfc.findAll", query="SELECT p FROM ProjectIfc p")
public class ProjectIfc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	@Column(name="ifc_name")
	private String ifcName;

	@Column(name="project_id")
	private int projectId;

	private short status;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcDoorstyle
	@OneToMany(mappedBy="projectIfc")
	private List<IfcDoorstyle> ifcDoorstyles;

	//bi-directional many-to-one association to IfcFurnituretype
	@OneToMany(mappedBy="projectIfc")
	private List<IfcFurnituretype> ifcFurnituretypes;

	//bi-directional many-to-one association to IfcPresentationlayer
	@OneToMany(mappedBy="projectIfc")
	private List<IfcPresentationlayer> ifcPresentationlayers;

	//bi-directional many-to-one association to IfcProject
	@OneToMany(mappedBy="projectIfc")
	private List<IfcProject> ifcProjects;

	//bi-directional many-to-one association to IfcProperty
	@OneToMany(mappedBy="projectIfc")
	private List<IfcProperty> ifcProperties;

	//bi-directional many-to-one association to IfcWindowstyle
	@OneToMany(mappedBy="projectIfc")
	private List<IfcWindowstyle> ifcWindowstyles;

	public ProjectIfc() {
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

	public String getIfcName() {
		return this.ifcName;
	}

	public void setIfcName(String ifcName) {
		this.ifcName = ifcName;
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
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

	public List<IfcDoorstyle> getIfcDoorstyles() {
		return this.ifcDoorstyles;
	}

	public void setIfcDoorstyles(List<IfcDoorstyle> ifcDoorstyles) {
		this.ifcDoorstyles = ifcDoorstyles;
	}

	public IfcDoorstyle addIfcDoorstyle(IfcDoorstyle ifcDoorstyle) {
		getIfcDoorstyles().add(ifcDoorstyle);
		ifcDoorstyle.setProjectIfc(this);

		return ifcDoorstyle;
	}

	public IfcDoorstyle removeIfcDoorstyle(IfcDoorstyle ifcDoorstyle) {
		getIfcDoorstyles().remove(ifcDoorstyle);
		ifcDoorstyle.setProjectIfc(null);

		return ifcDoorstyle;
	}

	public List<IfcFurnituretype> getIfcFurnituretypes() {
		return this.ifcFurnituretypes;
	}

	public void setIfcFurnituretypes(List<IfcFurnituretype> ifcFurnituretypes) {
		this.ifcFurnituretypes = ifcFurnituretypes;
	}

	public IfcFurnituretype addIfcFurnituretype(IfcFurnituretype ifcFurnituretype) {
		getIfcFurnituretypes().add(ifcFurnituretype);
		ifcFurnituretype.setProjectIfc(this);

		return ifcFurnituretype;
	}

	public IfcFurnituretype removeIfcFurnituretype(IfcFurnituretype ifcFurnituretype) {
		getIfcFurnituretypes().remove(ifcFurnituretype);
		ifcFurnituretype.setProjectIfc(null);

		return ifcFurnituretype;
	}

	public List<IfcPresentationlayer> getIfcPresentationlayers() {
		return this.ifcPresentationlayers;
	}

	public void setIfcPresentationlayers(List<IfcPresentationlayer> ifcPresentationlayers) {
		this.ifcPresentationlayers = ifcPresentationlayers;
	}

	public IfcPresentationlayer addIfcPresentationlayer(IfcPresentationlayer ifcPresentationlayer) {
		getIfcPresentationlayers().add(ifcPresentationlayer);
		ifcPresentationlayer.setProjectIfc(this);

		return ifcPresentationlayer;
	}

	public IfcPresentationlayer removeIfcPresentationlayer(IfcPresentationlayer ifcPresentationlayer) {
		getIfcPresentationlayers().remove(ifcPresentationlayer);
		ifcPresentationlayer.setProjectIfc(null);

		return ifcPresentationlayer;
	}

	public List<IfcProject> getIfcProjects() {
		return this.ifcProjects;
	}

	public void setIfcProjects(List<IfcProject> ifcProjects) {
		this.ifcProjects = ifcProjects;
	}

	public IfcProject addIfcProject(IfcProject ifcProject) {
		getIfcProjects().add(ifcProject);
		ifcProject.setProjectIfc(this);

		return ifcProject;
	}

	public IfcProject removeIfcProject(IfcProject ifcProject) {
		getIfcProjects().remove(ifcProject);
		ifcProject.setProjectIfc(null);

		return ifcProject;
	}

	public List<IfcProperty> getIfcProperties() {
		return this.ifcProperties;
	}

	public void setIfcProperties(List<IfcProperty> ifcProperties) {
		this.ifcProperties = ifcProperties;
	}

	public IfcProperty addIfcProperty(IfcProperty ifcProperty) {
		getIfcProperties().add(ifcProperty);
		ifcProperty.setProjectIfc(this);

		return ifcProperty;
	}

	public IfcProperty removeIfcProperty(IfcProperty ifcProperty) {
		getIfcProperties().remove(ifcProperty);
		ifcProperty.setProjectIfc(null);

		return ifcProperty;
	}

	public List<IfcWindowstyle> getIfcWindowstyles() {
		return this.ifcWindowstyles;
	}

	public void setIfcWindowstyles(List<IfcWindowstyle> ifcWindowstyles) {
		this.ifcWindowstyles = ifcWindowstyles;
	}

	public IfcWindowstyle addIfcWindowstyle(IfcWindowstyle ifcWindowstyle) {
		getIfcWindowstyles().add(ifcWindowstyle);
		ifcWindowstyle.setProjectIfc(this);

		return ifcWindowstyle;
	}

	public IfcWindowstyle removeIfcWindowstyle(IfcWindowstyle ifcWindowstyle) {
		getIfcWindowstyles().remove(ifcWindowstyle);
		ifcWindowstyle.setProjectIfc(null);

		return ifcWindowstyle;
	}

}