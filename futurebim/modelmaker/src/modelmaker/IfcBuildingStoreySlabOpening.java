package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_slab_opening database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_slab_opening")
@NamedQuery(name="IfcBuildingStoreySlabOpening.findAll", query="SELECT i FROM IfcBuildingStoreySlabOpening i")
public class IfcBuildingStoreySlabOpening implements Serializable {
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

	//bi-directional many-to-one association to IfcBuildingStoreySlab
	@ManyToOne
	@JoinColumn(name="slab_id")
	private IfcBuildingStoreySlab ifcBuildingStoreySlab;

	//bi-directional many-to-one association to IfcBuildingStoreySlabOpeningPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreySlabOpening")
	private List<IfcBuildingStoreySlabOpeningPresentationlayer> ifcBuildingStoreySlabOpeningPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreySlabOpeningProperty
	@OneToMany(mappedBy="ifcBuildingStoreySlabOpening")
	private List<IfcBuildingStoreySlabOpeningProperty> ifcBuildingStoreySlabOpeningProperties;

	public IfcBuildingStoreySlabOpening() {
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

	public IfcBuildingStoreySlab getIfcBuildingStoreySlab() {
		return this.ifcBuildingStoreySlab;
	}

	public void setIfcBuildingStoreySlab(IfcBuildingStoreySlab ifcBuildingStoreySlab) {
		this.ifcBuildingStoreySlab = ifcBuildingStoreySlab;
	}

	public List<IfcBuildingStoreySlabOpeningPresentationlayer> getIfcBuildingStoreySlabOpeningPresentationlayers() {
		return this.ifcBuildingStoreySlabOpeningPresentationlayers;
	}

	public void setIfcBuildingStoreySlabOpeningPresentationlayers(List<IfcBuildingStoreySlabOpeningPresentationlayer> ifcBuildingStoreySlabOpeningPresentationlayers) {
		this.ifcBuildingStoreySlabOpeningPresentationlayers = ifcBuildingStoreySlabOpeningPresentationlayers;
	}

	public IfcBuildingStoreySlabOpeningPresentationlayer addIfcBuildingStoreySlabOpeningPresentationlayer(IfcBuildingStoreySlabOpeningPresentationlayer ifcBuildingStoreySlabOpeningPresentationlayer) {
		getIfcBuildingStoreySlabOpeningPresentationlayers().add(ifcBuildingStoreySlabOpeningPresentationlayer);
		ifcBuildingStoreySlabOpeningPresentationlayer.setIfcBuildingStoreySlabOpening(this);

		return ifcBuildingStoreySlabOpeningPresentationlayer;
	}

	public IfcBuildingStoreySlabOpeningPresentationlayer removeIfcBuildingStoreySlabOpeningPresentationlayer(IfcBuildingStoreySlabOpeningPresentationlayer ifcBuildingStoreySlabOpeningPresentationlayer) {
		getIfcBuildingStoreySlabOpeningPresentationlayers().remove(ifcBuildingStoreySlabOpeningPresentationlayer);
		ifcBuildingStoreySlabOpeningPresentationlayer.setIfcBuildingStoreySlabOpening(null);

		return ifcBuildingStoreySlabOpeningPresentationlayer;
	}

	public List<IfcBuildingStoreySlabOpeningProperty> getIfcBuildingStoreySlabOpeningProperties() {
		return this.ifcBuildingStoreySlabOpeningProperties;
	}

	public void setIfcBuildingStoreySlabOpeningProperties(List<IfcBuildingStoreySlabOpeningProperty> ifcBuildingStoreySlabOpeningProperties) {
		this.ifcBuildingStoreySlabOpeningProperties = ifcBuildingStoreySlabOpeningProperties;
	}

	public IfcBuildingStoreySlabOpeningProperty addIfcBuildingStoreySlabOpeningProperty(IfcBuildingStoreySlabOpeningProperty ifcBuildingStoreySlabOpeningProperty) {
		getIfcBuildingStoreySlabOpeningProperties().add(ifcBuildingStoreySlabOpeningProperty);
		ifcBuildingStoreySlabOpeningProperty.setIfcBuildingStoreySlabOpening(this);

		return ifcBuildingStoreySlabOpeningProperty;
	}

	public IfcBuildingStoreySlabOpeningProperty removeIfcBuildingStoreySlabOpeningProperty(IfcBuildingStoreySlabOpeningProperty ifcBuildingStoreySlabOpeningProperty) {
		getIfcBuildingStoreySlabOpeningProperties().remove(ifcBuildingStoreySlabOpeningProperty);
		ifcBuildingStoreySlabOpeningProperty.setIfcBuildingStoreySlabOpening(null);

		return ifcBuildingStoreySlabOpeningProperty;
	}

}