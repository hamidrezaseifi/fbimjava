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

	@Column(name="furnituretype_id")
	private String furnituretypeId;

	private short status;

	//bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelement
	@ManyToOne
	@JoinColumn(name="felement_id")
	private IfcBuildingStoreySpaceFurnishingelement ifcBuildingStoreySpaceFurnishingelement;

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

	public String getFurnituretypeId() {
		return this.furnituretypeId;
	}

	public void setFurnituretypeId(String furnituretypeId) {
		this.furnituretypeId = furnituretypeId;
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