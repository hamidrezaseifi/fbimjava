package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_footing database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_footing")
@NamedQuery(name="IfcBuildingStoreyFooting.findAll", query="SELECT i FROM IfcBuildingStoreyFooting i")
public class IfcBuildingStoreyFooting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	@Column(name="footing_name")
	private String footingName;

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
	@ManyToOne
	@JoinColumn(name="storey_id")
	private IfcBuildingStorey ifcBuildingStorey;

	//bi-directional many-to-one association to IfcBuildingStoreyFootingPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreyFooting")
	private List<IfcBuildingStoreyFootingPresentationlayer> ifcBuildingStoreyFootingPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreyFootingProperty
	@OneToMany(mappedBy="ifcBuildingStoreyFooting")
	private List<IfcBuildingStoreyFootingProperty> ifcBuildingStoreyFootingProperties;

	public IfcBuildingStoreyFooting() {
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

	public String getFootingName() {
		return this.footingName;
	}

	public void setFootingName(String footingName) {
		this.footingName = footingName;
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

	public List<IfcBuildingStoreyFootingPresentationlayer> getIfcBuildingStoreyFootingPresentationlayers() {
		return this.ifcBuildingStoreyFootingPresentationlayers;
	}

	public void setIfcBuildingStoreyFootingPresentationlayers(List<IfcBuildingStoreyFootingPresentationlayer> ifcBuildingStoreyFootingPresentationlayers) {
		this.ifcBuildingStoreyFootingPresentationlayers = ifcBuildingStoreyFootingPresentationlayers;
	}

	public IfcBuildingStoreyFootingPresentationlayer addIfcBuildingStoreyFootingPresentationlayer(IfcBuildingStoreyFootingPresentationlayer ifcBuildingStoreyFootingPresentationlayer) {
		getIfcBuildingStoreyFootingPresentationlayers().add(ifcBuildingStoreyFootingPresentationlayer);
		ifcBuildingStoreyFootingPresentationlayer.setIfcBuildingStoreyFooting(this);

		return ifcBuildingStoreyFootingPresentationlayer;
	}

	public IfcBuildingStoreyFootingPresentationlayer removeIfcBuildingStoreyFootingPresentationlayer(IfcBuildingStoreyFootingPresentationlayer ifcBuildingStoreyFootingPresentationlayer) {
		getIfcBuildingStoreyFootingPresentationlayers().remove(ifcBuildingStoreyFootingPresentationlayer);
		ifcBuildingStoreyFootingPresentationlayer.setIfcBuildingStoreyFooting(null);

		return ifcBuildingStoreyFootingPresentationlayer;
	}

	public List<IfcBuildingStoreyFootingProperty> getIfcBuildingStoreyFootingProperties() {
		return this.ifcBuildingStoreyFootingProperties;
	}

	public void setIfcBuildingStoreyFootingProperties(List<IfcBuildingStoreyFootingProperty> ifcBuildingStoreyFootingProperties) {
		this.ifcBuildingStoreyFootingProperties = ifcBuildingStoreyFootingProperties;
	}

	public IfcBuildingStoreyFootingProperty addIfcBuildingStoreyFootingProperty(IfcBuildingStoreyFootingProperty ifcBuildingStoreyFootingProperty) {
		getIfcBuildingStoreyFootingProperties().add(ifcBuildingStoreyFootingProperty);
		ifcBuildingStoreyFootingProperty.setIfcBuildingStoreyFooting(this);

		return ifcBuildingStoreyFootingProperty;
	}

	public IfcBuildingStoreyFootingProperty removeIfcBuildingStoreyFootingProperty(IfcBuildingStoreyFootingProperty ifcBuildingStoreyFootingProperty) {
		getIfcBuildingStoreyFootingProperties().remove(ifcBuildingStoreyFootingProperty);
		ifcBuildingStoreyFootingProperty.setIfcBuildingStoreyFooting(null);

		return ifcBuildingStoreyFootingProperty;
	}

}