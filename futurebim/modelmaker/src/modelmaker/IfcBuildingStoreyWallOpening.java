package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_wall_opening database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_wall_opening")
@NamedQuery(name="IfcBuildingStoreyWallOpening.findAll", query="SELECT i FROM IfcBuildingStoreyWallOpening i")
public class IfcBuildingStoreyWallOpening implements Serializable {
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

	//bi-directional many-to-one association to IfcBuildingStoreyWall
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="wall_id")
	private IfcBuildingStoreyWall ifcBuildingStoreyWall;

	//bi-directional many-to-one association to IfcBuildingStoreyWallOpeningPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreyWallOpening")
	private List<IfcBuildingStoreyWallOpeningPresentationlayer> ifcBuildingStoreyWallOpeningPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreyWallOpeningProperty
	@OneToMany(mappedBy="ifcBuildingStoreyWallOpening")
	private List<IfcBuildingStoreyWallOpeningProperty> ifcBuildingStoreyWallOpeningProperties;

	public IfcBuildingStoreyWallOpening() {
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

	public IfcBuildingStoreyWall getIfcBuildingStoreyWall() {
		return this.ifcBuildingStoreyWall;
	}

	public void setIfcBuildingStoreyWall(IfcBuildingStoreyWall ifcBuildingStoreyWall) {
		this.ifcBuildingStoreyWall = ifcBuildingStoreyWall;
	}

	public List<IfcBuildingStoreyWallOpeningPresentationlayer> getIfcBuildingStoreyWallOpeningPresentationlayers() {
		return this.ifcBuildingStoreyWallOpeningPresentationlayers;
	}

	public void setIfcBuildingStoreyWallOpeningPresentationlayers(List<IfcBuildingStoreyWallOpeningPresentationlayer> ifcBuildingStoreyWallOpeningPresentationlayers) {
		this.ifcBuildingStoreyWallOpeningPresentationlayers = ifcBuildingStoreyWallOpeningPresentationlayers;
	}

	public IfcBuildingStoreyWallOpeningPresentationlayer addIfcBuildingStoreyWallOpeningPresentationlayer(IfcBuildingStoreyWallOpeningPresentationlayer ifcBuildingStoreyWallOpeningPresentationlayer) {
		getIfcBuildingStoreyWallOpeningPresentationlayers().add(ifcBuildingStoreyWallOpeningPresentationlayer);
		ifcBuildingStoreyWallOpeningPresentationlayer.setIfcBuildingStoreyWallOpening(this);

		return ifcBuildingStoreyWallOpeningPresentationlayer;
	}

	public IfcBuildingStoreyWallOpeningPresentationlayer removeIfcBuildingStoreyWallOpeningPresentationlayer(IfcBuildingStoreyWallOpeningPresentationlayer ifcBuildingStoreyWallOpeningPresentationlayer) {
		getIfcBuildingStoreyWallOpeningPresentationlayers().remove(ifcBuildingStoreyWallOpeningPresentationlayer);
		ifcBuildingStoreyWallOpeningPresentationlayer.setIfcBuildingStoreyWallOpening(null);

		return ifcBuildingStoreyWallOpeningPresentationlayer;
	}

	public List<IfcBuildingStoreyWallOpeningProperty> getIfcBuildingStoreyWallOpeningProperties() {
		return this.ifcBuildingStoreyWallOpeningProperties;
	}

	public void setIfcBuildingStoreyWallOpeningProperties(List<IfcBuildingStoreyWallOpeningProperty> ifcBuildingStoreyWallOpeningProperties) {
		this.ifcBuildingStoreyWallOpeningProperties = ifcBuildingStoreyWallOpeningProperties;
	}

	public IfcBuildingStoreyWallOpeningProperty addIfcBuildingStoreyWallOpeningProperty(IfcBuildingStoreyWallOpeningProperty ifcBuildingStoreyWallOpeningProperty) {
		getIfcBuildingStoreyWallOpeningProperties().add(ifcBuildingStoreyWallOpeningProperty);
		ifcBuildingStoreyWallOpeningProperty.setIfcBuildingStoreyWallOpening(this);

		return ifcBuildingStoreyWallOpeningProperty;
	}

	public IfcBuildingStoreyWallOpeningProperty removeIfcBuildingStoreyWallOpeningProperty(IfcBuildingStoreyWallOpeningProperty ifcBuildingStoreyWallOpeningProperty) {
		getIfcBuildingStoreyWallOpeningProperties().remove(ifcBuildingStoreyWallOpeningProperty);
		ifcBuildingStoreyWallOpeningProperty.setIfcBuildingStoreyWallOpening(null);

		return ifcBuildingStoreyWallOpeningProperty;
	}

}