package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_doorstyle database table.
 * 
 */
@Entity
@Table(name="ifc_doorstyle")
@NamedQuery(name="IfcDoorstyle.findAll", query="SELECT i FROM IfcDoorstyle i")
public class IfcDoorstyle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="construction_type")
	private String constructionType;

	private Timestamp created;

	@Column(name="operation_type")
	private String operationType;

	@Column(name="parameter_takes_precedence")
	private String parameterTakesPrecedence;

	private String sizeable;

	private short status;

	private String tag;

	@Column(name="type_name")
	private String typeName;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuildingStoreyDoorStyle
	@OneToMany(mappedBy="ifcDoorstyle")
	private List<IfcBuildingStoreyDoorStyle> ifcBuildingStoreyDoorStyles;

	//bi-directional many-to-one association to ProjectIfc
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ifc_id")
	private ProjectIfc projectIfc;

	public IfcDoorstyle() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConstructionType() {
		return this.constructionType;
	}

	public void setConstructionType(String constructionType) {
		this.constructionType = constructionType;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getOperationType() {
		return this.operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getParameterTakesPrecedence() {
		return this.parameterTakesPrecedence;
	}

	public void setParameterTakesPrecedence(String parameterTakesPrecedence) {
		this.parameterTakesPrecedence = parameterTakesPrecedence;
	}

	public String getSizeable() {
		return this.sizeable;
	}

	public void setSizeable(String sizeable) {
		this.sizeable = sizeable;
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

	public List<IfcBuildingStoreyDoorStyle> getIfcBuildingStoreyDoorStyles() {
		return this.ifcBuildingStoreyDoorStyles;
	}

	public void setIfcBuildingStoreyDoorStyles(List<IfcBuildingStoreyDoorStyle> ifcBuildingStoreyDoorStyles) {
		this.ifcBuildingStoreyDoorStyles = ifcBuildingStoreyDoorStyles;
	}

	public IfcBuildingStoreyDoorStyle addIfcBuildingStoreyDoorStyle(IfcBuildingStoreyDoorStyle ifcBuildingStoreyDoorStyle) {
		getIfcBuildingStoreyDoorStyles().add(ifcBuildingStoreyDoorStyle);
		ifcBuildingStoreyDoorStyle.setIfcDoorstyle(this);

		return ifcBuildingStoreyDoorStyle;
	}

	public IfcBuildingStoreyDoorStyle removeIfcBuildingStoreyDoorStyle(IfcBuildingStoreyDoorStyle ifcBuildingStoreyDoorStyle) {
		getIfcBuildingStoreyDoorStyles().remove(ifcBuildingStoreyDoorStyle);
		ifcBuildingStoreyDoorStyle.setIfcDoorstyle(null);

		return ifcBuildingStoreyDoorStyle;
	}

	public ProjectIfc getProjectIfc() {
		return this.projectIfc;
	}

	public void setProjectIfc(ProjectIfc projectIfc) {
		this.projectIfc = projectIfc;
	}

}