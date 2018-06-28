package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_furnituretypes database table.
 * 
 */
@Entity
@Table(name="ifc_furnituretypes")
@NamedQuery(name="IfcFurnituretype.findAll", query="SELECT i FROM IfcFurnituretype i")
public class IfcFurnituretype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="assembly_place")
	private String assemblyPlace;

	private Timestamp created;

	@Column(name="element_type")
	private String elementType;

	private short status;

	private String tag;

	@Column(name="type_name")
	private String typeName;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelementFurnituretype
	@OneToMany(mappedBy="ifcFurnituretype")
	private List<IfcBuildingStoreySpaceFurnishingelementFurnituretype> ifcBuildingStoreySpaceFurnishingelementFurnituretypes;

	//bi-directional many-to-one association to ProjectIfc
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ifc_id")
	private ProjectIfc projectIfc;

	public IfcFurnituretype() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAssemblyPlace() {
		return this.assemblyPlace;
	}

	public void setAssemblyPlace(String assemblyPlace) {
		this.assemblyPlace = assemblyPlace;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getElementType() {
		return this.elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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

	public List<IfcBuildingStoreySpaceFurnishingelementFurnituretype> getIfcBuildingStoreySpaceFurnishingelementFurnituretypes() {
		return this.ifcBuildingStoreySpaceFurnishingelementFurnituretypes;
	}

	public void setIfcBuildingStoreySpaceFurnishingelementFurnituretypes(List<IfcBuildingStoreySpaceFurnishingelementFurnituretype> ifcBuildingStoreySpaceFurnishingelementFurnituretypes) {
		this.ifcBuildingStoreySpaceFurnishingelementFurnituretypes = ifcBuildingStoreySpaceFurnishingelementFurnituretypes;
	}

	public IfcBuildingStoreySpaceFurnishingelementFurnituretype addIfcBuildingStoreySpaceFurnishingelementFurnituretype(IfcBuildingStoreySpaceFurnishingelementFurnituretype ifcBuildingStoreySpaceFurnishingelementFurnituretype) {
		getIfcBuildingStoreySpaceFurnishingelementFurnituretypes().add(ifcBuildingStoreySpaceFurnishingelementFurnituretype);
		ifcBuildingStoreySpaceFurnishingelementFurnituretype.setIfcFurnituretype(this);

		return ifcBuildingStoreySpaceFurnishingelementFurnituretype;
	}

	public IfcBuildingStoreySpaceFurnishingelementFurnituretype removeIfcBuildingStoreySpaceFurnishingelementFurnituretype(IfcBuildingStoreySpaceFurnishingelementFurnituretype ifcBuildingStoreySpaceFurnishingelementFurnituretype) {
		getIfcBuildingStoreySpaceFurnishingelementFurnituretypes().remove(ifcBuildingStoreySpaceFurnishingelementFurnituretype);
		ifcBuildingStoreySpaceFurnishingelementFurnituretype.setIfcFurnituretype(null);

		return ifcBuildingStoreySpaceFurnishingelementFurnituretype;
	}

	public ProjectIfc getProjectIfc() {
		return this.projectIfc;
	}

	public void setProjectIfc(ProjectIfc projectIfc) {
		this.projectIfc = projectIfc;
	}

}