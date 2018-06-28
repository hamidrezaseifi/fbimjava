package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_project_site database table.
 * 
 */
@Entity
@Table(name="ifc_project_site")
@NamedQuery(name="IfcProjectSite.findAll", query="SELECT i FROM IfcProjectSite i")
public class IfcProjectSite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="composition_type")
	private String compositionType;

	private Timestamp created;

	@Column(name="object_placement")
	private String objectPlacement;

	@Column(name="object_type")
	private String objectType;

	@Column(name="ref_elevation")
	private String refElevation;

	@Column(name="ref_latitude")
	private String refLatitude;

	@Column(name="ref_longitude")
	private String refLongitude;

	@Column(name="site_name")
	private String siteName;

	private short status;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuilding
	@OneToMany(mappedBy="ifcProjectSite")
	private List<IfcBuilding> ifcBuildings;

	//bi-directional many-to-one association to IfcProject
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_id")
	private IfcProject ifcProject;

	public IfcProjectSite() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompositionType() {
		return this.compositionType;
	}

	public void setCompositionType(String compositionType) {
		this.compositionType = compositionType;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getObjectPlacement() {
		return this.objectPlacement;
	}

	public void setObjectPlacement(String objectPlacement) {
		this.objectPlacement = objectPlacement;
	}

	public String getObjectType() {
		return this.objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getRefElevation() {
		return this.refElevation;
	}

	public void setRefElevation(String refElevation) {
		this.refElevation = refElevation;
	}

	public String getRefLatitude() {
		return this.refLatitude;
	}

	public void setRefLatitude(String refLatitude) {
		this.refLatitude = refLatitude;
	}

	public String getRefLongitude() {
		return this.refLongitude;
	}

	public void setRefLongitude(String refLongitude) {
		this.refLongitude = refLongitude;
	}

	public String getSiteName() {
		return this.siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
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

	public List<IfcBuilding> getIfcBuildings() {
		return this.ifcBuildings;
	}

	public void setIfcBuildings(List<IfcBuilding> ifcBuildings) {
		this.ifcBuildings = ifcBuildings;
	}

	public IfcBuilding addIfcBuilding(IfcBuilding ifcBuilding) {
		getIfcBuildings().add(ifcBuilding);
		ifcBuilding.setIfcProjectSite(this);

		return ifcBuilding;
	}

	public IfcBuilding removeIfcBuilding(IfcBuilding ifcBuilding) {
		getIfcBuildings().remove(ifcBuilding);
		ifcBuilding.setIfcProjectSite(null);

		return ifcBuilding;
	}

	public IfcProject getIfcProject() {
		return this.ifcProject;
	}

	public void setIfcProject(IfcProject ifcProject) {
		this.ifcProject = ifcProject;
	}

}