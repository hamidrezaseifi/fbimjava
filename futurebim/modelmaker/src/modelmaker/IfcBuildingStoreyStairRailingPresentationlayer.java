package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_storey_stair_railing_presentationlayers database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_stair_railing_presentationlayers")
@NamedQuery(name="IfcBuildingStoreyStairRailingPresentationlayer.findAll", query="SELECT i FROM IfcBuildingStoreyStairRailingPresentationlayer i")
public class IfcBuildingStoreyStairRailingPresentationlayer implements Serializable {
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

	//bi-directional many-to-one association to IfcBuildingStoreyStairRailing
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="railing_id")
	private IfcBuildingStoreyStairRailing ifcBuildingStoreyStairRailing;

	public IfcBuildingStoreyStairRailingPresentationlayer() {
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

	public IfcBuildingStoreyStairRailing getIfcBuildingStoreyStairRailing() {
		return this.ifcBuildingStoreyStairRailing;
	}

	public void setIfcBuildingStoreyStairRailing(IfcBuildingStoreyStairRailing ifcBuildingStoreyStairRailing) {
		this.ifcBuildingStoreyStairRailing = ifcBuildingStoreyStairRailing;
	}

}