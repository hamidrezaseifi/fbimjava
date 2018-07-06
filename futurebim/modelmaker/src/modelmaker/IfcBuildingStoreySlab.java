package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_slab database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_slab")
@NamedQuery(name="IfcBuildingStoreySlab.findAll", query="SELECT i FROM IfcBuildingStoreySlab i")
public class IfcBuildingStoreySlab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	@Column(name="object_placement")
	private String objectPlacement;

	@Column(name="object_type")
	private String objectType;

	@Column(name="predefined_type")
	private String predefinedType;

	@Column(name="slab_name")
	private String slabName;

	private short status;

	private String tag;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuildingStorey
	@ManyToOne
	@JoinColumn(name="storey_id")
	private IfcBuildingStorey ifcBuildingStorey;

	//bi-directional many-to-one association to IfcBuildingStoreySlabOpening
	@OneToMany(mappedBy="ifcBuildingStoreySlab")
	private List<IfcBuildingStoreySlabOpening> ifcBuildingStoreySlabOpenings;

	//bi-directional many-to-one association to IfcBuildingStoreySlabPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreySlab")
	private List<IfcBuildingStoreySlabPresentationlayer> ifcBuildingStoreySlabPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreySlabProperty
	@OneToMany(mappedBy="ifcBuildingStoreySlab")
	private List<IfcBuildingStoreySlabProperty> ifcBuildingStoreySlabProperties;

	public IfcBuildingStoreySlab() {
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

	public String getPredefinedType() {
		return this.predefinedType;
	}

	public void setPredefinedType(String predefinedType) {
		this.predefinedType = predefinedType;
	}

	public String getSlabName() {
		return this.slabName;
	}

	public void setSlabName(String slabName) {
		this.slabName = slabName;
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

	public IfcBuildingStorey getIfcBuildingStorey() {
		return this.ifcBuildingStorey;
	}

	public void setIfcBuildingStorey(IfcBuildingStorey ifcBuildingStorey) {
		this.ifcBuildingStorey = ifcBuildingStorey;
	}

	public List<IfcBuildingStoreySlabOpening> getIfcBuildingStoreySlabOpenings() {
		return this.ifcBuildingStoreySlabOpenings;
	}

	public void setIfcBuildingStoreySlabOpenings(List<IfcBuildingStoreySlabOpening> ifcBuildingStoreySlabOpenings) {
		this.ifcBuildingStoreySlabOpenings = ifcBuildingStoreySlabOpenings;
	}

	public IfcBuildingStoreySlabOpening addIfcBuildingStoreySlabOpening(IfcBuildingStoreySlabOpening ifcBuildingStoreySlabOpening) {
		getIfcBuildingStoreySlabOpenings().add(ifcBuildingStoreySlabOpening);
		ifcBuildingStoreySlabOpening.setIfcBuildingStoreySlab(this);

		return ifcBuildingStoreySlabOpening;
	}

	public IfcBuildingStoreySlabOpening removeIfcBuildingStoreySlabOpening(IfcBuildingStoreySlabOpening ifcBuildingStoreySlabOpening) {
		getIfcBuildingStoreySlabOpenings().remove(ifcBuildingStoreySlabOpening);
		ifcBuildingStoreySlabOpening.setIfcBuildingStoreySlab(null);

		return ifcBuildingStoreySlabOpening;
	}

	public List<IfcBuildingStoreySlabPresentationlayer> getIfcBuildingStoreySlabPresentationlayers() {
		return this.ifcBuildingStoreySlabPresentationlayers;
	}

	public void setIfcBuildingStoreySlabPresentationlayers(List<IfcBuildingStoreySlabPresentationlayer> ifcBuildingStoreySlabPresentationlayers) {
		this.ifcBuildingStoreySlabPresentationlayers = ifcBuildingStoreySlabPresentationlayers;
	}

	public IfcBuildingStoreySlabPresentationlayer addIfcBuildingStoreySlabPresentationlayer(IfcBuildingStoreySlabPresentationlayer ifcBuildingStoreySlabPresentationlayer) {
		getIfcBuildingStoreySlabPresentationlayers().add(ifcBuildingStoreySlabPresentationlayer);
		ifcBuildingStoreySlabPresentationlayer.setIfcBuildingStoreySlab(this);

		return ifcBuildingStoreySlabPresentationlayer;
	}

	public IfcBuildingStoreySlabPresentationlayer removeIfcBuildingStoreySlabPresentationlayer(IfcBuildingStoreySlabPresentationlayer ifcBuildingStoreySlabPresentationlayer) {
		getIfcBuildingStoreySlabPresentationlayers().remove(ifcBuildingStoreySlabPresentationlayer);
		ifcBuildingStoreySlabPresentationlayer.setIfcBuildingStoreySlab(null);

		return ifcBuildingStoreySlabPresentationlayer;
	}

	public List<IfcBuildingStoreySlabProperty> getIfcBuildingStoreySlabProperties() {
		return this.ifcBuildingStoreySlabProperties;
	}

	public void setIfcBuildingStoreySlabProperties(List<IfcBuildingStoreySlabProperty> ifcBuildingStoreySlabProperties) {
		this.ifcBuildingStoreySlabProperties = ifcBuildingStoreySlabProperties;
	}

	public IfcBuildingStoreySlabProperty addIfcBuildingStoreySlabProperty(IfcBuildingStoreySlabProperty ifcBuildingStoreySlabProperty) {
		getIfcBuildingStoreySlabProperties().add(ifcBuildingStoreySlabProperty);
		ifcBuildingStoreySlabProperty.setIfcBuildingStoreySlab(this);

		return ifcBuildingStoreySlabProperty;
	}

	public IfcBuildingStoreySlabProperty removeIfcBuildingStoreySlabProperty(IfcBuildingStoreySlabProperty ifcBuildingStoreySlabProperty) {
		getIfcBuildingStoreySlabProperties().remove(ifcBuildingStoreySlabProperty);
		ifcBuildingStoreySlabProperty.setIfcBuildingStoreySlab(null);

		return ifcBuildingStoreySlabProperty;
	}

}