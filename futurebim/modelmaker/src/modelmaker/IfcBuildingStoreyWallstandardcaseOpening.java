package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_wallstandardcase_opening database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_wallstandardcase_opening")
@NamedQuery(name="IfcBuildingStoreyWallstandardcaseOpening.findAll", query="SELECT i FROM IfcBuildingStoreyWallstandardcaseOpening i")
public class IfcBuildingStoreyWallstandardcaseOpening implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	@Column(name="object_placement")
	private String objectPlacement;

	@Column(name="object_type")
	private String objectType;

	@Column(name="opening_name")
	private String openingName;

	private short status;

	private String tag;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuildingStoreyWallstandardcase
	@ManyToOne
	@JoinColumn(name="wall_id")
	private IfcBuildingStoreyWallstandardcase ifcBuildingStoreyWallstandardcase;

	//bi-directional many-to-one association to IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreyWallstandardcaseOpening")
	private List<IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer> ifcBuildingStoreyWallstandardcaseOpeningPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreyWallstandardcaseOpeningProperty
	@OneToMany(mappedBy="ifcBuildingStoreyWallstandardcaseOpening")
	private List<IfcBuildingStoreyWallstandardcaseOpeningProperty> ifcBuildingStoreyWallstandardcaseOpeningProperties;

	public IfcBuildingStoreyWallstandardcaseOpening() {
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

	public String getOpeningName() {
		return this.openingName;
	}

	public void setOpeningName(String openingName) {
		this.openingName = openingName;
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

	public IfcBuildingStoreyWallstandardcase getIfcBuildingStoreyWallstandardcase() {
		return this.ifcBuildingStoreyWallstandardcase;
	}

	public void setIfcBuildingStoreyWallstandardcase(IfcBuildingStoreyWallstandardcase ifcBuildingStoreyWallstandardcase) {
		this.ifcBuildingStoreyWallstandardcase = ifcBuildingStoreyWallstandardcase;
	}

	public List<IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer> getIfcBuildingStoreyWallstandardcaseOpeningPresentationlayers() {
		return this.ifcBuildingStoreyWallstandardcaseOpeningPresentationlayers;
	}

	public void setIfcBuildingStoreyWallstandardcaseOpeningPresentationlayers(List<IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer> ifcBuildingStoreyWallstandardcaseOpeningPresentationlayers) {
		this.ifcBuildingStoreyWallstandardcaseOpeningPresentationlayers = ifcBuildingStoreyWallstandardcaseOpeningPresentationlayers;
	}

	public IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer addIfcBuildingStoreyWallstandardcaseOpeningPresentationlayer(IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer ifcBuildingStoreyWallstandardcaseOpeningPresentationlayer) {
		getIfcBuildingStoreyWallstandardcaseOpeningPresentationlayers().add(ifcBuildingStoreyWallstandardcaseOpeningPresentationlayer);
		ifcBuildingStoreyWallstandardcaseOpeningPresentationlayer.setIfcBuildingStoreyWallstandardcaseOpening(this);

		return ifcBuildingStoreyWallstandardcaseOpeningPresentationlayer;
	}

	public IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer removeIfcBuildingStoreyWallstandardcaseOpeningPresentationlayer(IfcBuildingStoreyWallstandardcaseOpeningPresentationlayer ifcBuildingStoreyWallstandardcaseOpeningPresentationlayer) {
		getIfcBuildingStoreyWallstandardcaseOpeningPresentationlayers().remove(ifcBuildingStoreyWallstandardcaseOpeningPresentationlayer);
		ifcBuildingStoreyWallstandardcaseOpeningPresentationlayer.setIfcBuildingStoreyWallstandardcaseOpening(null);

		return ifcBuildingStoreyWallstandardcaseOpeningPresentationlayer;
	}

	public List<IfcBuildingStoreyWallstandardcaseOpeningProperty> getIfcBuildingStoreyWallstandardcaseOpeningProperties() {
		return this.ifcBuildingStoreyWallstandardcaseOpeningProperties;
	}

	public void setIfcBuildingStoreyWallstandardcaseOpeningProperties(List<IfcBuildingStoreyWallstandardcaseOpeningProperty> ifcBuildingStoreyWallstandardcaseOpeningProperties) {
		this.ifcBuildingStoreyWallstandardcaseOpeningProperties = ifcBuildingStoreyWallstandardcaseOpeningProperties;
	}

	public IfcBuildingStoreyWallstandardcaseOpeningProperty addIfcBuildingStoreyWallstandardcaseOpeningProperty(IfcBuildingStoreyWallstandardcaseOpeningProperty ifcBuildingStoreyWallstandardcaseOpeningProperty) {
		getIfcBuildingStoreyWallstandardcaseOpeningProperties().add(ifcBuildingStoreyWallstandardcaseOpeningProperty);
		ifcBuildingStoreyWallstandardcaseOpeningProperty.setIfcBuildingStoreyWallstandardcaseOpening(this);

		return ifcBuildingStoreyWallstandardcaseOpeningProperty;
	}

	public IfcBuildingStoreyWallstandardcaseOpeningProperty removeIfcBuildingStoreyWallstandardcaseOpeningProperty(IfcBuildingStoreyWallstandardcaseOpeningProperty ifcBuildingStoreyWallstandardcaseOpeningProperty) {
		getIfcBuildingStoreyWallstandardcaseOpeningProperties().remove(ifcBuildingStoreyWallstandardcaseOpeningProperty);
		ifcBuildingStoreyWallstandardcaseOpeningProperty.setIfcBuildingStoreyWallstandardcaseOpening(null);

		return ifcBuildingStoreyWallstandardcaseOpeningProperty;
	}

}