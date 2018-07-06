package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_storey_wallstandardcase_presentationlayer database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_wallstandardcase_presentationlayer")
@NamedQuery(name="IfcBuildingStoreyWallstandardcasePresentationlayer.findAll", query="SELECT i FROM IfcBuildingStoreyWallstandardcasePresentationlayer i")
public class IfcBuildingStoreyWallstandardcasePresentationlayer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp created;

	@Column(name="presentationlayer_id")
	private String presentationlayerId;

	private short status;

	//bi-directional many-to-one association to IfcBuildingStoreyWallstandardcase
	@ManyToOne
	@JoinColumn(name="wall_id")
	private IfcBuildingStoreyWallstandardcase ifcBuildingStoreyWallstandardcase;

	public IfcBuildingStoreyWallstandardcasePresentationlayer() {
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

	public String getPresentationlayerId() {
		return this.presentationlayerId;
	}

	public void setPresentationlayerId(String presentationlayerId) {
		this.presentationlayerId = presentationlayerId;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public IfcBuildingStoreyWallstandardcase getIfcBuildingStoreyWallstandardcase() {
		return this.ifcBuildingStoreyWallstandardcase;
	}

	public void setIfcBuildingStoreyWallstandardcase(IfcBuildingStoreyWallstandardcase ifcBuildingStoreyWallstandardcase) {
		this.ifcBuildingStoreyWallstandardcase = ifcBuildingStoreyWallstandardcase;
	}

}