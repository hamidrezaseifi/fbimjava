package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ifc_building_storey_space_furnishingelement_furnituretypes database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_space_furnishingelement_furnituretypes")
@NamedQuery(name="IfcBuildingStoreySpaceFurnishingelementFurnituretype.findAll", query="SELECT i FROM IfcBuildingStoreySpaceFurnishingelementFurnituretype i")
public class IfcBuildingStoreySpaceFurnishingelementFurnituretype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private Timestamp created;

	private short status;

	//bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelement
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="felement_id")
	private IfcBuildingStoreySpaceFurnishingelement ifcBuildingStoreySpaceFurnishingelement;

	//bi-directional many-to-one association to IfcFurnituretype
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="furnituretype_id")
	private IfcFurnituretype ifcFurnituretype;

	public IfcBuildingStoreySpaceFurnishingelementFurnituretype() {
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

	public IfcBuildingStoreySpaceFurnishingelement getIfcBuildingStoreySpaceFurnishingelement() {
		return this.ifcBuildingStoreySpaceFurnishingelement;
	}

	public void setIfcBuildingStoreySpaceFurnishingelement(IfcBuildingStoreySpaceFurnishingelement ifcBuildingStoreySpaceFurnishingelement) {
		this.ifcBuildingStoreySpaceFurnishingelement = ifcBuildingStoreySpaceFurnishingelement;
	}

	public IfcFurnituretype getIfcFurnituretype() {
		return this.ifcFurnituretype;
	}

	public void setIfcFurnituretype(IfcFurnituretype ifcFurnituretype) {
		this.ifcFurnituretype = ifcFurnituretype;
	}

}