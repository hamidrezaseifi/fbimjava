package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_storey_door_style database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_door_style")
@NamedQuery(name="IfcBuildingStoreyDoorStyle.findAll", query="SELECT i FROM IfcBuildingStoreyDoorStyle i")
public class IfcBuildingStoreyDoorStyle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp created;

	private short status;

	@Column(name="style_id")
	private String styleId;

	//bi-directional many-to-one association to IfcBuildingStoreyDoor
	@ManyToOne
	@JoinColumn(name="door_id")
	private IfcBuildingStoreyDoor ifcBuildingStoreyDoor;

	public IfcBuildingStoreyDoorStyle() {
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

	public String getStyleId() {
		return this.styleId;
	}

	public void setStyleId(String styleId) {
		this.styleId = styleId;
	}

	public IfcBuildingStoreyDoor getIfcBuildingStoreyDoor() {
		return this.ifcBuildingStoreyDoor;
	}

	public void setIfcBuildingStoreyDoor(IfcBuildingStoreyDoor ifcBuildingStoreyDoor) {
		this.ifcBuildingStoreyDoor = ifcBuildingStoreyDoor;
	}

}