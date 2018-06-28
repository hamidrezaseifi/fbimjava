package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_space database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_space")
@NamedQuery(name="IfcBuildingStoreySpace.findAll", query="SELECT i FROM IfcBuildingStoreySpace i")
public class IfcBuildingStoreySpace implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="composition_type")
	private String compositionType;

	private Timestamp created;

	private String description;

	@Column(name="interior_or_exterior_space")
	private String interiorOrExteriorSpace;

	@Column(name="long_name")
	private String longName;

	@Column(name="object_placement")
	private String objectPlacement;

	@Column(name="space_name")
	private String spaceName;

	private short status;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuildingStorey
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="stair_id")
	private IfcBuildingStorey ifcBuildingStorey;

	//bi-directional many-to-one association to IfcBuildingStoreySpacePresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreySpace")
	private List<IfcBuildingStoreySpacePresentationlayer> ifcBuildingStoreySpacePresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreySpaceProperty
	@OneToMany(mappedBy="ifcBuildingStoreySpace")
	private List<IfcBuildingStoreySpaceProperty> ifcBuildingStoreySpaceProperties;

	public IfcBuildingStoreySpace() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompositionType() {
		return this.compositionType;
	}

	public void setCompositionType(String compositionType) {
		this.compositionType = compositionType;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInteriorOrExteriorSpace() {
		return this.interiorOrExteriorSpace;
	}

	public void setInteriorOrExteriorSpace(String interiorOrExteriorSpace) {
		this.interiorOrExteriorSpace = interiorOrExteriorSpace;
	}

	public String getLongName() {
		return this.longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getObjectPlacement() {
		return this.objectPlacement;
	}

	public void setObjectPlacement(String objectPlacement) {
		this.objectPlacement = objectPlacement;
	}

	public String getSpaceName() {
		return this.spaceName;
	}

	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
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

	public List<IfcBuildingStoreySpacePresentationlayer> getIfcBuildingStoreySpacePresentationlayers() {
		return this.ifcBuildingStoreySpacePresentationlayers;
	}

	public void setIfcBuildingStoreySpacePresentationlayers(List<IfcBuildingStoreySpacePresentationlayer> ifcBuildingStoreySpacePresentationlayers) {
		this.ifcBuildingStoreySpacePresentationlayers = ifcBuildingStoreySpacePresentationlayers;
	}

	public IfcBuildingStoreySpacePresentationlayer addIfcBuildingStoreySpacePresentationlayer(IfcBuildingStoreySpacePresentationlayer ifcBuildingStoreySpacePresentationlayer) {
		getIfcBuildingStoreySpacePresentationlayers().add(ifcBuildingStoreySpacePresentationlayer);
		ifcBuildingStoreySpacePresentationlayer.setIfcBuildingStoreySpace(this);

		return ifcBuildingStoreySpacePresentationlayer;
	}

	public IfcBuildingStoreySpacePresentationlayer removeIfcBuildingStoreySpacePresentationlayer(IfcBuildingStoreySpacePresentationlayer ifcBuildingStoreySpacePresentationlayer) {
		getIfcBuildingStoreySpacePresentationlayers().remove(ifcBuildingStoreySpacePresentationlayer);
		ifcBuildingStoreySpacePresentationlayer.setIfcBuildingStoreySpace(null);

		return ifcBuildingStoreySpacePresentationlayer;
	}

	public List<IfcBuildingStoreySpaceProperty> getIfcBuildingStoreySpaceProperties() {
		return this.ifcBuildingStoreySpaceProperties;
	}

	public void setIfcBuildingStoreySpaceProperties(List<IfcBuildingStoreySpaceProperty> ifcBuildingStoreySpaceProperties) {
		this.ifcBuildingStoreySpaceProperties = ifcBuildingStoreySpaceProperties;
	}

	public IfcBuildingStoreySpaceProperty addIfcBuildingStoreySpaceProperty(IfcBuildingStoreySpaceProperty ifcBuildingStoreySpaceProperty) {
		getIfcBuildingStoreySpaceProperties().add(ifcBuildingStoreySpaceProperty);
		ifcBuildingStoreySpaceProperty.setIfcBuildingStoreySpace(this);

		return ifcBuildingStoreySpaceProperty;
	}

	public IfcBuildingStoreySpaceProperty removeIfcBuildingStoreySpaceProperty(IfcBuildingStoreySpaceProperty ifcBuildingStoreySpaceProperty) {
		getIfcBuildingStoreySpaceProperties().remove(ifcBuildingStoreySpaceProperty);
		ifcBuildingStoreySpaceProperty.setIfcBuildingStoreySpace(null);

		return ifcBuildingStoreySpaceProperty;
	}

}