package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_storey_window_style database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_window_style")
@NamedQuery(name="IfcBuildingStoreyWindowStyle.findAll", query="SELECT i FROM IfcBuildingStoreyWindowStyle i")
public class IfcBuildingStoreyWindowStyle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp created;

	private short status;

	//bi-directional many-to-one association to IfcWindowstyle
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="style_id")
	private IfcWindowstyle ifcWindowstyle;

	//bi-directional many-to-one association to IfcBuildingStoreyWindow
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="window_id")
	private IfcBuildingStoreyWindow ifcBuildingStoreyWindow;

	public IfcBuildingStoreyWindowStyle() {
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

	public IfcWindowstyle getIfcWindowstyle() {
		return this.ifcWindowstyle;
	}

	public void setIfcWindowstyle(IfcWindowstyle ifcWindowstyle) {
		this.ifcWindowstyle = ifcWindowstyle;
	}

	public IfcBuildingStoreyWindow getIfcBuildingStoreyWindow() {
		return this.ifcBuildingStoreyWindow;
	}

	public void setIfcBuildingStoreyWindow(IfcBuildingStoreyWindow ifcBuildingStoreyWindow) {
		this.ifcBuildingStoreyWindow = ifcBuildingStoreyWindow;
	}

}