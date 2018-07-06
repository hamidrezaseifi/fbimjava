package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_wallstandardcase database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_wallstandardcase")
@NamedQuery(name="IfcBuildingStoreyWallstandardcase.findAll", query="SELECT i FROM IfcBuildingStoreyWallstandardcase i")
public class IfcBuildingStoreyWallstandardcase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	@Column(name="object_placement")
	private String objectPlacement;

	@Column(name="object_type")
	private String objectType;

	private short status;

	private String tag;

	private Timestamp updated;

	private int version;

	@Column(name="wall_name")
	private String wallName;

	//bi-directional many-to-one association to IfcBuildingStorey
	@ManyToOne
	@JoinColumn(name="storey_id")
	private IfcBuildingStorey ifcBuildingStorey;

	//bi-directional many-to-one association to IfcBuildingStoreyWallstandardcaseOpening
	@OneToMany(mappedBy="ifcBuildingStoreyWallstandardcase")
	private List<IfcBuildingStoreyWallstandardcaseOpening> ifcBuildingStoreyWallstandardcaseOpenings;

	//bi-directional many-to-one association to IfcBuildingStoreyWallstandardcasePresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreyWallstandardcase")
	private List<IfcBuildingStoreyWallstandardcasePresentationlayer> ifcBuildingStoreyWallstandardcasePresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreyWallstandardcaseProperty
	@OneToMany(mappedBy="ifcBuildingStoreyWallstandardcase")
	private List<IfcBuildingStoreyWallstandardcaseProperty> ifcBuildingStoreyWallstandardcaseProperties;

	public IfcBuildingStoreyWallstandardcase() {
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

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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

	public String getWallName() {
		return this.wallName;
	}

	public void setWallName(String wallName) {
		this.wallName = wallName;
	}

	public IfcBuildingStorey getIfcBuildingStorey() {
		return this.ifcBuildingStorey;
	}

	public void setIfcBuildingStorey(IfcBuildingStorey ifcBuildingStorey) {
		this.ifcBuildingStorey = ifcBuildingStorey;
	}

	public List<IfcBuildingStoreyWallstandardcaseOpening> getIfcBuildingStoreyWallstandardcaseOpenings() {
		return this.ifcBuildingStoreyWallstandardcaseOpenings;
	}

	public void setIfcBuildingStoreyWallstandardcaseOpenings(List<IfcBuildingStoreyWallstandardcaseOpening> ifcBuildingStoreyWallstandardcaseOpenings) {
		this.ifcBuildingStoreyWallstandardcaseOpenings = ifcBuildingStoreyWallstandardcaseOpenings;
	}

	public IfcBuildingStoreyWallstandardcaseOpening addIfcBuildingStoreyWallstandardcaseOpening(IfcBuildingStoreyWallstandardcaseOpening ifcBuildingStoreyWallstandardcaseOpening) {
		getIfcBuildingStoreyWallstandardcaseOpenings().add(ifcBuildingStoreyWallstandardcaseOpening);
		ifcBuildingStoreyWallstandardcaseOpening.setIfcBuildingStoreyWallstandardcase(this);

		return ifcBuildingStoreyWallstandardcaseOpening;
	}

	public IfcBuildingStoreyWallstandardcaseOpening removeIfcBuildingStoreyWallstandardcaseOpening(IfcBuildingStoreyWallstandardcaseOpening ifcBuildingStoreyWallstandardcaseOpening) {
		getIfcBuildingStoreyWallstandardcaseOpenings().remove(ifcBuildingStoreyWallstandardcaseOpening);
		ifcBuildingStoreyWallstandardcaseOpening.setIfcBuildingStoreyWallstandardcase(null);

		return ifcBuildingStoreyWallstandardcaseOpening;
	}

	public List<IfcBuildingStoreyWallstandardcasePresentationlayer> getIfcBuildingStoreyWallstandardcasePresentationlayers() {
		return this.ifcBuildingStoreyWallstandardcasePresentationlayers;
	}

	public void setIfcBuildingStoreyWallstandardcasePresentationlayers(List<IfcBuildingStoreyWallstandardcasePresentationlayer> ifcBuildingStoreyWallstandardcasePresentationlayers) {
		this.ifcBuildingStoreyWallstandardcasePresentationlayers = ifcBuildingStoreyWallstandardcasePresentationlayers;
	}

	public IfcBuildingStoreyWallstandardcasePresentationlayer addIfcBuildingStoreyWallstandardcasePresentationlayer(IfcBuildingStoreyWallstandardcasePresentationlayer ifcBuildingStoreyWallstandardcasePresentationlayer) {
		getIfcBuildingStoreyWallstandardcasePresentationlayers().add(ifcBuildingStoreyWallstandardcasePresentationlayer);
		ifcBuildingStoreyWallstandardcasePresentationlayer.setIfcBuildingStoreyWallstandardcase(this);

		return ifcBuildingStoreyWallstandardcasePresentationlayer;
	}

	public IfcBuildingStoreyWallstandardcasePresentationlayer removeIfcBuildingStoreyWallstandardcasePresentationlayer(IfcBuildingStoreyWallstandardcasePresentationlayer ifcBuildingStoreyWallstandardcasePresentationlayer) {
		getIfcBuildingStoreyWallstandardcasePresentationlayers().remove(ifcBuildingStoreyWallstandardcasePresentationlayer);
		ifcBuildingStoreyWallstandardcasePresentationlayer.setIfcBuildingStoreyWallstandardcase(null);

		return ifcBuildingStoreyWallstandardcasePresentationlayer;
	}

	public List<IfcBuildingStoreyWallstandardcaseProperty> getIfcBuildingStoreyWallstandardcaseProperties() {
		return this.ifcBuildingStoreyWallstandardcaseProperties;
	}

	public void setIfcBuildingStoreyWallstandardcaseProperties(List<IfcBuildingStoreyWallstandardcaseProperty> ifcBuildingStoreyWallstandardcaseProperties) {
		this.ifcBuildingStoreyWallstandardcaseProperties = ifcBuildingStoreyWallstandardcaseProperties;
	}

	public IfcBuildingStoreyWallstandardcaseProperty addIfcBuildingStoreyWallstandardcaseProperty(IfcBuildingStoreyWallstandardcaseProperty ifcBuildingStoreyWallstandardcaseProperty) {
		getIfcBuildingStoreyWallstandardcaseProperties().add(ifcBuildingStoreyWallstandardcaseProperty);
		ifcBuildingStoreyWallstandardcaseProperty.setIfcBuildingStoreyWallstandardcase(this);

		return ifcBuildingStoreyWallstandardcaseProperty;
	}

	public IfcBuildingStoreyWallstandardcaseProperty removeIfcBuildingStoreyWallstandardcaseProperty(IfcBuildingStoreyWallstandardcaseProperty ifcBuildingStoreyWallstandardcaseProperty) {
		getIfcBuildingStoreyWallstandardcaseProperties().remove(ifcBuildingStoreyWallstandardcaseProperty);
		ifcBuildingStoreyWallstandardcaseProperty.setIfcBuildingStoreyWallstandardcase(null);

		return ifcBuildingStoreyWallstandardcaseProperty;
	}

}