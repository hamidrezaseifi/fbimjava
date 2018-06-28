package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_storey_window_presentationlayer database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_window_presentationlayer")
@NamedQuery(name="IfcBuildingStoreyWindowPresentationlayer.findAll", query="SELECT i FROM IfcBuildingStoreyWindowPresentationlayer i")
public class IfcBuildingStoreyWindowPresentationlayer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	private short status;

	//bi-directional many-to-one association to IfcPresentationlayer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="presentationlayer_id")
	private IfcPresentationlayer ifcPresentationlayer;

	//bi-directional many-to-one association to IfcBuildingStoreyWindow
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="window_id")
	private IfcBuildingStoreyWindow ifcBuildingStoreyWindow;

	public IfcBuildingStoreyWindowPresentationlayer() {
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

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public IfcPresentationlayer getIfcPresentationlayer() {
		return this.ifcPresentationlayer;
	}

	public void setIfcPresentationlayer(IfcPresentationlayer ifcPresentationlayer) {
		this.ifcPresentationlayer = ifcPresentationlayer;
	}

	public IfcBuildingStoreyWindow getIfcBuildingStoreyWindow() {
		return this.ifcBuildingStoreyWindow;
	}

	public void setIfcBuildingStoreyWindow(IfcBuildingStoreyWindow ifcBuildingStoreyWindow) {
		this.ifcBuildingStoreyWindow = ifcBuildingStoreyWindow;
	}

}