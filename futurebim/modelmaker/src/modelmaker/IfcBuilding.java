package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building database table.
 * 
 */
@Entity
@Table(name="ifc_building")
@NamedQuery(name="IfcBuilding.findAll", query="SELECT i FROM IfcBuilding i")
public class IfcBuilding implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="building_name")
	private String buildingName;

	@Column(name="composition_type")
	private String compositionType;

	private Timestamp created;

	@Column(name="object_placement")
	private String objectPlacement;

	private short status;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcProjectSite
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="site_id")
	private IfcProjectSite ifcProjectSite;

	//bi-directional many-to-one association to IfcBuildingProperty
	@OneToMany(mappedBy="ifcBuilding")
	private List<IfcBuildingProperty> ifcBuildingProperties;

	//bi-directional many-to-one association to IfcBuildingStorey
	@OneToMany(mappedBy="ifcBuilding")
	private List<IfcBuildingStorey> ifcBuildingStoreys;

	public IfcBuilding() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBuildingName() {
		return this.buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
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

	public IfcProjectSite getIfcProjectSite() {
		return this.ifcProjectSite;
	}

	public void setIfcProjectSite(IfcProjectSite ifcProjectSite) {
		this.ifcProjectSite = ifcProjectSite;
	}

	public List<IfcBuildingProperty> getIfcBuildingProperties() {
		return this.ifcBuildingProperties;
	}

	public void setIfcBuildingProperties(List<IfcBuildingProperty> ifcBuildingProperties) {
		this.ifcBuildingProperties = ifcBuildingProperties;
	}

	public IfcBuildingProperty addIfcBuildingProperty(IfcBuildingProperty ifcBuildingProperty) {
		getIfcBuildingProperties().add(ifcBuildingProperty);
		ifcBuildingProperty.setIfcBuilding(this);

		return ifcBuildingProperty;
	}

	public IfcBuildingProperty removeIfcBuildingProperty(IfcBuildingProperty ifcBuildingProperty) {
		getIfcBuildingProperties().remove(ifcBuildingProperty);
		ifcBuildingProperty.setIfcBuilding(null);

		return ifcBuildingProperty;
	}

	public List<IfcBuildingStorey> getIfcBuildingStoreys() {
		return this.ifcBuildingStoreys;
	}

	public void setIfcBuildingStoreys(List<IfcBuildingStorey> ifcBuildingStoreys) {
		this.ifcBuildingStoreys = ifcBuildingStoreys;
	}

	public IfcBuildingStorey addIfcBuildingStorey(IfcBuildingStorey ifcBuildingStorey) {
		getIfcBuildingStoreys().add(ifcBuildingStorey);
		ifcBuildingStorey.setIfcBuilding(this);

		return ifcBuildingStorey;
	}

	public IfcBuildingStorey removeIfcBuildingStorey(IfcBuildingStorey ifcBuildingStorey) {
		getIfcBuildingStoreys().remove(ifcBuildingStorey);
		ifcBuildingStorey.setIfcBuilding(null);

		return ifcBuildingStorey;
	}

}