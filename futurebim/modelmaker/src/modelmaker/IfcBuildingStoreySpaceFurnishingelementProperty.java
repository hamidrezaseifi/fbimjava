package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_storey_space_furnishingelement_properties database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_space_furnishingelement_properties")
@NamedQuery(name="IfcBuildingStoreySpaceFurnishingelementProperty.findAll", query="SELECT i FROM IfcBuildingStoreySpaceFurnishingelementProperty i")
public class IfcBuildingStoreySpaceFurnishingelementProperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp created;

	@Column(name="property_id")
	private String propertyId;

	private short status;

	//bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelement
	@ManyToOne
	@JoinColumn(name="felement_id")
	private IfcBuildingStoreySpaceFurnishingelement ifcBuildingStoreySpaceFurnishingelement;

	public IfcBuildingStoreySpaceFurnishingelementProperty() {
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

	public IfcBuildingStoreySpaceFurnishingelement getIfcBuildingStoreySpaceFurnishingelement() {
		return this.ifcBuildingStoreySpaceFurnishingelement;
	}

	public void setIfcBuildingStoreySpaceFurnishingelement(IfcBuildingStoreySpaceFurnishingelement ifcBuildingStoreySpaceFurnishingelement) {
		this.ifcBuildingStoreySpaceFurnishingelement = ifcBuildingStoreySpaceFurnishingelement;
	}

}