package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_roof database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_roof")
@NamedQuery(name="IfcBuildingStoreyRoof.findAll", query="SELECT i FROM IfcBuildingStoreyRoof i")
public class IfcBuildingStoreyRoof implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	@Column(name="object_placement")
	private String objectPlacement;

	@Column(name="object_type")
	private String objectType;

	@Column(name="roof_name")
	private String roofName;

	@Column(name="shape_type")
	private String shapeType;

	private short status;

	private String tag;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuildingStorey
	@ManyToOne
	@JoinColumn(name="storey_id")
	private IfcBuildingStorey ifcBuildingStorey;

	//bi-directional many-to-one association to IfcBuildingStoreyRoofPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreyRoof")
	private List<IfcBuildingStoreyRoofPresentationlayer> ifcBuildingStoreyRoofPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreyRoofProperty
	@OneToMany(mappedBy="ifcBuildingStoreyRoof")
	private List<IfcBuildingStoreyRoofProperty> ifcBuildingStoreyRoofProperties;

	//bi-directional many-to-one association to IfcBuildingStoreyRoofSlab
	@OneToMany(mappedBy="ifcBuildingStoreyRoof")
	private List<IfcBuildingStoreyRoofSlab> ifcBuildingStoreyRoofSlabs;

	public IfcBuildingStoreyRoof() {
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

	public String getRoofName() {
		return this.roofName;
	}

	public void setRoofName(String roofName) {
		this.roofName = roofName;
	}

	public String getShapeType() {
		return this.shapeType;
	}

	public void setShapeType(String shapeType) {
		this.shapeType = shapeType;
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

	public List<IfcBuildingStoreyRoofPresentationlayer> getIfcBuildingStoreyRoofPresentationlayers() {
		return this.ifcBuildingStoreyRoofPresentationlayers;
	}

	public void setIfcBuildingStoreyRoofPresentationlayers(List<IfcBuildingStoreyRoofPresentationlayer> ifcBuildingStoreyRoofPresentationlayers) {
		this.ifcBuildingStoreyRoofPresentationlayers = ifcBuildingStoreyRoofPresentationlayers;
	}

	public IfcBuildingStoreyRoofPresentationlayer addIfcBuildingStoreyRoofPresentationlayer(IfcBuildingStoreyRoofPresentationlayer ifcBuildingStoreyRoofPresentationlayer) {
		getIfcBuildingStoreyRoofPresentationlayers().add(ifcBuildingStoreyRoofPresentationlayer);
		ifcBuildingStoreyRoofPresentationlayer.setIfcBuildingStoreyRoof(this);

		return ifcBuildingStoreyRoofPresentationlayer;
	}

	public IfcBuildingStoreyRoofPresentationlayer removeIfcBuildingStoreyRoofPresentationlayer(IfcBuildingStoreyRoofPresentationlayer ifcBuildingStoreyRoofPresentationlayer) {
		getIfcBuildingStoreyRoofPresentationlayers().remove(ifcBuildingStoreyRoofPresentationlayer);
		ifcBuildingStoreyRoofPresentationlayer.setIfcBuildingStoreyRoof(null);

		return ifcBuildingStoreyRoofPresentationlayer;
	}

	public List<IfcBuildingStoreyRoofProperty> getIfcBuildingStoreyRoofProperties() {
		return this.ifcBuildingStoreyRoofProperties;
	}

	public void setIfcBuildingStoreyRoofProperties(List<IfcBuildingStoreyRoofProperty> ifcBuildingStoreyRoofProperties) {
		this.ifcBuildingStoreyRoofProperties = ifcBuildingStoreyRoofProperties;
	}

	public IfcBuildingStoreyRoofProperty addIfcBuildingStoreyRoofProperty(IfcBuildingStoreyRoofProperty ifcBuildingStoreyRoofProperty) {
		getIfcBuildingStoreyRoofProperties().add(ifcBuildingStoreyRoofProperty);
		ifcBuildingStoreyRoofProperty.setIfcBuildingStoreyRoof(this);

		return ifcBuildingStoreyRoofProperty;
	}

	public IfcBuildingStoreyRoofProperty removeIfcBuildingStoreyRoofProperty(IfcBuildingStoreyRoofProperty ifcBuildingStoreyRoofProperty) {
		getIfcBuildingStoreyRoofProperties().remove(ifcBuildingStoreyRoofProperty);
		ifcBuildingStoreyRoofProperty.setIfcBuildingStoreyRoof(null);

		return ifcBuildingStoreyRoofProperty;
	}

	public List<IfcBuildingStoreyRoofSlab> getIfcBuildingStoreyRoofSlabs() {
		return this.ifcBuildingStoreyRoofSlabs;
	}

	public void setIfcBuildingStoreyRoofSlabs(List<IfcBuildingStoreyRoofSlab> ifcBuildingStoreyRoofSlabs) {
		this.ifcBuildingStoreyRoofSlabs = ifcBuildingStoreyRoofSlabs;
	}

	public IfcBuildingStoreyRoofSlab addIfcBuildingStoreyRoofSlab(IfcBuildingStoreyRoofSlab ifcBuildingStoreyRoofSlab) {
		getIfcBuildingStoreyRoofSlabs().add(ifcBuildingStoreyRoofSlab);
		ifcBuildingStoreyRoofSlab.setIfcBuildingStoreyRoof(this);

		return ifcBuildingStoreyRoofSlab;
	}

	public IfcBuildingStoreyRoofSlab removeIfcBuildingStoreyRoofSlab(IfcBuildingStoreyRoofSlab ifcBuildingStoreyRoofSlab) {
		getIfcBuildingStoreyRoofSlabs().remove(ifcBuildingStoreyRoofSlab);
		ifcBuildingStoreyRoofSlab.setIfcBuildingStoreyRoof(null);

		return ifcBuildingStoreyRoofSlab;
	}

}