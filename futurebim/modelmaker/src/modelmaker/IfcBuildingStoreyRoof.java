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

	@Column(name="storey_id")
	private String storeyId;

	private String tag;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuildingStoreyRoofOpening
	@OneToMany(mappedBy="ifcBuildingStoreyRoof")
	private List<IfcBuildingStoreyRoofOpening> ifcBuildingStoreyRoofOpenings;

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

	public String getStoreyId() {
		return this.storeyId;
	}

	public void setStoreyId(String storeyId) {
		this.storeyId = storeyId;
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

	public List<IfcBuildingStoreyRoofOpening> getIfcBuildingStoreyRoofOpenings() {
		return this.ifcBuildingStoreyRoofOpenings;
	}

	public void setIfcBuildingStoreyRoofOpenings(List<IfcBuildingStoreyRoofOpening> ifcBuildingStoreyRoofOpenings) {
		this.ifcBuildingStoreyRoofOpenings = ifcBuildingStoreyRoofOpenings;
	}

	public IfcBuildingStoreyRoofOpening addIfcBuildingStoreyRoofOpening(IfcBuildingStoreyRoofOpening ifcBuildingStoreyRoofOpening) {
		getIfcBuildingStoreyRoofOpenings().add(ifcBuildingStoreyRoofOpening);
		ifcBuildingStoreyRoofOpening.setIfcBuildingStoreyRoof(this);

		return ifcBuildingStoreyRoofOpening;
	}

	public IfcBuildingStoreyRoofOpening removeIfcBuildingStoreyRoofOpening(IfcBuildingStoreyRoofOpening ifcBuildingStoreyRoofOpening) {
		getIfcBuildingStoreyRoofOpenings().remove(ifcBuildingStoreyRoofOpening);
		ifcBuildingStoreyRoofOpening.setIfcBuildingStoreyRoof(null);

		return ifcBuildingStoreyRoofOpening;
	}

}