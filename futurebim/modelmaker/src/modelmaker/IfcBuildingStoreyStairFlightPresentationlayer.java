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

	@Column(name="presentationlayer_id")
	private String presentationlayerId;

	private short status;

	//bi-directional many-to-one association to IfcBuildingStoreyStairFlight
	@ManyToOne
	@JoinColumn(name="flight_id")
	private IfcBuildingStoreyStairFlight ifcBuildingStoreyStairFlight;

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

	public IfcBuildingStoreyStairFlight getIfcBuildingStoreyStairFlight() {
		return this.ifcBuildingStoreyStairFlight;
	}

	public void setIfcBuildingStoreyStairFlight(IfcBuildingStoreyStairFlight ifcBuildingStoreyStairFlight) {
		this.ifcBuildingStoreyStairFlight = ifcBuildingStoreyStairFlight;
	}

}