package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_storey_slab_presentationlayer database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_slab_presentationlayer")
@NamedQuery(name="IfcBuildingStoreySlabPresentationlayer.findAll", query="SELECT i FROM IfcBuildingStoreySlabPresentationlayer i")
public class IfcBuildingStoreySlabPresentationlayer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	private short status;

	//bi-directional many-to-one association to IfcBuildingStoreySlab
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="slab_id")
	private IfcBuildingStoreySlab ifcBuildingStoreySlab;

	//bi-directional many-to-one association to IfcPresentationlayer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="presentationlayer_id")
	private IfcPresentationlayer ifcPresentationlayer;

	public IfcBuildingStoreySlabPresentationlayer() {
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

	public IfcBuildingStoreySlab getIfcBuildingStoreySlab() {
		return this.ifcBuildingStoreySlab;
	}

	public void setIfcBuildingStoreySlab(IfcBuildingStoreySlab ifcBuildingStoreySlab) {
		this.ifcBuildingStoreySlab = ifcBuildingStoreySlab;
	}

	public IfcPresentationlayer getIfcPresentationlayer() {
		return this.ifcPresentationlayer;
	}

	public void setIfcPresentationlayer(IfcPresentationlayer ifcPresentationlayer) {
		this.ifcPresentationlayer = ifcPresentationlayer;
	}

}