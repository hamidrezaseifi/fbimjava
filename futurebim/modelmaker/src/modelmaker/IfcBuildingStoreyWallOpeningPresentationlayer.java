package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_storey_wall_opening_presentationlayer database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_wall_opening_presentationlayer")
@NamedQuery(name="IfcBuildingStoreyWallOpeningPresentationlayer.findAll", query="SELECT i FROM IfcBuildingStoreyWallOpeningPresentationlayer i")
public class IfcBuildingStoreyWallOpeningPresentationlayer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	private short status;

	//bi-directional many-to-one association to IfcBuildingStoreyWallOpening
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="opening_id")
	private IfcBuildingStoreyWallOpening ifcBuildingStoreyWallOpening;

	//bi-directional many-to-one association to IfcPresentationlayer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="presentationlayer_id")
	private IfcPresentationlayer ifcPresentationlayer;

	public IfcBuildingStoreyWallOpeningPresentationlayer() {
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

	public IfcBuildingStoreyWallOpening getIfcBuildingStoreyWallOpening() {
		return this.ifcBuildingStoreyWallOpening;
	}

	public void setIfcBuildingStoreyWallOpening(IfcBuildingStoreyWallOpening ifcBuildingStoreyWallOpening) {
		this.ifcBuildingStoreyWallOpening = ifcBuildingStoreyWallOpening;
	}

	public IfcPresentationlayer getIfcPresentationlayer() {
		return this.ifcPresentationlayer;
	}

	public void setIfcPresentationlayer(IfcPresentationlayer ifcPresentationlayer) {
		this.ifcPresentationlayer = ifcPresentationlayer;
	}

}