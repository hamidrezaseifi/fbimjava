package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_storey_space_felement_opening_presentationlayer database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_space_felement_opening_presentationlayer")
@NamedQuery(name="IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer.findAll", query="SELECT i FROM IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer i")
public class IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	@Column(name="presentationlayer_id")
	private String presentationlayerId;

	private short status;

	//bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelementOpening
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="opening_id")
	private IfcBuildingStoreySpaceFurnishingelementOpening ifcBuildingStoreySpaceFurnishingelementOpening;

	public IfcBuildingStoreySpaceFurnishingelementOpeningPresentationlayer() {
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

	public IfcBuildingStoreySpaceFurnishingelementOpening getIfcBuildingStoreySpaceFurnishingelementOpening() {
		return this.ifcBuildingStoreySpaceFurnishingelementOpening;
	}

	public void setIfcBuildingStoreySpaceFurnishingelementOpening(IfcBuildingStoreySpaceFurnishingelementOpening ifcBuildingStoreySpaceFurnishingelementOpening) {
		this.ifcBuildingStoreySpaceFurnishingelementOpening = ifcBuildingStoreySpaceFurnishingelementOpening;
	}

}