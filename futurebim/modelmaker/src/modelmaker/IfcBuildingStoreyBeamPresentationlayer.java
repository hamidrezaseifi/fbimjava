package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_storey_beam_presentationlayers database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_beam_presentationlayers")
@NamedQuery(name="IfcBuildingStoreyBeamPresentationlayer.findAll", query="SELECT i FROM IfcBuildingStoreyBeamPresentationlayer i")
public class IfcBuildingStoreyBeamPresentationlayer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp created;

	private short status;

	//bi-directional many-to-one association to IfcBuildingStoreyBeam
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="beam_id")
	private IfcBuildingStoreyBeam ifcBuildingStoreyBeam;

	//bi-directional many-to-one association to IfcPresentationlayer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="presentationlayer_id")
	private IfcPresentationlayer ifcPresentationlayer;

	public IfcBuildingStoreyBeamPresentationlayer() {
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

	public IfcBuildingStoreyBeam getIfcBuildingStoreyBeam() {
		return this.ifcBuildingStoreyBeam;
	}

	public void setIfcBuildingStoreyBeam(IfcBuildingStoreyBeam ifcBuildingStoreyBeam) {
		this.ifcBuildingStoreyBeam = ifcBuildingStoreyBeam;
	}

	public IfcPresentationlayer getIfcPresentationlayer() {
		return this.ifcPresentationlayer;
	}

	public void setIfcPresentationlayer(IfcPresentationlayer ifcPresentationlayer) {
		this.ifcPresentationlayer = ifcPresentationlayer;
	}

}