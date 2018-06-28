package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_storey_door_properties database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_door_properties")
@NamedQuery(name="IfcBuildingStoreyDoorProperty.findAll", query="SELECT i FROM IfcBuildingStoreyDoorProperty i")
public class IfcBuildingStoreyDoorProperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp created;

	private short status;

	//bi-directional many-to-one association to IfcBuildingStoreyDoor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="door_id")
	private IfcBuildingStoreyDoor ifcBuildingStoreyDoor;

	//bi-directional many-to-one association to IfcProperty
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="property_id")
	private IfcProperty ifcProperty;

	public IfcBuildingStoreyDoorProperty() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public IfcBuildingStoreyDoor getIfcBuildingStoreyDoor() {
		return this.ifcBuildingStoreyDoor;
	}

	public void setIfcBuildingStoreyDoor(IfcBuildingStoreyDoor ifcBuildingStoreyDoor) {
		this.ifcBuildingStoreyDoor = ifcBuildingStoreyDoor;
	}

	public IfcProperty getIfcProperty() {
		return this.ifcProperty;
	}

	public void setIfcProperty(IfcProperty ifcProperty) {
		this.ifcProperty = ifcProperty;
	}

}