package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_wall database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_wall")
@NamedQuery(name="IfcBuildingStoreyWall.findAll", query="SELECT i FROM IfcBuildingStoreyWall i")
public class IfcBuildingStoreyWall implements Serializable {
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

	//bi-directional many-to-one association to IfcBuildingStoreyWallOpening
	@OneToMany(mappedBy="ifcBuildingStoreyWall")
	private List<IfcBuildingStoreyWallOpening> ifcBuildingStoreyWallOpenings;

	//bi-directional many-to-one association to IfcBuildingStoreyWallPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreyWall")
	private List<IfcBuildingStoreyWallPresentationlayer> ifcBuildingStoreyWallPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreyWallProperty
	@OneToMany(mappedBy="ifcBuildingStoreyWall")
	private List<IfcBuildingStoreyWallProperty> ifcBuildingStoreyWallProperties;

	public IfcBuildingStoreyWall() {
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

	public List<IfcBuildingStoreyWallOpening> getIfcBuildingStoreyWallOpenings() {
		return this.ifcBuildingStoreyWallOpenings;
	}

	public void setIfcBuildingStoreyWallOpenings(List<IfcBuildingStoreyWallOpening> ifcBuildingStoreyWallOpenings) {
		this.ifcBuildingStoreyWallOpenings = ifcBuildingStoreyWallOpenings;
	}

	public IfcBuildingStoreyWallOpening addIfcBuildingStoreyWallOpening(IfcBuildingStoreyWallOpening ifcBuildingStoreyWallOpening) {
		getIfcBuildingStoreyWallOpenings().add(ifcBuildingStoreyWallOpening);
		ifcBuildingStoreyWallOpening.setIfcBuildingStoreyWall(this);

		return ifcBuildingStoreyWallOpening;
	}

	public IfcBuildingStoreyWallOpening removeIfcBuildingStoreyWallOpening(IfcBuildingStoreyWallOpening ifcBuildingStoreyWallOpening) {
		getIfcBuildingStoreyWallOpenings().remove(ifcBuildingStoreyWallOpening);
		ifcBuildingStoreyWallOpening.setIfcBuildingStoreyWall(null);

		return ifcBuildingStoreyWallOpening;
	}

	public List<IfcBuildingStoreyWallPresentationlayer> getIfcBuildingStoreyWallPresentationlayers() {
		return this.ifcBuildingStoreyWallPresentationlayers;
	}

	public void setIfcBuildingStoreyWallPresentationlayers(List<IfcBuildingStoreyWallPresentationlayer> ifcBuildingStoreyWallPresentationlayers) {
		this.ifcBuildingStoreyWallPresentationlayers = ifcBuildingStoreyWallPresentationlayers;
	}

	public IfcBuildingStoreyWallPresentationlayer addIfcBuildingStoreyWallPresentationlayer(IfcBuildingStoreyWallPresentationlayer ifcBuildingStoreyWallPresentationlayer) {
		getIfcBuildingStoreyWallPresentationlayers().add(ifcBuildingStoreyWallPresentationlayer);
		ifcBuildingStoreyWallPresentationlayer.setIfcBuildingStoreyWall(this);

		return ifcBuildingStoreyWallPresentationlayer;
	}

	public IfcBuildingStoreyWallPresentationlayer removeIfcBuildingStoreyWallPresentationlayer(IfcBuildingStoreyWallPresentationlayer ifcBuildingStoreyWallPresentationlayer) {
		getIfcBuildingStoreyWallPresentationlayers().remove(ifcBuildingStoreyWallPresentationlayer);
		ifcBuildingStoreyWallPresentationlayer.setIfcBuildingStoreyWall(null);

		return ifcBuildingStoreyWallPresentationlayer;
	}

	public List<IfcBuildingStoreyWallProperty> getIfcBuildingStoreyWallProperties() {
		return this.ifcBuildingStoreyWallProperties;
	}

	public void setIfcBuildingStoreyWallProperties(List<IfcBuildingStoreyWallProperty> ifcBuildingStoreyWallProperties) {
		this.ifcBuildingStoreyWallProperties = ifcBuildingStoreyWallProperties;
	}

	public IfcBuildingStoreyWallProperty addIfcBuildingStoreyWallProperty(IfcBuildingStoreyWallProperty ifcBuildingStoreyWallProperty) {
		getIfcBuildingStoreyWallProperties().add(ifcBuildingStoreyWallProperty);
		ifcBuildingStoreyWallProperty.setIfcBuildingStoreyWall(this);

		return ifcBuildingStoreyWallProperty;
	}

	public IfcBuildingStoreyWallProperty removeIfcBuildingStoreyWallProperty(IfcBuildingStoreyWallProperty ifcBuildingStoreyWallProperty) {
		getIfcBuildingStoreyWallProperties().remove(ifcBuildingStoreyWallProperty);
		ifcBuildingStoreyWallProperty.setIfcBuildingStoreyWall(null);

		return ifcBuildingStoreyWallProperty;
	}

}