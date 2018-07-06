package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_stair_railing database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_stair_railing")
@NamedQuery(name="IfcBuildingStoreyStairRailing.findAll", query="SELECT i FROM IfcBuildingStoreyStairRailing i")
public class IfcBuildingStoreyStairRailing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	@Column(name="object_placement")
	private String objectPlacement;

	@Column(name="object_type")
	private String objectType;

	@Column(name="railing_name")
	private String railingName;

	private short status;

	private String tag;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuildingStorey
	@ManyToOne
	@JoinColumn(name="stair_id")
	private IfcBuildingStorey ifcBuildingStorey;

	//bi-directional many-to-one association to IfcBuildingStoreyStair
	@ManyToOne
	@JoinColumn(name="stair_id")
	private IfcBuildingStoreyStair ifcBuildingStoreyStair;

	//bi-directional many-to-one association to IfcBuildingStoreyStairRailingPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreyStairRailing")
	private List<IfcBuildingStoreyStairRailingPresentationlayer> ifcBuildingStoreyStairRailingPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreyStairRailingProperty
	@OneToMany(mappedBy="ifcBuildingStoreyStairRailing")
	private List<IfcBuildingStoreyStairRailingProperty> ifcBuildingStoreyStairRailingProperties;

	public IfcBuildingStoreyStairRailing() {
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

	public String getRailingName() {
		return this.railingName;
	}

	public void setRailingName(String railingName) {
		this.railingName = railingName;
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

	public IfcBuildingStoreyStair getIfcBuildingStoreyStair() {
		return this.ifcBuildingStoreyStair;
	}

	public void setIfcBuildingStoreyStair(IfcBuildingStoreyStair ifcBuildingStoreyStair) {
		this.ifcBuildingStoreyStair = ifcBuildingStoreyStair;
	}

	public List<IfcBuildingStoreyStairRailingPresentationlayer> getIfcBuildingStoreyStairRailingPresentationlayers() {
		return this.ifcBuildingStoreyStairRailingPresentationlayers;
	}

	public void setIfcBuildingStoreyStairRailingPresentationlayers(List<IfcBuildingStoreyStairRailingPresentationlayer> ifcBuildingStoreyStairRailingPresentationlayers) {
		this.ifcBuildingStoreyStairRailingPresentationlayers = ifcBuildingStoreyStairRailingPresentationlayers;
	}

	public IfcBuildingStoreyStairRailingPresentationlayer addIfcBuildingStoreyStairRailingPresentationlayer(IfcBuildingStoreyStairRailingPresentationlayer ifcBuildingStoreyStairRailingPresentationlayer) {
		getIfcBuildingStoreyStairRailingPresentationlayers().add(ifcBuildingStoreyStairRailingPresentationlayer);
		ifcBuildingStoreyStairRailingPresentationlayer.setIfcBuildingStoreyStairRailing(this);

		return ifcBuildingStoreyStairRailingPresentationlayer;
	}

	public IfcBuildingStoreyStairRailingPresentationlayer removeIfcBuildingStoreyStairRailingPresentationlayer(IfcBuildingStoreyStairRailingPresentationlayer ifcBuildingStoreyStairRailingPresentationlayer) {
		getIfcBuildingStoreyStairRailingPresentationlayers().remove(ifcBuildingStoreyStairRailingPresentationlayer);
		ifcBuildingStoreyStairRailingPresentationlayer.setIfcBuildingStoreyStairRailing(null);

		return ifcBuildingStoreyStairRailingPresentationlayer;
	}

	public List<IfcBuildingStoreyStairRailingProperty> getIfcBuildingStoreyStairRailingProperties() {
		return this.ifcBuildingStoreyStairRailingProperties;
	}

	public void setIfcBuildingStoreyStairRailingProperties(List<IfcBuildingStoreyStairRailingProperty> ifcBuildingStoreyStairRailingProperties) {
		this.ifcBuildingStoreyStairRailingProperties = ifcBuildingStoreyStairRailingProperties;
	}

	public IfcBuildingStoreyStairRailingProperty addIfcBuildingStoreyStairRailingProperty(IfcBuildingStoreyStairRailingProperty ifcBuildingStoreyStairRailingProperty) {
		getIfcBuildingStoreyStairRailingProperties().add(ifcBuildingStoreyStairRailingProperty);
		ifcBuildingStoreyStairRailingProperty.setIfcBuildingStoreyStairRailing(this);

		return ifcBuildingStoreyStairRailingProperty;
	}

	public IfcBuildingStoreyStairRailingProperty removeIfcBuildingStoreyStairRailingProperty(IfcBuildingStoreyStairRailingProperty ifcBuildingStoreyStairRailingProperty) {
		getIfcBuildingStoreyStairRailingProperties().remove(ifcBuildingStoreyStairRailingProperty);
		ifcBuildingStoreyStairRailingProperty.setIfcBuildingStoreyStairRailing(null);

		return ifcBuildingStoreyStairRailingProperty;
	}

}