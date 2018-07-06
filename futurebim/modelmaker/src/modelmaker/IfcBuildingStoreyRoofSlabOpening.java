package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_roof_slab_opening database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_roof_slab_opening")
@NamedQuery(name="IfcBuildingStoreyRoofSlabOpening.findAll", query="SELECT i FROM IfcBuildingStoreyRoofSlabOpening i")
public class IfcBuildingStoreyRoofSlabOpening implements Serializable {
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

	//bi-directional many-to-one association to IfcBuildingStoreyRoofSlab
	@ManyToOne
	@JoinColumn(name="slab_id")
	private IfcBuildingStoreyRoofSlab ifcBuildingStoreyRoofSlab;

	//bi-directional many-to-one association to IfcBuildingStoreyRoofSlabOpeningPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreyRoofSlabOpening")
	private List<IfcBuildingStoreyRoofSlabOpeningPresentationlayer> ifcBuildingStoreyRoofSlabOpeningPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreyRoofSlabOpeningProperty
	@OneToMany(mappedBy="ifcBuildingStoreyRoofSlabOpening")
	private List<IfcBuildingStoreyRoofSlabOpeningProperty> ifcBuildingStoreyRoofSlabOpeningProperties;

	public IfcBuildingStoreyRoofSlabOpening() {
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

	public IfcBuildingStoreyRoofSlab getIfcBuildingStoreyRoofSlab() {
		return this.ifcBuildingStoreyRoofSlab;
	}

	public void setIfcBuildingStoreyRoofSlab(IfcBuildingStoreyRoofSlab ifcBuildingStoreyRoofSlab) {
		this.ifcBuildingStoreyRoofSlab = ifcBuildingStoreyRoofSlab;
	}

	public List<IfcBuildingStoreyRoofSlabOpeningPresentationlayer> getIfcBuildingStoreyRoofSlabOpeningPresentationlayers() {
		return this.ifcBuildingStoreyRoofSlabOpeningPresentationlayers;
	}

	public void setIfcBuildingStoreyRoofSlabOpeningPresentationlayers(List<IfcBuildingStoreyRoofSlabOpeningPresentationlayer> ifcBuildingStoreyRoofSlabOpeningPresentationlayers) {
		this.ifcBuildingStoreyRoofSlabOpeningPresentationlayers = ifcBuildingStoreyRoofSlabOpeningPresentationlayers;
	}

	public IfcBuildingStoreyRoofSlabOpeningPresentationlayer addIfcBuildingStoreyRoofSlabOpeningPresentationlayer(IfcBuildingStoreyRoofSlabOpeningPresentationlayer ifcBuildingStoreyRoofSlabOpeningPresentationlayer) {
		getIfcBuildingStoreyRoofSlabOpeningPresentationlayers().add(ifcBuildingStoreyRoofSlabOpeningPresentationlayer);
		ifcBuildingStoreyRoofSlabOpeningPresentationlayer.setIfcBuildingStoreyRoofSlabOpening(this);

		return ifcBuildingStoreyRoofSlabOpeningPresentationlayer;
	}

	public IfcBuildingStoreyRoofSlabOpeningPresentationlayer removeIfcBuildingStoreyRoofSlabOpeningPresentationlayer(IfcBuildingStoreyRoofSlabOpeningPresentationlayer ifcBuildingStoreyRoofSlabOpeningPresentationlayer) {
		getIfcBuildingStoreyRoofSlabOpeningPresentationlayers().remove(ifcBuildingStoreyRoofSlabOpeningPresentationlayer);
		ifcBuildingStoreyRoofSlabOpeningPresentationlayer.setIfcBuildingStoreyRoofSlabOpening(null);

		return ifcBuildingStoreyRoofSlabOpeningPresentationlayer;
	}

	public List<IfcBuildingStoreyRoofSlabOpeningProperty> getIfcBuildingStoreyRoofSlabOpeningProperties() {
		return this.ifcBuildingStoreyRoofSlabOpeningProperties;
	}

	public void setIfcBuildingStoreyRoofSlabOpeningProperties(List<IfcBuildingStoreyRoofSlabOpeningProperty> ifcBuildingStoreyRoofSlabOpeningProperties) {
		this.ifcBuildingStoreyRoofSlabOpeningProperties = ifcBuildingStoreyRoofSlabOpeningProperties;
	}

	public IfcBuildingStoreyRoofSlabOpeningProperty addIfcBuildingStoreyRoofSlabOpeningProperty(IfcBuildingStoreyRoofSlabOpeningProperty ifcBuildingStoreyRoofSlabOpeningProperty) {
		getIfcBuildingStoreyRoofSlabOpeningProperties().add(ifcBuildingStoreyRoofSlabOpeningProperty);
		ifcBuildingStoreyRoofSlabOpeningProperty.setIfcBuildingStoreyRoofSlabOpening(this);

		return ifcBuildingStoreyRoofSlabOpeningProperty;
	}

	public IfcBuildingStoreyRoofSlabOpeningProperty removeIfcBuildingStoreyRoofSlabOpeningProperty(IfcBuildingStoreyRoofSlabOpeningProperty ifcBuildingStoreyRoofSlabOpeningProperty) {
		getIfcBuildingStoreyRoofSlabOpeningProperties().remove(ifcBuildingStoreyRoofSlabOpeningProperty);
		ifcBuildingStoreyRoofSlabOpeningProperty.setIfcBuildingStoreyRoofSlabOpening(null);

		return ifcBuildingStoreyRoofSlabOpeningProperty;
	}

}