package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_storey_window_properties database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_window_properties")
@NamedQuery(name="IfcBuildingStoreyWindowProperty.findAll", query="SELECT i FROM IfcBuildingStoreyWindowProperty i")
public class IfcBuildingStoreyWindowProperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp created;

	private short status;

	//bi-directional many-to-one association to IfcBuildingStoreyWindow
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="window_id")
	private IfcBuildingStoreyWindow ifcBuildingStoreyWindow;

	//bi-directional many-to-one association to IfcProperty
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="property_id")
	private IfcProperty ifcProperty;

	public IfcBuildingStoreyWindowProperty() {
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

	public IfcBuildingStoreyWindow getIfcBuildingStoreyWindow() {
		return this.ifcBuildingStoreyWindow;
	}

	public void setIfcBuildingStoreyWindow(IfcBuildingStoreyWindow ifcBuildingStoreyWindow) {
		this.ifcBuildingStoreyWindow = ifcBuildingStoreyWindow;
	}

	public IfcProperty getIfcProperty() {
		return this.ifcProperty;
	}

	public void setIfcProperty(IfcProperty ifcProperty) {
		this.ifcProperty = ifcProperty;
	}

}