package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_storey_space_presentationlayers database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_space_presentationlayers")
@NamedQuery(name="IfcBuildingStoreySpacePresentationlayer.findAll", query="SELECT i FROM IfcBuildingStoreySpacePresentationlayer i")
public class IfcBuildingStoreySpacePresentationlayer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp created;

	private short status;

	//bi-directional many-to-one association to IfcPresentationlayer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="presentationlayer_id")
	private IfcPresentationlayer ifcPresentationlayer;

	//bi-directional many-to-one association to IfcBuildingStoreySpace
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="space_id")
	private IfcBuildingStoreySpace ifcBuildingStoreySpace;

	public IfcBuildingStoreySpacePresentationlayer() {
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

	public IfcPresentationlayer getIfcPresentationlayer() {
		return this.ifcPresentationlayer;
	}

	public void setIfcPresentationlayer(IfcPresentationlayer ifcPresentationlayer) {
		this.ifcPresentationlayer = ifcPresentationlayer;
	}

	public IfcBuildingStoreySpace getIfcBuildingStoreySpace() {
		return this.ifcBuildingStoreySpace;
	}

	public void setIfcBuildingStoreySpace(IfcBuildingStoreySpace ifcBuildingStoreySpace) {
		this.ifcBuildingStoreySpace = ifcBuildingStoreySpace;
	}

}