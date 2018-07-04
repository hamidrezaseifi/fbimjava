package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_space_furnishingelement_opening database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_space_furnishingelement_opening")
@NamedQuery(name="IfcBuildingStoreySpaceFurnishingelementOpening.findAll", query="SELECT i FROM IfcBuildingStoreySpaceFurnishingelementOpening i")
public class IfcBuildingStoreySpaceFurnishingelementOpening implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	@Column(name="element_id")
	private String elementId;

	@Column(name="object_placement")
	private String objectPlacement;

	@Column(name="object_type")
	private String objectType;

	@Column(name="open_name")
	private String openName;

	private short status;

	private String tag;

	private int version;

	//bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreySpaceFurnishingelementOpening")
	private List<IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer> ifcBuildingStoreySpaceFelementOpeningPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelementOpeningProperty
	@OneToMany(mappedBy="ifcBuildingStoreySpaceFurnishingelementOpening")
	private List<IfcBuildingStoreySpaceFurnishingelementOpeningProperty> ifcBuildingStoreySpaceFurnishingelementOpeningProperties;

	public IfcBuildingStoreySpaceFurnishingelementOpening() {
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

	public String getElementId() {
		return this.elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
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

	public String getOpenName() {
		return this.openName;
	}

	public void setOpenName(String openName) {
		this.openName = openName;
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

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer> getIfcBuildingStoreySpaceFelementOpeningPresentationlayers() {
		return this.ifcBuildingStoreySpaceFelementOpeningPresentationlayers;
	}

	public void setIfcBuildingStoreySpaceFelementOpeningPresentationlayers(List<IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer> ifcBuildingStoreySpaceFelementOpeningPresentationlayers) {
		this.ifcBuildingStoreySpaceFelementOpeningPresentationlayers = ifcBuildingStoreySpaceFelementOpeningPresentationlayers;
	}

	public IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer addIfcBuildingStoreySpaceFelementOpeningPresentationlayer(IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer ifcBuildingStoreySpaceFelementOpeningPresentationlayer) {
		getIfcBuildingStoreySpaceFelementOpeningPresentationlayers().add(ifcBuildingStoreySpaceFelementOpeningPresentationlayer);
		ifcBuildingStoreySpaceFelementOpeningPresentationlayer.setIfcBuildingStoreySpaceFurnishingelementOpening(this);

		return ifcBuildingStoreySpaceFelementOpeningPresentationlayer;
	}

	public IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer removeIfcBuildingStoreySpaceFelementOpeningPresentationlayer(IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer ifcBuildingStoreySpaceFelementOpeningPresentationlayer) {
		getIfcBuildingStoreySpaceFelementOpeningPresentationlayers().remove(ifcBuildingStoreySpaceFelementOpeningPresentationlayer);
		ifcBuildingStoreySpaceFelementOpeningPresentationlayer.setIfcBuildingStoreySpaceFurnishingelementOpening(null);

		return ifcBuildingStoreySpaceFelementOpeningPresentationlayer;
	}

	public List<IfcBuildingStoreySpaceFurnishingelementOpeningProperty> getIfcBuildingStoreySpaceFurnishingelementOpeningProperties() {
		return this.ifcBuildingStoreySpaceFurnishingelementOpeningProperties;
	}

	public void setIfcBuildingStoreySpaceFurnishingelementOpeningProperties(List<IfcBuildingStoreySpaceFurnishingelementOpeningProperty> ifcBuildingStoreySpaceFurnishingelementOpeningProperties) {
		this.ifcBuildingStoreySpaceFurnishingelementOpeningProperties = ifcBuildingStoreySpaceFurnishingelementOpeningProperties;
	}

	public IfcBuildingStoreySpaceFurnishingelementOpeningProperty addIfcBuildingStoreySpaceFurnishingelementOpeningProperty(IfcBuildingStoreySpaceFurnishingelementOpeningProperty ifcBuildingStoreySpaceFurnishingelementOpeningProperty) {
		getIfcBuildingStoreySpaceFurnishingelementOpeningProperties().add(ifcBuildingStoreySpaceFurnishingelementOpeningProperty);
		ifcBuildingStoreySpaceFurnishingelementOpeningProperty.setIfcBuildingStoreySpaceFurnishingelementOpening(this);

		return ifcBuildingStoreySpaceFurnishingelementOpeningProperty;
	}

	public IfcBuildingStoreySpaceFurnishingelementOpeningProperty removeIfcBuildingStoreySpaceFurnishingelementOpeningProperty(IfcBuildingStoreySpaceFurnishingelementOpeningProperty ifcBuildingStoreySpaceFurnishingelementOpeningProperty) {
		getIfcBuildingStoreySpaceFurnishingelementOpeningProperties().remove(ifcBuildingStoreySpaceFurnishingelementOpeningProperty);
		ifcBuildingStoreySpaceFurnishingelementOpeningProperty.setIfcBuildingStoreySpaceFurnishingelementOpening(null);

		return ifcBuildingStoreySpaceFurnishingelementOpeningProperty;
	}

}