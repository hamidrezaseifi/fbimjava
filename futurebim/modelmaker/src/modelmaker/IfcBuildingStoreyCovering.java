package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_covering database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_covering")
@NamedQuery(name="IfcBuildingStoreyCovering.findAll", query="SELECT i FROM IfcBuildingStoreyCovering i")
public class IfcBuildingStoreyCovering implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="covering_name")
	private String coveringName;

	private Timestamp created;

	@Column(name="object_placement")
	private String objectPlacement;

	@Column(name="object_type")
	private String objectType;

	@Column(name="predefined_type")
	private String predefinedType;

	private short status;

	private String tag;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuildingStorey
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="stair_id")
	private IfcBuildingStorey ifcBuildingStorey;

	//bi-directional many-to-one association to IfcBuildingStoreyCoveringPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreyCovering")
	private List<IfcBuildingStoreyCoveringPresentationlayer> ifcBuildingStoreyCoveringPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreyCoveringProperty
	@OneToMany(mappedBy="ifcBuildingStoreyCovering")
	private List<IfcBuildingStoreyCoveringProperty> ifcBuildingStoreyCoveringProperties;

	public IfcBuildingStoreyCovering() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCoveringName() {
		return this.coveringName;
	}

	public void setCoveringName(String coveringName) {
		this.coveringName = coveringName;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getObjectPlacement() {
		return this.objectPlacement;
	}

	public void setObjectPlacement(String objectPlacement) {
		this.objectPlacement = objectPlacement;
	}

	public String getObjectType() {
		return this.objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getPredefinedType() {
		return this.predefinedType;
	}

	public void setPredefinedType(String predefinedType) {
		this.predefinedType = predefinedType;
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

	public IfcBuildingStorey getIfcBuildingStorey() {
		return this.ifcBuildingStorey;
	}

	public void setIfcBuildingStorey(IfcBuildingStorey ifcBuildingStorey) {
		this.ifcBuildingStorey = ifcBuildingStorey;
	}

	public List<IfcBuildingStoreyCoveringPresentationlayer> getIfcBuildingStoreyCoveringPresentationlayers() {
		return this.ifcBuildingStoreyCoveringPresentationlayers;
	}

	public void setIfcBuildingStoreyCoveringPresentationlayers(List<IfcBuildingStoreyCoveringPresentationlayer> ifcBuildingStoreyCoveringPresentationlayers) {
		this.ifcBuildingStoreyCoveringPresentationlayers = ifcBuildingStoreyCoveringPresentationlayers;
	}

	public IfcBuildingStoreyCoveringPresentationlayer addIfcBuildingStoreyCoveringPresentationlayer(IfcBuildingStoreyCoveringPresentationlayer ifcBuildingStoreyCoveringPresentationlayer) {
		getIfcBuildingStoreyCoveringPresentationlayers().add(ifcBuildingStoreyCoveringPresentationlayer);
		ifcBuildingStoreyCoveringPresentationlayer.setIfcBuildingStoreyCovering(this);

		return ifcBuildingStoreyCoveringPresentationlayer;
	}

	public IfcBuildingStoreyCoveringPresentationlayer removeIfcBuildingStoreyCoveringPresentationlayer(IfcBuildingStoreyCoveringPresentationlayer ifcBuildingStoreyCoveringPresentationlayer) {
		getIfcBuildingStoreyCoveringPresentationlayers().remove(ifcBuildingStoreyCoveringPresentationlayer);
		ifcBuildingStoreyCoveringPresentationlayer.setIfcBuildingStoreyCovering(null);

		return ifcBuildingStoreyCoveringPresentationlayer;
	}

	public List<IfcBuildingStoreyCoveringProperty> getIfcBuildingStoreyCoveringProperties() {
		return this.ifcBuildingStoreyCoveringProperties;
	}

	public void setIfcBuildingStoreyCoveringProperties(List<IfcBuildingStoreyCoveringProperty> ifcBuildingStoreyCoveringProperties) {
		this.ifcBuildingStoreyCoveringProperties = ifcBuildingStoreyCoveringProperties;
	}

	public IfcBuildingStoreyCoveringProperty addIfcBuildingStoreyCoveringProperty(IfcBuildingStoreyCoveringProperty ifcBuildingStoreyCoveringProperty) {
		getIfcBuildingStoreyCoveringProperties().add(ifcBuildingStoreyCoveringProperty);
		ifcBuildingStoreyCoveringProperty.setIfcBuildingStoreyCovering(this);

		return ifcBuildingStoreyCoveringProperty;
	}

	public IfcBuildingStoreyCoveringProperty removeIfcBuildingStoreyCoveringProperty(IfcBuildingStoreyCoveringProperty ifcBuildingStoreyCoveringProperty) {
		getIfcBuildingStoreyCoveringProperties().remove(ifcBuildingStoreyCoveringProperty);
		ifcBuildingStoreyCoveringProperty.setIfcBuildingStoreyCovering(null);

		return ifcBuildingStoreyCoveringProperty;
	}

}