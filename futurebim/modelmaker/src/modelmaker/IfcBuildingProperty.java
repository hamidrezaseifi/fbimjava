package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_properties database table.
 * 
 */
@Entity
@Table(name="ifc_building_properties")
@NamedQuery(name="IfcBuildingProperty.findAll", query="SELECT i FROM IfcBuildingProperty i")
public class IfcBuildingProperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp created;

	private short status;

	//bi-directional many-to-one association to IfcBuilding
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="building_id")
	private IfcBuilding ifcBuilding;

	//bi-directional many-to-one association to IfcProperty
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="property_id")
	private IfcProperty ifcProperty;

	public IfcBuildingProperty() {
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

	public IfcBuilding getIfcBuilding() {
		return this.ifcBuilding;
	}

	public void setIfcBuilding(IfcBuilding ifcBuilding) {
		this.ifcBuilding = ifcBuilding;
	}

	public IfcProperty getIfcProperty() {
		return this.ifcProperty;
	}

	public void setIfcProperty(IfcProperty ifcProperty) {
		this.ifcProperty = ifcProperty;
	}

}