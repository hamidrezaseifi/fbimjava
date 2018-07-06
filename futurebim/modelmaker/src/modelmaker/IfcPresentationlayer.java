package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_presentationlayers database table.
 * 
 */
@Entity
@Table(name="ifc_presentationlayers")
@NamedQuery(name="IfcPresentationlayer.findAll", query="SELECT i FROM IfcPresentationlayer i")
public class IfcPresentationlayer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	@Column(name="layer_name")
	private String layerName;

	private short status;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuildingStoreySpacePresentationlayer
	@OneToMany(mappedBy="ifcPresentationlayer")
	private List<IfcBuildingStoreySpacePresentationlayer> ifcBuildingStoreySpacePresentationlayers;

	//bi-directional many-to-one association to ProjectIfc
	@ManyToOne
	@JoinColumn(name="ifc_id")
	private ProjectIfc projectIfc;

	public IfcPresentationlayer() {
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

	public String getLayerName() {
		return this.layerName;
	}

	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<IfcBuildingStoreySpacePresentationlayer> getIfcBuildingStoreySpacePresentationlayers() {
		return this.ifcBuildingStoreySpacePresentationlayers;
	}

	public void setIfcBuildingStoreySpacePresentationlayers(List<IfcBuildingStoreySpacePresentationlayer> ifcBuildingStoreySpacePresentationlayers) {
		this.ifcBuildingStoreySpacePresentationlayers = ifcBuildingStoreySpacePresentationlayers;
	}

	public IfcBuildingStoreySpacePresentationlayer addIfcBuildingStoreySpacePresentationlayer(IfcBuildingStoreySpacePresentationlayer ifcBuildingStoreySpacePresentationlayer) {
		getIfcBuildingStoreySpacePresentationlayers().add(ifcBuildingStoreySpacePresentationlayer);
		ifcBuildingStoreySpacePresentationlayer.setIfcPresentationlayer(this);

		return ifcBuildingStoreySpacePresentationlayer;
	}

	public IfcBuildingStoreySpacePresentationlayer removeIfcBuildingStoreySpacePresentationlayer(IfcBuildingStoreySpacePresentationlayer ifcBuildingStoreySpacePresentationlayer) {
		getIfcBuildingStoreySpacePresentationlayers().remove(ifcBuildingStoreySpacePresentationlayer);
		ifcBuildingStoreySpacePresentationlayer.setIfcPresentationlayer(null);

		return ifcBuildingStoreySpacePresentationlayer;
	}

	public ProjectIfc getProjectIfc() {
		return this.projectIfc;
	}

	public void setProjectIfc(ProjectIfc projectIfc) {
		this.projectIfc = projectIfc;
	}

}