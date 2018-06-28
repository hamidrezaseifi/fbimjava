package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_door database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_door")
@NamedQuery(name="IfcBuildingStoreyDoor.findAll", query="SELECT i FROM IfcBuildingStoreyDoor i")
public class IfcBuildingStoreyDoor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	@Column(name="door_name")
	private String doorName;

	@Column(name="object_placement")
	private String objectPlacement;

	@Column(name="object_type")
	private String objectType;

	@Column(name="overall_height")
	private String overallHeight;

	@Column(name="overall_width")
	private String overallWidth;

	private short status;

	private String tag;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuildingStorey
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="storey_id")
	private IfcBuildingStorey ifcBuildingStorey;

	//bi-directional many-to-one association to IfcBuildingStoreyDoorPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreyDoor")
	private List<IfcBuildingStoreyDoorPresentationlayer> ifcBuildingStoreyDoorPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreyDoorProperty
	@OneToMany(mappedBy="ifcBuildingStoreyDoor")
	private List<IfcBuildingStoreyDoorProperty> ifcBuildingStoreyDoorProperties;

	//bi-directional many-to-one association to IfcBuildingStoreyDoorStyle
	@OneToMany(mappedBy="ifcBuildingStoreyDoor")
	private List<IfcBuildingStoreyDoorStyle> ifcBuildingStoreyDoorStyles;

	public IfcBuildingStoreyDoor() {
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

	public String getDoorName() {
		return this.doorName;
	}

	public void setDoorName(String doorName) {
		this.doorName = doorName;
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

	public String getOverallHeight() {
		return this.overallHeight;
	}

	public void setOverallHeight(String overallHeight) {
		this.overallHeight = overallHeight;
	}

	public String getOverallWidth() {
		return this.overallWidth;
	}

	public void setOverallWidth(String overallWidth) {
		this.overallWidth = overallWidth;
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

	public List<IfcBuildingStoreyDoorPresentationlayer> getIfcBuildingStoreyDoorPresentationlayers() {
		return this.ifcBuildingStoreyDoorPresentationlayers;
	}

	public void setIfcBuildingStoreyDoorPresentationlayers(List<IfcBuildingStoreyDoorPresentationlayer> ifcBuildingStoreyDoorPresentationlayers) {
		this.ifcBuildingStoreyDoorPresentationlayers = ifcBuildingStoreyDoorPresentationlayers;
	}

	public IfcBuildingStoreyDoorPresentationlayer addIfcBuildingStoreyDoorPresentationlayer(IfcBuildingStoreyDoorPresentationlayer ifcBuildingStoreyDoorPresentationlayer) {
		getIfcBuildingStoreyDoorPresentationlayers().add(ifcBuildingStoreyDoorPresentationlayer);
		ifcBuildingStoreyDoorPresentationlayer.setIfcBuildingStoreyDoor(this);

		return ifcBuildingStoreyDoorPresentationlayer;
	}

	public IfcBuildingStoreyDoorPresentationlayer removeIfcBuildingStoreyDoorPresentationlayer(IfcBuildingStoreyDoorPresentationlayer ifcBuildingStoreyDoorPresentationlayer) {
		getIfcBuildingStoreyDoorPresentationlayers().remove(ifcBuildingStoreyDoorPresentationlayer);
		ifcBuildingStoreyDoorPresentationlayer.setIfcBuildingStoreyDoor(null);

		return ifcBuildingStoreyDoorPresentationlayer;
	}

	public List<IfcBuildingStoreyDoorProperty> getIfcBuildingStoreyDoorProperties() {
		return this.ifcBuildingStoreyDoorProperties;
	}

	public void setIfcBuildingStoreyDoorProperties(List<IfcBuildingStoreyDoorProperty> ifcBuildingStoreyDoorProperties) {
		this.ifcBuildingStoreyDoorProperties = ifcBuildingStoreyDoorProperties;
	}

	public IfcBuildingStoreyDoorProperty addIfcBuildingStoreyDoorProperty(IfcBuildingStoreyDoorProperty ifcBuildingStoreyDoorProperty) {
		getIfcBuildingStoreyDoorProperties().add(ifcBuildingStoreyDoorProperty);
		ifcBuildingStoreyDoorProperty.setIfcBuildingStoreyDoor(this);

		return ifcBuildingStoreyDoorProperty;
	}

	public IfcBuildingStoreyDoorProperty removeIfcBuildingStoreyDoorProperty(IfcBuildingStoreyDoorProperty ifcBuildingStoreyDoorProperty) {
		getIfcBuildingStoreyDoorProperties().remove(ifcBuildingStoreyDoorProperty);
		ifcBuildingStoreyDoorProperty.setIfcBuildingStoreyDoor(null);

		return ifcBuildingStoreyDoorProperty;
	}

	public List<IfcBuildingStoreyDoorStyle> getIfcBuildingStoreyDoorStyles() {
		return this.ifcBuildingStoreyDoorStyles;
	}

	public void setIfcBuildingStoreyDoorStyles(List<IfcBuildingStoreyDoorStyle> ifcBuildingStoreyDoorStyles) {
		this.ifcBuildingStoreyDoorStyles = ifcBuildingStoreyDoorStyles;
	}

	public IfcBuildingStoreyDoorStyle addIfcBuildingStoreyDoorStyle(IfcBuildingStoreyDoorStyle ifcBuildingStoreyDoorStyle) {
		getIfcBuildingStoreyDoorStyles().add(ifcBuildingStoreyDoorStyle);
		ifcBuildingStoreyDoorStyle.setIfcBuildingStoreyDoor(this);

		return ifcBuildingStoreyDoorStyle;
	}

	public IfcBuildingStoreyDoorStyle removeIfcBuildingStoreyDoorStyle(IfcBuildingStoreyDoorStyle ifcBuildingStoreyDoorStyle) {
		getIfcBuildingStoreyDoorStyles().remove(ifcBuildingStoreyDoorStyle);
		ifcBuildingStoreyDoorStyle.setIfcBuildingStoreyDoor(null);

		return ifcBuildingStoreyDoorStyle;
	}

}