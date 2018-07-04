package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_storey_wall_opening_properties database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_wall_opening_properties")
@NamedQuery(name="IfcBuildingStoreyWallOpeningProperty.findAll", query="SELECT i FROM IfcBuildingStoreyWallOpeningProperty i")
public class IfcBuildingStoreyWallOpeningProperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	@Column(name="property_id")
	private String propertyId;

	private short status;

	//bi-directional many-to-one association to IfcBuildingStoreyWallOpening
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="opening_id")
	private IfcBuildingStoreyWallOpening ifcBuildingStoreyWallOpening;

	public IfcBuildingStoreyWallOpeningProperty() {
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

	public IfcBuildingStoreyWallOpening getIfcBuildingStoreyWallOpening() {
		return this.ifcBuildingStoreyWallOpening;
	}

	public void setIfcBuildingStoreyWallOpening(IfcBuildingStoreyWallOpening ifcBuildingStoreyWallOpening) {
		this.ifcBuildingStoreyWallOpening = ifcBuildingStoreyWallOpening;
	}

}