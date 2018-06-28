package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_storey_stair_flight_presentationlayers database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_stair_flight_presentationlayers")
@NamedQuery(name="IfcBuildingStoreyStairFlightPresentationlayer.findAll", query="SELECT i FROM IfcBuildingStoreyStairFlightPresentationlayer i")
public class IfcBuildingStoreyStairFlightPresentationlayer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp created;

	private short status;

	//bi-directional many-to-one association to IfcBuildingStoreyStairFlight
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="flight_id")
	private IfcBuildingStoreyStairFlight ifcBuildingStoreyStairFlight;

	//bi-directional many-to-one association to IfcPresentationlayer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="presentationlayer_id")
	private IfcPresentationlayer ifcPresentationlayer;

	public IfcBuildingStoreyStairFlightPresentationlayer() {
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

	public IfcBuildingStoreyStairFlight getIfcBuildingStoreyStairFlight() {
		return this.ifcBuildingStoreyStairFlight;
	}

	public void setIfcBuildingStoreyStairFlight(IfcBuildingStoreyStairFlight ifcBuildingStoreyStairFlight) {
		this.ifcBuildingStoreyStairFlight = ifcBuildingStoreyStairFlight;
	}

	public IfcPresentationlayer getIfcPresentationlayer() {
		return this.ifcPresentationlayer;
	}

	public void setIfcPresentationlayer(IfcPresentationlayer ifcPresentationlayer) {
		this.ifcPresentationlayer = ifcPresentationlayer;
	}

}