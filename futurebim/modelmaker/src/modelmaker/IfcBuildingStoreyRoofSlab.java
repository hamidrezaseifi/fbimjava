package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_roof_slab database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_roof_slab")
@NamedQuery(name="IfcBuildingStoreyRoofSlab.findAll", query="SELECT i FROM IfcBuildingStoreyRoofSlab i")
public class IfcBuildingStoreyRoofSlab implements Serializable {
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

	//bi-directional many-to-one association to IfcBuildingStoreyRoof
	@ManyToOne
	@JoinColumn(name="roof_id")
	private IfcBuildingStoreyRoof ifcBuildingStoreyRoof;

	//bi-directional many-to-one association to IfcBuildingStoreyRoofSlabOpening
	@OneToMany(mappedBy="ifcBuildingStoreyRoofSlab")
	private List<IfcBuildingStoreyRoofSlabOpening> ifcBuildingStoreyRoofSlabOpenings;

	//bi-directional many-to-one association to IfcBuildingStoreyRoofSlabPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreyRoofSlab")
	private List<IfcBuildingStoreyRoofSlabPresentationlayer> ifcBuildingStoreyRoofSlabPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreyRoofSlabProperty
	@OneToMany(mappedBy="ifcBuildingStoreyRoofSlab")
	private List<IfcBuildingStoreyRoofSlabProperty> ifcBuildingStoreyRoofSlabProperties;

	public IfcBuildingStoreyRoofSlab() {
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

	public IfcBuildingStoreyRoof getIfcBuildingStoreyRoof() {
		return this.ifcBuildingStoreyRoof;
	}

	public void setIfcBuildingStoreyRoof(IfcBuildingStoreyRoof ifcBuildingStoreyRoof) {
		this.ifcBuildingStoreyRoof = ifcBuildingStoreyRoof;
	}

	public List<IfcBuildingStoreyRoofSlabOpening> getIfcBuildingStoreyRoofSlabOpenings() {
		return this.ifcBuildingStoreyRoofSlabOpenings;
	}

	public void setIfcBuildingStoreyRoofSlabOpenings(List<IfcBuildingStoreyRoofSlabOpening> ifcBuildingStoreyRoofSlabOpenings) {
		this.ifcBuildingStoreyRoofSlabOpenings = ifcBuildingStoreyRoofSlabOpenings;
	}

	public IfcBuildingStoreyRoofSlabOpening addIfcBuildingStoreyRoofSlabOpening(IfcBuildingStoreyRoofSlabOpening ifcBuildingStoreyRoofSlabOpening) {
		getIfcBuildingStoreyRoofSlabOpenings().add(ifcBuildingStoreyRoofSlabOpening);
		ifcBuildingStoreyRoofSlabOpening.setIfcBuildingStoreyRoofSlab(this);

		return ifcBuildingStoreyRoofSlabOpening;
	}

	public IfcBuildingStoreyRoofSlabOpening removeIfcBuildingStoreyRoofSlabOpening(IfcBuildingStoreyRoofSlabOpening ifcBuildingStoreyRoofSlabOpening) {
		getIfcBuildingStoreyRoofSlabOpenings().remove(ifcBuildingStoreyRoofSlabOpening);
		ifcBuildingStoreyRoofSlabOpening.setIfcBuildingStoreyRoofSlab(null);

		return ifcBuildingStoreyRoofSlabOpening;
	}

	public List<IfcBuildingStoreyRoofSlabPresentationlayer> getIfcBuildingStoreyRoofSlabPresentationlayers() {
		return this.ifcBuildingStoreyRoofSlabPresentationlayers;
	}

	public void setIfcBuildingStoreyRoofSlabPresentationlayers(List<IfcBuildingStoreyRoofSlabPresentationlayer> ifcBuildingStoreyRoofSlabPresentationlayers) {
		this.ifcBuildingStoreyRoofSlabPresentationlayers = ifcBuildingStoreyRoofSlabPresentationlayers;
	}

	public IfcBuildingStoreyRoofSlabPresentationlayer addIfcBuildingStoreyRoofSlabPresentationlayer(IfcBuildingStoreyRoofSlabPresentationlayer ifcBuildingStoreyRoofSlabPresentationlayer) {
		getIfcBuildingStoreyRoofSlabPresentationlayers().add(ifcBuildingStoreyRoofSlabPresentationlayer);
		ifcBuildingStoreyRoofSlabPresentationlayer.setIfcBuildingStoreyRoofSlab(this);

		return ifcBuildingStoreyRoofSlabPresentationlayer;
	}

	public IfcBuildingStoreyRoofSlabPresentationlayer removeIfcBuildingStoreyRoofSlabPresentationlayer(IfcBuildingStoreyRoofSlabPresentationlayer ifcBuildingStoreyRoofSlabPresentationlayer) {
		getIfcBuildingStoreyRoofSlabPresentationlayers().remove(ifcBuildingStoreyRoofSlabPresentationlayer);
		ifcBuildingStoreyRoofSlabPresentationlayer.setIfcBuildingStoreyRoofSlab(null);

		return ifcBuildingStoreyRoofSlabPresentationlayer;
	}

	public List<IfcBuildingStoreyRoofSlabProperty> getIfcBuildingStoreyRoofSlabProperties() {
		return this.ifcBuildingStoreyRoofSlabProperties;
	}

	public void setIfcBuildingStoreyRoofSlabProperties(List<IfcBuildingStoreyRoofSlabProperty> ifcBuildingStoreyRoofSlabProperties) {
		this.ifcBuildingStoreyRoofSlabProperties = ifcBuildingStoreyRoofSlabProperties;
	}

	public IfcBuildingStoreyRoofSlabProperty addIfcBuildingStoreyRoofSlabProperty(IfcBuildingStoreyRoofSlabProperty ifcBuildingStoreyRoofSlabProperty) {
		getIfcBuildingStoreyRoofSlabProperties().add(ifcBuildingStoreyRoofSlabProperty);
		ifcBuildingStoreyRoofSlabProperty.setIfcBuildingStoreyRoofSlab(this);

		return ifcBuildingStoreyRoofSlabProperty;
	}

	public IfcBuildingStoreyRoofSlabProperty removeIfcBuildingStoreyRoofSlabProperty(IfcBuildingStoreyRoofSlabProperty ifcBuildingStoreyRoofSlabProperty) {
		getIfcBuildingStoreyRoofSlabProperties().remove(ifcBuildingStoreyRoofSlabProperty);
		ifcBuildingStoreyRoofSlabProperty.setIfcBuildingStoreyRoofSlab(null);

		return ifcBuildingStoreyRoofSlabProperty;
	}

}