package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_storey_footing_properties database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_footing_properties")
@NamedQuery(name="IfcBuildingStoreyFootingProperty.findAll", query="SELECT i FROM IfcBuildingStoreyFootingProperty i")
public class IfcBuildingStoreyFootingProperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp created;

	@Column(name="property_id")
	private String propertyId;

	private short status;

	//bi-directional many-to-one association to IfcBuildingStoreyFooting
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="footing_id")
	private IfcBuildingStoreyFooting ifcBuildingStoreyFooting;

	public IfcBuildingStoreyFootingProperty() {
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

	public String getPropertyId() {
		return this.propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public IfcBuildingStoreyFooting getIfcBuildingStoreyFooting() {
		return this.ifcBuildingStoreyFooting;
	}

	public void setIfcBuildingStoreyFooting(IfcBuildingStoreyFooting ifcBuildingStoreyFooting) {
		this.ifcBuildingStoreyFooting = ifcBuildingStoreyFooting;
	}

}