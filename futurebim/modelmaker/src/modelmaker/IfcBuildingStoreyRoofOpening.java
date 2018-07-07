package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_roof_opening database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_roof_opening")
@NamedQuery(name="IfcBuildingStoreyRoofOpening.findAll", query="SELECT i FROM IfcBuildingStoreyRoofOpening i")
public class IfcBuildingStoreyRoofOpening implements Serializable {
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

	//bi-directional many-to-one association to IfcBuildingStoreyRoof
	@ManyToOne
	@JoinColumn(name="roof_id")
	private IfcBuildingStoreyRoof ifcBuildingStoreyRoof;

	//bi-directional many-to-one association to IfcBuildingStoreyRoofOpeningPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreyRoofOpening")
	private List<IfcBuildingStoreyRoofOpeningPresentationlayer> ifcBuildingStoreyRoofOpeningPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreyRoofOpeningProperty
	@OneToMany(mappedBy="ifcBuildingStoreyRoofOpening")
	private List<IfcBuildingStoreyRoofOpeningProperty> ifcBuildingStoreyRoofOpeningProperties;

	public IfcBuildingStoreyRoofOpening() {
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

	public IfcBuildingStoreyRoof getIfcBuildingStoreyRoof() {
		return this.ifcBuildingStoreyRoof;
	}

	public void setIfcBuildingStoreyRoof(IfcBuildingStoreyRoof ifcBuildingStoreyRoof) {
		this.ifcBuildingStoreyRoof = ifcBuildingStoreyRoof;
	}

	public List<IfcBuildingStoreyRoofOpeningPresentationlayer> getIfcBuildingStoreyRoofOpeningPresentationlayers() {
		return this.ifcBuildingStoreyRoofOpeningPresentationlayers;
	}

	public void setIfcBuildingStoreyRoofOpeningPresentationlayers(List<IfcBuildingStoreyRoofOpeningPresentationlayer> ifcBuildingStoreyRoofOpeningPresentationlayers) {
		this.ifcBuildingStoreyRoofOpeningPresentationlayers = ifcBuildingStoreyRoofOpeningPresentationlayers;
	}

	public IfcBuildingStoreyRoofOpeningPresentationlayer addIfcBuildingStoreyRoofOpeningPresentationlayer(IfcBuildingStoreyRoofOpeningPresentationlayer ifcBuildingStoreyRoofOpeningPresentationlayer) {
		getIfcBuildingStoreyRoofOpeningPresentationlayers().add(ifcBuildingStoreyRoofOpeningPresentationlayer);
		ifcBuildingStoreyRoofOpeningPresentationlayer.setIfcBuildingStoreyRoofOpening(this);

		return ifcBuildingStoreyRoofOpeningPresentationlayer;
	}

	public IfcBuildingStoreyRoofOpeningPresentationlayer removeIfcBuildingStoreyRoofOpeningPresentationlayer(IfcBuildingStoreyRoofOpeningPresentationlayer ifcBuildingStoreyRoofOpeningPresentationlayer) {
		getIfcBuildingStoreyRoofOpeningPresentationlayers().remove(ifcBuildingStoreyRoofOpeningPresentationlayer);
		ifcBuildingStoreyRoofOpeningPresentationlayer.setIfcBuildingStoreyRoofOpening(null);

		return ifcBuildingStoreyRoofOpeningPresentationlayer;
	}

	public List<IfcBuildingStoreyRoofOpeningProperty> getIfcBuildingStoreyRoofOpeningProperties() {
		return this.ifcBuildingStoreyRoofOpeningProperties;
	}

	public void setIfcBuildingStoreyRoofOpeningProperties(List<IfcBuildingStoreyRoofOpeningProperty> ifcBuildingStoreyRoofOpeningProperties) {
		this.ifcBuildingStoreyRoofOpeningProperties = ifcBuildingStoreyRoofOpeningProperties;
	}

	public IfcBuildingStoreyRoofOpeningProperty addIfcBuildingStoreyRoofOpeningProperty(IfcBuildingStoreyRoofOpeningProperty ifcBuildingStoreyRoofOpeningProperty) {
		getIfcBuildingStoreyRoofOpeningProperties().add(ifcBuildingStoreyRoofOpeningProperty);
		ifcBuildingStoreyRoofOpeningProperty.setIfcBuildingStoreyRoofOpening(this);

		return ifcBuildingStoreyRoofOpeningProperty;
	}

	public IfcBuildingStoreyRoofOpeningProperty removeIfcBuildingStoreyRoofOpeningProperty(IfcBuildingStoreyRoofOpeningProperty ifcBuildingStoreyRoofOpeningProperty) {
		getIfcBuildingStoreyRoofOpeningProperties().remove(ifcBuildingStoreyRoofOpeningProperty);
		ifcBuildingStoreyRoofOpeningProperty.setIfcBuildingStoreyRoofOpening(null);

		return ifcBuildingStoreyRoofOpeningProperty;
	}

}