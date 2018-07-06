package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_storey_slab_opening_presentationlayer database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_slab_opening_presentationlayer")
@NamedQuery(name="IfcBuildingStoreySlabOpeningPresentationlayer.findAll", query="SELECT i FROM IfcBuildingStoreySlabOpeningPresentationlayer i")
public class IfcBuildingStoreySlabOpeningPresentationlayer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp created;

	@Column(name="presentationlayer_id")
	private String presentationlayerId;

	private short status;

	//bi-directional many-to-one association to IfcBuildingStoreySlabOpening
	@ManyToOne
	@JoinColumn(name="opening_id")
	private IfcBuildingStoreySlabOpening ifcBuildingStoreySlabOpening;

	public IfcBuildingStoreySlabOpeningPresentationlayer() {
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

	public IfcBuildingStoreySlabOpening getIfcBuildingStoreySlabOpening() {
		return this.ifcBuildingStoreySlabOpening;
	}

	public void setIfcBuildingStoreySlabOpening(IfcBuildingStoreySlabOpening ifcBuildingStoreySlabOpening) {
		this.ifcBuildingStoreySlabOpening = ifcBuildingStoreySlabOpening;
	}

}