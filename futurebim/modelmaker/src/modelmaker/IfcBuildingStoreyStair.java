package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_stair database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_stair")
@NamedQuery(name="IfcBuildingStoreyStair.findAll", query="SELECT i FROM IfcBuildingStoreyStair i")
public class IfcBuildingStoreyStair implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	@Column(name="object_placement")
	private String objectPlacement;

	@Column(name="object_type")
	private String objectType;

	@Column(name="shape_type")
	private String shapeType;

	@Column(name="stair_name")
	private String stairName;

	private short status;

	private String tag;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuildingStorey
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="storey_id")
	private IfcBuildingStorey ifcBuildingStorey;

	//bi-directional many-to-one association to IfcBuildingStoreyStairProperty
	@OneToMany(mappedBy="ifcBuildingStoreyStair")
	private List<IfcBuildingStoreyStairProperty> ifcBuildingStoreyStairProperties;

	public IfcBuildingStoreyStair() {
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

	public String getShapeType() {
		return this.shapeType;
	}

	public void setShapeType(String shapeType) {
		this.shapeType = shapeType;
	}

	public String getStairName() {
		return this.stairName;
	}

	public void setStairName(String stairName) {
		this.stairName = stairName;
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

	public List<IfcBuildingStoreyStairProperty> getIfcBuildingStoreyStairProperties() {
		return this.ifcBuildingStoreyStairProperties;
	}

	public void setIfcBuildingStoreyStairProperties(List<IfcBuildingStoreyStairProperty> ifcBuildingStoreyStairProperties) {
		this.ifcBuildingStoreyStairProperties = ifcBuildingStoreyStairProperties;
	}

	public IfcBuildingStoreyStairProperty addIfcBuildingStoreyStairProperty(IfcBuildingStoreyStairProperty ifcBuildingStoreyStairProperty) {
		getIfcBuildingStoreyStairProperties().add(ifcBuildingStoreyStairProperty);
		ifcBuildingStoreyStairProperty.setIfcBuildingStoreyStair(this);

		return ifcBuildingStoreyStairProperty;
	}

	public IfcBuildingStoreyStairProperty removeIfcBuildingStoreyStairProperty(IfcBuildingStoreyStairProperty ifcBuildingStoreyStairProperty) {
		getIfcBuildingStoreyStairProperties().remove(ifcBuildingStoreyStairProperty);
		ifcBuildingStoreyStairProperty.setIfcBuildingStoreyStair(null);

		return ifcBuildingStoreyStairProperty;
	}

}