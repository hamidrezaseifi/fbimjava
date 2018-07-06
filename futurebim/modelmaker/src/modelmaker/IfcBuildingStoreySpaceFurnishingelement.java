package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_space_furnishingelement database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_space_furnishingelement")
@NamedQuery(name="IfcBuildingStoreySpaceFurnishingelement.findAll", query="SELECT i FROM IfcBuildingStoreySpaceFurnishingelement i")
public class IfcBuildingStoreySpaceFurnishingelement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	@Column(name="element_name")
	private String elementName;

	@Column(name="object_placement")
	private String objectPlacement;

	@Column(name="object_type")
	private String objectType;

	private short status;

	private String tag;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuildingStoreySpace
	@ManyToOne
	@JoinColumn(name="space_id")
	private IfcBuildingStoreySpace ifcBuildingStoreySpace;

	//bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelementFurnituretype
	@OneToMany(mappedBy="ifcBuildingStoreySpaceFurnishingelement")
	private List<IfcBuildingStoreySpaceFurnishingelementFurnituretype> ifcBuildingStoreySpaceFurnishingelementFurnituretypes;

	//bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelementOpening
	@OneToMany(mappedBy="ifcBuildingStoreySpaceFurnishingelement")
	private List<IfcBuildingStoreySpaceFurnishingelementOpening> ifcBuildingStoreySpaceFurnishingelementOpenings;

	//bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelementPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreySpaceFurnishingelement")
	private List<IfcBuildingStoreySpaceFurnishingelementPresentationlayer> ifcBuildingStoreySpaceFurnishingelementPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelementProperty
	@OneToMany(mappedBy="ifcBuildingStoreySpaceFurnishingelement")
	private List<IfcBuildingStoreySpaceFurnishingelementProperty> ifcBuildingStoreySpaceFurnishingelementProperties;

	public IfcBuildingStoreySpaceFurnishingelement() {
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

	public String getElementName() {
		return this.elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
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

	public IfcBuildingStoreySpace getIfcBuildingStoreySpace() {
		return this.ifcBuildingStoreySpace;
	}

	public void setIfcBuildingStoreySpace(IfcBuildingStoreySpace ifcBuildingStoreySpace) {
		this.ifcBuildingStoreySpace = ifcBuildingStoreySpace;
	}

	public List<IfcBuildingStoreySpaceFurnishingelementFurnituretype> getIfcBuildingStoreySpaceFurnishingelementFurnituretypes() {
		return this.ifcBuildingStoreySpaceFurnishingelementFurnituretypes;
	}

	public void setIfcBuildingStoreySpaceFurnishingelementFurnituretypes(List<IfcBuildingStoreySpaceFurnishingelementFurnituretype> ifcBuildingStoreySpaceFurnishingelementFurnituretypes) {
		this.ifcBuildingStoreySpaceFurnishingelementFurnituretypes = ifcBuildingStoreySpaceFurnishingelementFurnituretypes;
	}

	public IfcBuildingStoreySpaceFurnishingelementFurnituretype addIfcBuildingStoreySpaceFurnishingelementFurnituretype(IfcBuildingStoreySpaceFurnishingelementFurnituretype ifcBuildingStoreySpaceFurnishingelementFurnituretype) {
		getIfcBuildingStoreySpaceFurnishingelementFurnituretypes().add(ifcBuildingStoreySpaceFurnishingelementFurnituretype);
		ifcBuildingStoreySpaceFurnishingelementFurnituretype.setIfcBuildingStoreySpaceFurnishingelement(this);

		return ifcBuildingStoreySpaceFurnishingelementFurnituretype;
	}

	public IfcBuildingStoreySpaceFurnishingelementFurnituretype removeIfcBuildingStoreySpaceFurnishingelementFurnituretype(IfcBuildingStoreySpaceFurnishingelementFurnituretype ifcBuildingStoreySpaceFurnishingelementFurnituretype) {
		getIfcBuildingStoreySpaceFurnishingelementFurnituretypes().remove(ifcBuildingStoreySpaceFurnishingelementFurnituretype);
		ifcBuildingStoreySpaceFurnishingelementFurnituretype.setIfcBuildingStoreySpaceFurnishingelement(null);

		return ifcBuildingStoreySpaceFurnishingelementFurnituretype;
	}

	public List<IfcBuildingStoreySpaceFurnishingelementOpening> getIfcBuildingStoreySpaceFurnishingelementOpenings() {
		return this.ifcBuildingStoreySpaceFurnishingelementOpenings;
	}

	public void setIfcBuildingStoreySpaceFurnishingelementOpenings(List<IfcBuildingStoreySpaceFurnishingelementOpening> ifcBuildingStoreySpaceFurnishingelementOpenings) {
		this.ifcBuildingStoreySpaceFurnishingelementOpenings = ifcBuildingStoreySpaceFurnishingelementOpenings;
	}

	public IfcBuildingStoreySpaceFurnishingelementOpening addIfcBuildingStoreySpaceFurnishingelementOpening(IfcBuildingStoreySpaceFurnishingelementOpening ifcBuildingStoreySpaceFurnishingelementOpening) {
		getIfcBuildingStoreySpaceFurnishingelementOpenings().add(ifcBuildingStoreySpaceFurnishingelementOpening);
		ifcBuildingStoreySpaceFurnishingelementOpening.setIfcBuildingStoreySpaceFurnishingelement(this);

		return ifcBuildingStoreySpaceFurnishingelementOpening;
	}

	public IfcBuildingStoreySpaceFurnishingelementOpening removeIfcBuildingStoreySpaceFurnishingelementOpening(IfcBuildingStoreySpaceFurnishingelementOpening ifcBuildingStoreySpaceFurnishingelementOpening) {
		getIfcBuildingStoreySpaceFurnishingelementOpenings().remove(ifcBuildingStoreySpaceFurnishingelementOpening);
		ifcBuildingStoreySpaceFurnishingelementOpening.setIfcBuildingStoreySpaceFurnishingelement(null);

		return ifcBuildingStoreySpaceFurnishingelementOpening;
	}

	public List<IfcBuildingStoreySpaceFurnishingelementPresentationlayer> getIfcBuildingStoreySpaceFurnishingelementPresentationlayers() {
		return this.ifcBuildingStoreySpaceFurnishingelementPresentationlayers;
	}

	public void setIfcBuildingStoreySpaceFurnishingelementPresentationlayers(List<IfcBuildingStoreySpaceFurnishingelementPresentationlayer> ifcBuildingStoreySpaceFurnishingelementPresentationlayers) {
		this.ifcBuildingStoreySpaceFurnishingelementPresentationlayers = ifcBuildingStoreySpaceFurnishingelementPresentationlayers;
	}

	public IfcBuildingStoreySpaceFurnishingelementPresentationlayer addIfcBuildingStoreySpaceFurnishingelementPresentationlayer(IfcBuildingStoreySpaceFurnishingelementPresentationlayer ifcBuildingStoreySpaceFurnishingelementPresentationlayer) {
		getIfcBuildingStoreySpaceFurnishingelementPresentationlayers().add(ifcBuildingStoreySpaceFurnishingelementPresentationlayer);
		ifcBuildingStoreySpaceFurnishingelementPresentationlayer.setIfcBuildingStoreySpaceFurnishingelement(this);

		return ifcBuildingStoreySpaceFurnishingelementPresentationlayer;
	}

	public IfcBuildingStoreySpaceFurnishingelementPresentationlayer removeIfcBuildingStoreySpaceFurnishingelementPresentationlayer(IfcBuildingStoreySpaceFurnishingelementPresentationlayer ifcBuildingStoreySpaceFurnishingelementPresentationlayer) {
		getIfcBuildingStoreySpaceFurnishingelementPresentationlayers().remove(ifcBuildingStoreySpaceFurnishingelementPresentationlayer);
		ifcBuildingStoreySpaceFurnishingelementPresentationlayer.setIfcBuildingStoreySpaceFurnishingelement(null);

		return ifcBuildingStoreySpaceFurnishingelementPresentationlayer;
	}

	public List<IfcBuildingStoreySpaceFurnishingelementProperty> getIfcBuildingStoreySpaceFurnishingelementProperties() {
		return this.ifcBuildingStoreySpaceFurnishingelementProperties;
	}

	public void setIfcBuildingStoreySpaceFurnishingelementProperties(List<IfcBuildingStoreySpaceFurnishingelementProperty> ifcBuildingStoreySpaceFurnishingelementProperties) {
		this.ifcBuildingStoreySpaceFurnishingelementProperties = ifcBuildingStoreySpaceFurnishingelementProperties;
	}

	public IfcBuildingStoreySpaceFurnishingelementProperty addIfcBuildingStoreySpaceFurnishingelementProperty(IfcBuildingStoreySpaceFurnishingelementProperty ifcBuildingStoreySpaceFurnishingelementProperty) {
		getIfcBuildingStoreySpaceFurnishingelementProperties().add(ifcBuildingStoreySpaceFurnishingelementProperty);
		ifcBuildingStoreySpaceFurnishingelementProperty.setIfcBuildingStoreySpaceFurnishingelement(this);

		return ifcBuildingStoreySpaceFurnishingelementProperty;
	}

	public IfcBuildingStoreySpaceFurnishingelementProperty removeIfcBuildingStoreySpaceFurnishingelementProperty(IfcBuildingStoreySpaceFurnishingelementProperty ifcBuildingStoreySpaceFurnishingelementProperty) {
		getIfcBuildingStoreySpaceFurnishingelementProperties().remove(ifcBuildingStoreySpaceFurnishingelementProperty);
		ifcBuildingStoreySpaceFurnishingelementProperty.setIfcBuildingStoreySpaceFurnishingelement(null);

		return ifcBuildingStoreySpaceFurnishingelementProperty;
	}

}